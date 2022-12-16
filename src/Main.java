import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        try {
            System.out.println(checkArray(a, 2));
        }
        catch(Exception e) {
            System.out.println("Error");
        }
    }

    public static int checkArray(int[] array, Integer num) throws Exception {
        if (num == null)
            throw new Exception("-3");
        if (array.length < 2)
            throw new Exception("-1");
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num)
                return i;
        }
            return -2;
        }









}