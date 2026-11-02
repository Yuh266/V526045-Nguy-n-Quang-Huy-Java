import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai2Diem {
    /** Cộng khoảng cách mọi cặp cùng loại, mỗi cặp chỉ tính một lần. */
    public static double tinhTongKhoangCach(List<Diem2D> danhSach, boolean la3D) {
        double tong = 0;
        for (int i = 0; i < danhSach.size(); i++) {
            Diem2D a = danhSach.get(i);
            if ((a instanceof Diem3D) != la3D) {
                continue;
            }
            for (int j = i + 1; j < danhSach.size(); j++) {
                Diem2D b = danhSach.get(j);
                // Điểm 3D cũng là instanceof Diem2D nên phải phân loại bằng Diem3D.
                if ((b instanceof Diem3D) == la3D) {
                    tong += a.khoangCach(b);
                }
            }
        }
        return tong;
    }

    public static void themCacDiemDoiXung(List<Diem2D> danhSach) {
        int soDiemBanDau = danhSach.size();
        for (int i = 0; i < soDiemBanDau; i++) {
            // Đa hình: điểm 3D tự gọi phiên bản doiXung() của Diem3D.
            danhSach.add(danhSach.get(i).doiXung());
        }
    }

    public static void hienThi(List<Diem2D> danhSach) {
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.println((i + 1) + ". " + danhSach.get(i));
        }
    }

    public static void main(String[] args) {
        List<Diem2D> danhSach = new ArrayList<>();
        boolean demo = args.length > 0 && args[0].equals("--demo");
        if (demo) {
            danhSach.add(new Diem2D(0, 0));
            danhSach.add(new Diem3D(0, 0, 0));
            danhSach.add(new Diem2D(3, 4));
            danhSach.add(new Diem3D(1, 2, 2));
        } else {
            Scanner scanner = new Scanner(System.in);
            int n = NhapLieu.nhapIntTrongKhoang(scanner, "Nhập số điểm: ", 1, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                System.out.println("Điểm thứ " + (i + 1) + ":");
                int loai = NhapLieu.nhapIntTrongKhoang(scanner, "  Loại điểm (2 = 2D, 3 = 3D): ", 2, 3);
                double x = NhapLieu.nhapDouble(scanner, "  x: ");
                double y = NhapLieu.nhapDouble(scanner, "  y: ");
                if (loai == 3) {
                    double z = NhapLieu.nhapDouble(scanner, "  z: ");
                    danhSach.add(new Diem3D(x, y, z));
                } else {
                    danhSach.add(new Diem2D(x, y));
                }
            }
        }

        System.out.println("\nDanh sách ban đầu:");
        hienThi(danhSach);
        System.out.printf("Tổng khoảng cách các cặp điểm 2D: %.4f%n", tinhTongKhoangCach(danhSach, false));
        System.out.printf("Tổng khoảng cách các cặp điểm 3D: %.4f%n", tinhTongKhoangCach(danhSach, true));

        themCacDiemDoiXung(danhSach);
        System.out.println("\nDanh sách sau khi thêm các điểm đối xứng:");
        hienThi(danhSach);

        Diem2D diem2D = new Diem2D(1, 2);
        diem2D.tinhTien(2, -1);
        System.out.println("\nTịnh tiến Diem2D(1, 2) với độ lệch (2, -1): " + diem2D);
        Diem3D diem3D = new Diem3D(1, 2, 3);
        diem3D.tinhTien(2, -1, 4);
        System.out.println("Tịnh tiến Diem3D(1, 2, 3) với độ lệch (2, -1, 4): " + diem3D);
    }
}
