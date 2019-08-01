package demo01;

public class GrayInk implements  Ink{
    private String brand;

    public GrayInk(){
        System.out.println("&&&&&&GrayInk&&&&&&&");
    }
    //构造方法
    public GrayInk(String brand){
        this.brand = brand;
    }
//    public GrayInk(){}
    @Override
    public void print() {
        System.out.println(brand+"********黑色墨盒*******");
    }
}
