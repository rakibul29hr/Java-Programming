import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        double radius;
        Scanner  sc = new Scanner(System.in);
        System.out.println("Enter radius:");
        radius = sc.nextDouble();
        CircleRadInContructor2 obj = new CircleRadInContructor2();
        obj.setRadius(radius);
        System.out.print("The area of the circle with radius " + obj.getRadius() + " is: " + obj.computeArea());
        sc.close();
    }
}
