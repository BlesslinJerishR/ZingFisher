package AeroplaneTicketBooking;

import java.util.ArrayList;

public class Flight {
 
	static int id = 0;
	int flightId;
	int tickets;
	int price;
	ArrayList<String> passengerDetails;
	ArrayList<Integer> passengerIDs;
	ArrayList<Integer> bookedTicketsPerPassenger;
	ArrayList<Integer> passengerCost;
	public Flight() {
		tickets = 50 ;
		price  = 5000 ;
		id = id+1;
		flightId =id;
		passengerDetails = new ArrayList<String>();
		passengerIDs = new ArrayList<Integer>();
		bookedTicketsPerPassenger = new ArrayList<Integer>();
		passengerCost = new ArrayList<Integer>();
	}
	public void addPassengerDetails(String passengerDetails,int numberOfTickets,int passengerID) {
		this.passengerDetails.add(passengerDetails);
        passengerIDs.add(passengerID);
        passengerCost.add(price * numberOfTickets);
        
        price += 200*numberOfTickets;
        
        tickets -=numberOfTickets;
        
        bookedTicketsPerPassenger.add(numberOfTickets);
        
        System.out.println("Booked Successfully");
	}
	public void cancelTicket(int passengerID)  {
		
		int indexToRemove = passengerIDs.indexOf(passengerID);
		if(indexToRemove < 0) {
			
			System.out.println("Passenger ID not found");
			 return;
		}
		int ticketsToCancel = bookedTicketsPerPassenger.get(indexToRemove);
		
		tickets += ticketsToCancel;
		price -= 200*ticketsToCancel;
		System.out.println("Refund Amount after cancel : " + passengerCost.get(indexToRemove));

	       //remove details of passenger from all lists
	       bookedTicketsPerPassenger.remove(indexToRemove);
	       passengerIDs.remove(Integer.valueOf(passengerID));
	       passengerDetails.remove(indexToRemove);
	       passengerCost.remove(indexToRemove);
	       
	       System.out.println("Cancelled Booked Tickets Successfully!");
	}
	 public void flightSummary()
	    {
	        System.out.println("Flight ID " + flightId + " --" + "Remaining Tickets " + tickets + " --" + 
	        "Current Ticket Price " + price);
	    }
	    public void printDetails()
	    {
	       System.out.println("Flight ID " + flightId + "->");
	        for(String detail : passengerDetails)
	            System.out.println(detail);
	    }


}
