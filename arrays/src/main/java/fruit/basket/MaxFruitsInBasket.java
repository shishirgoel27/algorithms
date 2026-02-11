package fruit.basket;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of trees and two baskets, each containing one type of fruit with no limitations
 * Find the maximum number of fruits that can be collected in the baskets continuously, if only one fruit can be plucked from a tree
 */
public class MaxFruitsInBasket {
    public static void main(String[] args) {
        int[] trees = new int[]{1,2,3,2,2};
        int differentTypes = 2;
        int maxFruits = findMaxFruits(trees, differentTypes);
        System.out.println(maxFruits);
    }

    private static int findMaxFruits(int[] trees, int differentTypes) {
        int start = 0, end = 0, max = Integer.MIN_VALUE;
        Map<Integer,Boolean> fruitTypeMap = new HashMap<>();
        for(;end < trees.length;end++) {
           int fruitType = trees[end];
           if(fruitTypeMap.size() < differentTypes && !fruitTypeMap.containsKey(fruitType)) {
               fruitTypeMap.put(fruitType, true);
               max = Math.max(max, end-start+1);
           }else if(fruitTypeMap.containsKey(fruitType)) {
               max = Math.max(max, end-start+1);
           }else {
               fruitTypeMap.clear();
               fruitTypeMap.put(fruitType, true);
               fruitTypeMap.put(trees[end-1], true);
               start = end - 1;
               while(trees[start] == trees[start-1]) {
                   start--;
               }
           }
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}
