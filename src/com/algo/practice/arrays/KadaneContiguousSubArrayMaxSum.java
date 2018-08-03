package com.algo.practice.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KadaneContiguousSubArrayMaxSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of test cases");
        int t = scanner.nextInt();
        while (t > 0) {
            System.out.println("Enter one dimensional array size");
            int n = scanner.nextInt();
            System.out.println("Enter one dimensional array elements");
            List<Integer> arrayElements = new ArrayList<>();
            while (scanner.hasNextInt()) {
                int a = scanner.nextInt();
                System.out.println("next val = " + a);
                arrayElements.add(a);
                if (arrayElements.size() == n) {
                    break;
                }
            }

            System.out.println(findMaxSum(getSumOfSubArray(arrayElements)));
            t--;
        }
    }
    private static int findMaxSum(int[] inputArray) {
        int currentMax, globalMax = currentMax  = inputArray[0]; //Assign first element
        for (int i =1 ; i < inputArray.length; i++) { //Iterate from second element
            //Max between sum of @{currentMax} + next element and next element.
            currentMax = Math.max(currentMax + inputArray[i], inputArray[i]);
            if(currentMax > globalMax) {
                globalMax = currentMax;
            }
        }

        return globalMax;
    }
    private static int[] getSumOfSubArray(List<Integer> inputArrayList) {
        return inputArrayList.stream().mapToInt(a -> a).toArray();
    }
}
