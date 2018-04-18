package nimmspiel;

/**
 *
 * @author sirkpetzold
 */
/// interface für die Zug-Methode
public interface IPlayingMember {

    /**
     *
     * @param verbleibendeSteine
     * @return
     */
    public int Zug(int verbleibendeSteine); // Methode die abzuziehende Steine zurückgibt

    /**
     *
     * @return
     */
    public String getName();                // Gibt den Namen zurück
}
