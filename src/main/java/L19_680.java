/**
 * @author sk
 * @time 2021/10/22
 * @desc say
 **/
public class L19_680 {

    /*
     * 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "aba"
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: s = "abca"
     * 输出: true
     * 解释: 可以删除 "c" 字符 或者 "b" 字符
     * 示例 3:
     * <p>
     * 输入: s = "abc"
     * 输出: false
     * <p>
     * <p>
     * 提示:
     * <p>
     * 1 <= s.length <= 105
     * s 由小写英文字母组成
     * 双指针
     */

    public static boolean handle(String s) {
        boolean b = false;

        if (s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        boolean addLeft = true, subRight = true;
        int lN = left, sR = right;
        while (left <= right) {
            Character cl = s.charAt(left);
            Character cr = s.charAt(right);
            if (!cl.equals(cr)) {
                if (addLeft) {
                    addLeft = false;
                    lN = left;
                    sR = right;
//                    right = sR;
                    left++;
                    continue;
                } else if (subRight) {
                    subRight = false;
                    right = sR;
                    left = lN;
                    right--;
                    continue;
                } else {
                    return false;
                }
            } else {
                b = true;
            }
            left++;
            right--;
            if (addLeft && subRight) {
                lN = left;
                sR = right;
            }
        }
        return b;
    }

    public static boolean handle2(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            Character cl = s.charAt(left);
            Character cr = s.charAt(right);
            if (!cl.equals(cr)) {
                return ii(s, left + 1, right) || ii(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean ii(String s, int left, int right) {
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s;
        s = "lcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucul";
        System.err.println(handle2(s));

        s = "1";
        System.err.println(handle2(s));

        s = "123321";
        System.err.println(handle2(s));

        s = "51233216";
        System.err.println(handle(s));

        s = "12233231";
        System.err.println(handle(s));

        s = "121";
        System.err.println(handle(s));

        s = "abc";
        System.err.println(handle(s));

        s = "aba";
        System.err.println(handle(s));

        s = "abca";
        System.err.println(handle(s));
    }

}
