/*Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
*/
//code
class Solution {
    public List<List<Integer>> permute(int[] nums) {                                                
        List<List<Integer>>ans=new ArrayList<>();                                               
        recurPermute(0, nums, ans);                                                 
        return ans;                                                 
    }                                                
    private void recurPermute(int index,int[] nums,List<List<Integer>>ans) {                                                
        if (index == nums.length){                                                 
            Lis<Integer>ds = new ArrayList<>();                                                 
            for (int i = 0; i < nums.length; i++) {   
                ds.add(nums[i]);                                                
            }                                
            ans.add(new ArrayList < > (ds));                                                
            return;                                                 
        }                                               
        for (int i = index;i<nums.length;i++){                                                 
            swap(i, index, nums);                                               
            recurPermute(index + 1, nums, ans);                                                 
            swap(i, index, nums);                                               
        }                                               
    }                                               
    private void swap(int i, int j, int[] nums) {                                               
        int t = nums[i];                                                
        nums[i] = nums[j];                                              
        nums[j] = t;                                                
    }                                               
}
