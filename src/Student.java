/**
 * https://blog.csdn.net/Joe18576558921/article/details/79892974
 */

import java.io.*;
import java.util.ArrayList;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    String name;
    int age;
    String sex;

    public Student(String _name, int _age, String _sex) {
        this.name = _name;
        this.age = _age;
        this.sex = _sex;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Age: " + this.age + ", Sex: " + this.sex;
    }
}

class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("output.dat"))));

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Cobbin CB Cao", 10, "Male"));
        studentList.add(new Student("Kathy Shen", 12, "Female"));
        studentList.add(new Student("Kelly Shi", 11, "Female"));

        oos.writeObject(studentList);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("output.dat"))));
        ArrayList<Student> inList;
        inList = (ArrayList<Student>) ois.readObject();
        System.out.println(inList);
    }
}
