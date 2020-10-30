package railForPycharm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("<h1 style=\"text-align:center;font-family:tahoma\">The Rail Poject</h1>");

		System.out.println(
				"<div style=\"border: 2px solid black\"> <p style=text-align:center;font-family:courier;font-size:140%>"
						+ "Your travel for serch :" + "<br>" + "Starting :" + args[1] + "<br>" + "Destination : "
						+ args[2] + "<br>" + "Time- " + Integer.parseInt(args[3]) + ":" + Integer.parseInt(args[4])
						+ "</p></div>" + "<br>");

		String starting = args[1], destination = args[2];

		int hour = Integer.parseInt(args[3]), minutes = Integer.parseInt(args[4]);

		File f = new File("Rail.txt");

		ArrayList<Travels> allTravels = scanFile(f);

		rideSearch(starting, destination, hour, minutes, allTravels);

	}

	public static void rideSearch(String starting, String destination, int hour, int minute,
			ArrayList<Travels> allTravels) {

		int counter = 1;

		while (hour > 24 || hour <= 0) {
			System.out.println(
					"<p style=\"color:red;\";font-family:courier;font-size:130%>" + "Invaild hour, try again </p>");

		}

		while (minute > 59 || minute < 0) {
			System.out.println("<p style=\\\"color:red;\\\";font-family:courier;font-size:130%>"
					+ "Invaild minutes, try again </p> ");

		}

		for (int i = 0; i < allTravels.size() && counter <= 3; i++) {
			if (allTravels.get(i).getStartingState().equalsIgnoreCase(starting)
					&& allTravels.get(i).getLastgState().equalsIgnoreCase(destination)) {

				if (allTravels.get(i).getHour() >= hour && allTravels.get(i).getMinute() >= minute) {
					System.out.println("<div style=\"border: 2px solid black\"> "
							+ "<p style=\"color:blue;\";font-family:courier;font-size:120%>"
							+ allTravels.get(i).toStringHTML(counter) + "</p></div>" + "<br>");
					counter++;
					continue;

				}
			}

		}
	}

	public static ArrayList<Travels> scanFile(File f) throws FileNotFoundException {

		ArrayList<Travels> allTravels = new ArrayList<Travels>();

		Scanner s = new Scanner(f);

		while (s.hasNext()) {

			int size = s.nextInt();

			for (int i = 0; i < size; i++) {
				s.nextLine();
				String starting = s.nextLine();
				String destination = s.nextLine();
				int hour = s.nextInt();
				int minute = s.nextInt();
				int midStations = s.nextInt();

				ArrayList<MidStations> allMids = new ArrayList<MidStations>();

				for (int j = 0; j < midStations; j++) {
					s.nextLine();
					String startName = s.nextLine();
					int theHour = s.nextInt();
					int theMin = s.nextInt();

					allMids.add(new MidStations(startName, theHour, theMin));

				}

				Travels t = new Travels(starting, destination, hour, minute, allMids);
				allTravels.add(t);

			}

		}
		s.close();

		return allTravels;
	}

}