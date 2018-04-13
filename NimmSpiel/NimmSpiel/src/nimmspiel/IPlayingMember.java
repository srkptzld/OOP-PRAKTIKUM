package nimmspiel;

/**
 *
 * @author sirkpetzold
 */
/// interface für die Zug-Methode
public interface IPlayingMember {

    public int Zug(int verbleibendeSteine); // Methode die abzuziehende Steine zurückgibt

    public String getName();                // Gibt den Namen zurück
}
