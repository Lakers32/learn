package com.example.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: 二叉搜索树中的众数
 * <p>
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 链接：https://leetcode.cn/problems/find-mode-in-binary-search-tree
 * @author: 程凯
 * @create: 2022-10-04 21:37
 **/
public class FindMode {

    /**
     * 暴力法
     *
     * @param root
     * @return
     */
    public int[] solution(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        // 获得频率 Map
        searchBST(root, map);
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
                .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                .collect(Collectors.toList());
        list.add(mapList.get(0).getKey());

        // 把频率最高的加入 list
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue() == mapList.get(i - 1).getValue()) {
                list.add(mapList.get(i).getKey());
            } else {
                break;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 中序遍历
     *
     * @param curr
     * @param map
     */
    void searchBST(TreeNode curr, Map<Integer, Integer> map) {
        if (curr == null) {
            return;
        }

        map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
        searchBST(curr.left, map);
        searchBST(curr.right, map);
    }


    ArrayList<Integer> resList;
    int maxCount;
    int count;
    TreeNode pre;

    /**
     * 递归法 + 双指针 + 预存最大值
     *
     * @param root
     * @return
     */
    public int[] solution2(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        searchBSTWithDoublePoint(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void searchBSTWithDoublePoint(TreeNode root) {
        if (root == null) {
            return;
        }
        searchBSTWithDoublePoint(root.left);

        int rootValue = root.val;
        // 计数
        if (pre == null || rootValue != pre.val) {
            count = 1;
        } else {
            count++;
        }
        // 更新结果以及maxCount
        if (count > maxCount) {
            resList.clear();
            resList.add(rootValue);
            maxCount = count;
        } else if (count == maxCount) {
            resList.add(rootValue);
        }
        pre = root;

        searchBSTWithDoublePoint(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(15);

        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;

        FindMode findMode = new FindMode();
        System.out.println("The Mode Is " + findMode.solution(root));
    }

}
