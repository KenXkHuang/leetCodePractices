public class countRepeatedA {
    static long repeatedString(String s, long n) {
        long result=0;
        if(s.length()>=n){
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='a') result++;
            }
        }
        else{
            for(char c:s.toCharArray()){
                if(c=='a') result++;
            }
            result=result*(n/s.length());
            int remain=(int)n%s.length()-1;
            if(remain>=0) {
                String substring = s.substring(0,remain+1);
                for (char c : substring.toCharArray()) {
                    if (c == 'a') result++;
                }
            }
        }
        return result;


    }

    public static void main(String[] args) {
        System.out.println(repeatedString("a",1000000000000L));
    }
}
