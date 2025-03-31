package com.fourteenpatterns.twopinters;

/*
Comparing strings that contain backspaces (medium)

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
        String s = "nzp#o#g", t = "b#nzp#o#g";
        System.out.println(areStringsEqual(s, t));
//        System.out.println(getNextPointer("asbc##",1));
    }

    public static boolean areStringsEqual(String s, String t) {
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;
        if (p1 == -1 && p2 == -1) {
            return true;
        }
        while (p1 >= 0 && p2 >= 0) {
            int nextp2 = getNextPointer(t, p2);
            int nextp1 = getNextPointer(s, p1);
            if (nextp2 < 0 && nextp1 < 0) {
                return true;
            }
            if ((nextp2 < 0 && nextp1 >= 0) || (nextp1 < 0 && nextp2 >= 0)) {
                return false;
            }
            if (s.charAt(nextp1) == t.charAt(nextp2)) {
                p1 = nextp1 - 1;
                p2 = nextp2 - 1;
            } else {
                return false;
            }
        }
        if (p1 == p2) {
            return true;
        }
        return false;
    }

    private static int getNextPointer(String s, int p) {
        if (p <= 0) {
            return p;
        }
        int backSpaceCounter = 0;
        int iterator = p;
        while (iterator >= 0) {
            if (s.charAt(iterator) == '#') {
                backSpaceCounter++;
                iterator--;
            } else if (backSpaceCounter > 0) {
                backSpaceCounter--;
                iterator--;
            } else {
                break;
            }
        }
        return iterator;
    }
}
