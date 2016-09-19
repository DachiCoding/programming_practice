//CSC402 HW5
//@author DACHI XU

public class Djia implements Comparable<Djia> {
	private String Date;
	private double Open;
	private double Close;
	
	public Djia(String date, double opening, double closing){
		this.Date = date;
		this.Open = opening;
		this.Close = closing;
	}
	
	public String date(){
		return this.Date;
	}
	
	public double opening(){
		return this.Open;
	}
	
	public double closing(){
		return this.Close;
	}
	
	public int compareTo(Djia djiaItem){
		if (this.Close > djiaItem.Close){
			return 1;
		}
		else if (this.Close == djiaItem.Close){
			return 0;
		}
		else {
			return -1;
		}
	}
	
	public String toString(){
		return this.Date + "," + Double.toString(this.Open) + "," + Double.toString(this.Close);
	}
}
