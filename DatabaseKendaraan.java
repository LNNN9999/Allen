package utils;

import model.Kendaraan;
import model.Mobil;
import model.Motor;

// Class sebagai "database" statis untuk daftar kendaraan
public class DatabaseKendaraan {
    // Array sebagai koleksi data kendaraan
    public static Kendaraan[] getKendaraanList() {
        return new Kendaraan[] {
            new Mobil("Toyota Avanza", 300000, 7),
            new Motor("Honda Vario", 100000, "Matic"),
            new Mobil("Suzuki Ertiga", 250000, 7)
        };
    }
}