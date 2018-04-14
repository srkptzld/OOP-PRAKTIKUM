package nimmspiel;

/**
 *
 * @author funbold
 */
/// Gibt Informationstext aus
public class Ausgabe {
    //alle Methoden static
	
	public static void Begruessung(){
		
		System.out.println("Herzlich willkommen. Zum Spielen Namen eingeben und ENTER drücken:");
		
	}
	
	public static void SpielRegeln(int anzSteine) {
		
		System.out.println("Die Spielregeln sind simpel:");
		System.out.println("Auf dem Steinhaufen befinden sich " + anzSteine + " Steine.");
		System.out.println("Die Spieler nehmen abwechselnd 1-3 Steine vom Haufen, bis keine Steine mehr übrig sind.");
		System.out.println("Der Spieler, welcher den letzten Stein aufnimmt, hat verloren!");
		System.out.println("Möge der Bessere gewinnen!");
		
	}
	
	public static void ZugEnde(int abgezogeneSteine, int uebrigeSteine) {
		
		System.out.println("Es wurden " + abgezogeneSteine + " Steine genommen.");
		System.out.println("Auf dem Haufen befinden sich noch " + uebrigeSteine + " Steine.");
		
	}
	
	
}
