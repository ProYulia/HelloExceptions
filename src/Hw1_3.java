import java.sql.SQLOutput;
import java.util.Arrays;

public class Hw1_3 {
    public static void main(String[] args) {
        try {
            System.out.println(Arrays.toString(QuotientOf(new int[]{0, 2}, new int[]{3, 4})));
        }
        catch (RuntimeException e) {
            System.out.println("Ошибка!");
        }

    }
    private static float[] QuotientOf(int[] a, int[] b) {
        if (a.length != b.length) throw new RuntimeException("Длины массивов должны совпадать");
        float[] result = new float[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = b[i] / a[i];
        }
        return result;
    }
}
