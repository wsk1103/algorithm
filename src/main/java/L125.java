/**
 * @author sk
 * @time 2021/10/22
 * @desc say
 **/
public class L125 {

    /**
     * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
     * <p>
     * 本题中，将空字符串定义为有效的 回文串 。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "A man, a plan, a canal: Panama"
     * 输出: true
     * 解释："amanaplanacanalpanama" 是回文串
     * 示例 2:
     * <p>
     * 输入: s = "race a car"
     * 输出: false
     * 解释："raceacar" 不是回文串
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 2 * 105
     * 字符串 s 由 ASCII 字符组成
     */

    public static boolean handle(String s) {
        if (s.length() <= 1) {
            return true;
        }
        boolean b = false;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            Character cl = s.charAt(left);
            int clh = cl.hashCode();
            while (!((clh >= 48 && clh <= 57) || (clh >= 65 && clh <= 90) || (clh >= 97 && clh <= 122)) && left < right) {
                cl = s.charAt(++left);
                clh = cl.hashCode();
            }
            Character cr = s.charAt(right);
            int crh = cr.hashCode();
            while (!((crh >= 48 && crh <= 57) || (crh >= 65 && crh <= 90) || (crh >= 97 && crh <= 122)) && left < right) {
                cr = s.charAt(--right);
                crh = cr.hashCode();
            }
            if (Character.toLowerCase(cr) == Character.toLowerCase(cl)) {
                b = true;
            } else {
                return false;
            }
            left++;
            right--;
        }
        return b;
    }

    public static void main(String[] args) {
        String s;
        s = "0P";
        System.err.println(handle(s));
        s = ".";
        System.err.println(handle(s));
        s = "11";
        System.err.println(handle(s));

        s = " 123 565 321 ";
        System.err.println(handle(s));
        s = "A man, a plan, a canal: Panama";
        System.err.println(handle(s));
        s = "race a car";
        System.err.println(handle(s));
        s = "1.,";
        System.err.println(handle(s));
        s = "1.,1";
        System.err.println(handle(s));
        s = "1.,13";
        System.err.println(handle(s));
        s = "21.,1";
        System.err.println(handle(s));
        s = "31.,113";
        System.err.println(handle(s));
        s = "31.,13";
        System.err.println(handle(s));
        s = "1.3,1";
        System.err.println(handle(s));
        s = "1.32,1";
        System.err.println(handle(s));
    }

}
