/**
 *
 * @author roudet
 */
public class Orange {
	private double prix;
	private String origine;
	
	public Orange() 
	{
		this.prix = 0.5;  //prix en euros
		this.origine="Espagne";
	}
	
	public Orange(double prix, String origine) 
	{
		if(prix < 0)
			this.prix = -prix;  //une solution possible pour interdire les prix negatifs
		else
			this.prix = prix;

		if(origine.equals(""))
				this.origine = "Espagne";  //Espagne par défaut
		else
				this.origine = origine;   
	}

	public double getPrix(){
		return prix;
	}

	public void setPrix(double prix){
		this.prix=prix;
	}

	public String getOrigine(){
		return origine;
	}

	public void setOrigine(String origine){
		this.origine=origine;
	}

	@Override
	public String toString(){
		return "Orange de " + origine + " a " + prix + " euros";
	}

	@Override
	public boolean equals(Object o){  //predicat pour tester si 2 oranges sont equivalentes
		if(o != null && getClass() == o.getClass()){
			Orange or = (Orange) o;
			return (prix == or.prix && origine.equals(or.origine));
		}
		return false;
	}

	public boolean isSeedless() {  //predicat indiquant qu'une orange a des pepins
		return false;
	}


	public static void main (String[] args){
		//Ecrire ici vos tests
		System.out.println("premier test Orange");
		Orange test = new Orange( -5.2, "Pakistan");
		if (test.getPrix() != 5.2) System.out.println("Constructeur foireux (Prix)");
		test.setPrix(4.2);
		if (test.getPrix() != 4.2) System.out.println("setPrix foireux");
		if ("Pakistan" != test.getOrigine()) System.out.println("Constructeur foireux (Origine)");
		System.out.println(test.toString());
		Orange nouveau = new Orange(4.2,"Pakistan");
		if (! nouveau.equals(test)) System.out.println("comparaison == foireuse (cas succès)");
		
		nouveau.setOrigine("Espagne");
		if (nouveau.getOrigine() != "Espagne") System.out.println("Seteur Origine Foireux");
		if (nouveau.equals(test)) System.out.println("comparaison == foireuse (cas échec)");
		return;
	}
}
