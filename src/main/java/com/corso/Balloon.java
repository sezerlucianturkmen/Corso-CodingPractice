package com.corso;

import java.util.ArrayList;
import java.util.List;

public class Balloon {
    public int solution(String S) {

        List<Character> list = new ArrayList();

        for (int i = 0; i < S.length(); i++) {
            list.add(S.charAt(i));
        }

        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;

        for (int i = 0; i < S.length(); i++) {

            if (list.contains(S.charAt(i))) {
                if (S.charAt(i) == 'B') {
                    b++;
                } else if (S.charAt(i) == 'A') {
                    a++;
                } else if (S.charAt(i) == 'L') {
                    l++;
                } else if (S.charAt(i) == 'O') {
                    o++;
                } else if (S.charAt(i) == 'N') {
                    n++;
                }
            }
        }

        l = l / 2;
        o = o / 2;

        int min = b;
        int[] am = { b, a, l, o, n };
        for (int j = 0; j < am.length; j++) {
            min = Math.min(min, am[j]);
        }
        return min;

    }

    public static void main(String[] args) {

        Balloon balloon = new Balloon();
        int print1 = balloon.solution("BAONXXOLL");
        System.out.println(print1);
        int print2 = balloon.solution("BAOOLLNNOLOLGBAX");
        System.out.println(print2);
        int print3 = balloon.solution("QAWABAWONL");
        System.out.println(print3);
        int print4 = balloon.solution("ONLABLABLOON");
        System.out.println(print4);

    }
}