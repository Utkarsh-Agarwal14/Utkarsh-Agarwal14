/*
Given the root of a binary tree, return all duplicate subtrees.

For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with the same node values.

 

Example 1:


Input: root = [1,2,3,4,null,2,4,null,null,4]
Output: [[2,4],[4]]


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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans=new LinkedList<>();
        if(root == null){
            return null;
        }
        hm=new HashMap<>();
        helper(root);
        return ans;
    }
    List<TreeNode> ans;
    HashMap<String,Integer> hm;
    public String helper(TreeNode root){
        if(root == null){
            return "null";
        }

        String lefts=helper(root.left);
        String rights=helper(root.right);
        String x=Integer.toString(root.val)+", "+lefts+", "+rights;
        hm.put(x,hm.getOrDefault(x,0)+1);
        if(hm.get(x)== 2){
            ans.add(root);
        }
        return x;
        }
}
