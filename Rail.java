package rail;

import java.io.PrintWriter;
import java.util.Scanner;

public class Rail {

	private String starting; // תחנת יציאה
	private String destination; // תחנה הגעה
	private String leaving; // שעת יציאה
	private String arrival; // שעת הגעה
	private int midStationsNum; // מספר תחנות ביניים
	private String midStationsNames[]; // תחנות ביניים
	private String midStationsTimes[];
	
	public Rail(String starting, String destination, String leaving, String arrival, int midStationsNum,
			String[] midStationsNames, String[] midStationsTimes) {
		this.starting = starting;
		this.destination = destination;
		this.leaving = leaving;
		this.arrival = arrival;
		this.midStationsNum = midStationsNum;
		this.midStationsNames=midStationsNames;
		this.midStationsTimes=midStationsTimes;
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
		midStationsNum=s.nextInt();
		s.nextLine();
		midStationsNames=new String[midStationsNum];
		midStationsTimes=new String[midStationsNum];
		for (int i = 0; i < midStationsNum; i++) {
			midStationsNames[i]=s.nextLine();
			midStationsTimes[i]=s.nextLine();
			
		}

	}

	

	public void setMidStationsNames(String[] midStationsNames) {
		this.midStationsNames = midStationsNames;
	}

	public void setMidStationsTimes(String[] midStationsTimes) {
		this.midStationsTimes = midStationsTimes;
	}

	public String[] getMidStationsNames() {
		return midStationsNames;
	}

	public String[] getMidStationsTimes() {
		return midStationsTimes;
	}

	public int getMidStationsNum() {
		return midStationsNum;
	}

	
	

	public void save(PrintWriter pw) {
		pw.println(starting);
		pw.println(leaving);
		pw.println(destination);
		pw.println(arrival);
		pw.println(midStationsNum);
		for (int i = 0; i < midStationsNum; i++) {
			pw.println(midStationsNames[i]);
			pw.println(midStationsTimes[i]);
			
		}
	}

	public void finalSave(PrintWriter pw) { // שמירה סופית
		pw.println(starting);
		pw.println(leaving);
		pw.println(midStationsNum);
		for (int i = 0; i < midStationsNum; i++) {
			pw.println(midStationsNames[i]);
			pw.println(midStationsTimes[i]);
		}
		pw.println(destination);
		pw.println(arrival);
		
	}

	public String getLeaving() {
		return leaving;
	}

	public String toString() {
		return starting + ", " + leaving + ", " + destination + ", " + arrival + ",";
	}

}
