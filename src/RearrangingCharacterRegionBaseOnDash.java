import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RearrangingCharacterRegionBaseOnDash {
    public static void main(String[] args) {
//        System.out.println(solution(new String[]{"a.b@ZigzagTraversal.com","x@ZigzagTraversal.com","x@exa.mple.com","ab+1@ZigzagTraversal.com","y@ZigzagTraversal.com","y@ZigzagTraversal.com","y@ZigzagTraversal.com"}));
        System.out.println(solution("2-4A0R7-4K",4));
    }
    public static String solution(String givenString, int stringLength){
        String resultString="";
        int currentRegionLength=0;
        for(int i=givenString.length()-1;i>=0;i--){
            if(givenString.charAt(i)!='-'){
                resultString=givenString.charAt(i)+resultString;
                currentRegionLength++;
                if(currentRegionLength==stringLength&&i!=0){
                    currentRegionLength=0;
                    resultString='-'+resultString;
                }
            }
        }
        return resultString;
    }

}
//RearrangingCharacterRegionBaseOnDash
