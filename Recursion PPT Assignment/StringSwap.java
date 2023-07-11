public class StringSwap {
    public static boolean areAlmostEqual(String s, String goal) {
        int n = s.length();
        int diffCount = 0;
        int[] diffIndices = new int[2];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (diffCount >= 2) {
                    return false;
                }
                diffIndices[diffCount] = i;
                diffCount++;
            }
        }

        if (diffCount == 0) {
            return true; // Strings are already equal
        } else if (diffCount == 2) {
            // Check if swapping the characters makes the strings equal
            char c1 = s.charAt(diffIndices[0]);
            char c2 = s.charAt(diffIndices[1]);
            char g1 = goal.charAt(diffIndices[0]);
            char g2 = goal.charAt(diffIndices[1]);
            return c1 == g2 && c2 == g1;
        } else {
            return false; // More than two differences, cannot make equal
        }
    }

    public static void main(String[] args) {
        String s = "ab";
        String goal = "ba";

        boolean canSwap = areAlmostEqual(s, goal);

        System.out.println("Can swap two letters to make s equal to goal? " + canSwap);
    }
}
