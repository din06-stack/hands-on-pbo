import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;

public class ReadFileDemo {
    public static void main(String[] args) {

        Path inputPath = Paths.get("employees.txt");
        Path outputPath = Paths.get("copy_employees.txt");

        ArrayList<String> employees = new ArrayList<>();

        try {
            // Memeriksa apakah file tersedia
            if (Files.notExists(inputPath)) {
                System.out.println("File employees.txt tidak ditemukan.");
                return;
            }

            // Membaca seluruh isi file
            employees.addAll(
                    Files.readAllLines(inputPath, StandardCharsets.UTF_8)
            );

            // Menampilkan data karyawan
            System.out.println("Daftar Karyawan:");

            for (String employee : employees) {
                System.out.println(employee);
            }

            // Menulis hasil baca ke file baru
            Files.write(
                    outputPath,
                    employees,
                    StandardCharsets.UTF_8
            );

            System.out.println("\nData berhasil disalin ke copy_employees.txt");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
