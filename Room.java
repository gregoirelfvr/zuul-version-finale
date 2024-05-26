import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author LEFEVRE Gregoire 
 * @version V4
 */

public class Room
{
    //Attributs
    private String aDescription;
    private HashMap<String, Room> aExits;
    private ItemList aItemsRoom;
    private String aImageName;
    private Item aItem;
    private CharacterList aCharacters;
    
    /**
    * Constructeur naturel Room
    * @param pDescription
    * @param pImage
    */
    public Room(final String pDescription, final String pImage )
    {
      this.aDescription = pDescription;  
      aExits = new HashMap<String, Room>();
      aCharacters = new CharacterList();
      aItemsRoom = new ItemList("room");
      this.aImageName = pImage;
    }//Constructeur naturel
    
    /**
     * Accesseur de la liste d'objets dans la piece
     * 
     */
    public ItemList getItemList(){
        return this.aItemsRoom;
    }//getItemList()
    
    /**
     * Accesseur de de la liste de Personnages dans la piece
     */
    public CharacterList getCharacterList(){
        return this.aCharacters;
    }
    
    /**
    * Accesseur de la Description
    * 
    */
    public String getDescription()
    {
     return this.aDescription;  
    }//getDescription
    
    /**
     * Procedure setExit(String vDirection, Room vSetExit);
     */
    public void setExit(String vDirection, Room vSetExit){
        aExits.put(vDirection, vSetExit);
    }//setExit()
    
    /**
     * methode getExit();
     * 
     * @return La sortie en fonction de la direction
     */
    public Room getExit(final String pDirection){
        return this.aExits.get(pDirection);
    }//getExit()
    
    /**
     * getExitString
     * 
     * @return Les sorties de la piece 
     */
    public String getExitString(){
        String vAll = "Exits:";
        Set<String> keys = this.aExits.keySet();
        for(String exit : keys) {
          vAll += " "+ exit;  
        }
        return vAll;
    }//getExitString();
    
    /**
     * Renvoie une description plus detaillee de cette piece 
     * 
     * @return Une description de la piece avec ses sorties 
     */
    public String getLongDescription(){
        return "You are "+ aDescription + ".\n" + this.aItemsRoom.getItemString() + ".\n"+ getExitString() + ".\n"+ this.aCharacters.getCharacterString();
        
    }//getLongDescription()
    
    /**
     * Accesseur du nom de l'Image 
     */
    public String getImageName()
    {
         return this.aImageName;
    }//getImageName()
    
    /**
     * Verifie si un objet est dans une piece
     */
    public boolean isInRoom(final Item pItem){
        if(this.aItemsRoom.getItems().containsValue(pItem)){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * Verifie si la piece rentrer en parametre est une sortie
     */
    public boolean isExit(final Room pRoom){
        return this.aExits.containsValue(pRoom);
    }//isExit
}// Room 
