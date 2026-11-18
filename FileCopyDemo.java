import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.time.LocalDateTime;

public class FileCopyDemo {
    public static void main(String[] args) {

        Path source = Paths.get("report.txt");
        Path backup = Paths.get("backup/report.txt");
        Path log = Paths.get("log.txt");

        try {
            // Menulis isi laporan ke file
            Files.write(
                    source,
                    List.of("Report Generated", "Status: OK")
            );

            // Memeriksa apakah file sumber tersedia
            if (Files.exists(source)) {

                // Membuat folder backup jika belum tersedia
                if (Files.notExists(backup.getParent())) {
                    Files.createDirectories(backup.getParent());
                }

                // Menyalin file laporan
                Files.copy(
                        source,
                        backup,
                        StandardCopyOption.REPLACE_EXISTING
                );

                System.out.println("Backup berhasil dibuat.");

                // Membuat log operasi
                String logEntry = LocalDateTime.now()
                        + " - Backup berhasil dibuat.";

                Files.writeString(
                        log,
                        logEntry + System.lineSeparator(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND
                );

                System.out.println("Log berhasil disimpan.");

            } else {
                System.out.println("File report.txt tidak ditemukan.");
            }

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}
