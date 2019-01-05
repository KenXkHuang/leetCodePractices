import java.util.HashSet;

public class FindSeatAvailabilityOfTheSectionsThatFitAFamilyOfThree {

    public static void main(String[] args) {
        System.out.println(solution(12, "3C 2D 3D 6H 9L"));

    }
    public static int solution(int N, String S) {
        // write your code in Java SE 8
        // write your code in Java SE 8
        if (N <= 0) {
            return 0;
        }  //handling edge cases
        if(S.isEmpty()){
            return N*3;
        }
        int availability=3*N; //the total availability for family of 3
        availability-=fillSet(S,N); //total availability - the number of sections that can't fit family of 3
        return availability;
    }


    public static int fillSet(String S,int N){
        HashSet leftSeatSet=new HashSet<String>();
        HashSet midSeatSet=new HashSet<String>();
        HashSet rightSeatSet=new HashSet<String>();
        HashSet midEdgeCheck=new HashSet<String>();
        String temp;
        int tempStartIndex=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)==' ') {
                temp = S.substring(tempStartIndex, i);
                if (Character.getNumericValue(temp.charAt(0)) <= N) {
                    insertIntoSet(leftSeatSet,midSeatSet,rightSeatSet,midEdgeCheck,temp);//modify the sets accordingly
                    tempStartIndex = i + 1;//the next reservation starts at the next char after ' '
                }
            }
        }
        String lastReserved=S.substring(tempStartIndex);
        insertIntoSet(leftSeatSet,midSeatSet,rightSeatSet,midEdgeCheck,lastReserved);//taking care of last reservation
        return leftSeatSet.size()+rightSeatSet.size()+midSeatSet.size(); //return the total number of sections that can't fit a family of 3
    }


    public static void insertIntoSet(HashSet leftSeatSet,HashSet midSeatSet,HashSet rightSeatSet,HashSet midEdgeCheck, String temp){
        if(temp.isEmpty()||leftSeatSet==null||rightSeatSet==null||midEdgeCheck==null||midSeatSet==null){
            return;
        }
        if (temp.charAt(1) < 'D'&&temp.charAt(1)>='A') {
            if (!leftSeatSet.contains(temp.charAt(0))) {
                leftSeatSet.add(temp.charAt(0));
            }
        } else if (temp.charAt(1) == 'E' || temp.charAt(1) == 'F') {
            if (!midSeatSet.contains(temp.charAt(0))) {
                midSeatSet.add(temp.charAt(0));
            }

        } else if (temp.charAt(1) == 'D' || temp.charAt(1) == 'G') {
            if (!midEdgeCheck.contains(temp.charAt(0))) {
                midEdgeCheck.add(temp.charAt(0));
            } else {
                if (!midSeatSet.contains(temp.charAt(0))) {
                    midSeatSet.add(temp.charAt(0));
                }
            }
        } else if (temp.charAt(1) >= 'H' && temp.charAt(1) <= 'K') {
            if (!rightSeatSet.contains(temp.charAt(0))) {
                rightSeatSet.add(temp.charAt(0));
            }
        }
    }

}
