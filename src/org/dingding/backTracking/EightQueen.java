package org.dingding.backTracking;

/**
 * 八皇后问题
 * 回溯思想和递归问题
 * 说是回溯，其实只是当前一步不可行时直接终止尝试，不打印结果（这个叫剪枝技巧）。相当于回溯到上一步了
 * 当前皇后的米字延伸线上不能有棋子
 *
 * @author dzj
 */
public class EightQueen {

    int[] result = new int[8];// 全局或成员变量, 下标表示行, 值表示 queen 存储在哪一列

    public void cal8queens(int row) { // 调用方式：cal8queens(0);
        if (row == 8) { // 8 个棋子都放置好了，打印结果
            printQueens(result);
            return; // 8 行棋子都放好了，已经没法再往下递归了，所以就 return
        }
        for (int column = 0; column < 8; ++column) { // 每一行都有 8 中放法
            if (isOk(row, column)) { // 有些放法不满足要求
                result[row] = column; // 第 row 行的棋子放到了 column 列
                cal8queens(row + 1); // 考察下一行
            }
        }
    }

    // 检查是否符合条件这个地方需要理解一下是怎么检查的，其他地方不需要记忆
    private boolean isOk(int row, int column) {// 判断 row 行 column 列放置是否合适
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; --i) { // 逐行往上考察每一行
            // !! 实际此处由当前行当前列向上逐行检查了米字形状的上半部分
            if (result[i] == column) return false; // 第 i 行的 column 列有棋子吗？
            if (leftUp >= 0) { // 考察左上对角线：第 i 行 leftUp 列有棋子吗？
                if (result[i] == leftUp) return false;
            }
            if (rightUp < 8) { // 考察右上对角线：第 i 行 rightUp 列有棋子吗？
                if (result[i] == rightUp) return false;
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }

    private void printQueens(int[] result) { // 打印出一个二维矩阵
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new EightQueen().cal8queens(0);
    }
}
