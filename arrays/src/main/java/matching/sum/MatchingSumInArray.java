package matching.sum;

import java.util.HashMap;

/**
 * Given a list of numbers and a number k,
 * return whether any two numbers from the list add up to k
 */
public class MatchingSumInArray {
    public static void main(String[] args) {
//        int[] inputArray = {10, 15, 3, 7};
//        int  k = 25;
        int[] inputArray = {10, 3, 7, 10};
        int  k = 20;
        System.out.printf("found=%b 2 numbers in the array summing to %d%n", find2Numbers(inputArray, k), k);
    }

    private static boolean find2Numbers(int[] inputArray, int k) {
//        var arrayToSet = Arrays.stream(inputArray).boxed().collect(Collectors.toSet());
        var valueToIndexMap = new HashMap<Integer, Integer>();
        for(int i=0;i < inputArray.length;i++){
            valueToIndexMap.put(inputArray[i], i);
        }
        for(int i=0;i < inputArray.length;i++){
            if(valueToIndexMap.containsKey(k-inputArray[i]) && i != valueToIndexMap.get(k-inputArray[i])) {
                return true;
            }
        }
        return false;
    }
}
