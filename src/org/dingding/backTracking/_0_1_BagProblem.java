package org.dingding.backTracking;

/**
 * 0-1背包问题 回溯思想+递归+剪枝 （递归树
 * 背包容量w，一定数量的物品，判断背包最大的物品重量。物品不可分割
 * <p>
 * 实际是类似第一个物品是否装从虚拟根节点往下引申出一个二叉树。2^n个分支，只不过有些不符合条件的不会走下去，剪枝避免遍历所有情况
 *
 * @author dzj
 */
public class _0_1_BagProblem {

    public int maxW = Integer.MIN_VALUE; // 存储背包中物品总重量的最大值

    // curWeight 表示当前已经装进去的物品的重量和；
    // i 表示考察到哪个物品了；
    // bagCap 背包重量；items 表示每个物品的重量；itemNum 表示物品个数
    // 假设背包可承受重量 100，物品个数 10，物品重量存储在数组 a 中，那可以这样调用函数：
    // f(0, 0, a, 10, 100)
    public _0_1_BagProblem f(int i, int curWeight, int[] items, int itemNum, int bagCap) {
        if (curWeight == bagCap || i == itemNum) { // curWeight==bagCap 表示装满了 ;i==itemNum 表示已经考察完所有的物品
            if (curWeight > maxW) maxW = curWeight;
            return this;
        }
        System.out.println("cur="+i+" cur+1 not in");
        f(i + 1, curWeight, items, itemNum, bagCap); // 当前物品不装进去的分支

        if (curWeight + items[i] <= bagCap) {// 已经超过背包承受的重量的时候，就不要再装了，剪枝的技巧。否则装
            System.out.println("cur="+i+" cur+1 in");
            f(i + 1, curWeight + items[i], items, itemNum, bagCap); // 当前物品装进去的分支
        }
        return this;
    }

    public static void main(String[] args) {
        int[] items = {10, 3, 1};
        int bagCap = 11;
        System.out.println(new _0_1_BagProblem().f(0, 0, items, 3, bagCap).maxW);
    }
}
