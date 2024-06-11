package com.fourteenpatterns.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class Solution {
/*
Given two strings s and p, 
return an array of all the start indices of p's anagrams in s. 
You may return the answer in any order.

Input: s = "abab", p = "ab"
Output: [0,1,2]
*/    

    public static void main(String[] args) {
        String s = "abab", p = "ab";
        for(Integer i : solution(s,p)) {
            System.out.print(i+ " ");
        }

        System.out.println();
        s = "cbaebabacd";
        p = "abc";
        for(Integer i : solution(s,p)) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }

    public static int[] solution(String s, String p) {
        
        List<Integer> resultList = new ArrayList();
        int[] charCounter = new int[26];

        for(int i=0; i<p.length(); i++) {
            charCounter[p.charAt(i) - 'a']++;
        }

        int windowSize = p.length();

        for(int i=0; i<=s.length()-windowSize; i++) {
            if(isAnagram(i,s,windowSize,charCounter)) {
                resultList.add(i);
            }
        }

        
        int[] resultArray = new int[resultList.size()];
        int pos = 0;
        for(Integer i : resultList) {
            resultArray[pos++] = i;
        }
        return resultArray;
    }

    public static boolean isAnagram(int i, String s, int windowSize, int[] charCounter) {
        int[] cloneCounter = charCounter.clone();
        for(int j=0; j<windowSize; j++) {
            if(cloneCounter[s.charAt(i)-'a']==0) {
                return false;
            }
            cloneCounter[s.charAt(i)-'a']--;
            i++;
        }
        return true;
    }
}
