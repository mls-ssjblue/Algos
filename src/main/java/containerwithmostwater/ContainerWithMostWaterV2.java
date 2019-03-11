package containerwithmostwater;

public class ContainerWithMostWaterV2 {

    public static void main(String[] args) {

        int[] height = new int[] { 1,8,6,2,5,4,8,3,7 };
        int result = maxArea(height);
        System.out.println(result);

    }

    public static int maxArea(int[] height) {

        int area = 0, maxArea = 0;
        for (int i1 = 0, i2 = height.length - 1; i1 < i2; ) {
            area = Math.abs((i1 - i2)) * Math.min(height[i1], height[i2]);
            if (area > maxArea)
                maxArea = area;
            if(height[i1] < height[i2]) i1 ++;
            else i2--;
        }

        return maxArea;
    }
}