import java.util.LinkedList;

/**
 * @author sk
 * @time 2022/4/11
 **/
public class TreeNodeUtil {

    public static TreeNode toTreeString(String s) {
        String[] sp = s.split(",");
        TreeNode[] nodes = new TreeNode[sp.length];
        for (int i = 0; i < sp.length; i++) {
            if ("null".equals(sp[i])) {
                nodes[i] = null;
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(sp[i]));
                nodes[i] = node;
            }
        }
        for (int i = 0; i < nodes.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            TreeNode cur = nodes[i];
            if (cur == null) {
                continue;
            }
            TreeNode leftNode, rightNode;
            if (left < 0 || left >= nodes.length) {
                leftNode = null;
            } else {
                leftNode = nodes[left];
            }
            if (right < 0 || right >= nodes.length) {
                rightNode = null;
            } else {
                rightNode = nodes[right];
            }
            cur.left = leftNode;
            cur.right = rightNode;
        }
        return nodes[0];
    }

    public static String toTreeString(TreeNode s) {
        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(s);
        int addSize = 1;
        while (!list.isEmpty()) {
            int curSize = addSize;
            int nextSize = 0;
            while (curSize > 0 && !list.isEmpty()) {
                TreeNode node = list.poll();
                if (node == null) {
                    sb.append("null").append(",");
                } else {
                    sb.append(node.val).append(",");
                    TreeNode left = node.left;
                    nextSize++;
                    list.add(left);
                    TreeNode right = node.right;
                    nextSize++;
                    list.add(right);
                }
                curSize--;
            }
            addSize = nextSize;
        }
        sb.deleteCharAt(sb.length() - 1);
        String re = sb.toString();
        String end = ",null";
        while (re.endsWith(end)) {
            re = re.substring(0, re.lastIndexOf(end));
        }
        return re;
    }

    public static void main(String[] args) {
        String r = "1,2,3,4,null,null,null,5,5";
        TreeNode node = toTreeString(r);
        System.err.println(toTreeString(node));
    }

}
