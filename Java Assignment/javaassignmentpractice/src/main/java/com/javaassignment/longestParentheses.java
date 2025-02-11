package com.javaassignment;

public class longestParentheses {
    public static int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLength = 0;

    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            left++;
        } else {
            right++;
        }

        if (left == right) {
            maxLength = Math.max(maxLength, 2 * right);
        } else if (right > left) { 
            left = right = 0;
        }
    }

    left = right = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == ')') {
            right++;
        } else {
            left++;
        }

        if (left == right) {
            maxLength = Math.max(maxLength, 2 * left);
        } else if (left > right) { 
            left = right = 0;
        }
    }

    return maxLength;
}

public static void main(String[] args) {
    String s1 = "((()";
    System.out.println("Output: " + longestValidParentheses(s1)); 

    String s2 = ")()())";
    System.out.println("Output: " + longestValidParentheses(s2)); 
}
}
