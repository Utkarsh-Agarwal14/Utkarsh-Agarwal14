/*

Given the root of a binary tree, return the maximum width of the given tree.

The maximum width of a tree is the maximum width among all levels.

The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.

It is guaranteed that the answer will in the range of a 32-bit signed integer.

Example 1:


Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width exists in the third level with length 4 (5,3,null,9).
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
class pair{
    int pos;
    TreeNode node;
    pair(int pos,TreeNode node){
        this.pos=pos;
        this.node=node;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        int ans=0;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,root));

        while(!q.isEmpty()){
            int size=q.size();
            int start=0;
            int end=0;
            for(int i=0;i<size;i++){
                pair p=q.remove();
                int pos=p.pos;
                if(i==0){
                    start=pos;
                }
                if(i== size-1){
                    end=pos;
                }

                if(p.node.left != null){
                    q.add(new pair(2*pos+1,p.node.left));
                }
                if(p.node.right != null){
                    q.add(new pair(2*pos+2,p.node.right));
                }

            }
            ans=Math.max(ans,end+1-start);
        }
    return ans;
}
}
