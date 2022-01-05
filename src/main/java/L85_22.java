import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sk
 * @time 2021/11/23
 * @desc say
 **/
public class L85_22 {

    /*
     * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：["()"]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 8
     */
    public static List<String> handle(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        handle(list, sb, n, 0, 0);
        return list;
    }

    public static void handle(List<String> list, StringBuilder sb, int n, int cur, int size) {
        if (cur > n || size > n + 1 || size < 0) {
            return;
        }
        if (sb.length() + size == n * 2) {
            StringBuilder tsb = new StringBuilder(sb);
            int temp = size;
            while (temp > 0) {
                tsb.append(")");
                temp--;
            }
            list.add(tsb.toString());
            return;
        }
        for (int i = cur; i < n; i++) {
            sb.append("(");
            handle(list, sb, n, i + 1, size + 1);
            sb.delete(sb.length() - 1, sb.length());
            int temp = size;
            while (temp > 0) {
                sb.append(")");
                handle(list, sb, n, i, --temp);
                sb.delete(sb.length() - 1, sb.length());
            }

        }
    }

    //我的理解就是生成括号可以看作一棵满二叉树，对二叉树进行遍历，看路径是否满足括号
    public static List<String> handle2(int n) {
        ArrayList<String> res = new ArrayList<>();
        dfs(res, n , n , "");
        return res;
    }

    public static void dfs(ArrayList<String> res, int left, int right, String curStr) {
        if (left == 0 && right == 0) {
            res.add(curStr);// 结果加入集合
            return;
        }
        if (left > 0) {
            dfs(res, left - 1, right, curStr + "("); // 左大于0 拼接左括号
        }
        if (right > left) {
            dfs(res, left, right - 1, curStr + ")");//右大于左，可以拼接右括号
        }

    }

    public static void main(String[] args) {
        int n;
        n = 3;
        System.err.println(JSON.toJSONString(handle(n)));
        System.err.println(JSON.toJSONString(handle2(n)));
        n = 2;
        System.err.println(JSON.toJSONString(handle(n)));
        System.err.println(JSON.toJSONString(handle2(n)));
        n = 1;
        System.err.println(JSON.toJSONString(handle(n)));
        System.err.println(JSON.toJSONString(handle2(n)));
        n = 4;
        System.err.println(JSON.toJSONString(handle(n)));
        System.err.println(JSON.toJSONString(handle2(n)));
    }

}
