package weekTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历
 *
 * @author Ye-Ma
 */
public class Number590N叉树的后序遍历 {
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        postorderMethod(root, list);
        return list;
    }

    /**
     * N叉树的后序遍历
     * 后序:
     * 左  右  根
     *
     * @param root node
     * @param list 结果
     */
    public void postorderMethod(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            postorderMethod(node, list);
        }
        list.add(root.val);
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
