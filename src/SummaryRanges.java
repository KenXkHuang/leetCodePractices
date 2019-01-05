import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SummaryRanges {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
    public static List<String> summaryRanges(int[] nums) {
        List<Integer> list= Arrays.stream(nums).boxed().collect(Collectors.toList());
        ArrayList<String> result=new ArrayList<>();
        if(nums.length<=0){
            return result;
        }
        int starting_num=nums[0];
        for(int increment=nums[0];increment<=nums[nums.length-1];increment++){
            if(!list.contains(increment)){
                if(starting_num==increment-1){
                    result.add(Integer.toString(starting_num));
                    starting_num=nums[list.indexOf(starting_num)+1];
                }else{
                    result.add(Integer.toString(starting_num)+"->"+Integer.toString(increment-1));
                    starting_num=nums[list.indexOf(increment-1)+1];
                }
            }
            if(increment==nums[nums.length-1]){
                if(starting_num==increment){
                    result.add(Integer.toString(starting_num));
                }else{
                    result.add(Integer.toString(starting_num)+"->"+Integer.toString(increment));
                }
            }
        }
        return result;
    }
}
