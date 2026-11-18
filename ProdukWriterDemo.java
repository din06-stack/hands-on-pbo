import java.io.IOException;
import java.nio.file.*;
import java.util.*;

class Produk<T, U, V> {

    private T nama;
    private U harga;
    private V stok;

    public Produk(T nama, U harga, V stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    @Override
    public String toString() {
        return nama + "," + harga + "," + stok;
    }
}

public class ProdukWriterDemo {
    public static void main(String[] args) {

        // Membuat daftar produk
        List<Produk<String, Double, Integer>> produkList =
                new ArrayList<>();

        produkList.add(new Produk<>("Laptop", 15000000.0, 10));
        produkList.add(new Produk<>("Mouse", 150000.0, 25));
        produkList.add(new Produk<>("Keyboard", 350000.0, 15));

        Path filePath = Paths.get("produk_output.txt");

        try {

            // Menyiapkan data untuk ditulis ke file
            List<String> lines = new ArrayList<>();

            for (Produk<String, Double, Integer> produk : produkList) {
                lines.add(produk.toString());
            }

            // Menulis data ke file
            Files.write(filePath, lines);

            System.out.println("Data produk berhasil disimpan.");

            // Membaca kembali isi file
            List<String> savedLines =
                    Files.readAllLines(filePath);

            System.out.println("\nIsi File produk_output.txt:");

            for (String line : savedLines) {
                System.out.println(line);
            }

            // Contoh penggunaan generic untuk data lain
            Produk<String, String, Integer> pelanggan =
                    new Produk<>("Pelanggan", "Dinda", 20);

            Produk<String, String, Integer> transaksi =
                    new Produk<>("Transaksi", "TRX001", 250000);

            System.out.println("\nContoh Data Lain:");
            System.out.println(pelanggan);
            System.out.println(transaksi);

        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }
    }
}
