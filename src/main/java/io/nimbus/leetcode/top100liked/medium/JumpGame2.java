package io.nimbus.leetcode.top100liked.medium;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2 {


    public static void main(String[] args) {


        int a = Character.getNumericValue('a');
        int A = Character.getNumericValue('A');
        int aCast = 'a';
        int ACast = 'A';


        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(new JumpGame2().jump(nums));
    }

    /**
     * solution from: https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
     *
     * @param A
     * @return
     */
    public int jump(int[] A) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    /**
     * solution from: https://www.youtube.com/watch?v=vBdo7wtwlXs
     *
     * @param A
     * @return
     */
    public int jump_youtube(int[] A) {
        if (A.length <= 1) {
            return 0;
        }
        int ladder = A[0];// keep track of the largest ladder that you have
        int stairs = A[0];// keep track of the stairs in the current ladder
        int jump = 1;
        for (int level = 0; level < A.length; level++) {

            if (level == A.length - 1) {
                return jump;
            }

            if (level + A[level] > ladder) {
                ladder = level + A[level]; // build up the ladder
            }
            stairs--;// use up the stairs
            if (stairs == 0) {
                jump++;//no stairs left, now jump
                stairs = ladder - level;
            }
        }


        return jump;
    }


}
