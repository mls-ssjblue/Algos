package contest172;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintWordsVertically {
    @Test
    public void test(){
        List<String> expected = Arrays.asList("HAY","ORO","WEU");
        List<String> expected1 = Arrays.asList("TBONTB","OEROOE","   T");

//        Assertions.assertEquals(expected, printwords("HOW ARE YOU"));
        Assertions.assertEquals(expected1, printwords("TO BE OR NOT TO BE"));
    }

    private List<String> printwords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)==' ' ){
                words.add(currentWord.toString());
                currentWord.setLength(0);
                continue;
            }
            currentWord.append(s.charAt(i));
            if(i==s.length()-1){
                words.add(currentWord.toString());
            }
        }

        int max =0;
        for(int i=0;i<words.size();i++){
            int length = words.get(i).length();
            if(length >max)max= length;
        }

        List<String> verticalWords = new ArrayList<>();
        for(int i=0;i<max;i++){
            StringBuilder verticalWord= new StringBuilder();
            for(int j=0;j<words.size();j++){
                if(i>words.get(j).length()-1) verticalWord.append(' ');
                else verticalWord.append(words.get(j).charAt(i));
            }
            String vw = trimTrailing(verticalWord);
            verticalWords.add(vw);
        }
        return verticalWords;
    }
    public static String trimTrailing(StringBuilder sb) {
        if (sb != null) {
            for (int i = sb.length() - 1; i >= 0; --i) {
                if (sb.charAt(i) != ' ') {
                    return sb.substring(0, i + 1);
                }
            }
        }
        return sb.toString();
    }
}
