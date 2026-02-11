package multiply.except.self;

import java.util.stream.IntStream;

/**
 * Given an array [1,2,3,4,5] return a new array [120,60,40,30,24]
 * such that each element in the new array at index i is the product of all numbers in original array except at index i
 *  ## Constraint Division is not allowed
 */
public class MulitplyExceptSelf {
    public static void main(String[] args) {

//        int[] inputArray = {1,2,3,4,5};
        int[] inputArray = {3,2,1};
        var productArray =  productArrayWithoutSelfSimpler(inputArray);
        IntStream.of(productArray).forEach(System.out::println);
    }

    private static int[] productArrayWithoutSelf(int[] inputArray) {
        int mulNext = 1;
        int[] productArr = new int[inputArray.length];
        int[] mulArray = new int[inputArray.length];
        for (int i=0;i<inputArray.length;i++) {
            if(i == 0) {
                mulArray[i] = inputArray[i];
            } else {
                mulArray[i] = mulArray[i - 1] * inputArray[i];
            }
        }
        for(int j=inputArray.length-1;j>=0;j--) {
            if(j == 0) {
                productArr[j] = mulNext;
            } else {
                productArr[j] = mulNext * mulArray[j - 1];
                mulNext *= inputArray[j];
            }
        }
        return productArr;
    }
    private static int[] productArrayWithoutSelfSimpler(int[] inputArray) {
        int productBefore = 1;
        int[] productArr = new int[inputArray.length];
        int[] productArrayWithoutSelf = new int[inputArray.length];
        for (int i=0;i<inputArray.length;i++) {
            productArr[i] = productBefore;
            productBefore *= inputArray[i];
        }
        int productAfter = 1;
        for(int j=inputArray.length-1;j>=0;j--) {
            productArrayWithoutSelf[j] = productAfter * productArr[j];
            productAfter *= inputArray[j];
        }
        return productArrayWithoutSelf;
    }
}
