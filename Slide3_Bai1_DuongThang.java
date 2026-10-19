public class Slide3_Bai1_DuongThang {
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

    public static class DuongThang {
        private Diem a;
        private Diem b;

        public DuongThang(Diem a, Diem b) {
            this.a = a;
            this.b = b;
        }

        public Diem getA() {
            return a;
        }

        public Diem getB() {
            return b;
        }

        public double tinhDoDai() {
            // AB = căn bậc hai của ((xB - xA)^2 + (yB - yA)^2).
            return Math.hypot(b.getX() - a.getX(), b.getY() - a.getY());
        }
    }

    public static void main(String[] args) {
        Diem a = new Diem(1, 2);
        Diem b = new Diem(4, 6);
        DuongThang ab = new DuongThang(a, b);

        System.out.printf("A(%.2f, %.2f)%n", ab.getA().getX(), ab.getA().getY());
        System.out.printf("B(%.2f, %.2f)%n", ab.getB().getX(), ab.getB().getY());
        System.out.printf("Độ dài AB: %.2f%n", ab.tinhDoDai());
    }
}
