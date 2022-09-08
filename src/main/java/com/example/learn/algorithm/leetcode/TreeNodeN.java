package com.example.learn.algorithm.leetcode;

import java.util.List;

/**
 * @description: N叉树
 * @author: 程凯
 * @create: 2022-09-08 23:52
 **/
public class TreeNodeN {

    public int val;
    public List<TreeNodeN> children;

    public TreeNodeN() {}

    public TreeNodeN(int _val) {
        val = _val;
    }

    public TreeNodeN(int _val, List<TreeNodeN> _children) {
        val = _val;
        children = _children;
    }
}
