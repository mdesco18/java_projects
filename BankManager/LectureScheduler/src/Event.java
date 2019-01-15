/* Lecture Scheduler App
 * Author: Marc-Andre Descoteaux
 * Student ID: 100299390
 * Date: 2016-11-21
 * CPSC 1204 Project
 */


public class Event {

	private String name;
	private int hour;
	private int minute;
	private int duration;
	public int endHour;
	public int endMinute;

	public Event() {
		this.name = null;
		this.hour = 0;
		this.minute = 0;
		this.duration = 0;
	}
	
	//constructor for endtime sorting
	public Event(int hour, int minute){
		this.hour = hour;
		this.minute = minute;
	}

	//constructor for talks
	public Event(String name, int hour, int minute, int duration) throws Exception{
		
			this.name = name;
			this.hour = hour;
			if(hour < 0 || hour > 23)
				throw new Exception("Hour must be between (0-23)");
			this.minute = minute;
			if(minute < 0 || minute > 59)
				throw new Exception("Minute must be between (0-59)");
			this.duration = duration;

	}

	public String getName() {
		return name;
	}

	public int getHour() {
		return hour;
	}

	public int getMinute() {
		return minute;
	}

	public int getDuration() {
		return duration;
	}

	public int getEndHour() {
		int plusHour;
		int plusMinute;
		
		if(duration >= 60){
			plusHour = duration/60;
			endHour = hour + plusHour;
		}
		plusMinute = duration + minute;
		if(plusMinute >= 60){
			endHour = hour + plusMinute/60;
		}
		return endHour;
	}

	public int getEndMinute() {
		
		int plusMinute;
		
		if(duration >= 60){
			
			plusMinute = duration%60;
			endMinute = plusMinute + minute;
			
		}
		plusMinute = duration + minute;
		if(plusMinute < 60){
			endMinute = plusMinute;
		}
		else{
			endMinute = plusMinute%60;
			
		}
		return endMinute;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	private String timeFormat(){
		 int h = (getHour() == 0  || getHour() ==12 ) ? getHour(): getHour()%12;
		 String period = (getHour()<12) ? "AM" : "PM";
		 int endh = (getEndHour() == 0  || getEndHour() ==12 ) ? getEndHour(): getEndHour()%12;
		 String endperiod = (getEndHour()<12) ? "AM" : "PM";
		 
		return String.format("%02d:%02d %s to %02d:%02d %s",h, getMinute(), period, endh, getEndMinute(), endperiod );
	}
	@Override
	public String toString() {
		String type;
		if(getDuration() == 60)
			type = "Lecture: ";
		else
			type = "Talk: ";
		
		String output = String.format("%s%s (%s)", type, getName(), timeFormat());
		
		return output; 
		
	}




}
