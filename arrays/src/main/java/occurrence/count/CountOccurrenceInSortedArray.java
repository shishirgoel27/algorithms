package occurrence.count;

/**
 * Given a sorted array find the count of occurrence of a given number
 */
public class CountOccurrenceInSortedArray {
    public static void main(String[] args) {
//        int[] inputArray = {1,1,1,2,3,4};  k = 1
//        int[] inputArray = {1,2,3,4}; k = 2
        int[] inputArray = {1,2,3,4,5,5,6,7,8};
        int k = 5;
        System.out.println(countOccurrence(inputArray, k));
    }

    private enum Search {
        FIRST, LAST
    }

    private static int countOccurrence(int[] inputArray, int k) {
        int left = 0, right = inputArray.length - 1;
        int firstOccurrenceIndex = search(left, right, inputArray, k, Search.FIRST);
        if(firstOccurrenceIndex == -1) {
            return 0;
        }
        int lastOccurrenceIndex = search(left, right, inputArray, k, Search.LAST);
        return Math.abs(lastOccurrenceIndex - firstOccurrenceIndex) + 1;
    }

    private static int search(int left, int right, int[] inputArray, int k, Search searchType) {
        if(inputArray.length == 0 || left > right) {
            return -1;
        }
        int mid = left + (right-left)/2;
        if (inputArray[mid] == k) {
            switch(searchType) {
                case FIRST:
                    if (inBounds(mid - 1, inputArray.length) && inputArray[mid - 1] == inputArray[mid]) {
                        return search(left, mid - 1, inputArray, k, searchType);
                    }
                    break;
                case LAST:
                    if (inBounds(mid + 1, inputArray.length) && inputArray[mid + 1] == inputArray[mid]) {
                        return search(mid + 1, right, inputArray, k, searchType);
                    }
                    break;
            }
            return mid;
        }
        if(inputArray[mid] < k) {
            return search(mid+1, right, inputArray, k, searchType);
        }
        if(inputArray[mid] > k) {
            return search(left, mid-1, inputArray,k,searchType);
        }
        return -1;
    }

    private static boolean inBounds(int i, int arrayLength) {
        return i >=0 && i < arrayLength;
    }
}
