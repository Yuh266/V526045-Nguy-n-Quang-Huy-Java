import java.util.Arrays;

public class Slide2_TongHaiMang {
    public static void inMangTong(int[] mang1, int[] mang2) {
        int soPhanTu = Math.max(mang1.length, mang2.length);
        long[] mangTong = new long[soPhanTu];

        for (int i = 0; i < soPhanTu; i++) {
            long a = i < mang1.length ? mang1[i] : 0;
            long b = i < mang2.length ? mang2[i] : 0;
            mangTong[i] = a + b;
        }

        System.out.println("Mảng tổng: " + Arrays.toString(mangTong));
    }

    public static void main(String[] args) {
        int[] mang1 = {1, 2, 3};
        int[] mang2 = {4, 5, 6, 7, 8};

        System.out.println("Mảng thứ nhất: " + Arrays.toString(mang1));
        System.out.println("Mảng thứ hai: " + Arrays.toString(mang2));
        inMangTong(mang1, mang2);
    }
}
