/**
 * Die Klasse Monkey beschreibt alle Tierobjekte der Art Affen.
 * Sie erbt von der Klasse Animal und implementiert die abstrakten Methoden,
 * welche affennspezifisch sind. 
 * 
 * @author Kathrin Heim
 * @version 1.1
 * @see Animal
 */

public class Monkey extends Animal {

	/**
	 * Zähler für alle Affenobjekte
	 */
	private static int monkeynumber;

	/**
	 * Methode gibt einen Affenlaut als String zurück.
         * @return String Affenlaut   
	 */
        @Override //die abstrakte Methode roar aus Animal wird überschrieben.
	public String roar() {
            String monkeyroar = "Ugha, ugha, ugha!";
            return monkeyroar;
	}

	/**
	 * Methode nimmt ein Futter als String entgegen und gibt einen 
         * Affenlaut als String zurück; 
         * positiv im Fall, dass das Lieblingsfressen gefüttert wurde; 
         * ansonsten negativ.
         * @param food Futter für den Affen
         * @return String Affenlaut positiv oder negativ
	 */
        @Override //die abstrakte Methode feed aus Animal wird überschrieben.
	public String feed(String food) {
            if (food.equals(this.getFavoriteFood())) {
                String monkeypleased = "Mampf, mampf, uh, uh!!";
                return monkeypleased;
            }
            else {
                String monkeyangry = "Würg, Bäh, Grummel!";
                return monkeyangry;
            }
        
	}

	/**
	 * getter für Anzahl Affen
         * @return monkeynumber Anzahl Affenobjekte
	 */
	public static int getMonkeynumber() {
            return monkeynumber;
	}

        
        /**
	 * Standardkonstruktor für Affenobjekte
         * Es wird ein Affenobjekt angelegt und der Zähler aller Affenobjekte
         * hochgezählt.
	 */
        public Monkey() {
            super(); //Konstruktor aus Animal wird aufgerufen
            monkeynumber++; // monkeynumber++ statt Methode addAMonkey()

	}        

	/**
         * Konstruktor für Affenobjekte mit Parametern. Es wird der 
         * Konstruktor von Animal verwendet, dort wird der
         * Name des Affen sowie sein Lieblingsessen übergeben. 
         * Der Zähler für Affenobjekte wird zusätzlich zum Animal-Zähler
         * hochgezählt.
         * @param name Affenname
         * @param favoriteFood Lieblingsessen des Affen
	 */
	public Monkey(String name, String favoriteFood) {
            super(name, favoriteFood); //Konstruktor aus Animal wird aufgerufen
            monkeynumber++; //statt addAMonkey()
	}


}
