public class LongestSubArrayWithTwoRepeatingNumbers {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,1,3,4,3,5,1,2}));
    }
    public static int solution(int[] A) {
        Integer StartA=null, StartB=null;
        int max_length=0;
        for(int i=0;i<A.length;i++){
            if(StartA==null||StartB==null){
                if(StartA==null){
                    StartA=i;
                    max_length=i-StartA+1;
                }else{
                    StartB=i;
                    int value=Math.min(StartA,StartB);
                    max_length=Math.max(max_length,i-value+1);
                }
            }else{
                if(A[i]!=A[StartA]&&A[i]!=A[StartB]){
                    if(StartA<StartB){
                        StartA=i;
                    }else{
                        StartB=i;
                    }
                }
                int value=Math.min(StartA,StartB);
                max_length=Math.max(max_length,i-value+1);
            }
        }
        return max_length;
    }
}
