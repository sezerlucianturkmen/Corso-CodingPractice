package com.corso;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringBalanced {

    static boolean balanced(int small[], int caps[]) {

        for (int i = 0; i < 26; i++) {
            if (small[i] != 0 && (caps[i] == 0))
                return false;

            else if ((small[i] == 0) && (caps[i] != 0))
                return false;
        }
        return true;
    }

    static void smallestBalancedSubstring(String s) {

        int[] small = new int[26];
        int[] caps = new int[26];

        Arrays.fill(small, 0);
        Arrays.fill(caps, 0);

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
                caps[s.charAt(i) - 'A']++;
            else
                small[s.charAt(i) - 'a']++;
        }

        Map<Character, Integer> mp = new HashMap<Character, Integer>();

        for (int i = 0; i < 26; i++) {
            if (small[i] != 0 && caps[i] == 0)
                mp.put((char) (i + 'a'), 1);
            else if (caps[i] != 0 && small[i] == 0)
                mp.put((char) (i + 'A'), 1);
        }

        Arrays.fill(small, 0);
        Arrays.fill(caps, 0);

        int i = 0, st = 0;

        int start = -1, end = -1;

        int minm = Integer.MAX_VALUE;
        while (i < s.length()) {
            if (mp.get(s.charAt(i)) != null) {

                while (st < i) {
                    if (s.charAt(st) >= 65 && s.charAt(st) <= 90)
                        caps[s.charAt(st) - 'A']--;
                    else
                        small[s.charAt(st) - 'a']--;
                    st++;
                }
                i += 1;
                st = i;
            } else {
                if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
                    caps[s.charAt(i) - 'A']++;
                else
                    small[s.charAt(i) - 'a']++;

                while (true) {
                    if (s.charAt(st) >= 65 && s.charAt(st) <= 90 && caps[s.charAt(st) - 'A'] > 1) {
                        caps[s.charAt(st) - 'A']--;
                        st++;
                    } else if (s.charAt(st) >= 97 && s.charAt(st) <= 122 && small[s.charAt(st) - 'a'] > 1) {
                        small[s.charAt(st) - 'a']--;
                        st++;
                    } else
                        break;
                }

                if (balanced(small, caps)) {
                    if (minm > (i - st + 1)) {
                        minm = i - st + 1;
                        start = st;
                        end = i;
                    }
                }
                i += 1;
            }
        }

        if (start == -1 || end == -1)
            System.out.println(-1);

        else {
            String ans = "";
            for (int j = start; j <= end; j++)
                ans += s.charAt(j);
            System.out.println(ans);
        }
    }

    public static void main(String[] args) {
        String s = "azABaabba";
        smallestBalancedSubstring(s);
    }
}
