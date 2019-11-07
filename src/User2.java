import java.io.*;

public class User2 implements Serializable {
    public static final long serialVersionUID = 1L;

    String uid;
    String pwd;
    String name;

    public User2(String _uid, String _pwd) {
        this.uid = _uid;
        this.pwd = _pwd;
    }

    @Override
    public String toString() {
        return "UID: " + this.uid + ", PWD: " + this.pwd;
    }

    public static void writeObject(File file) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));

        User2 user = new User2("Tony Yang", "123456789");
        oos.writeObject(user);
        oos.flush();
        oos.close();

        System.out.println("WRITE: OK");
    }

    public static void readObject(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

        User2 user;
        user = (User2)ois.readObject();
        ois.close();

        System.out.println("READ: OK");
        System.out.println(user);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("user2.txt");

        //writeObject(file);
        readObject(file);
    }
}
