package arrays_part_4.Day_8;

import java.util.Arrays;
import java.util.HashSet;

public class P24_LongestSubStringWithoutReaptingChar {
    
    // TC -> O(n)
    // SC -> O(n)
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int len = 0;
        int l = 0;
        for(int r=0; r<s.length(); r++) {
            while(hs.contains(s.charAt(r))) {
                hs.remove(s.charAt(l));
                l++;
            }
            hs.add(s.charAt(r));
            len = Math.max(len, r - l + 1);
        }
        return len;
    }
}
