import java.util.Stack;
import java.util.HashMap;
import java.util.Set;

/**
 * Write a description of class Player here.
 *
 * @author LEFEVRE Gregoire
 * @version vFinale
 */
public class Player
{
    private Room aCurrentRoom;
    private String aUserName;
    private Room aPreviousRoom;
    private Stack  aPreviousRooms;
    private ItemList aInventory;
    private int aMaxPoids;
    private int aCurrentPoids;
    
    /**
     * Un constructeur naturel de Player
     * @param pCurrentRoom
     * @param pUserName
     */
    public Player(final Room pCurrentRoom, final String pUserName){
        this.aCurrentRoom =pCurrentRoom;
        this.aUserName = pUserName;
        this.aPreviousRooms = new Stack<Room>();
        //# apres ItemList
        this.aInventory = new ItemList("inventory");
        this.aMaxPoids = 100;
        this.aCurrentPoids = 0;
    }
    
    /**
     * Accesseur de la salle ou se situe le joueur
     */
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }
    
    /**
     * getter : retourne le nom du joueur
     */
    public String getUserName(){
        return this.aUserName;
    }
    
    /**
     * getter : retourne la Stack des PreviousrRooms
     */
    public Stack getPreviousRooms(){
        return this.aPreviousRooms;
    }
    
    /**
     * getter : retourne la PreviousRoom
     */
    public Room getPreviousRoom(){
        return this.aPreviousRoom;
    }
    
    /**
     * getter : retourne le poids max du joueur
     */
    public int getMaxPoids(){
        return this.aMaxPoids;
    }
    
    /**
     * getter : retourne le poids courant du joueur 
     */
    public int getCurrentPoids(){
        return this.aCurrentPoids;
    }
    
    /**
     *  un modificateurs du poids courant 
     */
    public void setCurrentPoids(final int pInt){
        this.aCurrentPoids = pInt;
    }
    
    /**
     *  un modificateurs du poids courant 
     */
    public void setCurrentRoom(final Room pRoom){
        this.aCurrentRoom = pRoom;
    }
    
      /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    public void goRoom( final String pDirection ) 
    {
        // Try to leave current room.
        Room vNextRoom = this.aCurrentRoom.getExit( pDirection );
        this.aPreviousRooms.push(this.aCurrentRoom);
        this.aCurrentRoom = vNextRoom;
    }//goRoom()
    
    /**
     * back() : utile pour la fonction interpretCommand() 
     */
    public boolean canBack(){
        if(this.aPreviousRooms.empty()){
            return false;
        }
        else{
            this.aPreviousRooms.pop();
            this.aPreviousRoom = (Room)(this.aPreviousRooms.peek()); 
            this.aPreviousRooms.pop();
            return true;
        }
    }//back()
    
    /**
     *  set la Stack de PreviousRooms
     *  @param pStack
     */
    public void setPreviousRooms(final Stack pStack){
        this.aPreviousRooms = pStack;
    }

    /**
     *  getter de l'inventaire
     */
    public ItemList getInventory(){
        return this.aInventory;
    }
    
    /**
     *  methode take() dans GameEngine
     *  @param pItem
     */
    public void take(final String pItem){
        this.aInventory.addItem(pItem,this.aInventory.getItem(pItem));
        this.aCurrentRoom.getItemList().removeItem(pItem);
    }
    
    /**
     * methode drop() utile dans GameEngine
     * @param pItem
     */
    public void drop(final String pItem){
        this.aCurrentRoom.getItemList().addItem(pItem,this.aInventory.getItem(pItem));
        this.aInventory.removeItem(pItem);
    }
    

    /**
     * methode isInInventory regarde si l'item est dans l'inventaire du joueur
     */
    public boolean isInInventory(final Item pItem){
        if(this.aInventory.getItems().containsValue(pItem)){
            return true;
        }
        else{
            return false;
        }
    }
    
    /**
     * methode modificateur setMaxPoids() 
     */
    public void setMaxPoids(final int pInt){
        this.aMaxPoids = pInt;
    }
    
   /**
     * Fonction poidsTotal()
     */ 
   public int poidsTotal(){
       int vPoids = 0;
       Set<String> keys = this.aInventory.getItems().keySet();
       for(String item : keys) {
            vPoids += this.aInventory.getItem(item).getPoidsItem();  
        }
       
       return vPoids;
   }
   
   /**
   * methode accesseur setInventory()
   * @param pItemList
   */
   public void setInventory(final ItemList pItemList){
       this.aInventory = pItemList;
   }
   
   /**
   * methode MagicCookie()
   * @param pItem
   */
   public boolean MagicCookie(final String pItem){
    if(isInInventory(this.aInventory.getItem(pItem))){
        this.setMaxPoids(200);
        return true;
    }
    else{
        return false;
    }
   }
}
