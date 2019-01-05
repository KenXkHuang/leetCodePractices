import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GoogleQuestion2 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1,2,6,5,3}, new int[]{5,5,7,6,8}));
    }
    public static int solution(int[] S, int[] E) {
        List<Integer> list_S = Arrays.stream(S).boxed().collect(Collectors.toList());
        List<Integer> list_E = Arrays.stream(E).boxed().collect(Collectors.toList());
        List<Integer> event_time=new ArrayList<>();
        event_time=list_S;
        for(Integer e : list_E){
            if(!event_time.contains(e)){
                event_time.add(e);
            }
        }
        Collections.sort(event_time);
//        System.out.println(event_time);
        int current=0;
        int max=0;

        for(int time:event_time){
            if(list_S.contains(time)){
                current+=countOcc(list_S,time);
            }
            if(list_E.contains(time)){
                current-=countOcc(list_E,time);
            }
            max=Math.max(max,current);
        }

        return max;
    }
    public static int countOcc(List<Integer> list, int target){
        int result=0;
        for(int num:list){
            if(num==target){
                result++;
            }
        }
        return result;
    }
}
