import java.io.*;
import java.util.Scanner;
public class Lab2 {
    public static void main(String[] args) {
        File inputFile = new File("Input.txt");
        File outputFile = new File("Output.txt");
        File sumFile = new File("Sum.txt");

        try (
                Scanner sc = new Scanner(inputFile);
                PrintWriter outHigh = new PrintWriter(outputFile);
                PrintWriter outSum = new PrintWriter(sumFile)
        ) {
            sc.useDelimiter("[,\\s]+");
            if (!sc.hasNextInt()) {
                System.out.println("Input file is empty.");
                return;
            }
            int currentVal = sc.nextInt();
            int maxSoFar = currentVal;
            long totalSum = currentVal;
            System.out.println("Processing file...");
            while (sc.hasNextInt()) {
                currentVal = sc.nextInt();
                totalSum += currentVal;
                if (currentVal > maxSoFar) {
                    maxSoFar = currentVal;
                    outHigh.print(maxSoFar + ", ");
                }
            }
            outSum.println("Total Sum: " + totalSum);
            System.out.println("Done! Check Output.txt and Sum.txt.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input.txt not found. Please create the file first.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}