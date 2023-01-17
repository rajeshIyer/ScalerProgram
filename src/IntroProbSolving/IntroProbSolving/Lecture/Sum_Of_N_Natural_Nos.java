package IntroProbSolving.IntroProbSolving.Lecture;

import java.util.Scanner;

public class Sum_Of_N_Natural_Nos {

    public long sumOfNNaturalNos(int n) {
        return ((long)(n*(n+1))/2);
    }

    public static void main(String[] args) {
        System.out.println("To find the sum of n natural numbers; enter n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Sum_Of_N_Natural_Nos sumOfNNaturalNos = new Sum_Of_N_Natural_Nos();
        long sum = sumOfNNaturalNos.sumOfNNaturalNos(n);
        System.out.println("The sum of first N=" + n  + " natural numbers is Sum=" + sum + ".");

        // Instead of adding elements one by one that would lead to TC of O(N), we instead use the formula.
        // TC : O(1)
        // SC: O(1)
    }
}
