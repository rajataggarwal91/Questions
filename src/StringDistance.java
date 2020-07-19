public class StringDistance {
    public static void main(String args[]) {
    }
}


// /import java.io.*;
//import java.util.*;
//
///*
//
//input: stock price [124, 125, 121, 119, 122, 126, 123, 110]
//output: min num of days to wait to sell [1, 4, 2, 1, 1, 0, 0, 0]
//
//edit distance?
//
//lcuk
//luck
//
//c -> u
//u -> c
//
//swap
//
//
//aab
//abb
//
//ab
//abb
//= 1
//
//abcd
//abc
// a b c
//a
//b
//c
//d
//
//*/
//
//class Solution {
//    public static void main(String[] args) {
//        String s1 = "luck";
//        String s2 = "lcuk";
//        System.out.println(getEditDistance(s1, s2));
//    }
//
//    ac
//            abc
//
//    [d c b]
//    a  0
//    b    0
//    c
//
//    Math.min(getEditDistance(modify(s1.charAt(i), getEditDistance(swap(s1.charAt(i))), s1.substring(0, i) + insert(charAt(i)
//
//    int counter = 0;
//
//    private static int getEditDistance(String s1, String s2, int index) {
//
//        if (s1.equals(s2)) return 0;
//        if (s1.charAt(index) == s2.charAt(index))
//            getEditDistance(s1, s2, index + 1);
//
//        if (index >= s1.length() || index >= s2.length()) return Integer.MAX_VALUE;
//
//        String insertString = "";
//        String deletedString = "";
//        if (s2.length() > s1.length())
//            insertString = s1.substring (0, i) + s2.charAt(i) + s1.substring(i+1);
//        else
//            insertString = s2.substring (0, i) + s1.charAt(i) + s2.substring(i+1);
//
//        if (s2.length() > s1.length())
//            deletedString  = s2.substring (0, i) + s2.substring(i+1);
//        else
//            deletedString = s1.substring (0, i) +  s1.substring(i+1);
//
//
//        modifiedString  = s1.substring (0, i) + s2.charAt(i) + s1.substring(i+1);
//
//        int ti = i;
//        while (ti < s1.length() && ti < s2.length()) {
//            if (s2.charAt(ti) == s1.charAt(i) && s1.charAt(ti) == s2.charAt(i))           {
//                // swap characters in both the strings
//                // char ctemp = s2.charAt(i);
//                counter++;
//            }
//            ti++;
//        }
//
//        return Math.min(getEditDistance(insertString, s2, index + 1), getEditDistance(deletedString, s2, index + 1), getEditDistance(modifiedString, s2, index + 1)) + 1;
//
//    }
