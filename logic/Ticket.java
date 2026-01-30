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
		return this.type;
	}
	
	public int getPricePerStation() {
		return this.priceperstation;
	}
	
	public Station getStart() {
		return this.start;
	}
	
	public Station getEnd() {
		return this.end;
	}
	
	public void setType(int type) {
		if(type<0 || type>2) {
            this.type = 1;
            this.priceperstation = 30;
        }else {
            this.type = type;
            if(type==2) {
                this.priceperstation = 25;
            }else {
                this.priceperstation = 30;
            }
        }
	}
	
	public void setStation(Station start,Station end) {
        this.start = start;
        this.end = end;
	}
	
	public double calculatePrice() {
		/* FILL CODE */
        if(!isStationValid(start,end)) return -1;
        int distance = getStationDistance(start, end);
        double basePrice = distance * priceperstation;
        switch (type) {
            case 0:
                if(distance > 4){
                    return basePrice * 0.8;
                } else {
                    return basePrice;
                }
            case 1:
                return basePrice;
            case 2:
                return basePrice * 0.6;
            default:
                return -1;
        }
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
            if(!isStationValid(start, end)) {
                typename = "Invalid";
            } else {
                typename = "Elderly";
            }
            break;
		default:
			typename = "Invalid";
		}
		
		return typename+" Ticket, from "+ getStart().getName() +" to "+ getEnd().getName();
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

    public void setEnd(Station end) {
        this.end = end;
    }

    public void setStart(Station start) {
        this.start = start;
    }

    public int getPriceperstation() {
        return priceperstation;
    }

    public void setPriceperstation(int priceperstation) {
        this.priceperstation = priceperstation;
    }

}
