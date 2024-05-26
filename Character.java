
/**
 * Write a description of class Character here.
 *
 * @author LEFEVRE Gregoire
 * @version vFinale
 */
public class Character
{
    private String      aDialogue;
    private String      aName;
    private Room        aRoomChara;
    
    /**
     * Constructeur de Character (Personnages)
     */
    public Character(final String pName, final String pDialogue, final Room pRoomChara){
        this.aName = pName;
        this.aDialogue = pDialogue;
        this.aRoomChara = pRoomChara;
    }//Character()
    
    /**
     * Accesseur du nom du Personnage 
     */
    public String getName(){
        return this.aName;
    }//getName()
    
    /**
     * Accesseur du dialogue du Personnage 
     */
    public String getDialogue(){
        return this.aDialogue;
    }//getDialogue()
    
    /**
     *  Accesseur de la piece dans laquelle se trouve le Personnage
     */
    public Room getRoomChara(){
        return this.aRoomChara;
    }//getRoomChara()
    
    /**
     * Modificateur du nom du Personnage 
     * 
     * @param pString
     */
    public void setName(final String pString){
        this.aName = pString;
    }//setName()
    
    /**
     * Modificateur du dialogue du Personnage
     * 
     * @param pString
     */
    public void setDialogue(final String pString){
        this.aDialogue = pString;
    }//setDialogue()
    
    /**
     * Modificateur de la piece du Personnage 
     */
    public void setRoomChara(final Room pRoom){
        this.aRoomChara = pRoom;
    }//setRoomChara()
}
