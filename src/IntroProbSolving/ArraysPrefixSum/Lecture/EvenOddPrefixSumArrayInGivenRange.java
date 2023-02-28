package IntroProbSolving.ArraysPrefixSum.Lecture;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class EvenOddPrefixSumArrayInGivenRange {
    private Map<String,int[]> fetchEvenOddPrefixSumArrayInGivenRange(int[] input) {
        Map<String,int[]> arrayMap = new HashMap<>();
        int size = input.length;
        int resultEvenArrayLength = 0;
        int resultOddArrayLength = size/2;
        if(size%2 == 1) {
                resultEvenArrayLength=size/2+1;
        } else {
                resultEvenArrayLength=size/2;
        }
        int[] prefixSumEvenArray = new int[resultEvenArrayLength];
        int[] prefixSumOddArray = new int[resultOddArrayLength];
        int j=1;
        int k=1;
        prefixSumEvenArray[0] = input[0];
        prefixSumOddArray[0] = input[1];
        for(int i=2; i<size; i++){
            if(i%2==0) {
                prefixSumEvenArray[j] = prefixSumEvenArray[j-1] + input[i];
                j++;
            } else {
                prefixSumOddArray[k] = prefixSumOddArray[k-1] + input[i];
                k++;
            }
        }
        arrayMap.put("E", prefixSumEvenArray);
        arrayMap.put("O", prefixSumOddArray);

        return arrayMap;
    }

    // Calculate sum of odd indexed and even indexed elements in a given range
    public static void main(String[] args) {
        System.out.println("Enter the size of array n followed by elements of the array: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[n];
        for(int i=0; i < n; i++) {
            input[i] = scanner.nextInt();
        }
        EvenOddPrefixSumArrayInGivenRange evenOddIndexed = new EvenOddPrefixSumArrayInGivenRange();
        Map<String,int[]> resultArrayMap = evenOddIndexed.fetchEvenOddPrefixSumArrayInGivenRange(input);

        // Q queries
        System.out.println("Enter the index type (E for Even and O for Odd) and range (startIndex endIndex) in which the sum needs to be calculated: ");
        String indexType = scanner.next();                   // E: Even and O:Odd
        int startIndex = scanner.nextInt();
        int endIndex = scanner.nextInt();

        int[] resultArray = resultArrayMap.get(indexType);
        int result = 0;
        if(endIndex>resultArray.length-1)
            endIndex = resultArray.length-1;
        if(startIndex > 0)
            result = resultArray[endIndex] - resultArray[startIndex-1];
        else
            result = resultArray[endIndex];

        System.out.println(" The sum in the range for index type: " + indexType + " is " + result);
    }

    // TC: O(N), SC: O(N)
    // We can achieve the result at better SC of O(1) for a single query.
    // However, for Q queries we benefit with the pre-calculation of even and odd prefix sum arrays. TC: O(Q+N), SC: O(N)
    // For Q queries without pre-calculation of even and odd prefix sum arrays. TC: O(Q*N), SC: O(1)
}
