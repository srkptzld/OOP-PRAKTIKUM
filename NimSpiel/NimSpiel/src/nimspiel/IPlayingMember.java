package nimspiel;

/**
 * Interface mit Zug-Methode
 * @author sirkpetzold
 */
public interface IPlayingMember {

    /**
     * Gibt abzuziehende Steine zurück
     * @param verbleibendeSteine int
     * @return abzuziehende Steine
     */
    public int Zug(int verbleibendeSteine); 

    /**
     * Gibt den Namen zurück
     * @return String
     */
    public String getName();                
}
