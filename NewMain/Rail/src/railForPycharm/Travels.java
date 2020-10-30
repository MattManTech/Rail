package railForPycharm;

import java.util.ArrayList;

public class Travels {
	
	private String starting;
	private String destination;
	private int hour;
	private int minute;
	private ArrayList<MidStations> midStations=new ArrayList<MidStations>(); 
		
	
	public Travels(String starting, String destination, int hour, int minute,ArrayList<MidStations> midStations ) {
		this.starting = starting;
		this.destination = destination;
		this.hour = hour;
		this.minute = minute;
		if (midStations != null) {
			this.midStations= midStations;	
		}
		
	}

	public String getLastgState() {
		return destination;
	}

	public void setLastgState(String lastgState) {
		this.destination = lastgState;
	}


	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getStartingState() {
		return starting;
	}

	public ArrayList<MidStations> getAllStopovers() {
		return midStations;
	}

	public void setAllStopovers(ArrayList<MidStations> allStopovers) {
		this.midStations = allStopovers;
	}

	public void setStartingState(String startingState) {
		this.starting = startingState;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void show() {

		if (hour < 10) {
			System.out.print("0" + hour);
		}
		if (minute < 10) {
			System.out.print(":0" + minute);
		}

	}

	public String show2() {
		String str = "";
		if (hour < 10) {
			str = "0" + hour + ":";
			if (minute < 10) {
				str += "0" + minute;
			} else {
				str += minute;
			}

		} else if (minute < 10) {
			str = hour + ":0" + minute;

		} else {
			str += hour + ":" + minute;
		}

		return str;

	}

	
	
	@Override
	public String toString() {
		return "travel [Starting State=" + starting + ", Lastg State=" + destination + ", Departure time = "
				+ show2() + "the stops overes between this stations: "+midStations.toString()+ "] \n";
	}
	
	public String toStringHTML(int counter) {
		return counter +")<br>" +"Starting = " + starting +"<br>"
	                   + "Dest= " + destination +"<br>"
				       +"Departure time = "+ show2()+"<br>"
				 + "The stops overes between this stations: "+midStations.toString()+ "<br>";
	}


}
