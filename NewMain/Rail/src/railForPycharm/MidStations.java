package railForPycharm;

public class MidStations {
	
	private String name; 
	private int hour;
	private int minute;
	
	
	
	public  MidStations (String name, int hour, int minute) {

		this.name = name;
		this.hour = hour;
		this.minute=minute;
	}


	public String show() {
		byte zero=0;
		String str = "";
		if (hour < 10) {
			str = zero + hour + ":";
			if (minute < 10) {
				str += zero + minute;
			} else {
				str += minute;
			}

		} else if (minute < 10) {
			str = hour + ":"+zero + minute;

		} else {
			str += hour + ":" + minute;
		}

		return str;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	@Override
	public String toString() {
		return " [name=" + name + ",  "+show()+"]\n";
		
	}
	
	
	
}
