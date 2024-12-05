package modul5;

public class Jalan {
	Kota asal, tujuan;
	int jarak;
	
	Jalan next,prev;
	
	Jalan(Kota asal, Kota tujuan, int jarak){
		this.asal=asal;
		this.tujuan=tujuan;
		this.jarak=jarak;
	}
}
