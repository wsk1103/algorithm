import java.util.List;

/**
 * @author sk
 * @time 2021/10/27
 * @desc say
 **/
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node left;
    public Node right;
    public List<Node> children;
    public List<Node> neighbors;
    public Node random;

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

}
