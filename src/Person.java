/**
 * https://blog.csdn.net/abc123lzf/article/details/82318148
 */

import java.io.*;

public class Person implements Serializable {
    private static final long serialVersionUID = 1386583756403881124L;

    String name;
    int age;
}

class Test {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("out.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Person p = new Person();
        p.name = "LZF";
        p.age = 19;
        oos.writeObject(p);
        oos.close();
    }
}
