package model;

// Inheritance: Mobil adalah turunan dari Kendaraan
public class Mobil extends Kendaraan {
    private int kapasitas;

    public Mobil(String merk, int hargaSewaPerHari, int kapasitas) {
        // Memanggil konstruktor superclass (Kendaraan)
        super(merk, "Mobil", hargaSewaPerHari);
        this.kapasitas = kapasitas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    // Polymorphism: method override untuk menampilkan info tambahan
    public String getInfo() {
        return super.getInfo() + " - Kapasitas: " + kapasitas + " orang";
    }
}