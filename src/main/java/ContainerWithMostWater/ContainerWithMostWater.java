package ContainerWithMostWater;

public class ContainerWithMostWater {

    public static void main(String[] args) {

        int[] height = new int[] { 3, 2, 5, 4, 6, 7 };
        int result = maxArea(height);
        System.out.println(result);

    }

    public static int maxArea(int[] height) {

        int area = 0, maxArea = 0;
        for (int i1 = 0; i1 < height.length; i1++) {
            for (int i2 = i1 + 1; i2 < height.length; i2++) {
                area = Math.abs((i1 - i2)) * Math.min(height[i1], height[i2]);
                if (area > maxArea)
                     maxArea = area;
            }
        }

        return maxArea;
    }
}
