import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bai1PhanSo {
    public static PhanSo timLonNhat(List<PhanSo> danhSach) {
        if (danhSach.isEmpty()) {
            throw new IllegalArgumentException("Danh sách phân số đang rỗng.");
        }
        PhanSo lonNhat = danhSach.get(0);
        for (PhanSo p : danhSach) {
            if (p.compareTo(lonNhat) > 0) {
                lonNhat = p;
            }
        }
        return lonNhat;
    }

    public static PhanSo tinhTong(List<PhanSo> danhSach) {
        PhanSo tong = new PhanSo();
        for (PhanSo p : danhSach) {
            tong = tong.cong(p);
        }
        return tong;
    }

    public static int demKhongNguyen(List<PhanSo> danhSach) {
        int dem = 0;
        for (PhanSo p : danhSach) {
            if (!p.laSoNguyen()) {
                dem++;
            }
        }
        return dem;
    }

    public static void main(String[] args) {
        List<PhanSo> danhSach = new ArrayList<>();
        boolean demo = args.length > 0 && args[0].equals("--demo");
        if (demo) {
            danhSach.add(new PhanSo(1, 2));
            danhSach.add(new PhanSo(3, 4));
            danhSach.add(new PhanSo(4, 2));
            danhSach.add(new PhanSo(-2, 3));
            danhSach.add(new PhanSo(0, 5));
        } else {
            Scanner scanner = new Scanner(System.in);
            int n = NhapLieu.nhapIntTrongKhoang(scanner, "Nhập số phân số: ", 1, Integer.MAX_VALUE);
            for (int i = 0; i < n; i++) {
                while (true) {
                    System.out.println("Phân số thứ " + (i + 1) + ":");
                    int tu = NhapLieu.nhapInt(scanner, "  Tử số: ");
                    int mau = NhapLieu.nhapInt(scanner, "  Mẫu số: ");
                    try {
                        danhSach.add(new PhanSo(tu, mau));
                        break;
                    } catch (IllegalArgumentException | ArithmeticException e) {
                        System.out.println("Phân số không hợp lệ hoặc vượt phạm vi int. Hãy nhập lại.");
                    }
                }
            }
        }

        System.out.println("Danh sách đã rút gọn: " + danhSach);
        System.out.println("Phân số lớn nhất: " + timLonNhat(danhSach));
        try {
            System.out.println("Tổng các phân số: " + tinhTong(danhSach));
        } catch (ArithmeticException e) {
            System.out.println("Tổng phân số vượt phạm vi int.");
        }
        System.out.println("Số phân số không phải số nguyên: " + demKhongNguyen(danhSach));

        if (danhSach.size() >= 2) {
            PhanSo a = danhSach.get(0);
            PhanSo b = danhSach.get(1);
            System.out.println("\nMinh họa các phép toán với " + a + " và " + b + ":");
            try {
                System.out.println("Tổng: " + a.cong(b));
                System.out.println("Hiệu: " + a.tru(b));
                System.out.println("Tích: " + a.nhan(b));
                System.out.println("Thương: " + a.chia(b));
            } catch (ArithmeticException e) {
                System.out.println("Không tính được phép toán: " + e.getMessage());
            }
            int soSanh = a.compareTo(b);
            System.out.println("So sánh: " + a + (soSanh < 0 ? " < " : soSanh > 0 ? " > " : " = ") + b);
        }
    }
}
