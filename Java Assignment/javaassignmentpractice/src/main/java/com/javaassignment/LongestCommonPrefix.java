package com.javaassignment;

public class LongestCommonPrefix {

    public static String longestPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i); 

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0]; 
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Output: " + longestPrefix(strs1)); 

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Output: " + longestPrefix(strs2));
    }
}
