package rail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner read = new Scanner(System.in);

		File f = new File("Rail.txt");
		PrintWriter pw = new PrintWriter(f);

		System.out.println("Welcome to train site!\n");
		String starting, destination, leaving, arrival, midStation, midStationTime;
		String midStations[] = null;
		byte choise, counter = 0, numOdMidStations;
		boolean b = true;

		while (b) {
			System.out.printf(
					"To schedule trip (number %d) press --> 1\nTo sort all trips by departure time press --> 2\nTo quit press--> 9\n\n",
					(counter + 1));
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
				System.out.println("How many midStations there is?");
				numOdMidStations = read.nextByte();
				midStations = new String[numOdMidStations];
				read.nextLine();
				for (int i = 0; i < numOdMidStations; i++) {
					System.out.println("Enter midStation name number " + (i + 1) + ":");
					midStation = read.nextLine();
					System.out.println("Enter midStation arrival time:");
					midStationTime = read.nextLine();
					midStations[i] = "MidStation " + (i + 1) + ": " + midStation + " - " + midStationTime;

				}

				Rail r = new Rail(starting, destination, leaving, arrival, numOdMidStations, midStations);
				r.save(pw);

				break;
			}

			case 2:
				pw.close();
				Triplist t = new Triplist("Rail.txt", counter);
				t.sort("Rail.txt");
				t.finalSave("Rail.txt");
				System.out.println(t.toString() + "\n");

				break;

			case 9:
				b = false;
				break;
			}
		}
		read.close();

	}
}
