package pac;

public class HashTable_LinearProbe extends HashTable{

	public Chain[] Table;
	
	public int Size;
	
	public HashTable_LinearProbe(int Size) {
		this.Size = Size;
		this.Table = new Chain[Size];
		for(int i = 0; i < Size; i++) {
			this.Table[i] = new Chain();
		}
	}
	
	
	//hashing is the process to translate a key into a value for indexing/searching
	private int Hashing(int key) {
		//use modulo for the hashing
		int result = key % this.Size;
		return result;
	}

	@Override
	public void HashInsert(int key, int value) {
		int index = Hashing(key);
		int bucketsProbed = 0;
		while(bucketsProbed < Size) {
			if(Table[index].Header == null) {
				Table[index].InsertNode(key, value);;
				return;
			}
			index = (index + 1) % Size;
			bucketsProbed++;
		}
	}

	@Override
	public boolean HashSearch(int key) {
		int index = Hashing(key);
		int bucketsProbed = 0;
		while (Table[index].emptySinceStart == false && bucketsProbed < Size) {
			if(Table[index].Header != null && Table[index].Header.Key == key) {
				return true;
			}
			index = (index + 1) % Size;
			bucketsProbed++;
		}
		return false;
		
	}

	@Override
	public void HashDelete(int key) {
		int index = Hashing(key);
		int bucketsProbed = 0;
		while(Table[index].emptySinceStart == false && bucketsProbed < Size) {
			if(Table[index].Header != null && Table[index].Header.Key == key) {
				Table[index].DeleteNodeByKey(key);
				return;
			}
			index = (index + 1) % Size;
			bucketsProbed++;
		}
	}
	
	@Override
	public String toString() {
		String output = "";
		for(int i = 0; i < this.Size; i++) {
			output += "[" + i + "]: " + this.Table[i].toString() + "\n";
		}
		return output;
	}
}
