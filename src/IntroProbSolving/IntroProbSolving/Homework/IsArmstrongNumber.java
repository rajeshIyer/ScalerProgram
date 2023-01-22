package IntroProbSolving.IntroProbSolving.Homework;

import java.util.Scanner;

public class IsArmstrongNumber {
    public boolean isArmstrongNumber(int n) {
        // Since n is needed for eventual comparison; storing it in another variable for manipulation
        int i = n;
        long sum=0;
        while(i/10 != 0) {
            sum+=(i%10)*(i%10)*(i%10);
            i=i/10;
        }
        // Adding cube of the most significant digit outside the loop
        sum+= (long) (i) *(i)*(i);
        return sum == n;
    }

    // If sum of cubes of each digit of the number is equal to the number itself, then the number is called an Armstrong number.
    public static void main(String[] args) {
        System.out.println("To check the armstrong numbers in the range 1 to n, enter the number n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        IsArmstrongNumber isArmstrongNumber = new IsArmstrongNumber();

        for(int i=1; i<=n; i++) {
            boolean result = isArmstrongNumber.isArmstrongNumber(i);
            if (result) {
                System.out.println("The number n=" + i + " is an armstrong number.");
            }
        }
    }
    // TC = O(logN)base2
    // SC = O(1)
}
