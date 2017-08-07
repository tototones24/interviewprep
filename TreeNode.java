public class TreeNode {

	TreeNode left = null;
	TreeNode right = null;
	int data;
	public TreeNode(int node) {
		data = node;
	}

	public static void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	} 


	public static void main(String[] args) {
		TreeNode tree = new TreeNode(8);
		TreeNode leftNode = new TreeNode(1);
		TreeNode rightNode = new TreeNode(10);
		TreeNode leftleft = new TreeNode(3);
		TreeNode leftRight = new TreeNode(2);
		TreeNode rightLeft = new TreeNode(5);
		TreeNode rightRight = new TreeNode(11);
		leftNode.left = leftleft;
		leftleft.right = leftRight;
		rightNode.left = rightLeft;
		rightNode.right = rightRight;
		tree.left = leftNode;	
		tree.right = rightNode;
		// System.out.println(tree.left.data);
		inOrder(tree);

	}

}
