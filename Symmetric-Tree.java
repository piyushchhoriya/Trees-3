// ## Problem2 (https://leetcode.com/problems/symmetric-tree/)
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
// Input: root = [1,2,2,3,4,4,3]
// Output: true



// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :
Solution:
class Solution {
    //maintaining a global variable
    boolean isSymetric;
    public boolean isSymmetric(TreeNode root) {
        //best case condition check
        if(root ==null){
            return true;
        }
        isSymetric = true;
        dfs(root.left,root.right);
        return isSymetric;
    }
    private void dfs(TreeNode left, TreeNode right){
        //base case condition check and processing
        if(left==null && right==null){
            return;
        }
        if(left == null || right==null){
            isSymetric=false;
            return;
        }
        if(left.val != right.val){
            isSymetric=false;
            return;
        }
        //Recursive calls
        dfs(left.left,right.right);
        dfs(left.right, right.left);
    }
}

//Code Optimization by removing global variable
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root ==null){
            return true;
        }
        return dfs(root.left,root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left == null || right==null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }

        boolean case1 = dfs(left.left,right.right);
         boolean case2 = dfs(left.right, right.left);

         return case1 && case2;
    }
}

//Further code optimization
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root ==null){
            return true;
        }
        return dfs(root.left,root.right);
    }
    private boolean dfs(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left == null || right==null){
            return false;
        }
        if(left.val != right.val){
            return false;
        }

         return dfs(left.left,right.right) && dfs(left.right, right.left);
    }
}