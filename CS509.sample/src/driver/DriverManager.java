package driver;

import java.util.ArrayList;
import java.util.List;

import Flight.Flight;
import Flight.Flights;
import dao.ServerInterface;

public class DriverManager {
	
	public Flights searchFlightsWithoutStop(String Arrival,String time,String Departure){
		ServerInterface resSys = new ServerInterface();
		Flights flights = resSys.getFlighs("TeamE","BOS","2017_05_10",true);
//		Flights flights = resSys.getFlighs("TeamE",Departure,time);
		flights.sortByArrivalAirport();
		flights=flights.filterByArrival("RDU", flights);
		return flights;
		
	}
	/*
	 * for the time being, it can only search flight within one day
	 */
	public List<Flights> searchFlightsWithOneStop(String Arrival,String time,String Departure){
		ServerInterface resSys = new ServerInterface();
		List<Flights> res=new ArrayList<Flights>();
		Flights flights1 = resSys.getFlighs("TeamE","PHL","2017_05_10",true);
//		Flights flights1 = resSys.getFlighs("TeamE",Departure,time,true);//true means search by departure
		flights1.sortByArrivalAirport();
		System.out.println(flights1.size());
		
		
		Flights flights2 = resSys.getFlighs("TeamE","RDU","2017_05_10",false);
//		Flights flights2 = resSys.getFlighs("TeamE",Arrival,time,false);
		flights2.sortByArrivalAirport();

		System.out.println(flights2.size());
		
	
		for(Flight f1 : flights1){
//			
			for(Flight f2 :flights2){
				System.out.println(f2.getDeparture());
				if(f1.getArrival().equals(f2.getDeparture())){
					Flights flight=new Flights();
					flight.add(f1);
					flight.add(f2);
					res.add(flight);
				}
			}
		}
		System.out.println("res size:"+res.size());
//		Flights flights2 =
		
		return res;
		
	}
	
}
