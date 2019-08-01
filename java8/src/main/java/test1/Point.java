package test1;

    public class Point {
    static int x;

    int y;

}

class Test {

    public static void main(String args[]) {

        Point p1 = new Point();

        Point p2 = new Point();

        p1.x = 10;

        p1.y= 20;

        System.out.print(p2.x+ ", ");

        System.out.print(p2.y);

    }

}
