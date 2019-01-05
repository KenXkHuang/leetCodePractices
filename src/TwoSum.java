import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(twoSum(new ArrayList<>(Arrays.asList(2,7,11,15)),9));
    }


    public static ArrayList<Integer> twosum(ArrayList<Integer> given, int Target ){
        ArrayList<Integer> value_store=new ArrayList<>();
        ArrayList<Integer> return_list=new ArrayList<>();
        given.forEach(
                b -> {
                    if(value_store.contains(Target-b)){
                        return_list.add(value_store.indexOf(Target-b));
                        return_list.add(value_store.size());

                    }else{
                        value_store.add(b);
                    }
                }
        );
        if(!return_list.isEmpty()){
            return return_list;
        }
        return null;
    }

    public static ArrayList<Integer> twoSum(List<Integer> originalList, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<originalList.size();i++){
            if(map.containsKey(target- originalList.get(i))){
                return new ArrayList<>(Arrays.asList(map.get(target-originalList.get(i)),i));
            }
            map.put(originalList.get(i),i);
        }
        return null;
    }

}
