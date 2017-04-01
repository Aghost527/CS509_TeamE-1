/**
 * 
 */
package driver;
import java.util.List;
import java.util.Scanner;

import Flight.Flight;
import Flight.Flights;
import airport.Airport;
import airport.Airports;
import dao.ServerInterface;


public class Driver {
	
	static DriverManager driverManager=new DriverManager();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String teamName = "TeamE";
//		if (args.length != 1) {
//			System.err.println("usage: CS509.sample teamName");
//			System.exit(-1);
//			return;
//		}
		
			// Try to get a list of airports
//		ServerInterface resSys=new ServerInterface();
//		Airports airports = resSys.getAirports(teamName);
//		for (Airport airport : airports) {
//			System.out.println(airport.toString());
//		}

		// Try to get a list of airports
//		while(true){
		
		System.out.println("departAirportCode:");	
	    String departure = s.nextLine();
		System.out.println("departTime (YYYY_MM_DD) e.g. 2017_05_10 :");
		String time = s.nextLine();
		System.out.println("arrivalAiportCode e.g. RDU :");
		String arrival = s.nextLine();

		
//		List<Flights> flightlis = driverManager.searchFlightsWithoutStop(departure, time, arrival );
		
		
//		List<Flights> flightlis = driverManager.searchFlightsWithOneStop(arrival, time, departure);

		
		List<Flights> flightlis = driverManager.searchFlightsWithTwoStop(arrival, time, departure);

		//output
		for(Flights flight  :flightlis){
		System.out.println(flight.toString());
//		System.out.println(driverManager.flights2xml(flight, "coach"));
	}
		System.out.println("finished");
		System.out.println("result size:"+flightlis.size());
		
		
	}
}
