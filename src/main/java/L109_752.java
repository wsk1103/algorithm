import java.util.*;

/**
 * @author sk
 * @time 2021/12/9
 * @desc say
 **/
public class L109_752 {

    /*
     * 一个密码锁由 4 个环形拨轮组成，每个拨轮都有 10 个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
     * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     *
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     *
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     *
     * 字符串 target 代表可以解锁的数字，请给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
     *
     *
     *
     * 示例 1:
     *
     * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * 输出：6
     * 解释：
     * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
     * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，因为当拨动到 "0102" 时这个锁就会被锁定。
     * 示例 2:
     *
     * 输入: deadends = ["8888"], target = "0009"
     * 输出：1
     * 解释：
     * 把最后一位反向旋转一次即可 "0000" -> "0009"。
     * 示例 3:
     *
     * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
     * 输出：-1
     * 解释：
     * 无法旋转到目标数字且不被锁定。
     * 示例 4:
     *
     * 输入: deadends = ["0000"], target = "8888"
     * 输出：-1
     *
     *
     * 提示：
     *
     * 1 <= deadends.length <= 500
     * deadends[i].length == 4
     * target.length == 4
     * target 不在 deadends 之中
     * target 和 deadends[i] 仅由若干位数字组成
     */

    public static int handle(String[] deadends, String target) {
        String start = "0000";

        Set<String> vis = new HashSet<>();
        Collections.addAll(vis, deadends);
        if (vis.contains(start)) {
            return -1;
        }
        LinkedList<String> path = new LinkedList<>();
        path.offer(start);
        vis.add(start);
        String last = start;
        int count = 0;
        while (!path.isEmpty()) {
            String cur = path.poll();
            if (cur.equals(target)) {
                return count;
            }
            int[] ints = new int[4];
            ints[0] = cur.charAt(0) - 48;
            ints[1] = cur.charAt(1) - 48;
            ints[2] = cur.charAt(2) - 48;
            ints[3] = cur.charAt(3) - 48;
            for (int i = 0; i < 4; i++) {
                add(i, ints, vis, path);
                sub(i, ints, vis, path);
            }

            //"0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
            if (cur.equals(last)) {
                count++;
                last = path.peekLast();
            }
        }
        return -1;
    }

    private static void add(int i, int[] ints, Set<String> vis, LinkedList<String> path) {
        int it = ints[i];
        int next;
        //add
        if (it == 9) {
            next = 0;
        } else {
            next = it + 1;
        }
        ints[i] = next;
        String ne = String.valueOf(ints[0]) + ints[1] + ints[2] + ints[3];
        if (vis.contains(ne)) {
            ints[i] = it;
            return;
        }
        vis.add(ne);
        path.offer(ne);
        ints[i] = it;
    }

    private static void sub(int i, int[] ints, Set<String> vis, LinkedList<String> path) {
        int it = ints[i];
        int next;
        //sub
        if (it == 0) {
            next = 9;
        } else {
            next = it - 1;
        }
        ints[i] = next;
        String ne = String.valueOf(ints[0]) + ints[1] + ints[2] + ints[3];
        if (vis.contains(ne)) {
            ints[i] = it;
            return;
        }
        vis.add(ne);
        path.offer(ne);
        ints[i] = it;
    }


    public static void main(String[] args) {
        List<String> dead;
        String t;
//        dead = Arrays.asList("3433","4648","3284","2751","9107","1121","4177","3002","6676","5097","5844","4552","3680","4708","9940","2808","1820","2982","4971","8074","3608","4309","6669","2412","8436","0850","1699","4879","9534","6431","7686","7425","8561","4136","7503","6055","1825","7445","1019","3667","6778","4370","0330","6420","0489","7851","9431","2131","8453","0757","6406","2048","5291","5600","8913","8660","5119","6463","7043","5361","9227","7959","6934","0212","6804","1869","6649","6781","5694","0964","9852","6695","7545","9806","9427","7551","5954","7186","6962","3682","8095","4294","0421","2449","4993","9371","1827","1335","9538","8441","2092","5130","9920","9221","7618","4266","6566","7319","8487","2510","6967","9757","3664","8835","2243","2799","5195","1327","7416","3004","5634","6630","0379","4452","9318","4531","1333","6257","0356","9359","0887","8849","8759","5101","0007","1053","2438","5806","3619","1042","1845","3786","0280","0848","7760","9525","2234","7966","2321","1440","2283","0690","2996","2838","6653","5767","5201","5448","0517","7444","0681","9457","1450","2239","6070","9550","2716","2067","3902","4409","7901","1778","3036","7770","1228","3278","3943","4238","3976","7305","0118","3458","2828","2325","8787","6900","5030","7665","0765","0605","9369","6701","4032","4499","9056","1302","8293","2307","8156","4571","3138","8550","7291","7340","1957","4711","8695","5059","6940","4248","2972","9343","9820","9699","2913","6268","7463","8576","8057","6741","6807","2453","5056","0502","6331","1596","9680","1234","0354","6397","6018","7308","9710","4660","1485","2353","4103","5074","2550","8860","8819","4990","6426","7194","2328","3581","1620","3993","0439","4421","7107","9514","6136","4853","2630","8526","6587","5266","2184","3267","1534","8130","0882","7932","0740","1413","7226","9721","4589","7341","3613","9856","7515","4132","7584","9679","9899","7960","1112","8128","9375","6404","3538","5535","8497","9692","6679","2166","3932","7850","1614","5960","7990","8193","8496","8050","1382","4886","9108","1315","1996","2705","5527","9616","9938","8721","0576","2478","8754","1592","1972","0090","6643","8158","7394","7627","3566","0182","1201","3990","5289","3445","3231","7256","3850","1794","9560","4541","3888","5067","9462","2978","9225","1852","5435","9268","9263","4556","1036","9229","7037","4574","3067","1590","1477","3654","9278","1753","1096","4383","1662","2132","4108","4520","6114","6211","6074","7645","0151","9685","1407","2908","3905","2059","8096","9244","4963","2714","2238","9285","0981","3576","0950","0436","1745","6229","4948","7187","9231","5882","9415","9566","4363","1462","3669","6156","9144","4984","1567","5244","7583","9979","0292","5038","6430","5193","9042","0533","5031","7243","1821","4128","8786","9322","0968","8308","9778","5155","2108","0159","0290","0493","9976","7964","4328","5639","7281","7321","6987","4226","6272","1897","8797","6072","8591","8378","5936","1130","1681","9109","5003","9355","0560","4553","6827","2694","9717","9927","5791","3423","0219","7758","6746","8177","6330","4317","1299","9800","4721","4923","3148","9587","5296","5302","0915","3219","7847","6086","3389","0087","3992","1156","5016","9790","7894","3293","2451","4041","2377","2418","8263","6509","7157","7475","7097","2945","8422","3075","2745","1091","6003","5578","0444","0055","3508","5702","6899","8495","7130","6713","5673","6337","8535","6858","2133","3299");
//        t = "7610";
//        System.err.println(handle((String[]) dead.toArray(), t));
//        System.err.println(handle2((String[]) dead.toArray(), t));
        /*
        ["1121","2267","9006","2521","6398","0454","9461","5431","6813","5147","3160","6482","7208","3594","2284","9467","7604","3398","0668","6000","7276","0362","3646","7633","5115","7008","3259","2007","4862","1691","0544","7827","3018","0606","3997","0892","3643","5943","2832","2177","1520","7876","1237","3273","3678","2919","2885","5106","3610","1663","7535","1599","2272","9369","4656","8782","2810","4765","2074","2461","4638","8891","4135","9070","5901","2070","8845","6028","4181","2586","3761","1235","4001","8706","8689","8538","1367","0347","9155","1414","2107","3853","2182","5073","2215","8870","2173","4800","6980","9773","7909","5637","5590","7815","8392","3907","3970","9919","0575","2888","7396","5457","4185","0416","9005","5182","4025","4251","5990","6972","7373","7606","8594","2756","5783","2325","0874","4859","7378","4050","2536","5638","7284","1756","1526","0090","2317","6084","4110","8390","8347","8395","2842","4607","6249","4501","3752","1710","9133","1091","7624","3542","7083","9163","0220","4808","0291","9719","6824","8817","4852","2540","0344","6302","9766","1262","8514","7953","9587","8315","8759","4097","0346","4165","5028","7934","7578","4941","8300","1082","8446","6233","1472","4052","7910","4337","1166","5218","8116","0503","3776","1085","7024","0618","4476","1197","8777","9157","3377","0607","6321","0184","5369","6974","5747","3567","6452","9807","0568","4963","5976","9256","0339","6106","9653","9496","5896","0075","1572","9503","4684","3960","7985","5167","8733","1521","0439","6843","0662","5885","9524","7540","0794","2319","1699","7116","5348","9065","8940","3493","3424","6577","7389","6370","8336","1381","1676","0625","0719","9114","7152","2504","2782","8449","2197","6146","1888","0604","3520","9890","4468","4288","8721","3118","1726","6582","7304","5235","6498","3444","8084","4070","3051","1654","5010","7757","1143","8196","8387","1719","5572","5937","7611","9297","0353","0752","9589","0645","9018","3760","8883","0072","8773","0406","7467","4613","3571","3474","9110","2393","9331","1129","3736","3470","1826","0297","5444","5173","8248","2922","9658","6559","8190","9416","5680","6479","7665","2560","9804","8838","0399","8664","9683","8231","3128","5625","0315","4088","6254","0095","3201","9474","5842","3929","0395","2623","9615","8098","7072","0520","3517","6301","5977","9980","5926","6930","0705","3301","0750","7888","5757","4440","2291","5339","1080","0302","2870","2575","5600","7042","6622","0841","0799","1962","1791","7198","7091","3417","7430","5967","9943","7163","2199","5395","5973","7629","8119","1238","3488","0588","6844","4399","3032","2231","9830","9158","7040","9595","9662","6026","0760","6760","1744","6723","3750","6551","8358","3410","7075","8882","4886","6580","9161","0811","8844","8369","6508","7403","4918","1114","0500","6795","7136","5579","7309","4398","3938","6530","3783","4464","0710","9737","2004","9122","8279","6639","2053","6023","2894","5679","6434","0944","5269","3861","6422","7587","1442","8526","8893","0250","0911","5692","4087","6887","6688","4451","1083","6037","9177","1150","6732","8608","1453","6787","6954","4387","7221","4578","8352","4161","3150","1918","4313","5076","5935","4340","1936","2898","1667","7107","2090","6967","8592","2997","5333","6196","5531","1071","4547","0140","8558","2773","5534","0472","1356","5438","5175","9879","8223","3990","7365","3083","1975","1870","7655","4888","1833","4534","1033","3525"]
"4529"
         */
//        dead = Arrays.asList("1121","2267","9006","2521","6398","0454","9461","5431","6813","5147","3160","6482","7208","3594","2284","9467","7604","3398","0668","6000","7276","0362","3646","7633","5115","7008","3259","2007","4862","1691","0544","7827","3018","0606","3997","0892","3643","5943","2832","2177","1520","7876","1237","3273","3678","2919","2885","5106","3610","1663","7535","1599","2272","9369","4656","8782","2810","4765","2074","2461","4638","8891","4135","9070","5901","2070","8845","6028","4181","2586","3761","1235","4001","8706","8689","8538","1367","0347","9155","1414","2107","3853","2182","5073","2215","8870","2173","4800","6980","9773","7909","5637","5590","7815","8392","3907","3970","9919","0575","2888","7396","5457","4185","0416","9005","5182","4025","4251","5990","6972","7373","7606","8594","2756","5783","2325","0874","4859","7378","4050","2536","5638","7284","1756","1526","0090","2317","6084","4110","8390","8347","8395","2842","4607","6249","4501","3752","1710","9133","1091","7624","3542","7083","9163","0220","4808","0291","9719","6824","8817","4852","2540","0344","6302","9766","1262","8514","7953","9587","8315","8759","4097","0346","4165","5028","7934","7578","4941","8300","1082","8446","6233","1472","4052","7910","4337","1166","5218","8116","0503","3776","1085","7024","0618","4476","1197","8777","9157","3377","0607","6321","0184","5369","6974","5747","3567","6452","9807","0568","4963","5976","9256","0339","6106","9653","9496","5896","0075","1572","9503","4684","3960","7985","5167","8733","1521","0439","6843","0662","5885","9524","7540","0794","2319","1699","7116","5348","9065","8940","3493","3424","6577","7389","6370","8336","1381","1676","0625","0719","9114","7152","2504","2782","8449","2197","6146","1888","0604","3520","9890","4468","4288","8721","3118","1726","6582","7304","5235","6498","3444","8084","4070","3051","1654","5010","7757","1143","8196","8387","1719","5572","5937","7611","9297","0353","0752","9589","0645","9018","3760","8883","0072","8773","0406","7467","4613","3571","3474","9110","2393","9331","1129","3736","3470","1826","0297","5444","5173","8248","2922","9658","6559","8190","9416","5680","6479","7665","2560","9804","8838","0399","8664","9683","8231","3128","5625","0315","4088","6254","0095","3201","9474","5842","3929","0395","2623","9615","8098","7072","0520","3517","6301","5977","9980","5926","6930","0705","3301","0750","7888","5757","4440","2291","5339","1080","0302","2870","2575","5600","7042","6622","0841","0799","1962","1791","7198","7091","3417","7430","5967","9943","7163","2199","5395","5973","7629","8119","1238","3488","0588","6844","4399","3032","2231","9830","9158","7040","9595","9662","6026","0760","6760","1744","6723","3750","6551","8358","3410","7075","8882","4886","6580","9161","0811","8844","8369","6508","7403","4918","1114","0500","6795","7136","5579","7309","4398","3938","6530","3783","4464","0710","9737","2004","9122","8279","6639","2053","6023","2894","5679","6434","0944","5269","3861","6422","7587","1442","8526","8893","0250","0911","5692","4087","6887","6688","4451","1083","6037","9177","1150","6732","8608","1453","6787","6954","4387","7221","4578","8352","4161","3150","1918","4313","5076","5935","4340","1936","2898","1667","7107","2090","6967","8592","2997","5333","6196","5531","1071","4547","0140","8558","2773","5534","0472","1356","5438","5175","9879","8223","3990","7365","3083","1975","1870","7655","4888","1833","4534","1033","3525");
//        t = "4529";
//        System.err.println(handle((String[]) dead.toArray(), t));
//        System.err.println(handle2((String[]) dead.toArray(), t));
        dead = Arrays.asList("0201", "0101", "0102", "1212", "2002");
        t = "0202";
        System.err.println(handle((String[]) dead.toArray(), t));
//        dead = Arrays.asList("8888", "0101", "0102", "1212", "2002");
//        t = "0009";
//        System.err.println(handle((String[]) dead.toArray(), t));
//        dead = Arrays.asList("8887","8889","8878","8898","8788","8988","7888","9888");
//        t = "8888";
//        System.err.println(handle((String[]) dead.toArray(), t));
//        dead = new ArrayList<>(500);
//        for (int i = 0; i < 500; i++) {
//            String tt = RandomStringUtils.randomNumeric(4);
//            if (dead.contains(tt)) {
//                continue;
//            }
//            dead.add(tt);
//        }
//        t = RandomStringUtils.randomNumeric(4);
//        System.err.println(JSON.toJSONString(dead));
//        System.err.println("\"" + t + "\"");
//        System.err.println(handle(dead.toArray(new String[0]), t));
    }

}
