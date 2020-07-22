/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
	public List <List<Integer>> zigzagLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList <TreeNode>();
		queue.offer(root);
		int level = 0;
		List <List<Integer>> mainList = new ArrayList <List<Integer>>();
		if (root == null) {
			return mainList;
		}
		List <Integer> subList = null;
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			subList = new ArrayList <Integer> ();
			while (queueSize > 0) {
				TreeNode temp = queue.poll();
				if (level % 2 == 0) {
					subList.add(temp.val);
				}
				else {
					subList.add(0, temp.val);
				}
				if (temp.left != null) {
					queue.offer(temp.left);
				}
				if (temp.right != null) {
					queue.offer(temp.right);
				}
				queueSize--;
			}
			mainList.add(subList);
			level++;
		}
		return mainList;
	}
}