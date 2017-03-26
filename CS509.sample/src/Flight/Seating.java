package Flight;



public class Seating {

	
	
	private String firstclassPrice;
	private String coachPrice;
	private int firstclassRemaining;
	private int coachRemaining;
	/**
	 * @param firstclassPrice
	 * @param coachPrice
	 * @param firstclassRemaining
	 * @param coachRemaining
	 */
	public Seating(String firstclassPrice, String coachPrice, int firstclassRemaining, int coachRemaining) {
		super();
		this.firstclassPrice = firstclassPrice;
		this.coachPrice = coachPrice;
		this.firstclassRemaining = firstclassRemaining;
		this.coachRemaining = coachRemaining;
	}
	
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Seating [firstclassPrice=" + firstclassPrice + ", coachPrice=" + coachPrice + ", firstclassRemaining="
				+ firstclassRemaining + ", coachRemaining=" + coachRemaining + "]";
	}





	public String getFirstclassPrce() {
		return firstclassPrice;
	}
	public void setFirstclassPrce(String firstclassPrice) {
		this.firstclassPrice = firstclassPrice;
	}
	public String getCoachPrice() {
		return coachPrice;
	}
	public void setCoachPrice(String coachPrice) {
		this.coachPrice = coachPrice;
	}
	public int getFirstclassRemaining() {
		return firstclassRemaining;
	}
	public void setFirstclassRemaining(int firstclassRemaining) {
		this.firstclassRemaining = firstclassRemaining;
	}
	public int getCoachRemaining() {
		return coachRemaining;
	}
	public void setCoachRemaining(int coachRemaining) {
		this.coachRemaining = coachRemaining;
	}

	
	
}
