
import java.util.*;

/**
 * 
 * @author sirkpetzold
 */
public class Protokoll {

    /**
     * Default constructor
     */
    public Protokoll() {
        _aktionen = new ArrayList<Aktion>();
    }

    /**
     * 
     */
    private ArrayList<Aktion> _aktionen;

    /**
     * @param aktion
     */
    public void hinzfuegen(Aktion aktion) {
        // TODO implement here
        _aktionen.add(aktion);
    }

    /**
     */
    public void ausgabe() {
     
        System.out.println(GetKopfzeile());
        for (int i = 0; i <= _aktionen.size(); i++){
            String aktion = aktionToString(_aktionen.get(i));
            System.out.println();
        }
    }
    
    private String aktionToString(Aktion aktion)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(" ").append(_aktionen.size()).append(" ");
        builder.append(" ").append(aktion.getWaggonNo()).append(" ");
        builder.append(aktion.getVon().getGleisTyp());
        builder.append(aktion.getNach().getGleisTyp());
        //builder.append(getWaggonListe(von))
        
        
        return null;
    }
    
    private String GetKopfzeile()
    {
        return "Aktion | Waggon |    von     |    nach    |  Zuggleis | Rangiergleis | Abstellgleis";
    }   
    
    private String getWaggonListe(Gleis gleis)
    {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<=gleis.getWaggons().size(); i++)
            builder.append(gleis.getWaggons().get(i)).append(" ");
        
        return builder.toString();
    }
    
    

}