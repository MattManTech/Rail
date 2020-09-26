package rail;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static byte counter;
	public static void main(String[] args) throws FileNotFoundException {

		Scanner read = new Scanner(System.in);

		File f = new File("Rail.txt");
		PrintWriter pw = new PrintWriter(f);

		System.out.println("Welcome to train site!\n");
		String starting, destination, leaving, arrival;
		String midStationName[] = null;
		String midStationTime[] = null;
		byte choise, numOdMidStations;
		boolean b = true;

		while (b) {
			System.out.printf(
					"To schedule trip (number %d) press --> 1\nTo sort all trips by departure time press --> 2\nTo check up to 3 upcoming trips press --> 3\nTo quit press--> 9\n\n",
					(counter + 1));
			choise = read.nextByte();

			try {
			
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
				midStationName = new String[numOdMidStations];
				midStationTime = new String[numOdMidStations];
				read.nextLine();
				for (int i = 0; i < numOdMidStations; i++) {
					System.out.println("Enter midStation name number " + (i + 1) + ":");
					midStationName[i] = read.nextLine();
					System.out.println("Enter midStation arrival time:");
					midStationTime[i] = read.nextLine();
					
				}

				Rail r = new Rail(starting, destination, leaving, arrival, numOdMidStations, midStationName, midStationTime);
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
				pw.close();
				System.out.println("From where? ");
				read.nextLine();
				starting = read.nextLine();
				System.out.println("Destination?");
				destination = read.nextLine();
				System.out.println("What is the departure time?");
				leaving = read.nextLine();
				Triplist tk = new Triplist("Rail.txt", counter);
				String upTo3Leaving[] = new String[3];
				String upTo3Arrive[] = new String[3];

				for (int i = 0; i < tk.getTripNum(); i++) {
					if (starting.equals(tk.getRails()[i].getStarting())) {
						if (tk.timeCheck(leaving, tk.getRails()[i].getLeaving()) == true) {
							upTo3Leaving[i] = tk.getRails()[i].getLeaving();
						}

					} else if (starting.equals(tk.getRails()[i].getDestination())) {
						break;
					}

					for (int j = 0; j < tk.getRails()[i].getMidStationsNum(); j++) {
						if (starting.equals(tk.getRails()[i].getMidStationsNames()[j])
								&& upTo3Leaving[i] == null) {
							if (tk.timeCheck(leaving,
									tk.getRails()[i].getMidStationsTimes()[j]) == true) {
								upTo3Leaving[i] = tk.getRails()[i].getMidStationsTimes()[j];
							}

						}
						if (destination.equals(tk.getRails()[i].getDestination()) && upTo3Leaving[i] != null) {
							upTo3Arrive[i] = tk.getRails()[i].getArrival();

						}

						else if (destination.equals(tk.getRails()[i].getMidStationsNames()[j])
								&& upTo3Leaving[i] != null) {
							upTo3Arrive[i] = tk.getRails()[i].getMidStationsTimes()[j];

						}
					}
				}
				int r=0;
				for (int i=0; i<3; i++) {
					if (upTo3Leaving[i]!=null && upTo3Arrive[i]!=null) { 
						r++;
					}
				}
				System.out.println("You have " + r + " next trips on schedule:");
				for (int i=0; i<3; i++) {
					if (upTo3Leaving[i]!=null && upTo3Arrive[i]!=null) {
					System.out.println("Leaving at " + upTo3Leaving[i] + " , arriving at " + upTo3Arrive[i] + "\n");
				}
				}
				
				

				break;

			case 9:
				b = false;
				System.out.println("Good Bye :)");
				break;
			}
			}
			catch (Exception e) {
				System.out.println("Not available option-- " + e.getMessage() + ", try again\n");
			}
		}
		read.close();

	}
}
