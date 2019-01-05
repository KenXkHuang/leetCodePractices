import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class Solution {

    static class Pair{
        double firstNum;
        double secondNum;
        Pair(double num1,double num2){
            firstNum=num1;
            secondNum=num2;
        }
    }

//[1,2), [3,6), [4,7),[5,7) -> [1,2), [3,7) -> 1+4 = 5
//
//        [-3.5,-1), [-2,-1.5), [0,3),[2,6),[2,6),[-1,3)-> [-3.5,-1), [0,6) - > 8.5

    public static void main(String[] args) {
        ArrayList<Pair> input= new ArrayList<>();
        input.add(new Pair(-3.5,-1));
        input.add(new Pair(-2,-1.5));
        input.add(new Pair(0,3));
        input.add(new Pair(2,6));
        input.add(new Pair(2,6));
        input.add(new Pair(-1,3));
        System.out.println(findTheLength(input));
    }
    public static double findTheLength(List<Pair> list){
        if(list==null || list.size()<=0){
            return 0;
        }
        ArrayList<Pair> newList= new ArrayList<>();
        Pair CurrentPair=null;
        for(Pair n : list){
            if(CurrentPair==null){
                CurrentPair=n;
            }else{
                if(n.firstNum<=CurrentPair.secondNum){ //can be marged
                    if(n.secondNum>CurrentPair.secondNum){
                        CurrentPair=new Pair(CurrentPair.firstNum, n.secondNum);
                    }
                }else{
                    newList.add(CurrentPair);
                    CurrentPair=n;
                }
            }
        }
        newList.add(CurrentPair);
        double answer=0;
        for (Pair n : newList){
            answer+=n.secondNum-n.firstNum;
        }
        return answer;
    }


}
