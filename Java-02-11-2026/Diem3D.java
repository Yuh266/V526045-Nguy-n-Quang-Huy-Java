public class Diem3D extends Diem2D {
    private double z;

    public Diem3D() {
        this(0, 0, 0);
    }

    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    // Ghi đè để vẫn tính đủ ba tọa độ khi tham chiếu có kiểu Diem2D.
    @Override
    public double khoangCach(Diem2D diem) {
        if (!(diem instanceof Diem3D)) {
            throw new IllegalArgumentException("Chỉ tính khoảng cách giữa hai điểm cùng loại.");
        }
        Diem3D diem3D = (Diem3D) diem;
        return Math.hypot(Math.hypot(x - diem3D.x, y - diem3D.y), z - diem3D.z);
    }

    @Override
    public Diem3D doiXung() {
        return new Diem3D(-x, -y, -z);
    }

    // Nạp chồng: phiên bản có ba độ lệch dành cho điểm 3D.
    public void tinhTien(double deltaX, double deltaY, double deltaZ) {
        super.tinhTien(deltaX, deltaY);
        z += deltaZ;
    }

    @Override
    public String toString() {
        return "Diem3D(" + x + ", " + y + ", " + z + ")";
    }
}
