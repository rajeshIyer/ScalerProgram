package IntroProbSolving.IntroProbSolving.Lecture;

import java.util.Scanner;

public class IsPrime {

    public boolean isPrime(int n) {
        // Start from 2 until root n
        for (int i=2; i*i<=n; i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(" To check if it is prime or not, enter the number n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        IsPrime isPrime = new IsPrime();
        boolean result = isPrime.isPrime(n);
        if(result){
            System.out.println("The number n=" + n + " is prime.");
        } else {
            System.out.println("The number n=" + n + " is not prime.");
        }
    }
    // Instead of looking for all possible factors lesser than n; we iterate only till root N as numbers greater than root N cant be factors.
    // TC = O(root N)
    // SC = O(1)
}
