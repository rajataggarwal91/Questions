import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode parent;

    TreeNode(int val) {
        this.val = val;
    }
}

public class CreateBST {
    public static void main(String args[]) {
        TreeNode root = createBST(new int[]{-1,-1,0,4,5,6,7,8}, 0, 7);

        root.right.right.right.right = new TreeNode(9);
        System.out.println(isBalanced(root));
        System.out.println(findSuccessor(root).val);
        System.out.println(findSuccessor(root.left.right).val);
        System.out.println("Common Ancestor: " + findCommonAncestor(root.left.right, root).val);
        //root = deleteNode(4);
        treePrinter(root);
    }

    private static TreeNode createBST(int[] arr, int start, int end) {
        int mid = (start + end)/2;
        if (start > end) return null;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createBST(arr, start, mid - 1);
        node.right = createBST(arr, mid + 1, end);
        if (node.left != null) node.left.parent = node;
        if (node.right != null) node.right.parent = node;

        return node;
    }

    private static void treePrinter(TreeNode root) {
        if (root == null) return;
        treePrinter(root.left);
        //System.out.print(root.val + " : " + depthMap.get(root) + ",");
        treePrinter(root.right);
    }

    static HashMap<TreeNode, Integer> depthMap = new HashMap<>();

    private static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int ldepth = depth(root.left, 1);
        int rdepth = depth(root.right, 1);
        depthMap.putIfAbsent(root, Math.max(ldepth, rdepth));
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(ldepth - rdepth) <= 1;
    }

    private static int depth(TreeNode root, int depth) {
        if (root == null) return depth - 1;
        if (depthMap.containsKey(root)) return depthMap.get(root);
        int ldepth = depth(root.left, depth + 1);
        int rdepth = depth(root.right, depth + 1);
        return Math.max(ldepth, rdepth);
    }


    // Three cases:
    //1. Node is the left child of parent, parent is the next node.
    //2, Node has right child, right child is successor.
    //3. Node is right child and has no children, go up until node is not left child of parent or null, return parent
    // or null.
    private static TreeNode findSuccessor(TreeNode node) {
        if (node.right !=null) return node.right;
        TreeNode temp = node;
        while (temp != null && temp.parent.left != temp) { temp = temp.parent; }
        return temp == null ? null : temp.parent;
    }


    // Move upwards from root1 and root2 together after leveling their depth.
    private static TreeNode findCommonAncestor(TreeNode root1, TreeNode root2) {
        //first find the depth of each node
        TreeNode temp = root1;
        int depth1 = 0;
        while (temp != null) {
            temp = temp.parent;
            depth1++;
        }

        temp = root2;
        int depth2 = 0;
        while (temp != null) {
            temp = temp.parent;
            depth2++;
        }

        if (depth2 > depth1) {
            for (int i = 0 ; i < depth2 - depth1; i++) {
                root2 = root2.parent;
            }
        } else {
            for (int i = 0 ; i < depth1 - depth2; i++) {
                root1 = root1.parent;
            }
        }

        while(root1 != null && root1 != root2) {
            root1 = root1.parent;
            root2 = root2.parent;
        }

        return root1;

    }

}

