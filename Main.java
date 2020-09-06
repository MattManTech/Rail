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
					"To schedule trip (number %d) press --> 1\nTo sort all trips by departure time press --> 2\nTo check up to 3 upcoming trips press --> 3\nTo quit press--> 9\n\n",
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
					midStations[i] = "Midstation " + (i+1) + " " + midStation + " - " + midStationTime;

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

			case 3:
				System.out.println("From where? ");//
				starting = read.nextLine();
				System.out.println("Destination?");
				destination = read.nextLine();
				System.out.println("What is the departure time?");
				leaving = read.nextLine();
				Triplist tr = new Triplist();
				String[][] schedule = new String[3][2];
				String temp[][];

				for (int i = 0; i < tr.getRails().length; i++) {
					if (starting.equals(tr.getRails()[i].getStarting())) {
						if (tr.timeCheck(leaving, tr.getRails()[i].getLeaving())==true) {
							schedule[i][0]=tr.getRails()[i].getLeaving();
						}
						
					} else if (starting.equals(tr.getRails()[i].getDestination())) {
						break;
					}
					for (int j = 0; j < tr.getRails()[i].getMidStations().length; j++) {
						if (starting.equals(tr.getRails()[i].getMidStations()[j].substring(14,tr.getRails()[i].getMidStations()[j].indexOf(" "))) && schedule[i][0]==null) {
							if (tr.timeCheck(leaving, tr.getRails()[i].getMidStations()[j].substring(tr.getRails()[i].getMidStations()[j].indexOf("-"+2),
									tr.getRails()[i].getMidStations()[j].length()))==true) {
							schedule[i][0]=tr.getRails()[i].getMidStations()[j].substring(tr.getRails()[i].getMidStations()[j].indexOf("-"+2),
									tr.getRails()[i].getMidStations()[j].length());
							}
							
						}
						if ( destination.equals(tr.getRails()[i].getDestination()) && schedule[i][0]!=null) {
							temp= new String[tr.getRails().length][tr.getRails()[i].getMidStations().length+2];
							temp[i][0]=schedule[i][0];
							for (int k=1; k<temp[i].length-1; k++) {
								temp[i][k]=tr.getRails()[i].getMidStations()[k];
							}
							temp[i][tr.getRails()[i].getMidStations().length-1]=tr.getRails()[i].getArrival();
							schedule[i]=temp[i];
						}
						else if (destination.equals(tr.getRails()[i].getMidStations()[j].substring(14, tr.getRails()[i].getMidStations()[j].indexOf(" ")))) {
							schedule[i][1]=tr.getRails()[i].getMidStations()[j].substring(tr.getRails()[i].getMidStations()[j].indexOf("-"+2),
									tr.getRails()[i].getMidStations()[j].length());
						}
					}
				}

				break;

			case 9:
				b = false;
				System.out.println("Good Bye :)");
				break;
			}
		}
		read.close();

	}
}
