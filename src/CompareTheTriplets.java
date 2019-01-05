import java.util.ArrayList;
import java.util.List;

public class CompareTheTriplets {
    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        ArrayList<Integer> result=new ArrayList<>();
        int apt=0;
        int bpt=0;
        for(int i=0;i<3;i++){
            if(a.get(i)>b.get(i)){
                apt++;
            }else if(a.get(i)<b.get(i)){
                bpt++;
            }
        }
        result.add(apt);
        result.add(bpt);
        return result;
    }
    public static void main(String args[]){

    }

}
