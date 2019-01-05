import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"hos","boo","nay","deb","wow","bop","bob","brr","hey","rye","eve","elf","pup","bum","iva","lyx","yap","ugh","hem","rod","aha","nam","gap","yea","doc","pen","job","dis","max","oho","jed","lye","ram","pup","qua","ugh","mir","nap","deb","hog","let","gym","bye","lon","aft","eel","sol","jab"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs){
        if(strs.length==0) return new ArrayList<>(new ArrayList<>());
        HashMap<String, List<String>> map = new HashMap<>();
        int[] charCheck=new int[26];
        for(String s : strs){
            Arrays.fill(charCheck,0);
            char[] charArray=s.toCharArray();
            for(char c : charArray){
                charCheck[c-'a']++;
            }
            String key="";
            for(int i=0;i<26;i++){
                if(charCheck[i]>0) {
                    key += "#"+i;
                }
                charCheck[i]--;
                i--;
            }
            if(!map.containsKey(key)) map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());

    }

}
