/**
 * Die Klasse Cat beschreibt alle Tierobjekte der Art Katzen.
 * Sie erbt von der Klasse Animal und implementiert die abstrakten Methoden,
 * welche katzenspezifisch sind. 
 * 
 * @author Kathrin Heim
 * @version 1.1
 * @see Animal
 */

public class Cat extends Animal {

	/**
	 * Zähler für alle Katzenobjekte
	 */
	private static int catnumber;

	/**
	 * Methode gibt einen Katzenlaut als String zurück.
         * @return String Katzenlaut   
	 */
        @Override
	public String roar() {
            String catroar = "Miauu!!";
            return catroar;
	}

	/**
	 * Methode nimmt ein Futter als String entgegen und gibt einen 
         * Katzenlaut als String zurück; 
         * positiv im Fall, dass das Lieblingsfressen gefüttert wurde; 
         * ansonsten negativ.
         * @param food Futter für die Katze
         * @return String Katzenlaut positiv oder negativ
	 */
        @Override
	public String feed(String food) {
            if (food.equals(this.getFavoriteFood())) {
                String catpleased = "Schnurr, Schnurr, Schnurrrrr!!";
                return catpleased;
            }
            else {
                String catangry = "Fauch!! Ich kratz dich gleich!";
                return catangry;
            }
        
	}

	/**
	 * getter für Anzahl Katzen
         * @return catnumber Anzahl Katzenobjekte
	 */
	public static int getCatnumber() {
            return catnumber;
	}

	/**
	 * Standardkonstruktor für Katzenobjekte
         * Es wird der Animal-Standardkonstruktor aufgerufen;
         * der Zähler aller Katzenobjekte wird zusätzlich hochgezählt.
	 */
        public Cat() {
            super();
            catnumber++; // Methode addACat() gelöscht, stattdessen catnumber++
	}

	/**
         * Konstruktor für Katzenobjekte mit Parametern. Es wird der 
         * Konstruktor von Animal verwendet, dort wird der
         * Name der Katze sowie ihr Lieblingsessen übergeben. 
         * Der Zähler für Katzenobjekte wird zusätzlich zum Animal-Zähler
         * hochgezählt.
         * @param name Katzenname
         * @param favoriteFood Lieblingsessen der Katze
	 */
        
	public Cat(String name, String favoriteFood) {
            super(name, favoriteFood);
            catnumber++; //statt der Methode addACat()            
	}

}
