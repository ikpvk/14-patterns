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
public class BackspaceStringCompare {

    public static void main(String[] args) {
        String s = "nzp#o#g", t = "b#nzp#o#g";
        System.out.println(areStringsEqual(s, t));
//        System.out.println(getNextPointer("asbc##",1));
    }

    public static boolean areStringsEqual(String s, String t) {
        // Initialize two pointers for iterating through the strings in reverse.
        int pointerS = s.length() - 1, pointerT = t.length() - 1;
        // Variables to keep track of the number of backspaces found.
        int skipS = 0, skipT = 0;

        // Continue comparing characters until both pointers go beyond the start of the string.
        while (pointerS >= 0 || pointerT >= 0) {
            // Process backspaces in string s.
            while (pointerS >= 0) {
                if (s.charAt(pointerS) == '#') {
                    skipS++; // We found a backspace character.
                    pointerS--; // Move one character back.
                } else if (skipS > 0) {
                    skipS--; // Reduce the backspace count.
                    pointerS--; // Skip over this character.
                } else {
                    break; // Found a character to compare.
                }
            }
            // Process backspaces in string t.
            while (pointerT >= 0) {
                if (t.charAt(pointerT) == '#') {
                    skipT++; // We found a backspace character.
                    pointerT--; // Move one character back.
                } else if (skipT > 0) {
                    skipT--; // Reduce the backspace count.
                    pointerT--; // Skip over this character.
                } else {
                    break; // Found a character to compare.
                }
            }

            // Compare the characters of both strings.
            if (pointerS >= 0 && pointerT >= 0) {
                // If characters do not match, return false.
                if (s.charAt(pointerS) != t.charAt(pointerT)) {
                    return false;
                }
            } else if (pointerS >= 0 || pointerT >= 0) {
                // If one pointer has reached the start but the other has not, they do not match.
                return false;
            }
            // Move to the next characters to compare.
            pointerS--;
            pointerT--;
        }
        // All characters match considering the backspace characters.
        return true;
    }
}
