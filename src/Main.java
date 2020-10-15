import java.util.Scanner;

public class Main {
    public static void showMain() {
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xoá");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Thoát");
    }
    public static void main(String[] args) {
        Method method = new Method();
        Scanner sc = new Scanner(System.in);
        String choise = "";
        do {
            showMain();
            choise = sc.nextLine();
            switch (choise) {
                case "1":
                    method.displayList();
                    break;
                case "2":
                    method.add();
                    break;
                case "3":
                    method.update();
                break;
                case "4":
                    method.delete();
                    break;
                case "5":
                    method.SeachNumPhoneByName();
                    break;
                case "0":
                    System.exit(-1);
            }
        }while (true);


    }
}
