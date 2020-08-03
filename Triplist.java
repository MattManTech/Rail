package rail;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Triplist {

	private int tripNum;
	private Rail[] rails;

	public Triplist(String name , int tripNum ) throws FileNotFoundException {
		this.tripNum = tripNum;
		rails = new Rail[tripNum];
		Scanner s = new Scanner(new File(name));

		for (int i = 0; i < tripNum; i++) {
			rails[i] = new Rail(s);;
		}
		s.close();
	}

	public void sort(String name) throws FileNotFoundException { //מיון
		for (int index = 0; index < rails.length - 1; index++) {
			for (int indexB = 0; indexB < rails.length - index - 1; indexB++) {

				int t = Integer.parseInt(rails[indexB].getleaving().substring(0, 2));
				int r = Integer.parseInt(rails[indexB + 1].getleaving().substring(0, 2));

				if (t > r) {
					swap(rails, indexB, indexB + 1);
				} else if (t == r) {
					int y = Integer.parseInt(rails[indexB].getleaving().substring(3, 5));
					int i = Integer.parseInt(rails[indexB+1].getleaving().substring(3, 5));
					if (y > i) {
						swap(rails, indexB, indexB + 1);
					}
				}
			}
		}
	}

	private void swap(Rail[] array, int indexA, int indexB) {
		Rail temp = array[indexA];
		array[indexA] = array[indexB];
		array[indexB] = temp;
	}

	public void save(String name) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(name));
		for (int i = 0; i < tripNum; i++) {
			rails[i].save(pw);
		}
		pw.close();
	}
	
	public void finalSave(String name) throws FileNotFoundException { //שמירה סופית
		PrintWriter pw = new PrintWriter(new File(name));
		for (int i = 0; i < tripNum; i++) {
			rails[i].finalSave(pw);
		}
		pw.close();
	}
	
	public String toString () {
		StringBuffer sb = new StringBuffer();			
		for (int i = 0 ; i < tripNum ; i++) {
			sb.append(i + ")" + rails[i].toString() + "\n");
		}
		return sb.toString();
	}
}