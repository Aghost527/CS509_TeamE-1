package dao;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import Flight.Flight;
import Flight.Flights;
import Flight.Seating;
import Time.Time;




public class DaoFlights {
	public static Flights addAll (String xmlFlights) throws NullPointerException {
		Flights flights = new Flights();
		
		// Load the XML string into a DOM tree for ease of processing
		// then iterate over all nodes adding each flight to our collection
		Document docFlights = buildDomDoc (xmlFlights);
		NodeList nodesFlights = docFlights.getElementsByTagName("Flight");
//		System.out.println("len"+nodesFlights.getLength());
		for (int i = 0; i < nodesFlights.getLength(); i++) {
			Element elementFlight = (Element) nodesFlights.item(i);
			Flight flight = buildFlight(elementFlight);
			
			flights.add(flight);
//			if (flight.isValid()) {
//				flights.add(flight);
//			}
		}
		
		return flights;
	}
		
	static private Flight buildFlight(Node nodeFlight) {
			/**
			 * Instantiate an empty Flight object
			 */
			Flight flight = new Flight();

			String Airplane;
			int FlightTime;
			String Number;
			
			String departureCode;
			String departureTime;
			
			String arrivalCode;
			String arrivalTime;
			
			 
			
			// The flight element has attributes of Name and 3 character flight code
			Element elementFlight = (Element) nodeFlight;
			Airplane = elementFlight.getAttributeNode("Airplane").getValue();
			FlightTime = Integer.parseInt(elementFlight.getAttributeNode("FlightTime").getValue());
			Number = elementFlight.getAttributeNode("Number").getValue();
			
			// The Departure, Arrival and Seating are child elements
			Element Departure ;
			Departure = (Element)elementFlight.getElementsByTagName("Departure").item(0);
			
			Element deCode = (Element)Departure.getElementsByTagName("Code").item(0);
			departureCode = getCharacterDataFromElement(deCode);
//			System.out.println(departureCode);
			Element deTime = (Element)Departure.getElementsByTagName("Time").item(0);
			departureTime = getCharacterDataFromElement(deTime);
			String[] dTime=departureTime.split(" ");
			Time tDeTime=new Time(dTime[0],dTime[1],dTime[2],dTime[3],dTime[4]);
			
			//elementLatLng = (Element)elementFlight.getElementsByTagName("Longitude").item(0);
			//longitude = Double.parseDouble(getCharacterDataFromElement(elementLatLng));
			
			Element Arrival;
			Arrival = (Element)elementFlight.getElementsByTagName("Arrival").item(0);
			Element arCode = (Element)Arrival.getElementsByTagName("Code").item(0);
			arrivalCode = getCharacterDataFromElement(arCode);
			Element arTime = (Element)Arrival.getElementsByTagName("Time").item(0);
			arrivalTime = getCharacterDataFromElement(arTime);
			String[] aTime=arrivalTime.split(" ");
			Time tArTime=new Time(aTime[0],aTime[1],aTime[2],aTime[3],aTime[4]);
			
			Element flightSeating;
			flightSeating = (Element)elementFlight.getElementsByTagName("Seating").item(0);
			Element coachSeating = (Element)flightSeating.getElementsByTagName("Coach").item(0);
			String coachPrice = coachSeating.getAttributeNode("Price").getValue();
			int coachRemaining = Integer.parseInt(getCharacterDataFromElement(coachSeating));
				
			Element firstclassSeating = (Element)flightSeating.getElementsByTagName("FirstClass").item(0);
			String firstclassPrice = firstclassSeating.getAttributeNode("Price").getValue();
			int firstRemaining = Integer.parseInt(getCharacterDataFromElement(firstclassSeating));

			Seating seats=new Seating(firstclassPrice, coachPrice, firstRemaining, coachRemaining);
			
			/**
			 * Update the Flight object with values from XML node
			 */
			
//			
			return new Flight( Airplane,  Number,  arrivalCode, departureCode,tDeTime ,  tArTime,
					  seats,FlightTime );
		}
		

	
	
	static private Document buildDomDoc (String xmlString) {
		/**
		 * load the xml string into a DOM document and return the Document
		 */
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
			InputSource inputSource = new InputSource();
			inputSource.setCharacterStream(new StringReader(xmlString));
			
			return docBuilder.parse(inputSource);
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		catch (SAXException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String getCharacterDataFromElement (Element e) {
		Node child = e.getFirstChild();
	    if (child instanceof CharacterData) {
	        CharacterData cd = (CharacterData) child;
	        return cd.getData();
	      }
	      return "";
	}
}

