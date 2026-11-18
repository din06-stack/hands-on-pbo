import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WriteUserInputDemo {
    public static void main(String[] args) {

        Path path = Paths.get("user_input.txt");

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (
            Scanner sc = new Scanner(System.in);
            BufferedWriter bw = Files.newBufferedWriter(path)
        ) {

            System.out.println("Masukkan teks.");
            System.out.println("Ketik exit untuk selesai.");

            while (true) {

                System.out.print("> ");
                String text = sc.nextLine();

                if (text.equalsIgnoreCase("exit")) {
                    break;
                }

                // Membuat timestamp
                String timestamp =
                        LocalDateTime.now().format(formatter);

                // Menulis teks dan timestamp ke file
                bw.write("[" + timestamp + "] " + text);
                bw.newLine();

                System.out.println("Data berhasil disimpan.");
            }

            System.out.println("\nProgram selesai.");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
