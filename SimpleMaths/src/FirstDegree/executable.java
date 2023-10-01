package FirstDegree;
import javax.swing.JOptionPane;
public class executable {

	public static void main(String[] args) {
		System.out.println("Start program");
		Equation EquationSample = new Equation();
		boolean flagCicleAdd= true;		
		int rangeDataLeft = Integer.parseInt(JOptionPane.showInputDialog("Cuantos terminos vas a ingresar en el lado IZQUIERDO de la ecuación?"));		
		int rangeDataRight = Integer.parseInt(JOptionPane.showInputDialog("Cuantos terminos vas a ingresar en el lado DERECHO de la ecuación?"));
		String vSite = "";
		while(flagCicleAdd) {		
			if(rangeDataLeft>0) {
				rangeDataLeft--;
				vSite = "L";
			}else if(rangeDataRight>0 && rangeDataLeft==0) {
				rangeDataRight--;
				vSite = "R";
			}
			int numberTerm = Integer.parseInt(JOptionPane.showInputDialog("Ingresa número:"));
			String selectOne = JOptionPane.showInputDialog("Contiene incoginita: (Si)(No)");
			boolean HasUnknown = selectOne.length()>0?true:false;
			Term NewTerm = new Term(numberTerm,HasUnknown);	
			EquationSample.addTermToEquation(NewTerm, vSite);
			flagCicleAdd  = (rangeDataLeft==0 && rangeDataRight==0) ?false:true;
		}
		String PrintEquation = EquationSample.PrintEquation();
		System.out.println(PrintEquation);
		JOptionPane.showMessageDialog(null,"Your equation: "+PrintEquation);
		
		System.out.println("Resolving equation");
		Resolve Resolve = new Resolve(EquationSample);
		Equation EquationSampleResult = Resolve.Resolve();
		
		String PrintEquationSample = EquationSampleResult.PrintEquation();
		System.out.println(PrintEquationSample);
		JOptionPane.showMessageDialog(null,"Result: "+PrintEquationSample);
		
		System.out.println("Finish Program");
	}//main

}//Class
