import java.util.Arrays;

public class GoogleQuestion1 {

    public static void main(String[] args) {
//        System.out.println(solution("2-4A0r7-4k",4));
        System.out.println(solution(new int[]{11,21,12,11,37,44,45,6,15,10,6,7}));
    }

    public static int solution(int[] A) {
        int possible_index=0;
        for(int i=0;i<A.length;i++){
            if(recursive_find_jump(0, i,A.length-1,A)){
                possible_index++;
            }
        }
        return possible_index;

    }

    private static boolean recursive_find_jump(int numOfJump,int initialIndex,int targetIndex, int[]arr) {
        int current_jump=numOfJump+1;

        if(initialIndex==targetIndex){
            return true;
        }else{
            int max=Integer.MAX_VALUE;
            int max_index=-1;
            int min=Integer.MIN_VALUE;
            int min_index=-1;
            if(current_jump%2!=0){//odd jump
                for(int i=initialIndex+1;i<arr.length;i++){
                    if(arr[i]>arr[initialIndex]&&arr[i]<=max){
                        max=arr[i];
                        max_index=i;
                    }

                }
                if(max_index==-1&&max==Integer.MAX_VALUE){
                    return false;
                }else{
                    return recursive_find_jump(current_jump,max_index,targetIndex,arr);
                }
            }else{//even jump
                for(int i=initialIndex+1;i<arr.length;i++){
                    if(arr[i]<arr[initialIndex]&&arr[i]>=min){
                        min=arr[i];
                        min_index=i;
                    }
                }
                if(min_index==-1&&min==Integer.MIN_VALUE){
                    return false;
                }else{
                    return recursive_find_jump(current_jump,min_index,targetIndex,arr);
                }
            }
        }

    }


//    public static String solution(String S, int K) {
//        String input=S.replaceAll("-","");
//        String output="";
//        int iteration_divider=0;
//        for(int i=input.length()-1;i>=0;i--){
//            if(iteration_divider==K){
//                output="-"+output;
//                iteration_divider=0;
//            }
//            output=            Character.toUpperCase(input.charAt(i))+output;
//            iteration_divider++;
//        }
//        return output;
//        // write your code in Java SE 8
//    }
}
