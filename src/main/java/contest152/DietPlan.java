package contest152;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DietPlan {
    @Test
    public void test(){

        int []calories = {6,13,8,7,10,1,12,11};
        Assertions.assertEquals(3, dietPlanPerformance(calories, 6,5,37));
    }

    public int dietPlanPerformance(int [] calories, int k, int lower, int upper) {
        int score = 0;
        for(int i = 0; i <=calories.length - k; i+=1){
            int cals = 0;
            for(int j = i; j<i+k & j<calories.length;j++){
               cals += calories[j];
           }
            if(cals < lower) score--;
            else if(cals > upper) score++;
       }
        return score;
    }
}
