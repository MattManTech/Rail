package rail;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Rail {

	private String starting;     // ���� �����
	private String destination; // ���� ����
	private String leaving; // ��� �����
	private String arrival; // ��� ����

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
	
	public void finalSave(PrintWriter pw) { //����� �����
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