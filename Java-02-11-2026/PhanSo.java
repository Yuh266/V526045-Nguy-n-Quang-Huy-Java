/** Phân số luôn được rút gọn và có mẫu số dương. */
public class PhanSo implements Comparable<PhanSo> {
    private int tuSo;
    private int mauSo;

    public PhanSo() {
        this(0, 1);
    }

    public PhanSo(int tuSo, int mauSo) {
        ganGiaTri(tuSo, mauSo);
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        ganGiaTri(tuSo, mauSo);
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        ganGiaTri(tuSo, mauSo);
    }

    private static long ucln(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long du = a % b;
            a = b;
            b = du;
        }
        return a;
    }

    // Dùng long cho kết quả trung gian, sau đó rút gọn trước khi lưu vào int.
    private void ganGiaTri(long tu, long mau) {
        if (mau == 0) {
            throw new IllegalArgumentException("Mẫu số phải khác 0.");
        }
        if (mau < 0) {
            tu = -tu;
            mau = -mau;
        }
        long uoc = ucln(tu, mau);
        int tuMoi = Math.toIntExact(tu / uoc);
        int mauMoi = Math.toIntExact(mau / uoc);
        tuSo = tuMoi;
        mauSo = mauMoi;
    }

    private static PhanSo taoKetQua(long tu, long mau) {
        PhanSo ketQua = new PhanSo();
        ketQua.ganGiaTri(tu, mau);
        return ketQua;
    }

    public void rutGon() {
        ganGiaTri(tuSo, mauSo);
    }

    // Các phép toán trả về phân số mới, không thay đổi hai toán hạng.
    public PhanSo cong(PhanSo p) {
        return taoKetQua((long) tuSo * p.mauSo + (long) p.tuSo * mauSo,
                (long) mauSo * p.mauSo);
    }

    public PhanSo tru(PhanSo p) {
        return taoKetQua((long) tuSo * p.mauSo - (long) p.tuSo * mauSo,
                (long) mauSo * p.mauSo);
    }

    public PhanSo nhan(PhanSo p) {
        return taoKetQua((long) tuSo * p.tuSo, (long) mauSo * p.mauSo);
    }

    public PhanSo chia(PhanSo p) {
        if (p.tuSo == 0) {
            throw new ArithmeticException("Không thể chia cho phân số bằng 0.");
        }
        return taoKetQua((long) tuSo * p.mauSo, (long) mauSo * p.tuSo);
    }

    @Override
    public int compareTo(PhanSo p) {
        return Long.compare((long) tuSo * p.mauSo, (long) p.tuSo * mauSo);
    }

    public boolean laSoNguyen() {
        return tuSo % mauSo == 0;
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }
}
