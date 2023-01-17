package IntroProbSolving.IntroProbSolving.Lecture;

import java.util.Scanner;

public class DivideByTwoToReachOne {

    public int fetchCountOfDivisionsByTwoToReachOne(int n){
        int count = 0;
        while(n!=1) {
            n = n / 2;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number for which we would like to get the count of division by 2 needed to reach 1: ");
        int n = scanner.nextInt();
        DivideByTwoToReachOne divideByTwoToReachOne = new DivideByTwoToReachOne();
        int count = divideByTwoToReachOne.fetchCountOfDivisionsByTwoToReachOne(n);
        System.out.println("The number of divisions by 2 needed to reach 1 for the number=" + n + " is " + "count=" + count);
    }

    //If N = 2^k, k is the answer.
    //For all other N , find the closest power of 2 less than N as the answer
    //https://www.khanacademy.org/math/algebra2/x2ec2f6f830c9fb89:logs/x2ec2f6f830c9fb89:log-intro/a/intro-to-logarithms
    //
    //(logN) base 2: Number of times N has to be divided by 2 to make it 1.
    // TC = O(logN base 2)
    // SC = O(1)
}
