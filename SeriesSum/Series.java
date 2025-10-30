import java.util.Scanner;

class SeriesSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of cases: ");
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            System.out.print("Case " + i + " - Enter n: ");
            int n = scanner.nextInt();
            StringBuilder series = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                series.append(j);
                if (j < n) {
                    series.append("+");
                }
            }
            int sum = n * (n + 1) / 2;
            System.out.println("Result: " + series + " = " + sum);
        }

        scanner.close();
    }
}
