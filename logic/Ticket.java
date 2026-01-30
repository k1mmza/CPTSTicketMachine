package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}
	
	public void setType(int type) {
		this.type = type;
	}
	
	public void setStation(Station start,Station end) {

	}
	
	public double calculatePrice() {
		/* FILL CODE */
	}
	
	public String getDescription() {
		String typename;
		
		switch(type) {
		
		case 0:
			typename = "Student";
			break;
		case 1:
			typename = "Adult";
            break;
		case 2:
			typename = "Elderly";
            break;
		default:
			typename = "Invalid";
		}
		
		return typename+" Ticket, from "+ getStart() +" to "+ getEnd();
	}
	
	public boolean isStationValid(Station start,Station end) {
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}
	
	public int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}
