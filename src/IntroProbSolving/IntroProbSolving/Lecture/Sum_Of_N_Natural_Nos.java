package IntroProbSolving.IntroProbSolving.Lecture;

import java.util.Scanner;

public class Sum_Of_N_Natural_Nos {

    public static void main(String[] args) {
        System.out.println("Enter the natural number n; for which we wish to find the sum:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = ((long)(n*(n+1))/2);
        System.out.println("The sum of first N=" + n  + " natural numbers is Sum=" + sum + ".");

        // Instead of adding elements one by one that would lead to TC of O(N), we instead use the formula.
        // TC : O(1)
        // SC: O(1)
    }
}
