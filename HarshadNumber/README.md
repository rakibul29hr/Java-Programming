# Harshad Number (Java)

This repository contains a Java solution for the **Harshad Number** problem from LeetCode.

---

## 📌 Problem Description

A number is called a **Harshad Number** if it is divisible by the sum of its digits.

Given an integer `x`, return the **sum of its digits** if `x` is a Harshad number. Otherwise, return `-1`.

---

## 🔗 Problem Link

[LeetCode Problem - Harshad Number](https://leetcode.com/problems/harshad-number)

---

## 💡 Approach

1. Take input number.
2. Find sum of digits.
3. Check if number is divisible by sum.
4. Return sum if true, otherwise return -1.

---

## 🧑‍💻 Java Code

```java
import java.util.Scanner;

public class HashedNumberCheck {

    // Method to calculate sum of digits and check Harshad condition
    public static int sumOfTheDigitsOfHarshadNumber(int x) {
        int original = x; // store original number for final check
        int sum = 0;      // variable to store sum of digits

        // Step 1: Extract digits and calculate sum
        while (x > 0) {
            sum += x % 10; // get last digit and add to sum
            x /= 10;       // remove last digit
        }

        // Step 2: Check Harshad condition
        if (original % sum == 0) {
            return sum; // return sum if divisible
        } else {
            return -1;  // return -1 if not divisible
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter a number: ");
        int x = scanner.nextInt();

        // Calling method and storing result
        int result = sumOfTheDigitsOfHarshadNumber(x);

        // Printing final output
        System.out.println("Result: " + result);

        scanner.close(); // close scanner to prevent memory leak
    }
}
