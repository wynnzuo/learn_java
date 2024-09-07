package basetype;

/**
 * 了解Integer的内部类IntegerCache
 */
public class IntegerCacheDemo {
    public static void main(String[] args) {
        Integer f1 = 127, f2 = 127, f3 = 128, f4 = 128;
        System.out.println(f1 == f2);//true
        System.out.println(f3 == f4);//false
    }
}
