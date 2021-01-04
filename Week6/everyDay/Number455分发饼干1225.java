package weekSix.everyDay;

import java.util.Arrays;

public class Number455分发饼干1225 {
    public int findContentChildren(int[] g, int[] s) {
        // g 学生的胃口
        // s 蛋糕的大小

        //  g  和  s 排序
        //  贪心 从最大的进行比较

        /*
    假设有 m 个孩子，胃口值分别是 g1 到 gm ，
    有 n 块饼干，尺寸分别是 s1 到 sn，满足 gi≤gi+1g_i \le g_{i+1}gi​≤gi+1​ 和 sj≤sj+1s_j \le s_{j+1}sj​≤sj+1​，其中 1≤i<m1 \le i < m1≤i<m，1≤j<n1 \le j < n1≤j<n。
    假设在对前 i−1i-1i−1 个孩子分配饼干之后，可以满足第 iii 个孩子的胃口的最小的饼干是第 jjj 块饼干，即 sjs_jsj​ 是剩下的饼干中满足 gi≤sjg_i \le s_jgi​≤sj​ 的最小值，最优解是将第 jjj 块饼干分配给第 iii 个孩子。如果不这样分配，考虑如下两种情形：
    如果 i<mi<mi<m 且 gi+1≤sjg_{i+1} \le s_jgi+1​≤sj​ 也成立，则如果将第 jjj 块饼干分配给第 i+1i+1i+1 个孩子，且还有剩余的饼干，则可以将第 j+1j+1j+1 块饼干分配给第 iii 个孩子，分配的结果不会让更多的孩子被满足；
    如果 j<nj<nj<n，则如果将第 j+1j+1j+1 块饼干分配给第 iii 个孩子，当 gi+1≤sjg_{i+1} \le s_jgi+1​≤sj​ 时，可以将第 jjj 块饼干分配给第 i+1i+1i+1 个孩子，分配的结果不会让更多的孩子被满足；当 gi+1>sjg_{i+1}>s_jgi+1​>sj​ 时，第 jjj 块饼干无法分配给任何孩子，因此剩下的可用的饼干少了一块，因此分配的结果不会让更多的孩子被满足，甚至可能因为少了一块可用的饼干而导致更少的孩子被满足。
        基于上述分析，可以使用贪心算法尽可能满足最多数量的孩子。
        首先对数组 ggg 和 sss 排序，然后从小到大遍历 ggg 中的每个元素，对于每个元素找到能满足该元素的 sss 中的最小的元素。具体而言，令 iii 是 ggg 的下标，jjj 是 sss 的下标，初始时 iii 和 jjj 都为 000，进行如下操作。
        对于每个元素 g[i]g[i]g[i]，找到未被使用的最小的 jjj 使得 g[i]≤s[j]g[i] \le s[j]g[i]≤s[j]，则 s[j]s[j]s[j] 可以满足 g[i]g[i]g[i]。由于 ggg 和 sss 已经排好序，因此整个过程只需要对数组 ggg 和 sss 各遍历一次。当两个数组之一遍历结束时，说明所有的孩子都被分配到了饼干，或者所有的饼干都已经被分配或被尝试分配（可能有些饼干无法分配给任何孩子），此时被分配到饼干的孩子数量即为可以满足的最多数量。
        * */

        Arrays.sort(g);
        Arrays.sort(s);
        // i和 j 都初始值0
        int i = 0;
        int j = 0;

        return 0;
    }


    static class Solution {


        public static void main(String[] args) {
            System.out.println(findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
        }

        /**
         * @param g 孩子  g[i] = 单个孩子的胃口
         * @param s 饼干 s[i]    每个饼干的大小
         * @return 结果
         */
        public static int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int numOfChildren = g.length, numOfCookies = s.length;
            // numOfChildren 孩子的队伍的长度   numOfCookies  饼干的个数
            // 排队完成
            int count = 0;
            // 孩子 或者 饼干 发完 立即执行结束
            for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
                while (j < numOfCookies && g[i] > s[j]) {
                    j++;
                }
                if (j < numOfCookies) {
                    count++;
                }
            }
            return count;
        }


        public static int findContentChildrenOne(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            // 创建   numOfChildren  Cookies
            int numOfChildren = g.length, numOfCookies = s.length ,count = 0;

            for (int j = 0, i = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
                // 两种情况

                // 不可以通过 进行跳过  j++
                while (j < numOfCookies && g[i] > s[j]){
                    j++;
                }
                // 可以通过
                if (j < numOfCookies) {
                    count++;
                }

            }
            return count;

        }


    }


}
