import java.util.ArrayList;

public class FindCommonElementsInThreeSortedArrays {
    public static void main(String[] args) {
        System.out.println(findCommon(new int[]{1,5,10,20,40,80},new int[]{6,7,20,80,100},new int[]{3,4,15,20,30,70,80,120}));
    }
    public static ArrayList findCommon(int[] list1, int[] list2, int[] list3) {
        int list1Index = 0, list2Index = 0, list3Index = 0;
        ArrayList<Integer> commonArray = new ArrayList<>();
        while (list1Index < list1.length && list2Index < list2.length && list3Index < list3.length) {
            if (list1[list1Index] == list2[list2Index] && list2[list2Index] == list3[list3Index]) {
                commonArray.add(list1[list1Index]);

                list1Index++;
                list2Index++;
                list3Index++;
            } else {
                if (list1[list1Index] < list2[list2Index] && list1[list1Index] < list3[list3Index]) {
                    list1Index++;
                } else if (list2[list2Index] < list1[list1Index] && list2[list2Index] < list3[list3Index]) {
                    list2Index++;
                } else {
                    list3Index++;
                }
            }

        }
        return commonArray;
    }
}
