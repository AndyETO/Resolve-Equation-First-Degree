package FirstDegree;
import java.util.*;

import javax.swing.JOptionPane;
public class Equation {
	
	ArrayList<Term> lstTermLeft = new ArrayList<>();
	ArrayList<Term> lstTermRight = new ArrayList<>();
	String eSide = "";
	
	//REGION getters and setters
	public ArrayList<Term> getLstTermLeft() {
		return lstTermLeft;
	}

	public void setLstTermLeft(ArrayList<Term> lstTermLeft) {
		this.lstTermLeft = lstTermLeft;
	}

	public ArrayList<Term> getLstTermRight() {
		return lstTermRight;
	}

	public void setLstTermRight(ArrayList<Term> lstTermRight) {
		this.lstTermRight = lstTermRight;
	}
	//REGION END getters and setters
	
	public void addTermToEquation(Term item,String eSide) {
		if (eSide.equals("L")) {
			lstTermLeft.add(item);
		}else if(eSide.equals("R")){
			lstTermRight.add(item);
		}else {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
	}//addTermToEquation
	
	public String PrintEquation() {
		String PrintEquation = ""; 
		String Unknown = "";
		for(Term item : lstTermLeft) {
			Unknown = item.HasUnknown?"X ":" ";
			PrintEquation += String.valueOf(item.number).concat(Unknown);
		}
		PrintEquation += "= ";
		for(Term item : lstTermRight) {
			Unknown = item.HasUnknown?"X ":" ";
			PrintEquation += String.valueOf(item.number).concat(Unknown);
		}
		
		return PrintEquation;
	}//JOptionPane
	
	
}//Equation
