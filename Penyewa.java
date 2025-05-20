package model;

// Class sederhana untuk menyimpan data penyewa
public class Penyewa {
    // Encapsulation: atribut private, akses melalui getter
    private String nama;
    private String noKTP;

    public Penyewa(String nama, String noKTP) {
        this.nama = nama;
        this.noKTP = noKTP;
    }

    public String getNama() {
        return nama;
    }

    public String getNoKTP() {
        return noKTP;
    }
}