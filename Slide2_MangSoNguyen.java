import java.util.Scanner;

public class Slide2_MangSoNguyen {
    public static void main(String[] args) {
        // 1. Tạo công cụ Scanner để đọc dữ liệu nhập từ bàn phím
        Scanner scanner = new Scanner(System.in);

        // 2. Nhập số lượng phần tử n
        System.out.print("Nhap so luong phan tu n = ");
        int n = scanner.nextInt();

        // 3. Khai báo mảng số nguyên gồm n phần tử
        int[] arr = new int[n];

        // 4. Nhập giá trị cho từng phần tử của mảng
        System.out.println("Nhap cac phan tu cua mang:");
        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }

        // 5. In ra các phần tử trong mảng
        System.out.print("Mang vua nhap la: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(); // Xuống dòng

        // 6. Tính tổng các phần tử
        int tong = 0;
        for (int i = 0; i < n; i++) {
            tong += arr[i];
        }

        // 7. In ra tổng
        System.out.println("Tong cac phan tu trong mang la: " + tong);

        // Đóng scanner sau khi dùng xong
        scanner.close();
    }
}
