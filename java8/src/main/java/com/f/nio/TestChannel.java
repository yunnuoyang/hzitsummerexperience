package com.f.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * 一、通道（Channel）：用于源节点与目标节点的连接。在 Java NIO 中负责缓冲区中数据的传输。Channel 本身不存储数据，因此需要配合缓冲区进行传输。
 *
 * 二、通道的主要实现类
 * 	java.nio.channels.Channel 接口：
 * 		|--FileChannel
 * 		|--SocketChannel
 * 		|--ServerSocketChannel
 * 		|--DatagramChannel
 *
 * 三、获取通道
 * 1. Java 针对支持通道的类提供了 getChannel() 方法
 * 		本地 IO：
 * 		FileInputStream/FileOutputStream
 * 		RandomAccessFile
 *
 * 		网络IO：
 * 		Socket
 * 		ServerSocket
 * 		DatagramSocket
 *
 * 2. 在 JDK 1.7 中的 NIO.2 针对各个通道提供了静态方法 open()
 * 3. 在 JDK 1.7 中的 NIO.2 的 Files 工具类的 newByteChannel()
 *
 * 四、通道之间的数据传输
 * transferFrom()
 * transferTo()
 *
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区中的数据聚集到通道中
 *
 * 六、字符集：Charset
 * 编码：字符串 -> 字节数组
 * 解码：字节数组  -> 字符串
 */
public class TestChannel {
    @Test
    public void test1() throws CharacterCodingException {
        Charset cs=Charset.forName("GBK");
        //获取编码器
        CharsetEncoder encoder = cs.newEncoder();
        //获取解码器
        CharsetDecoder decoder = cs.newDecoder();
        //分配初始化空间
        CharBuffer cb=CharBuffer.allocate(1024);
        cb.put("张三今天吃了两碗米饭");
        //切换为读流的方式
        cb.flip();
        //以GBK进行编码
        ByteBuffer encode = encoder.encode(cb);
        System.out.println(encode.limit());
        for (int i = 0; i <encode.limit() ; i++) {
            System.out.print(encode.get());
        }
        System.out.println();
        //转换为读模式
        encode.flip();
        //以GBK进行解码
        CharBuffer decode = decoder.decode(encode);
        for (int i = 0; i <decode.limit() ; i++) {
            System.out.print(decode.get());
        }
    }
    //Charset里边包含的所有的编码器及解码器--->共有170
    @Test
    public void test2(){
        Map<String, Charset> map = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> set = map.entrySet();
        int count=0;
        for (Map.Entry<String, Charset> entry : set) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
            count++;
        }
        System.out.println("共有"+count);
    }
    //分散和聚集，分配两个缓冲区来进行缓冲数据，当
    //缓冲数据大于第一个缓冲区的容量时，会开始将数据存放在第二个缓冲区中
    //缓冲区由通道进行管理
    @Test
    public void test3() throws IOException {
//        RandomAccessFile raf1=new RandomAccessFile(new File("1.txt"),"rw");
        RandomAccessFile raf1 = new RandomAccessFile("1.txt", "rw");
        //1. 获取通道
        FileChannel channel1 = raf1.getChannel();

        //2. 分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //3. 分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);
//        buf1.flip();
//        byte[] b=new byte[buf1.limit()];
//        System.out.println("this is my data:"+new String(b,0,buf1.limit()));
        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("-----------------");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        //4. 聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("2.txt", "rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);
    }
    //通道之间的数据传输(直接缓冲区)
    @Test
    public void test4() throws IOException{
        FileChannel inChannel = FileChannel.open(Paths.get("E:\\IdeaProjects\\hzitsummerexperience\\java8\\src\\main\\java\\com\\f\\nio/1.md"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\IdeaProjects\\hzitsummerexperience\\java8\\src\\main\\java\\com\\f\\nio/2.md"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
//方式一
		inChannel.transferTo(0, inChannel.size(), outChannel);
//方式二
//        outChannel.transferFrom(inChannel, 0, inChannel.size());

        inChannel.close();
        outChannel.close();
    }
    //使用直接缓冲区完成文件的复制(内存映射文件)
    @Test
    public void test5() throws IOException{//2127-1902-1777
        long start = System.currentTimeMillis();

        FileChannel inChannel = FileChannel.open(Paths.get("E:\\IdeaProjects\\hzitsummerexperience\\java8\\src\\main\\java\\com\\f\\nio/17授权二.avi"), StandardOpenOption.READ,StandardOpenOption.CREATE);
        FileChannel outChannel = FileChannel.open(Paths.get("E:\\IdeaProjects\\hzitsummerexperience\\java8\\src\\main\\java\\com\\f\\nio/2.avi"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start));
    }

    //利用通道完成文件的复制（非直接缓冲区）
    @Test
    public void test6(){//10874-10953
        long start = System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        //①获取通道
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("d:/1.mkv");
            fos = new FileOutputStream("d:/2.mkv");

            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //②分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            //③将通道中的数据存入缓冲区中
            while(inChannel.read(buf) != -1){
                buf.flip(); //切换读取数据的模式
                //④将缓冲区中的数据写入通道中
                outChannel.write(buf);
                buf.clear(); //清空缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outChannel != null){
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(inChannel != null){
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("耗费时间为：" + (end - start));

    }


}
