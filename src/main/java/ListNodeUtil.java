/**
 * @author sk
 * @time 2022/4/1
 **/
public class ListNodeUtil {

    public static ListNode to(String s) {
        System.err.println("ListNode.to() = " + s);
        ListNode li = new ListNode();
        if (s == null) {
            return li;
        }
        s = s.trim();
        if (s.length() == 0) {
            return li;
        }
        s = s.replace("[", "").replace("]", "");
        String[] to = s.split(",");
        li.val = Integer.parseInt(to[0]);
        if (to.length == 1) {
            return li;
        }
        ListNode te = li;
        for (int i = 1; i < to.length; i++) {
            String ss = to[i];
            if (ss.length() == 0) {
                continue;
            }
            int j = Integer.parseInt(to[i]);
            ListNode t = new ListNode(j);
            te.next = t;
            te = t;
        }
        return li;
    }

    public static String to(ListNode node) {

        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val).append(",");
            node = node.next;
        }
        if (sb.length() > 0) {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

}
