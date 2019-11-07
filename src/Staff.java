/**
 * https://blog.csdn.net/qq_40646143/article/details/84312912
 */

import java.io.*;

public class Staff implements Serializable {
    private static final long serialVersionUID = 2497140260621995246L;
    private transient String name;
    private int pay;

    public Staff() {
    }

    public Staff(String name, int pay) {
        this.name = name;
        this.pay = pay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public static void write(String path) throws IOException {
        Staff staff = new Staff("TY", 10000);
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(path))));

        oos.writeObject(staff);
        oos.flush();
        oos.close();
    }

    public static void read(String path) throws IOException, ClassNotFoundException {
        Staff staff;
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(path))));

        staff = (Staff)ois.readObject();
        System.out.println("Name: " + staff.name);
        System.out.println("Pay: " + staff.pay);
        ois.close();
    }

    public static void writeGroup(String path) throws IOException {
        Staff[] staffArray = new Staff[3];
        staffArray[0] = new Staff("Kathy Shen", 10000);
        staffArray[1] = new Staff("Kelly Shi", 12000);
        staffArray[2] = new Staff("Susan Feng", 13000);

        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(path))));
        oos.writeObject(staffArray);
        oos.flush();
        oos.close();
    }

    public static void readGroup(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(path))));

        Staff[] staffArray;
        staffArray = (Staff[])ois.readObject();

        ois.close();

        for (Staff staff : staffArray) {
            System.out.println("Name: " + staff.name);
            System.out.println("Pay: " + staff.pay);
        }
    }

    public static void writeGroup(int type) throws IOException {
        if (type == 1) {
            Staff[] staff = new Staff[3];
            staff[0] = new Staff("Kathy Shen", 10000);
            staff[1] = new Staff("Kelly Shi", 12000);
            staff[2] = new Staff("Susan Feng", 13000);

            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("staff.txt"))));
            oos.writeObject(staff);
            oos.flush();
            oos.close();
        }
        else if (type == 2) {
            int[] id = new int[]{1, 2, 3};

            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("id.txt"))));
            oos.writeObject(id);
            oos.flush();
            oos.close();
        }
        else {
            System.out.println("ERROR: not supported type - " + type);
        }
    }

    public static void readGroup(int type) throws IOException, ClassNotFoundException {
        if (type == 1) {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("staff.txt"))));

            Staff[] staffArray;
            staffArray = (Staff[])ois.readObject();
            ois.close();

            for (Staff staff : staffArray) {
                System.out.println("Name: " + staff.name);
                System.out.println("Pay: " + staff.pay);
            }

        }
        else if (type == 2) {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("id.txt"))));

            int[] idArray;
            idArray = (int[])ois.readObject();
            ois.close();

            for (int id : idArray) {
                System.out.println("ID: " + id);
            }
        }
        else {
            System.out.println("ERROR: not supported type - " + type);
        }
    }

    public static void main(String[] args) {
        /*try {
            write("staff.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            read("staff.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            writeGroup("staffgroup.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            readGroup("staffgroup.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        try {
            writeGroup(1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readGroup(1);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            writeGroup(2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            readGroup(2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
