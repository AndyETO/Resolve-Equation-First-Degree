package FirstDegree;

import java.util.ArrayList;

public class Resolve {
	
	
	private String result = "";
	private Equation EquationToResolve;		
	private Equation ResultEquation;
	
	
	
	public Resolve(Equation EquationToResolve) {
		this.EquationToResolve = EquationToResolve;
	}//constructor
	
	
	public Equation Resolve() {
		
		//reduce common elements
		ArrayList<Term> lstTermsLeft = Simplify(EquationToResolve.getLstTermLeft());
		ArrayList<Term> lstTermsRight =  Simplify(EquationToResolve.getLstTermRight());
		
		//Send terms to own side
		ArrayList<Term> newlstTermsLeft = ChangeTerms(lstTermsLeft,lstTermsRight,"L");
		ArrayList<Term> newlstTermsRight = ChangeTerms(lstTermsLeft,lstTermsRight,"R");
		
		Term ResultLeft =  SimplifyToATerm(newlstTermsLeft,true);
		Term ResultRight =  SimplifyToATerm(newlstTermsRight,false);
		
		Equation ResultEquation = new Equation();
		if(DoDivition(ResultLeft)) {
			Term newTermResultRight = DivitionTerms(ResultLeft,ResultRight);
			ResultLeft.number = 1;
			ResultEquation.addTermToEquation(ResultLeft, "L");
			ResultEquation.addTermToEquation(newTermResultRight, "R");
		}else {
			ResultRight.DivideByNumber = ResultLeft.number;
			ResultLeft.number = 1;
			ResultEquation.addTermToEquation(ResultLeft, "L");
			ResultEquation.addTermToEquation(ResultRight, "R");
		}
		
		return ResultEquation;
	}
	
	private ArrayList<Term> Simplify(ArrayList<Term> lstTerms) {
		ArrayList<Term> newLstTerms = new ArrayList<Term>();
		Term ResultUnknownFactors = new Term(0,true);
		Term ResultNumericFactors = new Term(0,false);
		int number =0;
		for(Term Item :lstTerms) {
			if(Item.HasUnknown) {
				number = Item.number + ResultUnknownFactors.number;
				ResultUnknownFactors.number=number;
			}else {
				number = Item.number + ResultNumericFactors.number;
				ResultNumericFactors.number=number;
			}
		}
		//Exists cases where doesn't have any element of one factor 
		newLstTerms.add(ResultNumericFactors);
		
		newLstTerms.add(ResultUnknownFactors);
		
		return newLstTerms;
	}//SimplifyLeft
	
	private ArrayList<Term> ChangeTerms(ArrayList<Term> lstTermsLeft,ArrayList<Term> lstTermsRight,String Side) {
		ArrayList<Term> newList = new ArrayList<Term>();
		
		
		if(Side.equals("L")) {
			
			for(Term Item :lstTermsLeft) {
				if(Item.HasUnknown) {
					if(Item.number!=0) {
						newList.add(Item);
					}// if 2
				}//if 1
			}//for 1
			
			for(Term Item :lstTermsRight) {
				if(Item.HasUnknown) {
					if(Item.number>0) {
						Item.number = -Item.number;
						newList.add(Item);
						
					}else {
						Item.number = Math.abs(Item.number);
						newList.add(Item);
					}// if 3
				}//if 1
			}//for 2
		}else {
			for(Term Item :lstTermsLeft) {
				if(!Item.HasUnknown) {
					if(Item.number>0) {
						Item.number = -Item.number;
						newList.add(Item);
					}else {
						Item.number = Math.abs(Item.number);
						newList.add(Item);
					}// if 3
					//if 2
				}//if 1
			}//for 4
			
			for(Term Item :lstTermsRight) {
				if(!Item.HasUnknown) {
					if(Item.number!=0) {
						newList.add(Item);
					}//if 2
				}//if 1
			}//for 5
		}

		return newList;
	}//SimplifyRight
	
	private Term SimplifyToATerm(ArrayList<Term> lstTerms,Boolean Unknown){	
		Term newTerm = new Term(0,Unknown);
		for(Term item: lstTerms) {
			newTerm.number += item.number;
		}
		return newTerm;
	}//SimplifyToATerm
	
	public boolean DoDivition(Term ResultLeft) {
		boolean DoDivition=false;
		
		if(ResultLeft.number!=0 || ResultLeft.number!=1) {
			 DoDivition=true;
		}
		
		return DoDivition;
	}//DoDivition
	
	public Term DivitionTerms(Term ResultLeft,Term ResultRight) {
		Term newTerm = new Term(0,false);
		float numberResult=0;
		numberResult = ResultRight.number/ResultLeft.number;
		
		
		if(!Float.toString(numberResult).contains(".0")) {
			newTerm.number = ResultRight.number;
			newTerm.DivideByNumber = ResultLeft.number;
		}else {
			newTerm.number = (int)numberResult;
		}
		return newTerm;
	}//DivitionTerms
}//class
