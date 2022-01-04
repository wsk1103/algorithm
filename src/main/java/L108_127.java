import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author sk
 * @time 2021/12/7
 * @desc say
 **/
public class L108_127 {

    /*
     * 在字典（单词列表） wordList 中，从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
     *
     * 序列中第一个单词是 beginWord 。
     * 序列中最后一个单词是 endWord 。
     * 每次转换只能改变一个字母。
     * 转换过程中的中间单词必须是字典 wordList 中的单词。
     * 给定两个长度相同但内容不同的单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。
     * 如果不存在这样的转换序列，返回 0。
     *
     *
     *
     * 示例 1：
     *
     * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
     * 输出：5
     * 解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
     * 示例 2：
     *
     * 输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
     * 输出：0
     * 解释：endWord "cog" 不在字典中，所以无法进行转换。
     *
     *
     * 提示：
     *
     * 1 <= beginWord.length <= 10
     * endWord.length == beginWord.length
     * 1 <= wordList.length <= 5000
     * wordList[i].length == beginWord.length
     * beginWord、endWord 和 wordList[i] 由小写英文字母组成
     * beginWord != endWord
     * wordList 中的所有字符串 互不相同
     */
    private static Map<String, Integer> rm = new HashMap<>();
    private static Map<String, List<String>> path = new HashMap<>();
    private static int[] tt;
    private static int to = Integer.MAX_VALUE;
    private static LinkedList<String> queue = new LinkedList<>();

    public static int handle(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
//        rm.put(beginWord, -1);
//        rm.put(endWord, -1);
        tt = new int[wordList.size()];
//        check(beginWord, endWord, wordList, 1);
        check2(beginWord, endWord, null, wordList, 1);
        return to == Integer.MAX_VALUE ? 0 : to;
    }

    private static void check(String beginWord, String end, List<String> wordList, int size) {
        if (to <= size) {
            return;
        }

        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            if (is(end, s)) {
                if (s.equals(beginWord)) {
                    to = Math.min(size, to);
                    break;
                }
                int v = tt[i];
                if (v <= size && v != 0) {
                    continue;
                }
                queue.add(s);
                tt[i] = size;
            }
        }

//        for (String s : wordList) {
//            if (is(end, s)) {
//                if (s.equals(beginWord)) {
//                    to = Math.min(size, to);
//                    break;
//                }
//                if (rm.containsKey(s)) {
//                    int v = rm.get(s);
//                    if (size >= v) {
//                        continue;
//                    }
//                }
//                queue.add(s);
//                rm.put(s, size);
//            }
//        }
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if (is(beginWord, temp)) {
                to = Math.min(size + 1, to);
            }
            check(beginWord, temp, wordList, size + 1);
        }
    }

    private static void check2(String beginWord, String end, String last, List<String> wordList, int size) {
        if (to <= size) {
            return;
        }
        for (int i = 0; i < wordList.size(); i++) {
            String s = wordList.get(i);
            if (is(beginWord, s)) {
                int v = tt[i];
                if (v != 0) {
                    continue;
                }
                queue.add(s);
                tt[i] = size;
            }
        }
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if (end.equals(temp)) {
//                to = size;
//                return;
                to = Math.min(size, to);
            }
            if (last == null && !queue.isEmpty()) {
                last = queue.peekLast();
            }
            if (temp.equals(last) && !queue.isEmpty()) {
                last = queue.peekLast();
                check2(temp, end, last, wordList, size + 1);
            } else {
                check2(temp, end, last, wordList, size);
            }
        }
    }


    private static boolean is(String begin, String end) {
        if (begin.equals(end)) {
            return false;
        }
        int to = 0;
        int len = begin.length();
        for (int i = 0; i < len; i++) {
            if (begin.charAt(i) != end.charAt(i)) {
                to++;
            }
            if (to > 1) {
                return false;
            }
        }
        return to != 0;
    }

    public static int handle3(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> set = new HashSet<>(wordList.size());
        int count = 1;
        String last = beginWord;
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (endWord.equals(cur)) {
                return count;
            }
            for (String s : wordList) {
                if (is(cur, s) && !set.contains(s)) {
                    queue.offer(s);
                    set.add(s);
                }
            }

            if (cur.equals(last)) {
                count++;
                last = queue.peekLast();
            }
        }
        return 0;
    }

    public static int handle2(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

//        int[] vis = new int[wordList.size()];
//        vis[0] = 1;
        // 初始化标记数组
        Map<String, Boolean> visited = new HashMap<>();  // 访问标志数组
        visited.put(beginWord, true);
        for (String value : wordList) {
            visited.put(value, false);
        }
        LinkedList<String> queue = new LinkedList<>();  // 辅助队列
        queue.offer(beginWord);  // 从beginWord开始访问
        int count = 1;
        String last = queue.peekLast();  // 队列中每层的最后一个节点
        // 队列不为空时，逐层遍历节点
        while (!queue.isEmpty()) {
            String cur = queue.poll();  // 队首节点出队
            // 找到了到达endWord的路径
            if (cur.equals(endWord)) {
                return count;
            }
            for (int i = 0; i < wordList.size(); i++) {
                String s = wordList.get(i);
                // 该单词没有被访问过，且可以由当前单词转换得到
                if (!visited.get(s) && isTransport(cur, s)) {
                    visited.replace(s, true);  // 邻接点的访问标志置true
                    queue.offer(s);  // 入队
                }
//                if (vis[i] != 1 && isTransport(cur, s)) {
//                    vis[i]=1;  // 邻接点的访问标志置true
//                    queue.offer(s);  // 入队
//                }
            }
            // 更新新一层的最后一个节点标志
            if (cur.equals(last)) {
                count++;
                last = queue.peekLast();
            }

        }
        // 	没有找到到达endWord的路径
        return 0;
    }

    // 判断两个字符串是否可以转换
    public static boolean isTransport(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        int res = 0;
        for (int i = 0; i < a.length() && res <= 1; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                res++;
            }
        }
        return res == 1;
    }

    public static void main(String[] args) {
        String s1, s2;
        List<String> list;
//        s1 = "a";
//        s2 = "c";
//        list = Arrays.asList("a","b","c");
//        System.err.println(handle(s1, s2, list));

//        s1 = RandomStringUtils.randomAlphabetic(10).toLowerCase();
//        s2 = RandomStringUtils.randomAlphabetic(10).toLowerCase();
//        list = new ArrayList<>();
//        list.add(s2);
//        for (int i = 0; i < 5000; i++) {
//            String temp = RandomStringUtils.randomAlphabetic(10).toLowerCase();
//            if (list.contains(temp)) {
//                continue;
//            }
//            list.add(temp);
//        }
//        System.err.println("\"" + s1 + "\"");
//        System.err.println("\"" + s2 + "\"");
//        System.err.println(JSON.toJSONString(list));
//        System.err.println(handle(s1, s2, list));
//        s1 = "wvo";
//        s2 = "peu";
//        list = Arrays.asList("peu", "vpe", "tbo", "vdw", "hwm", "ryc", "rll", "xtn", "bki", "vbx", "htv", "ktz", "trv", "gcc", "hre", "ddg", "iaf", "wsb", "ekp", "goo", "wbd", "jst", "ewv", "wuq", "flr", "qps", "egc", "nus", "onj", "pgb", "eyv", "evh", "bhz", "mnq", "lor", "pzf", "zli", "lxm", "rff", "gmt", "yxa", "wwy", "lds", "rpe", "izr", "rac", "otp", "pef", "sgd", "alm", "dbg", "pxe", "jwg", "pux", "ivk", "xgf", "hzv", "cqk", "lyw", "pal", "wlf", "mwc", "rgm", "xbe", "lnp", "erb", "kgk", "dkv", "eck", "lfx", "jvz", "unt", "cop", "bvf", "jow", "zdi", "xeo", "ymc", "fsh", "jxu", "ysa", "nhm", "dsf", "jcr", "jsp", "pun", "mzv", "szn", "nlx", "xye", "sbk", "uao", "wxy", "iiq", "rqf", "unh", "oip", "ixl", "qej", "krh", "wsn", "zlk", "yct", "dbr", "mfy", "zix", "qxw", "drc", "zhx", "aid", "ljg", "gfw", "ptl", "bgr", "ygx", "oki", "sbf", "xyg", "plf", "mxq", "who", "nim", "vbc", "iuh", "lun", "efu", "dnw", "psu", "bcy", "els", "qij", "rhq", "duf", "sjl", "ddf", "wgj", "kpt", "npm", "gnr", "ozn", "wwx", "jwc", "fvj", "kxz", "nhy", "mwn", "pti", "tcw", "hct", "zdn", "jya", "dxw", "xpk", "pvi", "tjj", "sfm", "ljf", "ltu", "nbj", "kvk", "cbh", "yqv", "nlw", "rji", "gre", "zro", "aol", "xyb", "phu", "cun", "cjk", "aox", "uji", "ior", "xdw", "xap", "htb", "cru", "tzk", "tbp", "prb", "dof", "wkh", "fzj", "aky", "ijx", "tge", "gbr", "lks", "ohq", "yav", "pop", "afq", "hpw", "ugw", "hmf", "elj", "gar", "ntl", "jyb", "udc", "pox", "jml", "bsn", "yyq", "irc", "qnw", "dxh", "kwu", "ugp", "dal", "wgy", "xgx", "dhj", "vqm", "gmh", "niw", "rfj", "qxx", "qbc", "gks", "fiw", "llk", "zml", "zss", "zrx", "pvk", "deu", "bvy", "zjm", "hpg", "fdr", "sdu", "imy", "fuc", "kiz", "ome", "sld", "llg", "qhc", "sjq", "yqz", "bge", "mfi", "oog", "txd", "qqs", "dxi", "mbd", "asy", "xfd", "zte", "olt", "adx", "eiv", "qvm", "fla", "kea", "jbm", "fvd", "fzg", "npj", "wvh", "qug", "tpl", "iox", "rpp", "cgr", "def", "cqg", "iml", "uqk", "qjn", "lku", "qcw", "hrm", "yec", "bet", "wvx", "vmt", "qeq", "luu", "mlw", "pzm", "abx", "luw", "jmn", "grb", "jqx", "wua", "fwe", "krw", "jhw", "wxx", "ivc", "afw", "ymg", "zpo", "jib", "ikh", "kfu", "zpp", "vbi", "dlv", "lvk", "arn", "olx", "mft", "uvn", "qgc", "kmn", "sev", "bcn", "mya", "cvx", "qxa", "gsj", "lsw", "tyt", "qxp", "gxh", "blm", "pgr", "ape", "njh", "exo", "oqs", "hif", "prc", "fwo", "woc", "tlb", "tty", "xfl", "hfg", "bxh", "ojd", "qsk", "ion", "oak", "mma", "zps", "fbb", "fow", "pkw", "gkd", "kcz", "mll", "gps", "fyc", "ujg", "caz", "gxi", "cpt", "vuu", "ysc", "yhl", "bnp", "dpk", "osp", "rcs", "ajo", "tnq", "yip", "qfc", "mej", "yii", "hyn", "hro", "deh", "grg", "pvo", "hnc", "aiu", "dpp", "nue", "shj", "aoq", "gkb", "dnh", "uun", "ndz", "kdd", "plv", "saz", "cpm", "wdn", "iiu", "woi", "cgm", "juu", "oxr", "gil", "rpl", "zll", "iyq", "uze", "ewk", "sbv", "bqi", "jaz", "ven", "smb", "doj", "mbj", "ofq", "weo", "dmg", "wov", "opf", "jsu", "gvi", "jej", "caf", "ioc", "ijt", "qou", "ydk", "msi", "sie", "ysf", "tah", "amu", "cko", "dzy", "faz", "odu", "etp", "fys", "uqu", "pgk", "oho", "zgl", "yay", "vnt", "aka", "gcl", "iwz", "bhd", "dyj", "pbv", "smi", "ieo", "smv", "rpw", "ivv", "dlj", "njn", "syp", "jim", "xzn", "sky", "jte", "ghw", "zqg", "zrp", "tio", "peo", "myo", "sjv", "oyr", "njm", "bln", "jsj", "nwq", "vfk", "hgk", "xch", "bdh", "ahy", "yah", "pdw", "blk", "mdi", "quo", "zca", "xjf", "xyu", "rkm", "xrq", "wzs", "bwv", "gfh", "pod", "cji", "fhg", "zgf", "tgc", "qkh", "fdf", "xmv", "ghe", "baw", "bly", "dvv", "sca", "oei", "amz", "wut");
//        System.err.println("\"" + s1 + "\"");
//        System.err.println("\"" + s2 + "\"");
//        System.err.println(JSON.toJSONString(list));
//        System.err.println(handle(s1, s2, list));
//        System.err.println(handle2(s1, s2, list));
        s1 = "vvo";
        s2 = "tds";
        list = Arrays.asList("tds", "bwq", "jxb", "wsu", "sxi", "qge", "erj", "vye", "iyj", "zpa", "zik", "ics", "bnh", "pqq", "pzz", "dfp", "uyo", "apv", "ulb", "obd", "rsg", "ctu", "lor", "qot", "fwf", "jtm", "pkv", "zyg", "esg", "nnv", "ctb", "kht", "qly", "bgn", "lhy", "lsg", "zyt", "vmn", "xwy", "ozw", "oib", "qve", "sih", "odl", "kkj", "rsm", "oag", "qnz", "nal", "wri", "ghg", "dof", "qjd", "urv", "dii", "vlq", "umv", "dao", "bxa", "rez", "luc", "mts", "ydu", "jan", "cdn", "bvt", "puh", "qnk", "xek", "lix", "nhx", "biv", "zdk", "ema", "ety", "ebg", "slf", "knq", "tqp", "cwh", "qgx", "ztc", "mkm", "zrh", "joq", "ygw", "heu", "dyq", "hjh", "fqk", "rzc", "xww", "ldv", "bey", "cpn", "rgd", "oxg", "smk", "ztz", "oal", "wqu", "rpw", "cqj", "vmc", "ldr", "tnd", "edf", "mrw", "pkb", "jwi", "zdy", "plm", "pmt", "jbm", "rmz", "axu", "mqy", "osx", "cbk", "qyu", "fel", "qbb", "sfn", "xby", "sud", "qtf", "ejq", "rui", "weh", "clf", "pbl", "bkg", "djq", "bjj", "wmb", "pdx", "jyn", "czb", "umx", "oqj", "uph", "gwr", "bbm", "zve", "chf", "dcj", "fxg", "yfk", "rtd", "mpy", "tcu", "dts", "sek", "swa", "bpd", "hyr", "zbr", "daf", "rdw", "eif", "cqe", "rig", "dye", "ylj", "sxa", "idu", "ixt", "fal", "agy", "uni", "pxq", "ild", "fae", "njt", "hpz", "bbx", "iih", "mbt", "gax", "ybd", "hiw", "pyj", "zxf", "ffh", "cxs", "kwm", "poi", "wir", "kpf", "mcm", "qzh", "ojt", "yso", "plo", "gne", "iqm", "cjb", "mcb", "hbk", "fox", "eag", "wml", "umg", "yyp", "riq", "kne", "rqp", "kxg", "zus", "qkq", "hag", "qcx", "pma", "xei", "nix", "syz", "tjv", "hsj", "pev", "awc", "cfu", "zuf", "pwx", "hpv", "rry", "hgc", "wux", "ppq", "wtr", "vaz", "cks", "eil", "pkk", "sne", "sbd", "rav", "nnt", "jok", "wph", "ugd", "ruj", "fed", "hgu", "wdz", "riz", "fbv", "eyy", "shv", "kpx", "tyd", "xhk", "qsn", "nwr", "ovo", "uxv", "yrc", "bue", "epe", "krd", "cdl", "okk", "cjy", "luv", "wdo", "ogf", "fna", "gfh", "bzv", "qgp", "nwu", "dhp", "vag", "dlf", "pip", "yzl", "hpi", "dxr", "zlm", "pzs", "omt", "lty", "pet", "vvq", "ggw", "los", "wxi", "hld", "kej", "baq", "fvd", "jbi", "dzl", "jxj", "hfs", "iyp", "aor", "paw", "szu", "efq", "sfd", "gbw", "fms", "ofl", "tii", "laf", "vil", "mlp", "fro", "lnf", "hbw", "sxn", "xop", "gpf", "dsw", "tfc", "olq", "lmr", "vfw", "jxs", "niw", "njh", "ccs", "hid", "puc", "esj", "uzx", "eca", "ese", "rhv", "dhg", "xaq", "khz", "nqt", "trs", "qwl", "lqb", "oww", "niu", "ctz", "znf", "fue", "zsg", "trh", "vya", "tdl", "azz", "dlx", "aia", "gsq", "oam", "gkq", "diz", "spd", "epy", "nop", "cnv", "kgd", "jpg", "djx", "uqx", "grx", "eup", "ysz", "cco", "dvt", "iao", "dby", "vie", "jzc", "kxq", "thd", "bjx", "vvt", "hlb", "cjp", "bzh", "cfe", "exr", "vuh", "bkz", "lxw", "ais", "qxs", "gor", "unv", "qnw", "jwu", "ioy", "edg", "iwj", "yyh", "hiz", "dnr", "gqk", "oaj", "mxv", "knc", "fpf", "tjq", "utr", "qjw", "ptf", "zdd", "lto", "inw", "duj", "hsa", "fjc", "exi", "phk", "bbq", "uzu", "ukp", "nff", "zbv", "hya", "fvk", "pls", "pmz", "kfu", "vkd", "loj", "tre", "nnz", "oin", "cfg", "zmm", "jxa", "kgs", "urf", "jgo", "cop", "mug", "yfz", "pwo", "cnq", "gyr", "jrs", "rbc", "aak", "wjy", "hqp", "dcr", "qhf", "oho", "bhl", "ymz", "urq", "xxl", "ieo", "bfj", "olw", "izs", "vbu", "qwv", "ttn", "msd", "uai", "kei", "lls", "xzq", "nxq", "ggo", "oay", "ndn", "xwp", "lbs", "lze", "uri", "grp", "dze", "dcy", "tvy", "nkj", "jeo", "rbl", "rer", "pil", "eaq", "qcf", "fsu", "zak", "whq", "gez", "ktd", "bbt", "jwc", "suu", "vey", "fus", "cpu", "sgd", "mxy", "gvh", "dhs", "adz", "ihn", "ptb", "pkp");
        System.err.println("\"" + s1 + "\"");
        System.err.println("\"" + s2 + "\"");
        System.err.println(JSON.toJSONString(list));
//        System.err.println(handle(s1, s2, list));
        System.err.println(handle2(s1, s2, list));
        System.err.println(handle3(s1, s2, list));
    }

}
