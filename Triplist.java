package rail;

import java.io.PrintWriter;
import java.util.Scanner;

public class Rail {

	private String starting; // תחנת יציאה
	private String destination; // תחנה הגעה
	private String leaving; // שעת יציאה
	private String arrival; // שעת הגעה
	private int midStationsNum; // מספר תחנות ביניים
	private String midStations[]; // תחנות ביניים

	public Rail(String starting, String destination, String leaving, String arrival, int midStationsNum,
			String[] midStations) {
		this.starting = starting;
		this.destination = destination;
		this.leaving = leaving;
		this.arrival = arrival;
		this.midStationsNum = midStationsNum;
		this.midStations = midStations;
	}

	public String getStarting() {
		return starting;
	}

	public String getDestination() {
		return destination;
	}


	public String getArrival() {
		return arrival;
	}

	public Rail(Scanner s) {
		starting = s.nextLine();
		leaving = s.nextLine();
		destination = s.nextLine();
		arrival = s.nextLine();
		midStations = new String[s.nextInt()];
		s.nextLine();
		for (int i = 0; i < midStations.length; i++) {
			midStations[i] = s.nextLine();
		}

	}

	public int getMidStationsNum() {
		return midStationsNum;
	}

	public String[] getMidStations() {
		return midStations;
	}

	public void save(PrintWriter pw) {
		pw.println(starting);
		pw.println(leaving);
		pw.println(destination);
		pw.println(arrival);
		pw.println(midStationsNum);
		for (int i = 0; i < midStations.length; i++) {
			pw.println(midStations[i]);
		}
	}

	public void finalSave(PrintWriter pw) { // שמירה סופית
		pw.print(starting + ",");
		pw.print(leaving + ",");
		for (int i = 0; i < midStations.length; i++) {
			pw.print(midStations[i] + ",");
		}
		pw.print(destination + ",");
		pw.print(arrival);
		pw.println();
	}

	public String getLeaving() {
		return leaving;
	}

	public String toString() {
		return starting + ", " + leaving + ", " + destination + ", " + arrival + ",";
	}

}
