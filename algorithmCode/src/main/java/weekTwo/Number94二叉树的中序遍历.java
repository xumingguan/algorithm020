package weekTwo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树 题目
 *
 * @author Ye-Ma
 */
public class Number94二叉树的中序遍历 {


    public static void main(String[] args) {


    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // 返回数据
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, ArrayList<Integer> list) {
        // ThreeNode  为空 无需在次进行递归了
        if (root == null) {
            return;
        }
        // 中序:  左 根  右
        inorder(root.getLeft(), list);
        list.add(root.val);
        inorder(root.getRight(), list);

    }

    @Getter
    @Setter
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
