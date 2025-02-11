package com.javaassignment;

public class SortingArrays {

    static void countSort (int[] arr) {
        int c0 = 0, c1 = 0, c2 = 0;

      for (int num : arr) {
            if (num == 0) c0++;
            else if (num == 1) c1++;
            else c2++;
        }

        int index = 0;
      
        for (int i = 0; i < c0; i++) arr[index++] = 0; // Fill 0s
        for (int i = 0; i < c1; i++) arr[index++] = 1; // Fill 1s
        for (int i = 0; i < c2; i++) arr[index++] = 2; // Fill 2s
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2, 1, 0};
        
        countSort (arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
