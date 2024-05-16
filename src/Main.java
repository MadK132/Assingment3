import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int size = 1000;
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>(size);
        for (int i = 0; i < size; i++) {
            MyTestingClass test = new MyTestingClass(String.valueOf(i),String.valueOf(i));
            Student student = new Student(String.valueOf(i),String.valueOf(i), 1.0 + (random.nextDouble() * 3));
            table.put(test,student);
        }
        int t = 2;
        for (int i = 0; i < size; i++) {
            MyTestingClass test = new MyTestingClass(String.valueOf(i), String.valueOf(i));
            if (table.get(test) == null) {
                t++;
                System.out.println("Value not found: " + test);
            }
        }
        System.out.println(t);
    }
}