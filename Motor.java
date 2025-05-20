package model;

// Inheritance: Motor adalah turunan dari Kendaraan
public class Motor extends Kendaraan {
    private String tipe;

    public Motor(String merk, int hargaSewaPerHari, String tipe) {
        super(merk, "Motor", hargaSewaPerHari);
        this.tipe = tipe;
    }

    public String getTipe() {
        return tipe;
    }

    // Polymorphism: method override
    public String getInfo() {
        return super.getInfo() + " - Tipe: " + tipe;
    }
}