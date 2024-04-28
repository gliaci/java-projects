package com.gliaci.easy;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int minStringLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minStringLength) {
                minStringLength = strs[i].length();
            }
        }

        int stringLengthIndex = 0;
        boolean hasSameChar = true;
        StringBuilder longestCommonPrefix = new StringBuilder();
        while (stringLengthIndex < minStringLength && hasSameChar)
        {
            char firstStringChar = strs[0].charAt(stringLengthIndex);

            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(stringLengthIndex) != firstStringChar || strs[strs.length - i - 1].charAt(stringLengthIndex) != firstStringChar) {
                    hasSameChar = false;
                    break;
                }

            }
            if (hasSameChar) {
                longestCommonPrefix.append(firstStringChar);
            }
            stringLengthIndex++;
        }
        return longestCommonPrefix.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        List<String[]> arrayToTestList = List.of(
                new String[]{"a","a","b"},
                new String[]{"ab", "a"},
                new String[]{"dog","racecar","car"},
                new String[]{"flower","flow","flight"},
                new String[]{"reflower","flow","flight"},
                new String[]{"flower","flower","flower", "flower"},
                new String[]{"cir","car"}
        );
        for (String[] strings : arrayToTestList) {
            System.out.printf("LongestCommonPrefix of %s is %s\n", Arrays.toString(strings), getLongestCommonPrefix(strings, longestCommonPrefix));
        }
    }

    private static String getLongestCommonPrefix(String[] strings, LongestCommonPrefix longestCommonPrefix) {
        Instant start = Instant.now();
        String result = longestCommonPrefix.longestCommonPrefix2(strings);
        Instant end = Instant.now();
        System.out.printf("Execution time: %s%n", Duration.between(start, end).toNanos());
        return result;
    }
}
