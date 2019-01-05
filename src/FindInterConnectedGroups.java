import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindInterConnectedGroups{
    public static void main(String[] args) {

//        ArrayList<String> list=new ArrayList();
//        list.add("1100");
//        list.add("1110");
//        list.add("0110");
//        list.add("0001");
//
//
//        System.out.println(zombieCluster(list));
        int[][] M= new int[4][4];
        M[0]=new int[]{1,1,0,0};
        M[1]=new int[]{1,1,1,0};
        M[2]=new int[]{0,1,1,0};
        M[3]=new int[]{0,0,0,1};
        System.out.println(findCircleNum(M));

    }
    static int findCircleNum(int[][] M) {
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) {
                dfs(M, i);
                count++;
            }
        }
        return count;
    }
    static void dfs(int[][] M, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1) {
                M[i][j] = M[j][i] = 0;
                dfs(M, j);
            }
        }
    }


//    static int zombieCluster(List<String> zombies) {
//            int count = 0;
//            for (int i = 0; i < zombies.size(); i++) {
//                if (zombies.get(i).charAt(i) == 1) {
//                    int[][]M=new int[zombies.size()][zombies.size()];
//                    for(int k=0;i<zombies.size();i++){
//                        for(int p=0;p<zombies.size();i++){
//                            M[k][p]=zombies.get(k).charAt(p);
//                        }
//                    }
//                    dfs(M, i);
//                    count++;
//                }
//            }
//            return count;
//
//    }
//    static void dfs(int[][] M, int i) {
//        for (int j = 0; j < M.length; j++) {
//            if (M[i][j] == 1) {
//                M[i][j] = M[j][i] = 0;
//                dfs(M, j);
//            }
//        }
//    }


}
