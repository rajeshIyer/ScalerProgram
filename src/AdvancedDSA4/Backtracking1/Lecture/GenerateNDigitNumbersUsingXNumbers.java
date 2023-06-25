package AdvancedDSA4.Backtracking1.Lecture;
import java.util.Scanner;

public class GenerateNDigitNumbersUsingXNumbers {

    void printNDigitNumbers(int index, int size, int k, String temp){
        if(index == size){
            System.out.println(temp);
            return;
        }
        for(int i=1;i<=k; i++) {
            String result = temp + i;
            printNDigitNumbers(index+1,size,k,result);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter the size of the output numbers in digits n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        GenerateNDigitNumbersUsingXNumbers numbersUsingXNumbers = new GenerateNDigitNumbersUsingXNumbers();
        System.out.println("Enter the size of numbers that can be used for digits k: ");
        int k = scanner.nextInt();
        numbersUsingXNumbers.printNDigitNumbers(0,n,k,"");
    }
}
