class Pair<T1, T2> {
    private T1 first;
    private T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public void showTypes() {
        System.out.println(
                first.getClass().getSimpleName()
                + " & "
                + second.getClass().getSimpleName()
        );
    }

    public void display() {
        System.out.println("First: " + first);
        System.out.println("Second: " + second);
    }

    public Pair<T2, T1> swap() {
        return new Pair<>(second, first);
    }
}

public class PairDemo {
    public static void main(String[] args) {

        Pair<Integer, String> pair1 =
                new Pair<>(10, "Dinda");

        System.out.println("Pair 1:");
        pair1.display();
        pair1.showTypes();

        Pair<String, Integer> swapped1 = pair1.swap();

        System.out.println("\nSetelah Swap:");
        swapped1.display();

        System.out.println("\n------------------");

        Pair<Double, Boolean> pair2 =
                new Pair<>(3.14, true);

        System.out.println("Pair 2:");
        pair2.display();
        pair2.showTypes();

        Pair<Boolean, Double> swapped2 = pair2.swap();

        System.out.println("\nSetelah Swap:");
        swapped2.display();
    }
}
