package com.billy.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Billy_Cui on 2018/8/6
 * Describe:
 */

public class 探索_二维数组 {
    /**
     * 对角线遍历
     * <p>
     * <p>
     * https://www.cnblogs.com/grandyang/p/6414461.html
     * 规律   右上左下对角线  偶数是上行 , 奇数是下降
     *
     * @param matrix
     * @return
     */
    public int[] findDiagonalOrder(int[][] matrix) {
//        if (matrix == null){
//            throw new IllegalArgumentException("参数不可用");
//        }
//        int row = matrix.length;
//        int column = matrix[0].length;
//        int[] result = new int[row * column];
//
//        int temRow = 0;
//        int temColume = 0;
//
//        int recordRow = 0;
//        int recordColume = 0;
//        boolean up = true;
//        for (int i = 0; i < result.length; i++) {
//            result[i] = matrix[recordRow][recordColume];
//            if (up) {
//                temRow = recordRow - 1;
//                temColume = recordColume + 1;
//                if (row > temRow && temRow >= 0 && column > temColume && temColume >= 0) {
//                    recordColume = temColume;
//                    recordRow = temRow;
//                } else if (recordColume == column-1 && recordRow ==0){
//                    recordRow += 1;
//                    up = false;
//                }else{
//                    if (temRow < 0) {
//                        recordColume = temColume;
//                        up = false;
//                    }
//                    if (temColume > column - 1) {
//                        recordRow += 1;
//                        up = false;
//                    }
//                }
//            } else {
//                temRow = recordRow + 1;
//                temColume = recordColume - 1;
//
//                if (row > temRow && temRow >= 0 && column > temColume && temColume >= 0) {
//                    recordColume = temColume;
//                    recordRow = temRow;
//                }else if (recordColume == 0 && recordRow ==row-1){
//                    recordColume += 1;
//                    up = true;
//                } else {
//                    if (temColume < 0) {
//                        recordRow = temRow;
//                        up = true;
//                    }
//                    if (temRow > row - 1) {
//                        recordColume += 1;
//                        up = true;
//                    }
//                }
//            }
//        }
        if (matrix == null || matrix.length == 0) {
            return new int[0];
        }
        int row = matrix.length;
        int column = matrix[0].length;
        int[] result = new int[row * column];
        int r = 0, c = 0, k = 0;
        int[][] dirs = {{-1, 1}, {1, -1}};
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[r][c];
            r += dirs[k][0];
            c += dirs[k][1];
            if (r >= row) {
                r = row - 1;
                c += 2;
                k = 1 - k;
            }
            if (c >= column) {
                c = column - 1;
                r += 2;
                k = 1 - k;
            }
            if (r < 0) {
                r = 0;
                k = 1 - k;
            }
            if (c < 0) {
                c = 0;
                k = 1 - k;
            }
        }
        return result;
    }

    /**
     * 螺旋矩阵
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        //上 右 下 左
        int[][] border = {{0, matrix.length}, {0, matrix[0].length}};
        int[][] dirs = {{0, 1, 0, -1}, {1, 0, -1, 0}};
        int r = 0, c = 0, d = 0;
        for (int i = 0; i < matrix.length * matrix[0].length; i++) {
            System.out.println("r:" + r + ",c" + c);
            System.out.println(matrix[r][c]);
            list.add(matrix[r][c]);
            //列
            r += dirs[0][d];
            //行
            c += dirs[1][d];
            if (c >= border[1][1]) {
                border[0][0] += 1;
                r += 1;
                c -= 1;
                d = (d + 1) % 4;
            }
            if (r >= border[0][1]) {
                border[1][1] -= 1;
                r -= 1;
                c -= 1;
                d = (d + 1) % 4;
            }
            if (c < border[1][0]) {
                border[0][1] -= 1;
                r -= 1;
                c += 1;
                d = (d + 1) % 4;
            }
            if (r < border[0][0]) {
                border[1][0] += 1;
                r += 1;
                c += 1;
                d = (d + 1) % 4;
            }
        }
        return list;
    }


    /**
     * 杨辉三角
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listList = new ArrayList<>();
        List<Integer> list = null;
        int[][] result = new int[numRows][numRows];
        for (int i = 0; i < numRows; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (i == j || j == 0) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
                }
                list.add(result[i][j]);
            }
            listList.add(list);
        }
        return listList;
    }

    @Test
    public void main() {
        int[][] init = new int[3][4];
        init[0] = new int[]{1, 2, 3, 4};
        init[1] = new int[]{5, 6, 7, 8};
        init[2] = new int[]{9, 10, 11, 12};
//        init[3] = new int[]{13,14,15,16};
//        findDiagonalOrder(init);
//        System.out.print("index:" + dominantIndex(new int[]{3, 0, 0, 2}));
//        spiralOrder(init);
        generate(5);
    }
}
