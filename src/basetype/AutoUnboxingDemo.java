package basetype;

/**
 * 自动拆装箱
 */
public class AutoUnboxingDemo {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;//自动装箱 Integer类型
        int c = 3;
        System.out.println(a.equals(b));
        System.out.println(a == b);//不同的引用 false
        System.out.println(b == c);//自动拆箱 true
        System.out.println(a == c);//自动拆箱 true
    }
}
