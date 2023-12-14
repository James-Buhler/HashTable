package pac;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		int temp = -1;
		HashTable_Chaining hash = new HashTable_Chaining(10);
		for(int i = 0; i < 20; i++) {
			temp = r.nextInt(100);
			hash.HashInsert(temp, temp);
		}
		System.out.println(hash);
		
		HashTable_LinearProbe hash2 = new HashTable_LinearProbe(10);
		for(int i = 0; i < 10; i++) {
			temp = r.nextInt(100);
			hash2.HashInsert(temp, temp);
		}
		System.out.println(hash2);

	}
}
