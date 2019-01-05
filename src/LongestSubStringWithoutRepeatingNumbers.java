import java.util.HashMap;
import java.util.HashSet;

public class LongestSubStringWithoutRepeatingNumbers {
    public static void main(String[] args) {

        System.out.println(findLength2("pwwkew"));

    }
    public static int findLength(String s){
        if(s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int startIndex=0;
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                startIndex=Math.max(map.get(s.charAt(i)),startIndex);
            }
            maxLen=Math.max(maxLen,i-startIndex+1);
            if(map.containsKey(s.charAt(i))){
                map.replace(s.charAt(i),i+1);
            }else{
                map.put(s.charAt(i),i+1);
            }
        }
        return maxLen;
    }
    public static int findLength2(String s){
        if(s.length()==0) return 0;
        String temp="";
        int maxlen=0;
        for(char c : s.toCharArray()){

            if(temp.contains(Character.toString(c))){
                temp=temp.substring(temp.indexOf(c)+1);
            }
            temp+=c;

            maxlen=Math.max(maxlen,temp.length());
        }
        return maxlen;

    }



}
