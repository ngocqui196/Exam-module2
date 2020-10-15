import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Method {
    private static Pattern pattern;
    private static Matcher matcher;
    private  static Scanner scanner = new Scanner(System.in);
    private  static List<PhoneBook> phoneBookList;
    private static IOFile ioFile;


    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String NUMPHONE_REGEX = "^[0-9]{10}";

    public Method() {
        this.ioFile = new IOFile();
        phoneBookList = ioFile.readFile();
    }
    public static boolean validateNumPhone(String regex) {
        pattern = Pattern.compile(NUMPHONE_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validate(String regex) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static void add() {
        String numberPhone = inputSDT();
        String nhom = inputNhomDanhBa();
        String ten = inputName();
        String gioiTinh = inputGioiTinh();
        String diaChi = inputDiaChi();
        String ngaySinh = inputNgaySinh();
        String email = inputEmail();
        PhoneBook phoneBook = new PhoneBook(numberPhone,nhom,ten,gioiTinh,diaChi,ngaySinh,email);
        phoneBookList.add(phoneBook);
        ioFile.writeFile(phoneBookList);
    }

    public static void displayList() {
        for (PhoneBook phoneBook :
                phoneBookList) {
            System.out.println(phoneBook.toString());
        }
    }

    public static void update() {
        System.out.println("Cập nhật theo số điện thoại");
        String sdt = inputSDT();
        for (PhoneBook phonebook :
                phoneBookList) {
            if (sdt.equals(phonebook.getSdt())) {
                String sdt1 = updateSDT();
                String tenMoi = inputName();
                String nhomDanhBaMoi = inputNhomDanhBa();
                String gioiTinh = inputGioiTinh();
                String diaChi = inputDiaChi();
                String ngaySinh = inputNgaySinh();
                String email = inputEmail();
                phonebook.setSdt(sdt1);
                phonebook.setTen(tenMoi);
                phonebook.setNhomDanhBa(nhomDanhBaMoi);
                phonebook.setGioitinh(gioiTinh);
                phonebook.setDiaChi(diaChi);
                phonebook.setNgaySinh(ngaySinh);
                phonebook.setEmail(email);
            }
        }
        ioFile.writeFile(phoneBookList);
    }
    public static void delete() {
        String sdt = inputSDT();
        phoneBookList.removeIf(phoneBook -> sdt.equals(phoneBook.getSdt()));
        ioFile.writeFile(phoneBookList);
    }
    public static void SeachNumPhoneByName() {
        String name = inputName();
        for (PhoneBook phoneBook : phoneBookList) {
            if (name.equals(phoneBook.getTen())) {
                phoneBook.toString();
            }
        }
    }
    private  static String inputSDT() {
        String numberPhone = "";
        boolean checkNumberPhone = false;
        while (!checkNumberPhone) {
            try {
                System.out.println("Nhap vao so dien thoai: ");
                numberPhone = scanner.nextLine();
                checkNumberPhone = true;
            } catch (Exception e) {
                System.out.println("numberPhone phai la so nguyen");
            }

        }return numberPhone;

    }
    private static String updateSDT() {
        boolean checkSDT = false;
        String sdt = "";
        while (!checkSDT) {
            System.out.print("Nhập số điện thoại:");
            sdt = scanner.nextLine();
            if (validateNumPhone(sdt)) {
                checkSDT = true;
            }else {
                System.out.println("Số điện thoại không đúng định dạng.");
            }
        }
        return sdt;
    }

    private static String inputName() {
        System.out.print("Nhập tên: ");
                return  scanner.nextLine();
    }
    private static String inputNhomDanhBa() {
        System.out.print("Nhập nhóm danh bạ:");
        return scanner.nextLine();
    }
    private static String inputGioiTinh() {
        System.out.print("Nhập giới tính:");
        return scanner.nextLine();
    }
    private static String inputDiaChi() {
        System.out.print("Nhập Địa chỉ:");
        return scanner.nextLine();
    }
    private static String inputNgaySinh() {
        System.out.print("Nhập ngày sinh:");
        return scanner.nextLine();
    }


    private static String inputEmail() {
        boolean checkEmail = false;
        String email ="";
        while (!checkEmail){
            System.out.println("Nhap vao email: ");
            email = scanner.nextLine();
            if(validate(email)){
                checkEmail = true;
            }else {
                System.out.println("Email không đúng định dạng");
            }
        }
        return email;
    }

}
