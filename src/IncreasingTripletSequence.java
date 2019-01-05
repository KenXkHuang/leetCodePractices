import java.util.Arrays;

public class IncreasingTripletSequence {

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6}));
    }

    public static boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int increment=0;
        int previous=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>previous){
                increment++;
            }else{
                increment=0;
            }
            previous=nums[i];
            if(increment==2){
                return true;
            }

        }
        return false;
    }
}
