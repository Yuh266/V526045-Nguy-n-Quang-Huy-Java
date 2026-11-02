# Bài tập Java ngày 26 — phân số và điểm 2D/3D

## Biên dịch và chạy

Mở terminal trong thư mục `Java-26` (cần JDK 8 trở lên):

```powershell
javac -encoding UTF-8 -d out *.java
java -cp out Bai1PhanSo
java -cp out Bai2Diem
```

Hai chương trình cho nhập dữ liệu từ bàn phím. Dùng dấu chấm khi nhập số thập phân. Chạy với dữ liệu mẫu có sẵn:

```powershell
java -cp out Bai1PhanSo --demo
java -cp out Bai2Diem --demo
```

## Bài 1 — Class và object

- `PhanSo.java`: thuộc tính `private`, constructor mặc định `0/1`, constructor có đối số, getters/setters, `toString`, cộng/trừ/nhân/chia, so sánh qua `compareTo`, rút gọn và kiểm tra số nguyên.
- `Bai1PhanSo.java`: nhập danh sách; tìm phân số lớn nhất, tính tổng và đếm phân số không phải số nguyên; minh họa phép toán trên hai phần tử đầu.
- Phân số tự rút gọn khi tạo, gọi setter hoặc tính toán; mẫu luôn dương và khác 0. Ví dụ `6/-8` thành `-3/4`, `0/5` thành `0/1`. Hàm `rutGon()` vẫn được cung cấp riêng theo đề.
- Setter thay đổi tử hoặc mẫu của **giá trị đang lưu đã rút gọn**. Các phép toán trả về đối tượng mới. Chia cho phân số bằng 0 bị từ chối.
- Dùng `int` để lưu tử/mẫu, `long` cho phép nhân chéo. Nếu kết quả rút gọn vượt phạm vi `int`, chương trình báo lỗi thay vì trả kết quả tràn số.
- “Tập hợp” được lưu bằng danh sách: mỗi phân số nhập vào được tính một lần, kể cả các giá trị trùng nhau.

Dữ liệu mẫu: `[1/2, 3/4, 2/1, -2/3, 0/1]`.

Kết quả: lớn nhất `2/1`, tổng `31/12`, có `3` phân số không nguyên. Với `1/2` và `3/4`: tổng `5/4`, hiệu `-1/4`, tích `3/8`, thương `2/3`.

## Bài 2 — Kế thừa và access modifier

- `Diem2D.java`: tọa độ `x`, `y` có phạm vi `protected`, constructor/getter/setter; khoảng cách, điểm đối xứng qua gốc và tịnh tiến.
- `Diem3D.java`: kế thừa `Diem2D`, bổ sung `private z`; dùng `super`, ghi đè `khoangCach`, `doiXung`, `toString`; nạp chồng `tinhTien` với ba độ lệch.
- `Bai2Diem.java`: dùng chung `List<Diem2D>` chứa cả hai loại điểm và gọi phương thức qua đa hình.

Công thức:

- 2D: `sqrt((x1-x2)^2 + (y1-y2)^2)`; đối xứng `(-x, -y)`.
- 3D: `sqrt((x1-x2)^2 + (y1-y2)^2 + (z1-z2)^2)`; đối xứng `(-x, -y, -z)`.
- Tịnh tiến cộng từng độ lệch vào tọa độ tương ứng. Hàm này thay đổi điểm hiện tại; `doiXung()` tạo điểm mới.

**Cách hiểu tổng khoảng cách:** tính giữa mọi cặp điểm cùng loại trong danh sách ban đầu, mỗi cặp một lần (`i < j`). Không tính chéo 2D–3D; nếu một loại có dưới hai điểm thì tổng bằng 0. Sau khi tính tổng, thêm đúng một điểm đối xứng cho mỗi điểm ban đầu và hiển thị danh sách. Giữ cả các điểm trùng tọa độ.

Dữ liệu mẫu xen kẽ: 2D `(0,0)`, 3D `(0,0,0)`, 2D `(3,4)`, 3D `(1,2,2)`. Tổng khoảng cách 2D là `5`, 3D là `3`; thêm đối xứng xong có `8` điểm. Phần cuối minh họa tịnh tiến ra 2D `(3,1)` và 3D `(3,1,7)`.

`NhapLieu.java` cung cấp các hàm nhập dùng chung, kiểm tra kiểu dữ liệu, số lượng, loại điểm và số thực hữu hạn.
