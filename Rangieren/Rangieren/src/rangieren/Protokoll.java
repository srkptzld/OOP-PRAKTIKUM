package rangieren;

import java.util.ArrayList;

/**
 * 
 * @author sirkpetzold
 */
public class Protokoll {

    /**
     * Default constructor
     * @param zuggleis
     * @param rangiergleis
     * @param abstellgleis
     */
    public Protokoll(Gleis zuggleis, Gleis rangiergleis, Gleis abstellgleis) {
        _aktionen = new ArrayList<>();
        
        _abstellgleis = abstellgleis;
        _rangiergleis = rangiergleis;
        _zuggleis = zuggleis;
    }

    private String buildGleisString(Gleis gleis)
    {
        StringBuilder builder = new StringBuilder();         
        for(int i = gleis.getWaggons().size(); i >= 0;i--)
           builder.append(gleis.getWaggons().get(i)).append((i == gleis.getWaggons().size()) ? " " : "");
        return builder.toString();
    }
    /**
     * 
     */
    private ArrayList<Aktion> _aktionen;
    private Gleis _zuggleis, _rangiergleis, _abstellgleis;

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
        builder.append(" ").append(_aktionen.size()+1).append(" ");
        builder.append(" ").append(aktion.getWaggonNo()).append(" ");
        builder.append(aktion.getVon().getGleisTyp());
        builder.append(aktion.getNach().getGleisTyp());
        builder.append(buildGleisString(_zuggleis));
        builder.append(buildGleisString(_rangiergleis));
        builder.append(buildGleisString(_abstellgleis));
        return builder.toString();
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