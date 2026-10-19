public class Slide3_Bai2_CacHinh {
    public static class Diem {
        private double x;
        private double y;

        public Diem(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }
    }

    public static class TamGiac {
        private Diem a;
        private Diem b;
        private Diem c;

        public TamGiac(Diem a, Diem b, Diem c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        private double khoangCach(Diem p, Diem q) {
            return Math.hypot(q.getX() - p.getX(), q.getY() - p.getY());
        }

        public double tinhChuVi() {
            return khoangCach(a, b) + khoangCach(b, c) + khoangCach(c, a);
        }

        public double tinhDienTich() {
            // Diện tích từ tọa độ: S = |(xB-xA)(yC-yA) - (yB-yA)(xC-xA)| / 2.
            double abX = b.getX() - a.getX();
            double abY = b.getY() - a.getY();
            double acX = c.getX() - a.getX();
            double acY = c.getY() - a.getY();
            return Math.abs(abX * acY - abY * acX) / 2;
        }
    }

    public static class ChuNhat {
        private double chieuDai;
        private double chieuRong;

        public ChuNhat(double chieuDai, double chieuRong) {
            this.chieuDai = chieuDai;
            this.chieuRong = chieuRong;
        }

        public double tinhChuVi() {
            return 2 * (chieuDai + chieuRong);
        }

        public double tinhDienTich() {
            return chieuDai * chieuRong;
        }
    }

    public static class HinhTron {
        private Diem o;
        private double banKinh;

        public HinhTron(Diem o, double banKinh) {
            this.o = o;
            this.banKinh = banKinh;
        }

        public Diem getO() {
            return o;
        }

        public double tinhChuVi() {
            return 2 * Math.PI * banKinh;
        }

        public double tinhDienTich() {
            return Math.PI * banKinh * banKinh;
        }
    }

    private static void inKetQua(String tenHinh, double chuVi, double dienTich) {
        System.out.printf("%s: Chu vi = %.2f; Diện tích = %.2f%n", tenHinh, chuVi, dienTich);
    }

    public static void main(String[] args) {
        TamGiac tamGiac1 = new TamGiac(new Diem(0, 0), new Diem(3, 0), new Diem(0, 4));
        TamGiac tamGiac2 = new TamGiac(new Diem(1, 1), new Diem(7, 1), new Diem(1, 9));

        ChuNhat chuNhat1 = new ChuNhat(3, 4);
        ChuNhat chuNhat2 = new ChuNhat(5, 8);

        HinhTron hinhTron1 = new HinhTron(new Diem(0, 0), 2);
        HinhTron hinhTron2 = new HinhTron(new Diem(1, 2), 5);

        inKetQua("Tam giác 1", tamGiac1.tinhChuVi(), tamGiac1.tinhDienTich());
        inKetQua("Tam giác 2", tamGiac2.tinhChuVi(), tamGiac2.tinhDienTich());
        inKetQua("Chữ nhật 1", chuNhat1.tinhChuVi(), chuNhat1.tinhDienTich());
        inKetQua("Chữ nhật 2", chuNhat2.tinhChuVi(), chuNhat2.tinhDienTich());
        inKetQua("Hình tròn 1", hinhTron1.tinhChuVi(), hinhTron1.tinhDienTich());
        inKetQua("Hình tròn 2", hinhTron2.tinhChuVi(), hinhTron2.tinhDienTich());
    }
}
