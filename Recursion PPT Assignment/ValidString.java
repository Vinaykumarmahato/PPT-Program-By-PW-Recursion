public class ValidString {
    public static boolean checkValidString(String s) {
        int leftBalance = 0;
        int starBalance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftBalance++;
            } else if (c == '*') {
                starBalance++;
            } else {
                // If no left parenthesis or star to balance with
                if (leftBalance == 0 && starBalance == 0) {
                    return false;
                }
                
                // Use a left parenthesis to balance if available
                if (leftBalance > 0) {
                    leftBalance--;
                }
                // Use a star to balance if available
                else {
                    starBalance--;
                }
            }
        }

        // Check remaining left parenthesis and stars
        while (leftBalance > 0 && starBalance > 0) {
            leftBalance--;
            starBalance--;
        }

        return leftBalance == 0;
    }

    public static void main(String[] args) {
        String s = "()";

        boolean isValid = checkValidString(s);

        System.out.println("Is the string valid? " + isValid);
    }
}
