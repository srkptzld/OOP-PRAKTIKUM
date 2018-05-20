package rangieren;

import java.util.ArrayList;

/**
 * 
 * @author sirkpetzold
 */
public class Protokoll {

    private ArrayList<Aktion> _aktionen;
    private Gleis _zuggleis, _rangiergleis, _abstellgleis;
    private Integer _spaltenBreite;

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
        _spaltenBreite = abstellgleis.getWaggons().size() * 3;
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
     * Eine Aktion dem Protokoll hinzufügen
     * @param aktion
     */
    public void hinzfuegen(Aktion aktion) {
        // TODO implement here
        _aktionen.add(aktion);
    }

    /**
     * Ausgeben des Protokolls
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
        builder.append(" ").append(String.format("%5d",index+1)).append(" | ");
        builder.append(" ").append(String.format("%5s",aktion.getWaggonNo()) ).append(" | ");
        builder.append(" ").append(String.format("%15s",aktion.getVon())).append(" | ");
        builder.append(" ").append(String.format("%15s",aktion.getNach())).append(" | ");
        builder.append(" ").append(aktion.getWaggonStrings(_spaltenBreite));
        return builder.toString();
    }
    
    private String GetKopfzeile()
    {
        return "Aktion | Waggon | " + 
                String.format("%16s","von") + " |  "+
                String.format("%15s","nach") +" |  " + 
                String.format("%" + _spaltenBreite + "s","Zuggleis") + " | " +  
                String.format("%" + _spaltenBreite + "s","Rangiergleis") + " | " + 
                String.format("%" + _spaltenBreite + "s", "Abstellgleis");
    }   
}