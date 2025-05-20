package service;

import model.Kendaraan;
import model.Penyewa;

// Class untuk memproses transaksi penyewaan
public class Transaksi {
    private Penyewa penyewa;
    private Kendaraan kendaraan;
    private int lamaSewa;

    public Transaksi(Penyewa penyewa, Kendaraan kendaraan, int lamaSewa) {
        this.penyewa = penyewa;
        this.kendaraan = kendaraan;
        this.lamaSewa = lamaSewa;
    }

    public int hitungTotalHarga() {
        return kendaraan.getHargaSewaPerHari() * lamaSewa;
    }
}