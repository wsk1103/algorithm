import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author sk
 * @time 2022/6/29
 **/
public class L535 {

    /*
     * //TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-
     * //tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
     * //
     * // 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本
     * //的 URL 。
     * //
     * // 实现 Solution 类：
     * //
     * //
     * //
     * //
     * // Solution() 初始化 TinyURL 系统对象。
     * // String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
     * // String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系
     * //统对象加密的。
     * //
     * //
     * //
     * //
     * // 示例：
     * //
     * //
     * //输入：url = "https://leetcode.com/problems/design-tinyurl"
     * //输出："https://leetcode.com/problems/design-tinyurl"
     * //
     * //解释：
     * //Solution obj = new Solution();
     * //string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
     * //string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // 1 <= url.length <= 10⁴
     * // 题目数据保证 url 是一个有效的 URL
     * //
     * //
     * //
     * // Related Topics 设计 哈希表 字符串 哈希函数 👍 175 👎 0
     */

    /**
     * 执行耗时:3 ms,击败了62.97% 的Java用户
     * 内存消耗:41.4 MB,击败了57.52% 的Java用户
     */
    public static class Codec {

        private final String shortUrl = "http://tinyurl.com/";
        private static final Map<String, String> map = new HashMap<>();
        private final String rs = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        private final Random random = new Random();

        private String gen() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 6; i++) {
                int ri = random.nextInt(rs.length());
                char c = rs.charAt(ri);
                sb.append(c);
            }
            return sb.toString();
        }

        private String ret(String url) {
            String s = gen();
            while (map.containsKey(s)) {
                s = gen();
            }
            map.put(s, url);
            return s;
        }

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            return shortUrl + ret(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String sub = shortUrl.substring(this.shortUrl.length());
            return map.get(sub);
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String url = "https://leetcode.com/problems/design-tinyurl";
        String en = codec.encode(url);
        System.err.println(en);
        String de = codec.decode(en);
        System.err.println(de);

    }
}
