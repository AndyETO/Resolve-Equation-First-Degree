package FirstDegree;

public class Term {
	//String sign;
	boolean HasUnknown;
	

	int number;
	int DivideByNumber;
	public Term(int number_,boolean HasUnknown_) {
		this.HasUnknown = HasUnknown_;
		//this.sign = sign;		
		this.number=number_;
	}//constructor
	
	public String PrintTerm () {
		String Unknown= this.HasUnknown ? "X":""; 
		String Content =String.valueOf(this.number)+Unknown;  
		return Content;
	}//PrintTerm
	
	//region getters and setters
	public boolean isHasUnknown() {
		return HasUnknown;
	}

	public void setHasUnknown(boolean hasUnknown) {
		HasUnknown = hasUnknown;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getDivideByNumber() {
		return DivideByNumber;
	}

	public void setDivideByNumber(int divideByNumber) {
		DivideByNumber = divideByNumber;
	}
	//Region end
}//class
