/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
 

Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1
*/

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
class Solution {
    public boolean isValidBST(TreeNode root) {

        // Can be checked by getting inorder values in an array and checking if the array is sorted
        // One way is to print out all nodes in inorder traversal and check if array is sorted

        TreeNode prev = null;

        // compare the prev node with the current node
        // check if cur > prev just like a sorted array for inorder traversal.

        return helper(root, prev); 
    }

    public boolean helper(TreeNode root, TreeNode prev) {

        if (root == null) {
            return true;
        }

        if (!helper(root.left, prev)) {
            return false;
        }

        if (prev != null && root.val <= prev.val) {
            return false;
        }

        prev = root;

        return helper(root.right, prev);  
    }
}
