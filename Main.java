package rail;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
gjkl
public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner read = new Scanner(System.in);

		File f = new File("Rail.txt");
		PrintWriter pw = new PrintWriter(f);

		System.out.println("Welcome to train site!\n");
		String starting, destination, leaving, arrival;

		byte choise, counter = 0;
		boolean b = true;

		while (b) {
			System.out.printf(
					"To schedule trip (number %d) press --> 1\nTo sort all trips by departure time press --> 2\nTo quit press--> 9\n\n",
					counter);
			choise = read.nextByte();

			switch (choise) {

			case 1: {
				counter++;
				read.nextLine();
				System.out.println("From where? ");
				starting = read.nextLine();
				System.out.println("What is the departure time?");
				leaving = read.nextLine();
				System.out.println("Destination?");
				destination = read.nextLine();
				System.out.println("What is the arrival time?");
				arrival = read.nextLine();
				
				Rail r = new Rail(starting, destination, leaving, arrival);
				r.save(pw);

				break;
			}

			case 2:
				pw.close();
				Triplist t = new Triplist("Rail.txt" , counter);
				t.sort("Rail.txt");
				t.finalSave("Rail.txt");
				System.out.println(t.toString());

				break;

			case 9:
				b = false;
				break;
			}
		}
read.close;
	}
}
