package misc;

public class MaxIncreaseSkyline {

    public static void main(String[] args) {

        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};

        System.out.println(maxIncreaseKeepingSkyline(grid));
    }

    public static int maxIncreaseKeepingSkyline(int[][] grid) {


        int[] maxInColumn = new int[10000];
        int[] maxInRow= new int[10000];
        int numRows = grid.length;
        int numColumns = grid[0].length;
        for(int i = 0 ; i < numRows; i++){
            for(int j = 0; j < numColumns; j++){
                if(grid[i][j] > maxInRow[i]) maxInRow[i] = grid[i][j];
            }
        }

        for(int i = 0 ; i < numColumns; i++){
            for(int j = 0; j < numRows; j++){
                if(grid[j][i] > maxInColumn[i]) maxInColumn[i] = grid[j][i];
            }
        }

        int sum=0;
        for(int i = 0 ; i < numRows; i++){
            for(int j = 0; j < numColumns; j++){
                int diff= 0;
                int maxToInc = Math.min(maxInColumn[j], maxInRow[i]);
                if(grid[i][j] < maxToInc) diff  = maxToInc - grid[i][j];
                sum += diff;
            }
        }
        return sum;

    }
}
