package IntroProbSolving.IntroToArrays.Lecture;

import java.util.Scanner;

public class ReverseAnArray {

    public int[] reverseAnArray(int[] input, int startIndex, int endIndex) {
        int temp;
        while(startIndex<endIndex){
            temp=input[startIndex];
            input[startIndex]=input[endIndex];
            input[endIndex]=temp;
            startIndex++;
            endIndex--;
        }
        return input;
    }
    public static void main(String[] args) {
        System.out.println("Enter the size of an array n followed by its elements:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input= new int[n];
        for(int i=0; i<n; i++) {
            input[i] = scanner.nextInt();
        }
        ReverseAnArray reverseAnArray = new ReverseAnArray();
        int startIndex = 0;
        int endIndex = input.length-1;
        input = reverseAnArray.reverseAnArray(input, startIndex, endIndex);
        for(int j : input)
            System.out.print(j + " ");
    }
    // TC = O(N)
    // SC = O(1)
}
