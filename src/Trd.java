import java.util.Arrays;

public class Trd {
    public static void main(String[] args) {
        /*int[] a = {1, 2, 3};
        // make a one bigger
        a = Arrays.copyOf(a, a.length + 1);
        for (int i : a)
            System.out.println(i);*/
        int [] a = new int[5];
        a[0] = 8;
        a[1] = 5;
        a[2] = 1;
        a[3] = 6;
        a[4] = 0;

        int max = 0, index = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]){
                max = a[i];
                index = i;
            }
        }
        System.out.println("max = " + max);
        System.out.println("inde = " + index);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        int [] temp = new int[a.length - 1];
        //System.arraycopy(a,0,temp,0,temp.length);
        //temp = Arrays.copyOf(a, a.length - 1);

        //a = temp;
        System.out.println();
        for (int i = 0; i < a.length - 1; i++) {
            if(a[i] == max){
                continue;
            } else {
                temp[i] = a[i];
            }
        }

        a = temp;
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        temp = null;
    }
}
