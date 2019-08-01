package demo01;

public class A4Paper implements  Paper {
    private int width;
    private int height;


    public void beforeInit(){
        this.width = 800;
        this.height = 700;
        System.out.println("-----------beforeInit()-----------");
    }

    public void destory(){
        System.out.println("--------销毁了 释放资源----");
    }

    public A4Paper(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public A4Paper(){

        System.out.println("******A4Paper*******");
    }

    @Override
    public void page() {
        System.out.println(width+"*******A4paper*******"+height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
