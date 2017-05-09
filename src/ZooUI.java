import java.io.*;
import java.util.ArrayList;

/**
 * ZooUI - ein vereinfachtes UI fuer eine Software fuer Besucher eines
 * Zoos. Der Besucher kann ein Tier aus einer gegebenen Liste auswaehlen 
 * und erhaelt dann jeweils Informationen zu diesem Tier in dem entsprechenden
 * Zoo bzw. Tierpark. Ausserdem wird noch ein Sound zu dem entsprechenden Tier 
 * abgespielt. Dies ist in unserem Programm allerdings auch nur ein String, 
 * der auf der Konsole ausgegeben wird.
 *
 * BibInfo16/2.Semester
 *
 * @author Kathrin Heim, nach einem Template von @Janett Mohnke
 * @version 1.1
 * @see Animal
 * @see Cat
 * @see Monkey
 */
public class ZooUI {

    public static void main(String args[]) throws IOException {
        int input;
        String futter;
        BufferedReader din = new BufferedReader(new InputStreamReader(System.in));
        
        /*
        ArrayList für alle Tierobjekte, wird mit Objekten der Klasse Animal 
        angelegt, daher kann jedes Tierobjekt darin abgelegt werden 
        -->polymorphe Datenstruktur
        */
        ArrayList<Animal> allAnimals = new ArrayList();
        

        //Zunaechst muessen die Tier-Objekte erzeugt werden und jedes angelegte
        //Objekt gezaehlt werden.
        
        /* 
        Anmerkung zu Anpassungen durch Kathrin Heim:
        Designschwäche 1: 
        Keine Kapselung verwendet! Für Attribute sollten setName/setFavoriteFood 
        (setter-Methoden) verwendet werden, diese Klassenattribute wurden in 
        Klasse Animal auf private gesetzt.
        Designschwäche 2:
        Methode addAMonkey() sowie addACat() sollte direkt im Konstruktor
        umgesetzt werden, damit sie nie vergessen gehen können und die Anzahl
        Tierobjekte immer stimmt. 
        Mit den hier verwendeten Methoden kann dies nicht gewährleistet werden.
        Daher wurden die Methoden in Animal (bzw. Cat/Monkey) nicht 
        implementiert und hier auskommentiert.
        Es wird einmal der Standardkonstruktor, und einmal der Konstruktor mit 
        Parametern verwendet, damit wird sowohl der Name & das Lieblingsfressen 
        des Tiers gesetzt sowie der Zähler für Animals und das jeweilige 
        vererbte Tier (Monkey/Cat) hochgezählt. 
        */
        Monkey ersterAffe;
        ersterAffe = new Monkey();
        //ersterAffe.name = "Otto"; Dies ist mit Kapselung nicht möglich, aber so:
        ersterAffe.setName("Otto");
        //ersterAffe.favoriteFood = "Bananen"; mit Kapselung so:
        ersterAffe.setFavoriteFood("Bananen");
        //Monkey.addAMonkey(); Dies wird im Konstruktor erledigt.
		
        //Affe wird zu Arraylist hinzugefügt
        allAnimals.add(ersterAffe);

        Monkey zweiterAffe;
        zweiterAffe = new Monkey();
        //zweiterAffe.name = "Paula";
        //zweiterAffe.favoriteFood = "Gurken";
        //Monkey.addAMonkey();
        zweiterAffe.setName("Paula");
        zweiterAffe.setFavoriteFood("Gurken");
        allAnimals.add(zweiterAffe);
        
        Monkey dritterAffe = new Monkey("Tarzan", "Schinkenbrot");
        allAnimals.add(dritterAffe);
        Monkey vierterAffe = new Monkey("Bubba", "Laeuse");
        allAnimals.add(vierterAffe);

        Cat ersteKatze;
        ersteKatze = new Cat();
        //ersteKatze.name = "Egon"; Kapselung nicht angewendet
        ersteKatze.setName("Egon");
        //ersteKatze.favoriteFood = "Maeuse"; Kapselung nicht angewendet
        ersteKatze.setFavoriteFood("Maeuse");
        //Cat.addACat(); Methode gelöscht, s.oben bei Monkey
        allAnimals.add(ersteKatze);        
        
        Cat zweiteKatze = new Cat("Gipsy", "Friskies");
        allAnimals.add(zweiteKatze);
        
        Cat dritteKatze = new Cat("Tigger", "Schmand");
        allAnimals.add(dritteKatze);
        
        Cat vierteKatze = new Cat("Killer", "Spatzen");
        allAnimals.add(vierteKatze);

        do { //Hauptschleife
            printMenue();
            input = Integer.parseInt(din.readLine());
            switch (input) {
                case 1:
                    //Lassen Sie die Affen bruellen und 
                    //geben Sie Informationen ueber sie aus.
                    for (int i = 1; i<=Monkey.getMonkeynumber();i++) {
                        System.out.println(ersterAffe.roar());
                    }
                    
                    if (Monkey.getMonkeynumber() == 1) {
                        System.out.println("Im Tierpark lebt 1 Affe.");
                    } else {
                        System.out.println("Im Tierpark leben "
                                + Monkey.getMonkeynumber() + " Affen.");
                    }
                    break;
                case 2:
                    //Lassen Sie die Katzen bruellen und 
                    //geben Sie Informationen ueber sie aus.
                    for (int i = 1; i<=Cat.getCatnumber();i++) {
                        System.out.println(ersteKatze.roar());
                    }
                    
                    if (Cat.getCatnumber() == 1) {
                        System.out.println("Im Tierpark lebt 1 Katze.");
                    } else {
                        System.out.println("Im Tierpark leben "
                                + Cat.getCatnumber() + " Katzen.");
                    }
                    break;
                case 3:
                    //Lassen Sie die Loewen bruellen und 
                    //geben Sie Informationen ueber sie aus.
                    System.out.println("Im Tierpark leben keine Loewen.");
                    break;
                case 4:
                    //Lassen Sie die Baeren bruellen und 
                    //geben Sie Informationen ueber sie aus.
                    System.out.println("Im Tierpark leben keine  Baeren.");
                    break;
                case 5:
                    //Mittels Eingabeaufforderung kann allen Tieren ein Futter
                    //vorgeworfen werden. Die Tiere geben Laut, je nach dem,
                    //wie das Futter schmeckt.
                    /*
                    Anwendung des Polymorphismus und der dynamischen Bindung:
                    Alle Tierobjekte werden aus der Arraylist geholt und mit der
                    jeweils in ihrer Klasse implementierten Methode feed() aus-
                    geführt. feed() überschreibt dabei jeweils die Methode aus der
                    abstrakten Klasse.
                    */
                    System.out.println("Geben Sie ein Futter ein: ");
                    futter = din.readLine();
                    for (Animal tempAnimal: allAnimals){
                        System.out.println(tempAnimal.getName()+": "+
                                tempAnimal.feed(futter));                    
                    }
            }
        } while (input != 0);
        System.out.println("Bis zum naechsten Mal!");
    }

    private static void printMenue() {
        System.out.println("\nWaehlen Sie ein Tier aus:");
        System.out.println();
        System.out.println(" 1 Affe");
        System.out.println(" 2 Katze");
        System.out.println(" 3 Loewe");
        System.out.println(" 4 Baer");
        System.out.println(" 5 Alle Tiere füttern");
        System.out.println(" 0 Das Programm wird beendet");
        System.out.println();
        System.out.println("Bitte waehlen Sie nun aus! ");
    }

}
