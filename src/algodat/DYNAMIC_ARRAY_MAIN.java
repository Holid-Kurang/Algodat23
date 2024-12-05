package algodat;

public class DYNAMIC_ARRAY_MAIN {

	public static void main(String[] args) {
		DYNAMIC_ARRAY dynamicArray = new DYNAMIC_ARRAY();
		
		for(int i = 1; i<10000; i++) {
			dynamicArray.add(i);
		}
//		dynamicArray.add("A");
//		dynamicArray.add("B");
//		dynamicArray.add("C");
//		System.out.println(dynamicArray.get(0));
//		dynamicArray.insert(1, "X");
//		dynamicArray.delete("A");
//		dynamicArray.delete("B");
//		dynamicArray.delete("C");
		System.out.println("size: " + dynamicArray.size);
		System.out.println(dynamicArray.search(128));
		
//		System.out.println(dynamicArray);
//		System.out.println("capacity: " + dynamicArray.capacity);
//		System.out.println("empty: " + dynamicArray.isEmpty());
	}

}
