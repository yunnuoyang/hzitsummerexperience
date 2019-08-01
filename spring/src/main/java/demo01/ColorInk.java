package demo01;

public class ColorInk implements  Ink {
    private String brand;
    public  void print(){
        System.out.println(brand+"*******彩色墨盒*******");
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
