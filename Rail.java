package rail;

import java.io.PrintWriter;
import java.util.Scanner;

public class Rail {

	private String starting;     // úçðú éöéàä
	private String destination; // úçðä äâòä
	private String leaving; // ùòú éöéàä
	private String arrival; // ùòú äâòä

	public Rail(String starting, String destination, String leaving, String arrival) {
		this.starting = starting;
		this.destination = destination;
		this.leaving = leaving;
		this.arrival = arrival;
	}

	public Rail(Scanner s) {
		starting = s.nextLine();
		leaving = s.nextLine();
		destination = s.nextLine();
		arrival = s.nextLine();
	}

	public void save(PrintWriter pw) { 
		pw.println(starting);
		pw.println(leaving);
		pw.println(destination);
		pw.println(arrival);
	}
	
	public void finalSave(PrintWriter pw) { //ùîéøä ñåôéú
		pw.print(starting + ",");
		pw.print(leaving + ",");
		pw.print(destination + ",");
		pw.print(arrival);
		pw.println("");
	}

	public String getleaving() {
		return leaving;
	}
	
	public String toString() {
		return starting + "," + leaving + "," + destination + "," + arrival;
	}
}
