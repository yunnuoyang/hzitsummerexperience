package com.d;

/**
 * sleep和wait
 * 这两个方法来自不同的类分别是Thread和Object
 * 最主要是sleep方法没有释放锁，而wait方法释放了锁，使得其他线程可以使用同步控制块或者方法(锁代码块和方法锁)。
 * wait，notify和notifyAll只能在同步控制方法或者同步控制块里面使用，而sleep可以在任何地方使用(使用范围)
 * sleep必须捕获异常，而wait，notify和notifyAll不需要捕获异常
 */
public class Thread {
    public static void main(String[] args) {
//        ThreadDemo t=new ThreadDemo();
//        java.lang.Thread thread=new java.lang.Thread(t);
//        thread.start();
//        thread.notify();
        java.lang.Thread thread = new java.lang.Thread(new ThreadDemo());
        thread.start();
        try {
            thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        thread.interrupt();
//        new java.lang.Thread(new ThreadDemo()).start();
//        Thread.class.notifyAll();
    }

}
class ThreadDemo implements Runnable{

    @Override
    public void run() {
        synchronized (ThreadDemo.class) {
            System.out.println("enter thread1...");
            System.out.println("thread1 is waiting...");
            try {
                //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                ThreadDemo.class.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("thread1 is going on ....");
            System.out.println("thread1 is over!!!");
        }
    }
}
