package IntroProbSolving.IntroProbSolving.Lecture;

import java.util.Scanner;

public class IsItPerfect {

    // A perfect number is a positive integer that is equal to the sum of its proper positive divisors (excluding the number).
    // A proper divisor divides a number without leaving any remainder.
    // Input: 4, Output: NO, as sum of divisors is 1+2 =3
    // Input: 6, Output: YES, as sum of divisors is 1+2+3 =6
    public boolean isItPerfect(int n) {
        // Initialize sum to 1 as 1 is a factor for all numbers
        int sum = 1;

        // Start from 2 until root n
        for (int i=2; i*i<=n; i++){
            if(n%i==0){
                if(i != n/i) {
                    sum += i + n/i;
                } else {
                    sum += i;
                }
            }
        }
        if(sum==n) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println("To check if the number is perfect or not, enter the number n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        IsItPerfect isItPerfect = new IsItPerfect();
        boolean result = isItPerfect.isItPerfect(n);
        if(result) {
            System.out.println("The number n=" + n + " is perfect.");
        } else {
            System.out.println("The number n=" + n + " is not perfect.");
        }
    }
    // Instead of looking for all possible factors lesser than n; we iterate only till root N as numbers greater than root N
    // which are factors would have already been considered with those which are less than root N.
    // TC = O(root N)
    // SC = O(1)
}
