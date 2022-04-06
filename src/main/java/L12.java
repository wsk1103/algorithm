import java.util.*;

/**
 * @author sk
 * @time 2022/4/6
 **/
public class L12 {

    /**
     * //罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
     * //
     * //
     * //字符          数值
     * //I             1
     * //V             5
     * //X             10
     * //L             50
     * //C             100
     * //D             500
     * //M             1000
     * //
     * // 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V +
     * //II 。
     * //
     * // 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
     * // 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * //
     * //
     * // I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * // X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * // C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * //
     * //
     * // 给你一个整数，将其转为罗马数字。
     * //
     * //
     * //
     * // 示例 1:
     * //
     * //
     * //输入: num = 3
     * //输出: "III"
     * //
     * // 示例 2:
     * //
     * //
     * //输入: num = 4
     * //输出: "IV"
     * //
     * // 示例 3:
     * //
     * //
     * //输入: num = 9
     * //输出: "IX"
     * //
     * // 示例 4:
     * //
     * //
     * //输入: num = 58
     * //输出: "LVIII"
     * //解释: L = 50, V = 5, III = 3.
     * //
     * //
     * // 示例 5:
     * //
     * //
     * //输入: num = 1994
     * //输出: "MCMXCIV"
     * //解释: M = 1000, CM = 900, XC = 90, IV = 4.
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= num <= 3999
     * //
     * // Related Topics 哈希表 数学 字符串 👍 845 👎 0
     */

    @Deprecated
    public static String intToRoman(int num) {
        System.err.println(num);
        Map<Integer, String> map = new HashMap<>(16);
        //I， V， X， L，C，D 和 M。
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        if (map.containsKey(num)) {
            return map.get(num);
        }

        List<Integer> list = new ArrayList<>();
        list.add(1000);
        list.add(500);
        list.add(100);
        list.add(50);
        list.add(10);
        list.add(5);
        list.add(1);

        String to = "";
        int sub = 1000;
        int m = num / sub;
        int o = 0;
        int loop = num;
        while (m == 0) {
            o++;
            sub = sub / (((o & 1) == 1) ? 2 : 5);
            if (sub <= 1) {
                sub = 1;
            }
            m = loop / sub;
            loop = loop % sub;
        }
        loop = num;
        while (m > 0) {
//            int lTemp = loop % temp;
            if (map.containsKey(loop)) {
                to += map.get(loop);
                break;
            } else if (loop > 900 && loop < 1000) {
                to += "CM";
                m = loop / 900;
                loop = loop % 900;
                if (loop < 50) {
                    o = 4;
                    m = loop / 10;
                    sub = 10;
                } else {
                    sub = 50;
                    o = 3;
                }
            } else if (loop > 400 && loop < 500) {
                to += "CD";
                m = loop / 400;
                loop = loop % 400;
                if (loop < 50) {
                    o = 4;
                    m = loop / 10;
                    sub = 10;
                } else {
                    sub = 50;
                    o = 3;
                }
            } else if (loop > 90 && loop < 100) {
                to += "XC";
                m = loop / 90;
                loop = loop % 90;
                if (loop < 5) {
                    o = 6;
                    m = loop;
                    sub = 1;
                } else {
                    sub = 5;
                    o = 5;
                }
            } else if (loop > 40 && loop < 50) {
                to += "XL";
                m = loop / 40;
                loop = loop % 40;
                if (loop < 5) {
                    o = 6;
                    m = loop;
                    sub = 1;
                } else {
                    sub = 5;
                    o = 5;
                }
            } else {
                int temp = sub;
                for (int i = 0; i < m; i++) {
                    to += map.get(temp);
                    loop = loop % temp;
                }
                o++;
                if (o >= list.size()) {
                    sub = 1;
                } else {
                    sub = list.get(o);
                }
                m = loop / sub;
                while (m == 0 && loop != 0) {
                    o++;
                    if (o >= list.size()) {
                        sub = 1;
                    } else {
                        sub = list.get(o);
                    }
                    m = loop / sub;
                }
            }
        }
        return to;
    }

    public static String handel(int num) {
        System.err.println(num);
        Map<Integer, String> map = new HashMap<>(16);
        //I， V， X， L，C，D 和 M。
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
        if (map.containsKey(num)) {
            return map.get(num);
        }

        List<Integer> list = new ArrayList<>();
        list.add(1000);
        list.add(900);
        list.add(500);
        list.add(400);
        list.add(100);
        list.add(90);
        list.add(50);
        list.add(40);
        list.add(10);
        list.add(9);
        list.add(5);
        list.add(4);
        list.add(1);

        String to = "";
        int o = 0;
        int sub = list.get(o);
        int m = num / sub;
        while (m == 0 && sub != 1) {
            o++;
            if (o > list.size()) {
                sub = 1;
            } else {
                sub = list.get(o);
            }
            m = num / sub;
        }
        while (m > 0) {
            for (int i = 0; i < m; i++) {
                to += map.get(sub);
            }
            num = num % sub;
            while (num < sub && sub != 1) {
                o++;
                if (o > list.size()) {
                    sub = 1;
                } else {
                    sub = list.get(o);
                }
            }
            m = num / sub;
        }

        return to;
    }

    public static void main(String[] args) {
        int num;
        num = 1994;
//        System.err.println(intToRoman(num));
        System.err.println(handel(num));
        num = 2;
        //System.err.println(intToRoman(num));
        System.err.println(handel(num));
        num = 11;
        //System.err.println(intToRoman(num));
        System.err.println(handel(num));
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            int t = r.nextInt(3999) + 1;
            //System.err.println(intToRoman(t));
            System.err.println(handel(t));
        }
    }

}
