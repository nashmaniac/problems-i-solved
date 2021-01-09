package medium;

import java.util.*;

public class leetcode_199 {

    class  TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }

    class Elem {
        TreeNode node;
        int level;
        Elem(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public void BFS(TreeNode root, ArrayList<Integer>[] arr) {
        if(root == null) {
            return;
        }
        Queue<Elem> q = new LinkedList<>();
        q.offer(new Elem(root, 0));
        while (!q.isEmpty()) {
            Elem node = q.poll();
            arr[node.level].add(node.node.val);

            if(node.node.left != null) {
                q.offer(new Elem(node.node.left, node.level+1));
            }
            if(node.node.right != null) {
                q.offer(new Elem(node.node.right, node.level+1));
            }
        }

    }

    public int findHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1+ Math.max(findHeight(root.left), findHeight(root.right));
    }

    public List<Integer> rightSideView(TreeNode root) {
        int h = findHeight(root);

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer>[] arr = new ArrayList[h];


        for(int i=0;i<h;i++) {
            arr[i] = new ArrayList<>();
        }
        BFS(root, arr);

        for(int i=0;i<arr.length;i++) {
            if(!arr[i].isEmpty()) {
                a.add(arr[i].get(arr[i].size()-1));
            }
        }
        return a;
    }

    public void solve() {
    }

    public static void main(String[] args) {
        leetcode_199 t = new leetcode_199();
        t.solve();
    }
}
