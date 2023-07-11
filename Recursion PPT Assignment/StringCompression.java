public class StringCompression {
    public static int compress(char[] chars) {
        int n = chars.length;
        int anchor = 0; // Start of the current group
        int writeIndex = 0; // Index to write the compressed characters

        for (int readIndex = 0; readIndex < n; readIndex++) {
            // Check if it's the last character or the next character is different
            if (readIndex + 1 == n || chars[readIndex] != chars[readIndex + 1]) {
                chars[writeIndex++] = chars[anchor]; // Write the character
                
                // Check if the group has more than one character
                if (readIndex > anchor) {
                    String count = String.valueOf(readIndex - anchor + 1);
                    for (char c : count.toCharArray()) {
                        chars[writeIndex++] = c; // Write the group's length
                    }
                }
                
                anchor = readIndex + 1; // Move the anchor to the start of the next group
            }
        }
        
        return writeIndex; // Return the new length of the compressed array
    }

    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        int newLength = compress(chars);

        System.out.print("Compressed array: [");
        for (int i = 0; i < newLength; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print("'" + chars[i] + "'");
        }
        System.out.println("]");
    }
}
