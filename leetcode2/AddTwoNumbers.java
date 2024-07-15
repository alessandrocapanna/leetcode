package leetcode2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args) {
        int[] numbers1 = {9,9,9,9,9,9,9};
        int[] numbers2 = {9,9,9,9};
        int[] target   = {8,9,9,9,0,0,0,1};

        LinkedList<Integer> result = AddTwoNumbers(numbers1, numbers2);
        System.out.println("result: " + Arrays.toString(result.toArray()) +" || expected:" + Arrays.toString(target));
    }

    public static LinkedList AddTwoNumbers(int[] numbers1, int[] numbers2) {

        int n = numbers1.length;
        int n2 = numbers2.length;

        //reverse arrays
        LinkedList<Integer> numbersReversed = new LinkedList<>();
        LinkedList<Integer> numbers2Reversed = new LinkedList<>();
        for (int i = 0; i < numbers1.length; i++) {
            numbersReversed.add(numbers1[n - i - 1]);
        }
        for (int i = 0; i < numbers2.length; i++) {
            numbers2Reversed.add(numbers2[n2 - i - 1]);
        }

        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < numbersReversed.size(); i++) {
            int secondNumber = 0;

            if (numbers2Reversed.size() > i) {
                secondNumber = numbers2Reversed.get(i);

            }

            int sum = numbersReversed.get(i) + secondNumber;
            if (result.size() != i) {
                sum +=1;
            }

            if (sum >= 10) {
                if (result.size() == i) {
                    result.add(sum - 10);
                } else {
                    result.set(i , sum - 10);
                }
                result.add(1);
            } else {
                if (result.size() == i) {
                    result.add(sum);
                } else {
                    result.set(i , sum);
                }
            }

        }

        return result;
    }
}