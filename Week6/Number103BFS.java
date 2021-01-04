package weekSix;

import java.util.*;

public class Number103BFS {
    public static void main(String[] args) {

    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return null;
    }

    // 查看套路模版
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        int sign = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> results = new ArrayList<>();

            // sign  0 从左到右   1从右到左
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                results.add(node.val);

                if (sign == 0) {

                    if (node.right != null) {
                        nodes.add(node.right);
                    }
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    sign = 1;
                    continue;
                }

                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
                sign = 0;
            }
            allResults.add(results);
        }
        return allResults;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> allResults = new ArrayList<>();
            if (root == null) {
                return allResults;
            }
            Queue<TreeNode> nodes = new LinkedList<>();
            nodes.add(root);
            int sign = 0;
            while (!nodes.isEmpty()) {
                int size = nodes.size();
                Deque<Integer> results = new LinkedList<>();

                // sign  0 从左到右   1从右到左
                for (int i = 0; i < size; i++) {
                    TreeNode node = nodes.poll();
                    results.add(node.val);
                    if (node.left != null) {
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        nodes.add(node.right);
                    }

                    if (sign == 0) {
                        results.offerLast(node.val);
                        continue;
                    }
                    results.offerFirst(node.val);
                }
                sign = sign == 0 ? 1 : 0;

                allResults.add(new LinkedList<>(results));

            }
            return allResults;
        }
    }


    class SolutionTest {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<List<Integer>>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
            nodeQueue.offer(root);
            // 关键词  作为  左开头和  右卡头的 标志
            boolean isOrderLeft = true;
            while (!nodeQueue.isEmpty()) {
                Deque<Integer> levelList = new LinkedList<Integer>();
                int size = nodeQueue.size();
                for (int i = 0; i < size; ++i) {
                    TreeNode curNode = nodeQueue.poll();
                    if (curNode.left != null) {
                        nodeQueue.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        nodeQueue.offer(curNode.right);
                    }
                    if (isOrderLeft) {
                        levelList.offerLast(curNode.val);
                        continue;
                    }
                    levelList.offerFirst(curNode.val);
                }
                ans.add(new LinkedList<Integer>(levelList));
                isOrderLeft = !isOrderLeft;
            }
            return ans;


        }
    }


}
