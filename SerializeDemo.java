import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    String name;
    int age;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

public class SerializeDemo {

    // Method untuk menyimpan objek
    public static void serialize(List<Employee> employees) {

        try (
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream("employees.ser")
                    )
        ) {

            oos.writeObject(new ArrayList<>(employees));

            System.out.println("Serialized successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method untuk membaca kembali objek
    @SuppressWarnings("unchecked")
    public static List<Employee> deserialize() {

        try (
            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream("employees.ser")
                    )
        ) {

            return (List<Employee>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        // Membuat beberapa objek Employee
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("John", 30));
        employees.add(new Employee("Siti", 25));
        employees.add(new Employee("Andi", 28));

        // Menyimpan objek ke file
        serialize(employees);

        // Membaca kembali objek dari file
        List<Employee> restoredEmployees = deserialize();

        System.out.println("\nHasil Deserialization:");

        for (Employee employee : restoredEmployees) {
            System.out.println(employee);
        }
    }
}
