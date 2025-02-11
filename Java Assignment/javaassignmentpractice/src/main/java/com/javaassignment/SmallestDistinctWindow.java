package com.javaassignment;

import java.util.HashMap;
import java.util.HashSet;

public class SmallestDistinctWindow {
static int findSmallestWindow(String str) {
        int n = str.length();
        if (n == 0) return 0;

        HashSet<Character> uniqueChars = new HashSet<>();
        for (char ch : str.toCharArray()) {
            uniqueChars.add(ch);
        }
        int requiredUniqueCount = uniqueChars.size();

        HashMap<Character, Integer> charFrequency = new HashMap<>();
        int left = 0, minLen = Integer.MAX_VALUE, distinctCount = 0;

        for (int right = 0; right < n; right++) {
            char rightChar = str.charAt(right);
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            if (charFrequency.get(rightChar) == 1) {
                distinctCount++;
            }

            while (distinctCount == requiredUniqueCount) {
                minLen = Math.min(minLen, right - left + 1);
                
                char leftChar = str.charAt(left);
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);
                
                if (charFrequency.get(leftChar) == 0) {
                    distinctCount--;
                }
                left++;
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        System.out.println(findSmallestWindow("abca"));        
        System.out.println(findSmallestWindow("aaaa"));       
    }
}