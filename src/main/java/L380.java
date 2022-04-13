import java.util.*;

/**
 * @author sk
 * @time 2022/4/13
 **/
public class L380 {

    /**
     * //实现RandomizedSet 类：
     * //
     * //
     * //
     * //
     * // RandomizedSet() 初始化 RandomizedSet 对象
     * // bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
     * // bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
     * // int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
     * //
     * //
     * // 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
     * //
     * //
     * //
     * // 示例：
     * //
     * //
     * //输入
     * //["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove",
     * //"insert", "getRandom"]
     * //[[], [1], [2], [2], [], [1], [2], []]
     * //输出
     * //[null, true, false, true, 2, true, false, 2]
     * //
     * //解释
     * //RandomizedSet randomizedSet = new RandomizedSet();
     * //randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
     * //randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
     * //randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
     * //randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
     * //randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
     * //randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
     * //randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
     * //
     * //
     * //
     * //
     * // 提示：
     * //
     * //
     * // -2³¹ <= val <= 2³¹ - 1
     * // 最多调用 insert、remove 和 getRandom 函数 2 * 10⁵ 次
     * // 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。
     * //
     * //
     * //
     * // Related Topics 设计 数组 哈希表 数学 随机化 👍 494 👎 0
     */

    /**
     * 解答成功:
     * 执行耗时:20 ms,击败了98.93% 的Java用户
     * 内存消耗:89.9 MB,击败了53.08% 的Java用户
     */
    public static class RandomizedSet {
        private List<Integer> list = new ArrayList<>();
        private Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }

            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int i = map.get(val);
            if (i != list.size() - 1) {
                int temp = list.get(list.size() - 1);
                map.put(temp, i);
                list.set(i, temp);
            }
            int last = list.remove(list.size() - 1);

            map.remove(val);
            return true;
        }

        public int getRandom() {
            int i = random.nextInt(list.size());
            return list.get(i);
        }
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.err.println(set.insert(0));
        System.err.println(set.remove(0));
        System.err.println(set.insert(-1));
        System.err.println(set.remove(0));
        System.err.println(set.getRandom());
        System.err.println(set.getRandom());
        System.err.println(set.getRandom());
        System.err.println(set.getRandom());
        System.err.println(set.getRandom());
        System.err.println(set.getRandom());
        System.err.println(set.remove(1));
        System.err.println(set.insert(2));
        System.err.println(set.getRandom());
    }

}
