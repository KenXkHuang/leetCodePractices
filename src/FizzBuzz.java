public class FizzBuzz {
    public static void FizzBuzzPrint(int n){
        int i=0;
        while(i<100){
            if(i%15==0&&i>=15){
                System.out.println("FizzBuzz");
            }
            else if(i%3==0&&i>=3){
                System.out.println("Fizz");
            }
            else if(i%5==0&&i>=5){
                System.out.println("Buzz");
            }
            else{
                System.out.println(i);
            }
            i++;
        }

    }

    public static void main(String[] args) {
        FizzBuzzPrint(100);
    }
}
