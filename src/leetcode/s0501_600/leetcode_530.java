package leetcode.s0501_600;

import java.util.ArrayList;

public class leetcode_530 {

    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }

    public ArrayList<Integer> dfs(TreeNode root, ArrayList<Integer> arr) {
        if(root == null) {
            return new ArrayList<>();
        }
        dfs(root.left, arr);
        arr.add(root.val);
        dfs(root.right, arr);
        return arr;
    }

    public int getMinimumDifference(TreeNode root) {
        ArrayList<Integer> arr = dfs(root, new ArrayList<>());
        if(arr.size() == 0) {
            return 0;
        } else if(arr.size()==1) {
            return arr.get(0);
        } else if(arr.size()==2) {
            return Math.abs(arr.get(0)-arr.get(1));
        } else {
            int min = Integer.MAX_VALUE;

            for(int i=1;i<arr.size();i++) {
                if(Math.abs(arr.get(i-1)-arr.get(i))<min) {
                    min = Math.abs(arr.get(i-1)-arr.get(i));
                }
            }
            return min;
        }
    }



    public static void main(String[] args) {
        leetcode_530 t = new leetcode_530();
    }
}
