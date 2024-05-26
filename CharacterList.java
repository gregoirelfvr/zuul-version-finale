import java.util.HashMap;
import java.util.Set;
/**
 * Write a description of class CharacterList here.
 *
 * @author LEFEVRE Gregoire
 * @version vFinale 
 */
public class CharacterList
{
    private HashMap<String,Character> aCharacters;
    /**
     * Constructeur CharcaterList()
     */
    public CharacterList(){
        this.aCharacters = new HashMap<String,Character>();
    }//CharacterList
    
    /**
     * Accesseur en String des Personnages present dans la piece
     */
    public String getCharacterString(){
        if(this.aCharacters != null){
            String vAll = "People here :";
            Set<String> keys = this.aCharacters.keySet();
            for(String character : keys) {
                vAll += " "+ character;  
            }
            return vAll;
        }
        else{
            return "";
        }
    }//getCharacterString()
    
    /**
     * Accesseur du Personnage present dans la HashMap
     * @param pCharacter
     */
    public Character getCharacter(final String pCharacter){
        return this.aCharacters.get(pCharacter);
    }//getCharacter()
    
    /**
     * Permet d'enlever un Personnage de la HashMap
     * @param pName
     */
    public void removeCharacter(final String pName){
        this.aCharacters.remove(pName);  
    }//removeCharacter()
    
   /**
    * Methode permettant d'ajouter un Personnage a la HashMap
    * 
    * @param pCharacter
    */
    public void setCharacters(final Character pCharacter){
       this.aCharacters.put(pCharacter.getName(),pCharacter);
   }//setCharacters()
   
}
