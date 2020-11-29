package weekTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Number  589   N叉树的前序遍历
 *
 * @author Ye-Ma
 */
public class Number589N叉树的前序遍历 {
    public List<Integer> preorder(Node root) {
        // 返回结果 设置结果
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        preorderMethod(root, list);
        return list;
    }



    /**
     * 前序  根 左 右
     * 中    左 根 右
     * 后    左 右 根
     * @param root node List
     * @param list 结果
     */
    private void preorderMethod(Node root, ArrayList<Integer> list) {
        if (root.children == null) {
            return;
        }
        for (Node child : root.children) {
            preorderMethod(child, list);
        }
        list.add(root.val);
    }


}
