public class Diem2D {
    // protected: lớp con Diem3D được truy cập trực tiếp hai tọa độ này.
    protected double x;
    protected double y;

    public Diem2D() {
        this(0, 0);
    }

    public Diem2D(double x, double y) {
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

    public double khoangCach(Diem2D diem) {
        if (diem instanceof Diem3D) {
            throw new IllegalArgumentException("Chỉ tính khoảng cách giữa hai điểm cùng loại.");
        }
        return Math.hypot(x - diem.x, y - diem.y);
    }

    // Trả về điểm mới, giữ nguyên điểm ban đầu.
    public Diem2D doiXung() {
        return new Diem2D(-x, -y);
    }

    // Tịnh tiến thay đổi trực tiếp tọa độ điểm hiện tại.
    public void tinhTien(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
    }

    @Override
    public String toString() {
        return "Diem2D(" + x + ", " + y + ")";
    }
}
