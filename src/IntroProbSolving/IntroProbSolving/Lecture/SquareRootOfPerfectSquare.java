package IntroProbSolving.IntroProbSolving.Lecture;

import java.util.Scanner;

public class SquareRootOfPerfectSquare {

    public int findSquareRootOfPerfectSquare(int n) {
        int low=0;
        int high=n;
        int mid = (low+high)/2;
        long mid_square = (long) mid*mid;

        while(mid_square != n) {
            if (mid_square > n) {
                high = mid;
                mid = (low + high) / 2;
                mid_square = (long) mid*mid;
            } else if (mid_square < n) {
                low = mid;
                mid = (low + high) / 2;
                mid_square = (long) mid*mid;
            }
        }

        return mid;
    }
    public static void main(String[] args) {
        System.out.println("To find square root, enter the perfect square : ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        SquareRootOfPerfectSquare squareRootOfPerfectSquare = new SquareRootOfPerfectSquare();
        int squareRoot = squareRootOfPerfectSquare.findSquareRootOfPerfectSquare(n);
        System.out.println("The square root of the perfect square number N=" + n  + " is squareRoot=" + squareRoot + ".");

        // Instead of iterating all possible numbers less than n to find square root;
        // reduce the search space by logN base2 using binary search concept
        // TC = O(logN)2
        // SC = O(1)
    }
}
