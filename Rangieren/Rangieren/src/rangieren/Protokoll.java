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
        ArrayList<Waggon> waggons = gleis.getWaggons();
        for(int i = 0; i <= waggons.size() - 1;i++)
           builder.append(waggons.get(i).getWaggonNo()).append((i == waggons.size()) ? " |" : " ");
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
        for (int i = 0; i <= _aktionen.size() - 1; i++){
            String aktion = aktionToString(_aktionen.get(i), i);
            System.out.println(aktion);
        }
    }
    
    private String aktionToString(Aktion aktion, int index)
    {
        StringBuilder builder = new StringBuilder();
        builder.append(" ").append(index+1).append(" | ");
        builder.append(" ").append(aktion.getWaggonNo()).append(" | ");
        builder.append(" ").append(aktion.getVon().getGleisTyp()).append(" | ");
        builder.append(" ").append(aktion.getNach().getGleisTyp()).append(" | ");
        builder.append(" ").append(aktion.getWaggonStrings());
        return builder.toString();
    }
    
    private String GetKopfzeile()
    {
        return "Aktion | Waggon |    von     |    nach    |  Zuggleis | Rangiergleis | Abstellgleis";
    }   
}