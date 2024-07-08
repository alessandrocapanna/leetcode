package leetcode1;

import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(numbers, target);
        System.out.println("Indices: " + Arrays.toString(result));
    }

    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int numToSearch = target - numbers[i];
            if (map.containsKey(numToSearch)) {
                result[0] = map.get(numToSearch);
                result[1] = i;
                break;
            }
            map.put(numbers[i], i);
        }

        return result;
    }
}