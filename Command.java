 /**
 * Classe Command - une commande du jeu d'aventure Zuul.
 *
 * @author LEFEVRE Gregoire
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /**
     * Constructeur Naturel
     */
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
        
    }//Constructeur Naturel
    
    /**
     * Accesseur 1 CommandWord
     */
    public String getCommandWord()
    {
      return this.aCommandWord;
    }//Accesseur 1
    
    /**
     * Accesseur 2 SecondWord
     */
    public String getSecondWord()
    {
      return this.aSecondWord;
    }//Accesseur 2
    
    /**
     * fonction booleene hasSecondWord
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null; //true ou false
    }//HasSecondWord

    /**
     * fonction booleene isUnknown
     */
    public boolean isUnknown()
    {
        return this.aCommandWord == null;
    }//isUnknown
    
    
    
} // Command
