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
		System.out.println("1. Auf dem Steinhaufen befinden sich " + anzSteine + " Steine.");
		System.out.println("2. Die Spieler nehmen abwechselnd 1-3 Steine vom Haufen, bis keine Steine mehr übrig sind.");
		System.out.println("3. Der Spieler, welcher den letzten Stein aufnimmt, hat verloren!");
		System.out.println("4. Möge der Bessere gewinnen!");
		
	}
	
	public static void ZugEnde(int abgezogeneSteine, int uebrigeSteine, IPlayingMember spieler) {	
		if (abgezogeneSteine > 0)
                    System.out.println("Es wurden " + abgezogeneSteine + " Steine von " + spieler.getName() + " genommen.");
		System.out.println("Auf dem Haufen befinden sich noch " + uebrigeSteine + " Steine.");
		
	}
	
        public static void SpielEnde(Spiel spiel ){
            IPlayingMember spieler = (spiel.getDran() > 0) ? spiel.getCom() : spiel.getSpieler();
            System.out.println("Nach " + spiel.getRunde() + " Runden hat der Spieler " + spieler.getName() + " verloren!");
        }
}
