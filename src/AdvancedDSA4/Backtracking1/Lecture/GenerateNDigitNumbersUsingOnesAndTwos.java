package AdvancedDSA4.Backtracking1.Lecture;
import java.util.Scanner;

public class GenerateNDigitNumbersUsingOnesAndTwos {

    void printNDigitNumbers(int index, int size, String temp){
        if(index == size){
            System.out.println(temp);
            return;
        }
        for(int i=1;i<=2; i++) {
            String result = temp + i;
            printNDigitNumbers(index+1,size,result);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of the output numbers in digits n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        GenerateNDigitNumbersUsingOnesAndTwos numbersUsingOnesAndTwos = new GenerateNDigitNumbersUsingOnesAndTwos();
        numbersUsingOnesAndTwos.printNDigitNumbers(0,n,"");
    }
}
