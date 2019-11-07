import java.io.*;

class Address implements Serializable {
    String country;
    String city;

    public Address(String _country, String _city) {
        this.country = _country;
        this.city = _city;
    }

    @Override
    public String toString() {
        return "Country: " + this.country + ", City: " + this.city;
    }
}

public class User3 implements Serializable {
    String uid;
    String pwd;
    Address address;

    public User3(String _uid, String _pwd, String _country, String _city) {
        this.uid = _uid;
        this.pwd = _pwd;
        this.address = new Address(_country, _city);
    }

    @Override
    public String toString() {
        return "UID: " + this.uid + ", PWD: " + this.pwd + ", " + this.address;
    }

    public static void writeObject(File file) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

        User3 user  = new User3("Tony Yang", "123456789", "China", "Suzhou");
        oos.writeObject(user);
        oos.flush();
        oos.close();

        System.out.println("WRITE: OK");
    }

    public static void readObject(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

        User3 user;
        user = (User3)ois.readObject();
        ois.close();

        System.out.println("READ: OK");
        System.out.println(user);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("user3.txt");

        writeObject(file);
        readObject(file);
    }
}
