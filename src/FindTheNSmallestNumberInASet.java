import java.util.*;

public class FindTheNSmallestNumberInASet {
    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>();

        set.add(1);
        set.add(5);
        set.add(4);
        set.add(6);
        set.add(3);
        System.out.println(thirdSmallest(set,4));

    }

    static int thirdSmallest(Set<Integer> set, Integer index){
        if(set.size()<index){
            return 0;
        }
//        Integer[] sample=new Integer[set.size()];
//        Integer[] arr=set.toArray(sample);
//        Arrays.sort(arr);

        PriorityQueue<Integer> maxheap=new PriorityQueue<>(Collections.reverseOrder());
//        for(Integer i : set){
//
//        }
        set.forEach((i)->{
            if(maxheap.size()<index){
                maxheap.add(i);
            }else{
                if(maxheap.peek()>i){
                    maxheap.poll();
                    maxheap.add(i);
                }
            }
        });

        return maxheap.peek()!=null ? maxheap.poll() : 0;
    }
}
