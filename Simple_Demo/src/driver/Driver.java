/**
 * 
 */
package driver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import airport.Airport;
import airport.Airports;
import dao.ServerInterface;
import flight.Flight;
import flight.Flights;
import net.sf.json.JSONArray;


public class Driver extends HttpServlet  {
	
	static DriverManager driverManager=new DriverManager();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
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
////			System.out.println(airport.toString());
//			System.out.println("put(\""+airport.code()+"\","+(int)airport.longitude()/15+");");
//		}

		// Try to get a list of airports
//		while(true){
		

		
		System.out.println("departAirportCode:");	
	    String departure = s.nextLine();
		System.out.println("departTime (YYYY_MM_DD) e.g. 2017_05_10 :");
		String time = s.nextLine();
		System.out.println("arrivalAiportCode e.g. RDU :");
		String arrival = s.nextLine();
		driverManager.search("", "", "", "", "");
//		driverManager.search("", "", departure, arrival, time);
		
		System.out.println("finished");
		
		List<Flights> flightlis = driverManager.searchFlightsWithoutStop(departure, time, arrival );

		
//		List<Flights> flightlis = driverManager.searchFlightsWithOneStop(arrival, time, departure);

		
//		List<Flights> flightlis = driverManager.searchFlightsWithTwoStop(arrival, time, departure);

		//output
		for(Flights flight  :flightlis){
		System.out.println(flight.toString());
//		System.out.println(driverManager.flights2xml(flight, "coach"));
	}
		

        JSONArray jsonArray = JSONArray.fromObject( flightlis );  
        System.out.println( jsonArray );  
        
		System.out.println("finished");
		System.out.println("result size:"+flightlis.size());
		
		
	}
}
