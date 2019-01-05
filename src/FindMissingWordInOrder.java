import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingWordInOrder {
    public static void main(String[] args) {
        System.out.println(missingWords("hello hey you","hello"));
    }
    public static List<String> missingWords(String s, String t) {
        ArrayList<String> result = new ArrayList<>();

        ArrayList<String> sGroup=new ArrayList(Arrays.asList(s.split(" ")));
        ArrayList tGroup=new ArrayList(Arrays.asList(t.split(" ")));

        sGroup.forEach( string ->{
            if(!tGroup.contains(string)) result.add(string);
        });

        return result;
    }
}
