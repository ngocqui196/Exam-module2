import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {

    public void writeFile(List<PhoneBook> productList) {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File("contacts.csv"));
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeOS(fileOutputStream);
            closeOS(objectOutputStream);

        }
    }

    public List<PhoneBook> readFile() {
        List<PhoneBook> products = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("contacts.csv"));
            objectInputStream = new ObjectInputStream(fileInputStream);
            products = (List<PhoneBook>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            closeIS(fileInputStream);
            closeIS(objectInputStream);
        }
        return products;
    }
    public void closeIS (InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void closeOS (OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}