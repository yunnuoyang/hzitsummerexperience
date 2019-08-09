package com.f.nio;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.file.*;

/**
 * 测试NIO中的Paths
 * E:\IdeaProjects\hzitsummerexperience\java8\src\main\java\com\f\nio
 */
public class TestPaths {
    @Test
    public void test3() throws IOException{
        //1. 获取管道
        Pipe pipe = Pipe.open();

        //开辟byte缓冲区，大小1024
        ByteBuffer buf = ByteBuffer.allocate(1024);

        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("通过单向管道发送数据".getBytes());
        buf.flip();
        //2. 将缓冲区中的数据写入管道
        sinkChannel.write(buf);

        //3. 读取缓冲区中的数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(), 0, len));

        sourceChannel.close();
        sinkChannel.close();
    }
    @Test
    public void test2() throws IOException {
        Path path = Paths.get("E:\\", "IdeaProjects\\hzitsummerexperience\\java8\\src\\main\\java\\com\\f\\nio\\2.md");
        Path parent = path.getParent().getParent();
        System.out.println(parent);
        Files.copy(path,Paths.get("f:\\","nio"), StandardCopyOption.REPLACE_EXISTING);
    }
    @Test
    public void test1(){
        Path path = Paths.get("E:\\", "IdeaProjects\\hzitsummerexperience\\java8\\src\\main\\java\\com\\f\\nio\\1.md");
        System.out.println(path.getParent()+"==="+path.getRoot());
        System.out.println(path.isAbsolute());
        System.out.println(path.toAbsolutePath());
        System.out.println(path.endsWith("IdeaProjects\\hzitsummerexperience\\java8\\src\\main\\java\\com\\f\\nio\\1.md"));
        System.out.println(path.endsWith("\\1.md"));
    }

}
