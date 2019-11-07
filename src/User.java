import java.io.*;

/**
 * https://www.cnblogs.com/fnz0/p/5410856.html
 */

public class User implements Serializable {
    String uid;
    String pwd;

    public User(String _uid, String _pwd) {
        this.uid = _uid;
        this.pwd = _pwd;
    }

    @Override
    public String toString() {
        return "UID: " + this.uid + ", PWD: " + this.pwd;
    }

    public static void writeObject(File file) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        oos.writeObject(new User("Tony Yang", "123456789"));
        oos.flush();
        oos.close();
    }

    public static void readObject(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));

        User user;
        user = (User)ois.readObject();
        ois.close();

        System.out.println(user);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("user.txt");

        writeObject(file);
        System.out.println("OK");

        readObject(file);
    }
}
