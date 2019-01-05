import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReturnTheSmallestPositiveValueNotInTheList {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,3,6,4,1,2}));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        ArrayList<Integer> list = new ArrayList<>();
        for(int i : A){
            list.add(i);
        }
        int result=1;
        while(list.contains(result)){
            result++;
        }
        return result;
    }
}

