import java.util.Scanner;

 class AreaCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Shape:");
        System.out.println("1. Rhombus");
        System.out.println("2. Trapezium");
        System.out.println("3. Parallelogram");
        System.out.print("Enter your choice (1/2/3): ");
        int t = scanner.nextInt();

        double area = 0;

        switch (t) {
            case 1: // Rhombus
                System.out.print("Enter first diagonal (d1): ");
                double d1 = scanner.nextDouble();
                System.out.print("Enter second diagonal (d2): ");
                double d2 = scanner.nextDouble();
                area = 0.5 * d1 * d2;
                System.out.println("Area of Rhombus = " + area);
                break;

            case 2: // Trapezium
                System.out.print("Enter base 1: ");
                double a = scanner.nextDouble();
                System.out.print("Enter base 2: ");
                double b = scanner.nextDouble();
                System.out.print("Enter height: ");
                double h = scanner.nextDouble();
                area = 0.5 * (a + b) * h;
                System.out.println("Area of Trapezium = " + area);
                break;

            case 3: // Parallelogram
                System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter height: ");
                double height = scanner.nextDouble();
                area = base * height;
                System.out.println("Area of Parallelogram = " + area);
                break;

            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
        }

        scanner.close();
    }
}
