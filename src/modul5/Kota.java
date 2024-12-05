package modul5;

//VERTEX
public class Kota {

    String nama;
    ListJalan jalan;

    Kota next, prev;

    Kota(String nama) {
        this.nama = nama;
        this.jalan = new ListJalan();
    }

    void addTetangga(Kota asal, Kota tujuan, int jarak) {
        jalan.addLast(asal, tujuan, jarak);
    }
}
