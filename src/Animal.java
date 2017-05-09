/**
 * Diese abstrakte Klasse Animal ist allen Tiere der Zoo-Applikation 
 * übergeordnet und enthält die gemeinsamen Variablen und Methoden aller Tiere.
 * 
 * @author Kathrin Heim
 * @version 1.1
 * @see Cat
 * @see Monkey
 * @see Object
 */
public abstract class Animal {
    
    private String name;
    private String favoriteFood;
    
    /**
     * number ist der Zähler für alle Tiere.
     */
    private static int number;
    
    /**
     * Methode gibt einen Tierlaut als String zurück.  
     * @return String Tierlaut
     */
    public abstract String roar(); 
    /*
    Abstrakte Methode, Implementierung in den einzelnen Tierklassen.
    Alternativ: statt kein Rumpf ein Pseudorumpf, z.B.
    System.out.println("...") => dann aber nicht mehr abstract 
    */
    
    /**
     * Methode nimmt ein Futter als String entgegen und gibt einen Tierlaut
     * als String zurück; positiv im Fall, dass das Lieblingsfressen 
     * gefüttert wurde; ansonsten negativ.
     * @return String Schnurrlevel
     * @param food Futter 
     */
    public abstract String feed(String food); 
    /*
    Abstrakte Methode, Implementierung in den einzelnen Tierklassen. 
    Alternativ: statt kein Rumpf ein Pseudorumpf, z.B.
    System.out.println("...") => dann aber nicht mehr abstract
    */
    
    /**
     * Getter für Anzahl aller Tiere
     * @return int number of animals
     */
    public static int getNumber() {
        return number;
    }
    
    /**
     * Setter für Tiername
     * @param name Tiername
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter für Tiername
     * @return String Tiername
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setter für Lieblingsessen
     * @param favoriteFood Lieblingsessen
     */
    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }
    
    /**
     * Getter für Lieblingsessen
     * @return String Lieblingsessen
     */
    public String getFavoriteFood() {
        return favoriteFood;
    }
    
    /**
     * Standardkonstruktor für Animal
     * Es wird jeweils beim Anlegen die Anzahl aller Tierobjekte
     * hochgezählt.
     */
    public Animal() {
        number++; //statt der Methode addAAnimal()
    }
    
    /**
     * Konstruktor für Animal, welcher Namen und Lieblingsessen übergibt
     * und den Zähler aller Tiere erhöht.
     * @param name Tiername
     * @param favoriteFood Lieblingsessen
     */
    public Animal(String name, String favoriteFood) {
        this(); //mit this() wird der Standardkonstruktor aufgerufen
        this.name = name;
        this.favoriteFood = favoriteFood;
    }

}
