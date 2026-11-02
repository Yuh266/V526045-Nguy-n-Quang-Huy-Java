import java.util.Scanner;

/** Các hàm nhập liệu dùng chung cho hai chương trình. */
public final class NhapLieu {
    private NhapLieu() {
    }

    public static int nhapInt(Scanner scanner, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String token = scanner.next();
            try {
                return Integer.parseInt(token);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên trong phạm vi int.");
            }
        }
    }

    public static int nhapIntTrongKhoang(Scanner scanner, String thongBao, int min, int max) {
        while (true) {
            int giaTri = nhapInt(scanner, thongBao);
            if (giaTri >= min && giaTri <= max) {
                return giaTri;
            }
            System.out.printf("Giá trị phải từ %d đến %d.%n", min, max);
        }
    }

    public static double nhapDouble(Scanner scanner, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            try {
                double giaTri = Double.parseDouble(scanner.next());
                if (Double.isFinite(giaTri)) {
                    return giaTri;
                }
            } catch (NumberFormatException e) {
                // In thông báo và cho nhập lại bên dưới.
            }
            System.out.println("Vui lòng nhập số thực hữu hạn, dùng dấu chấm thập phân.");
        }
    }
}
