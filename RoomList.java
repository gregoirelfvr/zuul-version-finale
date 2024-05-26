import java.util.HashMap;
import java.util.Set;
import java.lang.Math;
/**
 * Write a description of class RoomList here.
 *
 * @author LEFEVRE Gregoire
 * @version vFinale
 */
public class RoomList
{
    private HashMap <Integer, Room> aRooms;

   /**
    * Constructeur de RoomList
    */
   public RoomList(){
        this.aRooms = new HashMap<Integer, Room>();
   }
    
    
   /**
   * Accesseur getRoom() retourne la Room dans la Hashmap
   * @param pInt
   */
   public Room getRoom(final int pInt){
        return this.aRooms.get(pInt);
    }
    
   /**
   * Accesseur getRooms() retourne la Hashmap
   */
   public HashMap getRooms(){
        return this.aRooms;
    }
    
   /**
     * Ajoute une Room
     * @param pInt
     * @param pRoom
     */
    public void addRoom(final int pInt,final Room pRoom){
        this.aRooms.put(pInt,pRoom);  
    }

   /**
   * getter getRooms() retourne la Hashmap
   * 
   */
   public Room getRandomRoom(){
        int vRandom = (int)(Math.random()*(17));
        if(vRandom <= 17){
            return getRoom(vRandom);
        }
        else{
            return getRoom(0);
        }
    } 
}
