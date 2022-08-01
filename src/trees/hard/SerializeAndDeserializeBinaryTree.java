package trees.hard;

import utils.trees.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Pattern;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int size = q.size();
            int countNull = 0;
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                String suffix = i == size - 1 ? "" : "|";
                if (node.val != 9999)
                    line.append(node.val + suffix);
                else {
                    line.append("null" + suffix);
                    countNull++;
                    continue;
                }

                q.add(node.left != null ? node.left : new TreeNode(9999));
                q.add(node.right != null ? node.right : new TreeNode(9999));
            }
            if (countNull == size)
                break;
            sb.append(line + "\n");
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;

        String[] lines = data.split("\n");
        List<String[]> nodes = new ArrayList<>();
        for (String line : lines) {
            String[] nodesArr = line.split(Pattern.quote("|"));
            nodes.add(nodesArr);
            //System.out.println(Arrays.toString(nodesArr));
        }

        return constructBinaryTree(nodes);
    }

    public TreeNode constructBinaryTree(List<String[]> nodes) {
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)[0]));
        q.add(root);
        for (int k = 1; k < nodes.size(); k++) {
            String[] row = nodes.get(k);
            for (int i = 1; i < row.length; i += 2) {
                String n1 = row[i - 1];
                String n2 = row[i];
                TreeNode parent = q.poll();
                parent.left = n1.equals("null") ? null : new TreeNode(Integer.parseInt(n1));
                parent.right = n2.equals("null") ? null : new TreeNode(Integer.parseInt(n2));

                if (parent.left != null)
                    q.add(parent.left);
                if (parent.right != null)
                    q.add(parent.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));