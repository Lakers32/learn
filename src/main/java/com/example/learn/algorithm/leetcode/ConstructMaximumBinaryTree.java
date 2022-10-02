package com.example.learn.algorithm.leetcode;

/**
 * @description: 最大二叉树
 * <p>
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 * 返回nums 构建的 最大二叉树 。
 * <p>
 * 链接：https://leetcode.cn/problems/maximum-binary-tree
 * @author: 程凯
 * @create: 2022-10-02 22:34
 **/
public class ConstructMaximumBinaryTree {

    public TreeNode solution(int[] nums) {
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }

    /**
     * 中序遍历
     *
     * @param nums
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    public TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        // 没有元素了
        if (rightIndex - leftIndex < 1) {
            return null;
        }

        // 只有一个元素
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }

        // 最大值所在位置
        int maxIndex = leftIndex;
        int maxVal = nums[maxIndex];
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 根据maxIndex划分左右子树
        root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = {33, 2, 1, 6, 0, 5};

        ConstructMaximumBinaryTree constructMaximumBinaryTree = new ConstructMaximumBinaryTree();
        TreeNode root = constructMaximumBinaryTree.solution(nums);
        System.out.println("Construct Maximum Binary Tree Is" + root);
    }

}
