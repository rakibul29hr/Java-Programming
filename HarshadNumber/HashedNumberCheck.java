import java.util.Scanner;

public class HashedNumberCheck {

    // Method to check Harshad number
    public static int sumOfTheDigitsOfHarshadNumber(int x) {
        int original = x;
        int sum = 0;

        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }

        if (original % sum == 0) {
            return sum;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int x = scanner.nextInt();

        int result = sumOfTheDigitsOfHarshadNumber(x);

        System.out.println("Result: " + result);

        scanner.close();
    }
}
