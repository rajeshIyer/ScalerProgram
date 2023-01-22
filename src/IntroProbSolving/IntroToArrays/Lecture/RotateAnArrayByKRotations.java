package IntroProbSolving.IntroToArrays.Lecture;

import java.util.Scanner;

public class RotateAnArrayByKRotations {
    private int[] rotateByK(int[] input, int k) {
        ReverseAnArray reverseAnArray = new ReverseAnArray();
        input = reverseAnArray.reverseAnArray(input,0,input.length-1);
        input = reverseAnArray.reverseAnArray(input,0, k);
        input = reverseAnArray.reverseAnArray(input,k+1,input.length-1);
        return input;
    }

    // If A[] = {1,2,3,4,5} and k = 2
    // Expected Output = {3,4,5,1,2}
    public static void main(String[] args) {
        System.out.println("Enter the size of an array n followed by its elements:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input= new int[n];
        for(int i=0; i<n; i++) {
            input[i] = scanner.nextInt();
        }
        System.out.println("Enter the rotation factor K:");
        int k = scanner.nextInt();

        if(k>n) {
            k=k%n;
        }
        RotateAnArrayByKRotations kRotations = new RotateAnArrayByKRotations();
        input = kRotations.rotateByK(input, k);
        for(int j: input){
            System.out.print(j+ " ");
        }
    }
    // Steps followed:
    // 1. Reverse the whole array to get {5,4,3,2,1}
    // 2. Reverse elements in the range 0 to k of the reversed array to get {3,4,5,2,1}
    // 3. Reverse elements in the range (k+1) to (n-1) of the reversed array to get {3,4,5,1,2}
    // TC = O(N)
    // SC = O(N)
}
