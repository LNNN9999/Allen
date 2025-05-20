package model;

// Superclass yang akan diturunkan ke Mobil dan Motor (Inheritance)
public class Kendaraan {
    // Encapsulation: atribut dibuat private
    private String merk;
    private String jenis;
    private int hargaSewaPerHari;

    public Kendaraan(String merk, String jenis, int hargaSewaPerHari) {
        this.merk = merk;
        this.jenis = jenis;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    // Getter
    public String getInfo() {
        return jenis + " - " + merk + " (Rp" + hargaSewaPerHari + "/hari)";
    }

    public int getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    public String getMerk() {
        return merk;
    }

    public String getJenis() {
        return jenis;
    }
}