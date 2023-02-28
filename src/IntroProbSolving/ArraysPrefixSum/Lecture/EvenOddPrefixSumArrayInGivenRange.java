package IntroProbSolving.ArraysPrefixSum.Lecture;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class EvenOddPrefixSumArrayInGivenRange {
    public Map<String,int[]> fetchEvenOddPrefixSumArrayInGivenRange(int[] input) {
        Map<String,int[]> arrayMap = new HashMap<>();
        int size = input.length;
        int[] prefixSumEvenArray = new int[input.length];
        int[] prefixSumOddArray = new int[input.length];

        // The first element of the even prefix sum array is the same as the first element of input array
        prefixSumEvenArray[0] = input[0];
        // Initialize the first element of odd prefix sum array as 0
        prefixSumOddArray[0] = 0;
        for(int i=1; i<size; i++){
            if(i%2==0) {
                prefixSumEvenArray[i] = prefixSumEvenArray[i-1] + input[i];
                // For even indices, retain the odd array element value to be same as previous element
                prefixSumOddArray[i] = prefixSumOddArray[i-1];
            } else {
                prefixSumOddArray[i] = prefixSumOddArray[i-1] + input[i];
                // For odd indices, retain the even array element value to be same as previous element
                prefixSumEvenArray[i] = prefixSumEvenArray[i-1];
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
