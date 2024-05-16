
public class MyTestingClass {
    private String key1;
    private String key2;

    public MyTestingClass(String key1, String key2) {
        this.key1 = key1;
        this.key2 = key2;
    }
    public int hashCode() {
        int result = 0;
        String key1String = key1.toString();
        String key2String = key2.toString();
        for (int i = 0; i < key1String.length(); i++) {
            result += key1String.charAt(i);
        }
        for (int i = 0; i < key2String.length(); i++) {
            result += key2String.charAt(i);
        }
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        MyTestingClass other = (MyTestingClass) obj;
        return key1.equals(other.key1) && key2.equals(other.key2);
    }

    @Override
    public String toString() {
        return "MyTestingClass{" +
                "key1='" + key1 + '\'' +
                ", key2='" + key2 + '\'' +
                '}';
    }
}