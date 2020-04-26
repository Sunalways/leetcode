package cn.lee983.Apple;

import cn.lee983.entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: 62458
 * @Date: 2020/2/26 20:20
 * @Description:
 */
public class LC0104MaximumDepthOfBinaryTree {

    public int maxDepthRec(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepthRec(root.left), maxDepthRec(root.right)) + 1;
    }

    public int maxDepthQueue(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(root.left);
                }
                if (node.right != null) {
                    queue.add(root.right);
                }
            }
        }
        return depth;
    }

}
