public class JumpingOnTheCloud {
    public static void main(String arg[]){
        String string="aksdakdjfkxvze";
        string=string.replaceAll("[^akz]"," ");

        System.out.println(jumpingOnClouds(new int[]{0,0,0,0,1,0}));
    }
    static int jumpingOnClouds(int[] c) {
        int count=-1;
        for (int i = 0; i < c.length; i++, count++) {
            if (i<c.length-2 && c[i+2]==0)
                i++;
        }
        return count;
    }
}
