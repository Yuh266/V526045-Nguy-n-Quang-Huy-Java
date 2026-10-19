import java.util.Scanner;

public class Slide2_NhapMangTuChuoi {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Nhập các số nguyên trên một dòng, cách nhau bằng dấu cách:");
            String chuoi = scanner.nextLine().trim();

            if (chuoi.isEmpty()) {
                System.out.println("Số phần tử: 0; Tổng: 0.");
                return;
            }

            String[] cacSo = chuoi.split("\\s+");
            int[] mang = new int[cacSo.length];
            long tong = 0;

            try {
                for (int i = 0; i < cacSo.length; i++) {
                    mang[i] = Integer.parseInt(cacSo[i]);
                    tong += mang[i];
                }
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ. Vui lòng chỉ nhập các số nguyên kiểu int.");
                return;
            }

            System.out.println("Số phần tử: " + mang.length + "; Tổng: " + tong + ".");
        }
    }
}
