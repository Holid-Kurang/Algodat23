package algodat;

abstract class MyNumber{
	protected double value;
	abstract void display();
	abstract double getValue();
	abstract void setValue(int nilai);
	boolean compareTo(int nilai) {
		if(this.value>nilai) {
			return true;
		}
		return false;
	}	
	boolean isEven() {
        return value % 2 == 0;
    }

    boolean isOdd() {
        return value % 2 != 0;
    }

    boolean isPositive() {
        return value > 0;
    }

    boolean isNegative() {
        return value < 0;
    }

    boolean isZero() {
        return value == 0;
    }
    boolean isPrime() {
    	if(this.value>1) {
    		boolean cek=true;
    		for(int i=2; i<this.value; i++) {
    			if(this.value%i == 0) {
    				cek=false;
    				break;
    			}
    		}
    		return cek;
    	}
    	return false;
    }
}
class MyInteger extends MyNumber {
    MyInteger(int value) {
        this.value = value;
    }

    @Override
    double getValue() {
        return this.value;
    }

    @Override
    void setValue(int value) {
        if (value == (int) value) {
            this.value = (int) value;
        } else {
            System.out.println("Invalid value for MyInteger. Must be an integer.");
        }
    }

    @Override
    void display() {
        System.out.println("Value of MyInteger = " + (int) value);
    }

    // Operasi tambah untuk MyInteger
    void add(int number) {
        this.value += number;
    }

    // Konversi MyInteger ke MyDouble
    MyDouble toMyDouble() {
        return new MyDouble((double) value);
    }
}

class MyDouble extends MyNumber{
	//constructor
	MyDouble(double value){
		this.value=value;
	}
	
	@Override
	double getValue() {
		return this.value;
	}
	@Override
	void setValue(int nilai) {
		this.value=nilai;
	}
	@Override
	void display() {
		System.out.println("Value dari MyDouble = "+value);
	}
	
	//operasi aritmatika
	void tambah(int nilai) {
		this.value=this.value+nilai;
	}
	void kurang(int nilai) {
		this.value=this.value-nilai;
	}
	void kali(int nilai) {
		this.value=this.value*nilai;
	}
	void bagi(int nilai) {
		if (nilai != 0) {
			this.value /= nilai;
		} else {
			System.out.println("Division by zero!");
		}
	}
}

class Termometer extends MyNumber{
	private double celcius;
	
	Termometer(double value){
		this.celcius=value;
	}
	@Override
	double getValue() {
		return this.celcius;
	}
	@Override
	void setValue(int nilai) {
		this.celcius=nilai;
	}
	
	private double CtoR(){
		double reamur;
		reamur = this.celcius*4/5;
		return reamur;
	}
	private double CtoF(){
		double fahrenheit;
		fahrenheit = this.celcius*9/5+ 32;
		return fahrenheit;
	}
	private double CtoK(){
		double kelvin;
		kelvin = 273+this.celcius;
		return kelvin;
	}
	
	@Override
	void display() {
		System.out.println("Suhu = "+getValue()+" Celcius");
		System.out.println(this.celcius+" Celcius = "+CtoR()+" Reamur");
		System.out.println(this.celcius+" Celcius = "+CtoF()+" Fahrenheit");
		System.out.println(this.celcius+" Celcius = "+CtoK()+" Kelvin");
	}
	
}

public class Main {

	public static void main(String[] args) {
		Termometer suhu = new Termometer(30);
		suhu.display();
		System.out.println();
		
		MyDouble angka = new MyDouble(12);
		angka.display();
		System.out.println("membandingkan value lebih besar dengan nilai parameter = "+angka.compareTo(14));
		
		angka.tambah(25);
		angka.display();

		angka.kurang(17);
		angka.display();
		
		angka.kali(6);
		angka.display();
		
		angka.bagi(4);
		angka.display();
		
		angka.setValue(43);
		System.out.println();
		System.out.println("setelah di-set, menjadi -> "+angka.getValue());
		System.out.println("apakah value genap? "+angka.isEven());
		System.out.println("apakah value ganjil? "+angka.isOdd());
		System.out.println("apakah value positif? "+angka.isPositive());
		System.out.println("apakah value negatif? "+angka.isNegative());
		System.out.println("apakah value nol? "+angka.isZero());
		System.out.println("apakah value prima? "+angka.isPrime());
		
		// Membuat objek MyInteger
		System.out.println();
        MyInteger myInteger = new MyInteger(10);
        myInteger.display();
        myInteger.add(5);
        myInteger.display();
        System.out.println("Is it even? " + myInteger.isEven());
        System.out.println("Is it prime? " + myInteger.isPrime());

        // Konversi MyInteger ke MyDouble
        MyDouble convertedDouble = myInteger.toMyDouble();
        convertedDouble.display();
	}

}
