package weekTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * 待解决  需要换思路了
 * Number  429  N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * @author Ye-Ma
 */
public class Number429N叉树的层序遍历 {

    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        lists.add(list);

        sequenceTraverse(root, lists);
        return lists;
    }

    private void sequenceTraverse(Node root, List<List<Integer>> lists) {
        if (root.children == null || root.children.size() == 0) {
            return;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (Node child : root.children) {
            arrayList.add(child.val);
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (Node node : child.children) {
                list.add(node.val);
            }
            lists.add(list);
        }

        lists.add(arrayList);
    }


}
