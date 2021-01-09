package medium;

import java.util.ArrayList;
import java.util.List;

public class leetcode_54 {
    public void solve() {
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new ArrayList<>();
        }

        ArrayList<Integer> arr = new ArrayList<>();
        int r1 = 0, r2 = matrix.length-1, c1 = 0, c2 = matrix[0].length-1;

        while(r1 >= r2 && c1>= c2) {
            // row traverse
            for(int i=c1;i<=c2;i++) {
                arr.add(matrix[r1][i]);
            }

            // down
            for(int i=r1+1;i<=r2;i++) {
                arr.add(matrix[i][c2]);
            }

            for(int i=c2-1;i>c1;i--) {
                arr.add(matrix[r2][i]);
            }

            for(int i=r2-1;i>r1;i--) {
                arr.add(matrix[i][c1]);
            }

            r1++;
            r2--;
            c1++;
            c2--;

        }
        return arr;


    }

    public static void main(String[] args) {
        leetcode_54 t = new leetcode_54();
        t.solve();
    }
}