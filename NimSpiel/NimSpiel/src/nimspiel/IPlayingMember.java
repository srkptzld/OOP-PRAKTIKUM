package nimspiel;

/**
 *
 * @author sirkpetzold
 */
/// interface für die Zug-Methode
public interface IPlayingMember {

    /**
     * Gibt abzuziehende Steine zurück
     * @param verbleibendeSteine verbleibende Steine
     * @return abzuziehende Steine
     */
    public int Zug(int verbleibendeSteine); 

    /**
     * Gibt den Namen zurück
     * @return Name
     */
    public String getName();                
}
