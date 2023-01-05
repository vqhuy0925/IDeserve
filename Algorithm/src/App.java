public class App {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.root = new TreeNode(1);
        solution.root.left = new TreeNode(2);
        solution.root.right = new TreeNode(3);
        solution.root.left.left = new TreeNode(4);
        solution.root.left.right = new TreeNode(5);
        solution.root.left.right.left = new TreeNode(7);
        solution.root.left.right.right = new TreeNode(8);

        TreeNode result = solution.lowestCommonAncestor(4, 8);
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode sort = solution.sortArrayToBST(arr, 1, 7);

        System.out.println(result.val);
        solution.preOrder(sort);
    }
}

class Solution {
    TreeNode root;

    TreeNode lowestCommonAncestor(int n1, int n2) {
        return lowestCommonAncestor(root, n1, n2);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        } else {
            return left;
        }
    }

    TreeNode sortArrayToBST(int arr[], int start, int end){
        if(start > end){
            return null;
        }

        int mid = (start + end ) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        node.left = sortArrayToBST(arr, start, mid-1);
        node.right = sortArrayToBST(arr, mid + 1, end);
        return node;
    }

    void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
