import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author sk
 * @time 2021/12/10
 * @desc say
 **/
public class L399 {

    /*
     * 给定一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。
     * 每个 Ai 或 Bi 是一个表示单个变量的字符串。
     *
     * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
     *
     * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
     *
     * 注意：输入总是有效的。可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
     *
     *
     *
     * 示例 1：
     *
     * 输入：equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
     * 输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]
     * 解释：
     * 条件：a / b = 2.0, b / c = 3.0
     * 问题：a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
     * 结果：[6.0, 0.5, -1.0, 1.0, -1.0 ]
     * 示例 2：
     *
     * 输入：equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
     * 输出：[3.75000,0.40000,5.00000,0.20000]
     * a/b=1.5, b/c=2.5, bc/cd=5.0
     * a/c=a/b*(b/c)=3.75, c/b=1/(b/c)=1/(2.5)=0.4, cd/bc=1/(bc/cd)=1/(0.2)=5
     * 示例 3：
     *
     * 输入：equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
     * 输出：[0.50000,2.00000,-1.00000,-1.00000]
     *
     *
     * 提示：
     *
     * 1 <= equations.length <= 20
     * equations[i].length == 2
     * 1 <= Ai.length, Bi.length <= 5
     * values.length == equations.length
     * 0.0 < values[i] <= 20.0
     * 1 <= queries.length <= 20
     * queries[i].length == 2
     * 1 <= Cj.length, Dj.length <= 5
     * Ai, Bi, Cj, Dj 由小写英文字母与数字组成
     */

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Double> vMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> eqList = equations.get(i);
            String one = eqList.get(0);
            String tow = eqList.get(1);
            List<String> mapS = map.get(one);
            if (mapS == null) {
                mapS = new ArrayList<>();
                mapS.add(tow);
                map.put(one, mapS);
            } else {
                mapS.add(tow);
            }
            List<String> mapT = map.get(tow);
            if (mapT == null) {
                mapT = new ArrayList<>();
                mapT.add(one);
                map.put(tow, mapT);
            } else {
                mapT.add(one);
            }
            String vKey = one + "," + tow;
            double vValue = values[i];
            vMap.put(vKey, vValue);
            vKey = tow + "," + one;
            vValue = 1 / vValue;
            vMap.put(vKey, vValue);
        }

        double[] to = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> eqList = queries.get(i);
            String one = eqList.get(0);
            String tow = eqList.get(1);
            String con = one + "," + tow;
            if (vMap.containsKey(con)) {
                to[i] = vMap.get(con);
            } else {
                to[i] = hh(one, tow, 1.00000, map, vMap, new HashSet<>());
            }
        }
        return to;
    }

    private static double hh(String one, String tow, double re, Map<String, List<String>> map, Map<String, Double> vMap, Set<String> vis) {
        if (map.containsKey(one) && map.containsKey(tow)) {
            if (one.equals(tow)) {
                return 1.0;
            }
            List<String> vList = map.get(one);
            if (vList.contains(tow)) {
                String key = one + "," + tow;
                double d = vMap.get(key);
                return re * d;
            }
            for (int i = 0; i < vList.size(); i++) {
                String value = vList.get(i);
                String key = one + "," + value;
                if (vis.contains(key)) {
                    continue;
                }
                double d = vMap.get(key);
                double reT = re * d;
                vis.add(key);
                double te = hh(value, tow, reT, map, vMap, vis);
                if (te != -1) {
                    return te;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        //equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        List<List<String>> equations;
        double[] values;
        List<List<String>> queries;
        equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        values = new double[]{2.0, 3.0};
        queries = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        System.err.println(JSON.toJSONString(calcEquation(equations, values, queries)));
    }

}
