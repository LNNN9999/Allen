import java.util.Scanner;
import model.Kendaraan;
import model.Penyewa;
import service.Transaksi;
import utils.DatabaseKendaraan;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            // Input data penyewa
            System.out.print("Masukkan nama penyewa: ");
            String nama = input.nextLine();

            System.out.print("Masukkan no KTP: ");
            String noKTP = input.nextLine();

            Penyewa penyewa = new Penyewa(nama, noKTP);

            // Ambil array kendaraan dari database
            Kendaraan[] daftar = DatabaseKendaraan.getKendaraanList();

            System.out.println("\nDaftar Kendaraan Tersedia:");
            for (int i = 0; i < daftar.length; i++) {
                // Polymorphism: bisa panggil getInfo dari Mobil/Motor/Kendaraan
                System.out.println((i + 1) + ". " + daftar[i].getInfo());
            }

            System.out.print("\nPilih nomor kendaraan yang ingin disewa: ");
            int pilihan = input.nextInt();
            input.nextLine(); // Buang newline

            Kendaraan kendaraanDipilih = daftar[pilihan - 1];

            System.out.print("Masukkan lama sewa (hari): ");
            int lamaSewa = input.nextInt();

            // Proses transaksi
            Transaksi transaksi = new Transaksi(penyewa, kendaraanDipilih, lamaSewa);

            // Output struk
            System.out.println("\n--- Struk Transaksi ---");
            System.out.println("Nama Penyewa: " + penyewa.getNama());
            System.out.println("No KTP: " + penyewa.getNoKTP());
            System.out.println("Kendaraan: " + kendaraanDipilih.getInfo());
            System.out.println("Lama Sewa: " + lamaSewa + " hari");
            System.out.println("Total Harga: Rp" + transaksi.hitungTotalHarga());
        }
    }
}