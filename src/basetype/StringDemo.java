package basetype;

/**
 * 了解String.intern()方法
 */
public class StringDemo {
    public static void main(String[] args) {
        String s = new StringBuilder("go").append("od").toString();
        System.out.println(s == s.intern());//true
        String s3 = new String("java");
        System.out.println(s3.intern() == s3);//false
        String s2 = "java";
        System.out.println(s2.intern() == s2);//true
    }
}
