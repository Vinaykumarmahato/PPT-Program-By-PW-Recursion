import java.util.ArrayList;
import java.util.List;

public class AnagramsInString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();

        if (s.length() < p.length()) {
            return indices;
        }

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Count the characters in pattern string p
        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        // Slide a window of size p.length() over string s
        for (int i = 0; i < s.length(); i++) {
            // Add the current character to the window count
            sCount[s.charAt(i) - 'a']++;

            // Remove the leftmost character from the window count if it's outside the window size
            if (i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // Check if the window count matches the pattern count
            if (i >= p.length() - 1 && matches(pCount, sCount)) {
                indices.add(i - p.length() + 1);
            }
        }

        return indices;
    }

    private static boolean matches(int[] pCount, int[] sCount) {
        for (int i = 0; i < 26; i++) {
            if (pCount[i] != sCount[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> indices = findAnagrams(s, p);

        System.out.println("Start indices of p's anagrams in s: " + indices);
    }
}
