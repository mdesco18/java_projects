/* Lecture Scheduler App
 * Author: Marc-Andre Descoteaux
 * Student ID: 100299390
 * Date: 2016-11-21
 * CPSC 1204 Project
 */

public class Scheduler{

	private Event[] schedule;

	public Scheduler (int length){

		this.schedule = new Event[length];

	}

	public void addToSchedule(Event schedule, int i) {
		try{
			
				this.schedule[i] = new Event(schedule.getName(),
						schedule.getHour(),
						schedule.getMinute(),
						schedule.getDuration());
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}

	}
	public Event[] getSchedule() {
		Event[] temp = new Event[schedule.length];
		try{
			for(int i=0; i<schedule.length; i++){
				temp[i] = new Event(schedule[i].getName(),
						schedule[i].getHour(),
						schedule[i].getMinute(),
						schedule[i].getDuration());
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return temp; 
	}

	public Event[] AscendSort(){

		int n = schedule.length;
		for(int i = 1; i<n; i++){
			for(int j=i+1; j <= n; j++){
				if(schedule[j].getEndHour() <= schedule[i].getEndHour())
					schedule[j] = schedule[i];
			}
		}
		return schedule;
	}

	public void ScheduleSort(Event[] sortedSched){

		Event[] realSched = new Event[sortedSched.length];
		realSched[0] = new Event(sortedSched[0].getEndHour(), sortedSched[0].getEndMinute());
		int j = 0;
		for(int i = 1; i < sortedSched.length; i++){
			if((sortedSched[i].getHour() == realSched[j].getEndHour() 
					&& sortedSched[i].getMinute() >= realSched[j].getEndMinute()) 
					|| sortedSched[i].getHour() > realSched[j].getEndHour()){
				j++;
				realSched[j] = new Event(sortedSched[i].getEndHour(), sortedSched[i].getEndMinute());

			}
		}

	}
	
	
	@Override 
	public String toString() {

		String output = "";
		for(int i = 0; i < Application.getCounter(); i++)
		output += schedule[i].toString() + "\n";
		
			return output;
		
	}

}
