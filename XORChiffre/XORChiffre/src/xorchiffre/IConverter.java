package xorchiffre;
import java.util.*;

/**
 * 
 */
public interface IConverter {


    /**
     * 
     */
    public void Convert();
    public String AdjustKeyLength(String text,String keystring);

}