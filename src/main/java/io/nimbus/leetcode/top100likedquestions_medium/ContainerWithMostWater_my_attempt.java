package io.nimbus.leetcode.top100likedquestions_medium;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater_my_attempt {

    public static void main(String[] args) {

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new ContainerWithMostWater_my_attempt().maxArea(height));
    }

    //TODO surprisingly my pointer solution was one of the suggested solutions with a O(n) time complexity. But it took my sometime to think of it and I wasn't confident because it took my so long to think of it.
    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;
        int area = 0;

        while (start < end) {

            int h1 = height[start];
            int h2 = height[end];

            if (h1 < h2) {
                area = Math.max(area, h1 * (end - start));
                start++;
            } else {
                area = Math.max(area, h2 * (end - start));
                end--;
            }
        }

        return area;
    }
}
