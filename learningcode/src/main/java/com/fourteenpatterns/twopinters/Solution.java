package com.fourteenpatterns.twopinters;

/*
Given two strings s and t, return true if they are equal
when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
 */
public class Solution {

    public static void main(String[] args) {
        String s = "ab##", t = "c#d#";
        System.out.println(areStringsEqual(s,t));
    }

    public static boolean areStringsEqual(String s, String t) {
        int p1 = s.length()-1;
        int p2 = t.length()-1;
        if(p1==-1 && p2==-1) {
            return true;
        }
        while (p1>=0 && p2>=0) {
            System.out.println("Iteration "+p1+ " "+p2);
            if (s.charAt(p1) != t.charAt(p2)) {
                return false;
            }
            p1 = getNextPointer(s,p1);
            System.out.println("p1 :"+p1);
            p2 = getNextPointer(t,p2);
            System.out.println("p2 :"+p2);
        }
        System.out.println("final :"+p1+ " "+p2);
        if(p1==p2) {
            return true;
        }
        return false;
    }

    private static int getNextPointer(String s, int p) {
        System.out.println("String "+s+" p "+p);
        if(p<=0) {
            return -1;
        }
        int bckSpcCount = 0;
        if(s.charAt(p)=='#') {
            bckSpcCount++;
            while(bckSpcCount>0) {
                System.out.println(bckSpcCount+" ; "+p);
                p--;
                if(p<0) {
                    return 0;
                }
                if(s.charAt(p)=='#') {
                    bckSpcCount++;
                }
                bckSpcCount--;
            }
        } else {
            if(s.charAt(p-1)=='#') {
                return getNextPointer(s,p-1);
            } else {
                return p - 1;
            }
        }
        return p-1;
    }
}
