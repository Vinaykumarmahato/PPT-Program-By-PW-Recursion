import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ConstructBinaryTreeFromString {
    public static TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        StringBuilder num = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(new TreeNode(Integer.parseInt(num.toString())));
                num = new StringBuilder();
            } else if (c == ')') {
                TreeNode child = stack.pop();
                TreeNode parent = stack.peek();

                if (parent.left == null) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            } else {
                num.append(c);
            }
        }

        if (num.length() > 0) {
            TreeNode node = new TreeNode(Integer.parseInt(num.toString()));
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            return node;
        }

        return stack.peek();
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.print(root.val + " ");
            inOrderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        String s = "4(2(3)(1))(6(5))";

        TreeNode root = str2tree(s);

        System.out.print("In-order traversal of the constructed binary tree: ");
        inOrderTraversal(root);
    }
}
