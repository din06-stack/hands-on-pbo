public class CompareUtil {

    public static <T extends Comparable<T>>
    boolean isEqual(T a, T b) {

        return a.compareTo(b) == 0;
    }

    public static void main(String[] args) {

        System.out.println("Integer:");
        System.out.println(isEqual(5, 5));

        System.out.println("\nString:");
        System.out.println(isEqual("Hello", "World"));

        System.out.println("\nDouble:");
        System.out.println(isEqual(3.14, 3.14));

        System.out.println("\nCharacter:");
        System.out.println(isEqual('A', 'A'));
        System.out.println(isEqual('A', 'B'));
    }
}
