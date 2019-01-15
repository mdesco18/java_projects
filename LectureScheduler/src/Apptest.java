
public class Apptest {

	public static void main(String[] args) {
	try{
		
		Event talk = new Event("talk", 1,30,30);
		Event talk2 = new Event("talk2", 12,30,40);
		Scheduler schedule = new Scheduler(2);
		schedule.addToSchedule(talk, 0);
		schedule.addToSchedule(talk2, 1);
		System.out.print(schedule);
		
	}catch (Exception e){
	System.out.println(e.getMessage());
	}
	
	}
}
