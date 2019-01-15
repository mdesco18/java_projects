/* Lecture Scheduler App
 * Author: Marc-Andre Descoteaux
 * Student ID: 100299390
 * Date: 2016-11-21
 * CPSC 1204 Project
 */

import java.util.Scanner; 

public class Application {

public static int counter = 0;

	public static int getCounter() {
	return counter;
}

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
	
		System.out.println("Welcome to the Scheduler Application!");

		Scheduler schedule = new Scheduler(24); 

		int menuSelect = 0;
		while(menuSelect != 4){
			System.out.println(">> MAIN MENU <<");
			System.out.println("1. Add an event");
			System.out.println("2. Display events");
			System.out.println("3. Schedule");
			System.out.println("4. Exit");
			System.out.print(">> Select your option (1-4): ");

			menuSelect = userInput.nextInt();
			System.out.println("");

			if(menuSelect == 1){
				int eventSelect = 0;
				while(eventSelect != 3){
					System.out.println(">> EVENT MENU <<");
					System.out.println("1. Add a talk");
					System.out.println("2. Add a lecture");
					System.out.println("3. Return to Main Menu");
					System.out.print(">> Select your option (1-3): ");


					eventSelect = userInput.nextInt();
					userInput.nextLine(); // flush the input stream
					System.out.println("");

					if(eventSelect == 1){

						Event talk = new Event();

						System.out.print("Enter the title of the talk: ");
						talk.setName(userInput.nextLine());
						System.out.println("");
						System.out.println("Enter the start time");
						System.out.print("Hour (0-23): ");
						talk.setHour(userInput.nextInt());
						System.out.println("");
						System.out.print("Minute (0-59): ");
						talk.setMinute(userInput.nextInt());
						System.out.println("\n");
						System.out.println("Enter talk's duration (in minutes): ");
						talk.setDuration(userInput.nextInt());
						System.out.println("");
						schedule.addToSchedule(talk, counter);
						counter++;
					}else
						if(eventSelect == 2){

							Event lecture = new Event();

							System.out.print("Enter the title of the lecture: ");
							lecture.setName(userInput.nextLine());
							System.out.println("");
							System.out.println("Enter the start time");
							System.out.print("Hour (0-23): ");
							lecture.setHour(userInput.nextInt());
							System.out.println("");
							System.out.println("Minute (0-59): ");
							lecture.setMinute(userInput.nextInt());
							lecture.setDuration(60);
							System.out.println("");
							schedule.addToSchedule(lecture, counter);
							counter++;
						}
				}

			}
			if(menuSelect == 2){
				System.out.println("Events:");
				System.out.println(schedule);
			}
			if(menuSelect == 3){
				schedule.ScheduleSort(schedule.AscendSort());
				System.out.println("Schedule:");
				System.out.println(schedule);

			}

		}


		userInput.close();

	}



}
