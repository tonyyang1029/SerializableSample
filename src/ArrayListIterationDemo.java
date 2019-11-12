import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIterationDemo {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<>();
        strList.add("Kelly Shi");
        strList.add("Kathy Shen");
        strList.add("Tony Yang");

        // Method 1
        System.out.println("## Method 1 ##");
        Iterator iterator1 = strList.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        // Method 2
        System.out.println("## Method 2 ##");
        for (Iterator iterator2 = strList.iterator(); iterator2.hasNext();) {
            System.out.println(iterator2.next());
        }

        // Method 3
        System.out.println("## Method 3 ##");
        for (String str:strList) {
            System.out.println(str);
        }

        // Method 4
        System.out.println("## Method 4 ##");
        for (int i = 0; i < strList.size(); i++) {
            System.out.println(strList.get(i));
        }
    }
}
