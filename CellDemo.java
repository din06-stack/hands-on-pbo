class Cell<T> {
    private T data;

    public void setValue(T data) {
        this.data = data;
    }

    public T getValue() {
        return data;
    }

    public void displayType() {
        if (data == null) {
            System.out.println("Data masih kosong");
        } else {
            System.out.println("Tipe data: "
                    + data.getClass().getSimpleName());
        }
    }
}

public class CellDemo {
    public static void main(String[] args) {

        Cell<Integer> numberCell = new Cell<>();
        numberCell.setValue(100);

        Cell<String> textCell = new Cell<>();
        textCell.setValue("Belajar Java");

        System.out.println("Nilai Integer: "
                + numberCell.getValue());
        numberCell.displayType();

        System.out.println();

        System.out.println("Nilai String: "
                + textCell.getValue());
        textCell.displayType();
    }
}
