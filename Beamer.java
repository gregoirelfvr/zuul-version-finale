
/**
 * Write a description of class Beamer here.
 *
 * @author LEFEVRE Gregoire
 * @version vFinale
 */
public class Beamer extends Item
{
   private Room aChargeRoom;
   private boolean aCharge = false;
   /**
    * Constructeur Beamer
    */
   public Beamer(){
       super("beamer","an item which can used to teleport",10);
       this.aChargeRoom = null;
   }//Beamer()
   
   /**
    * Methode chargeBeamer(final Room pRoom)
    * 
    * @param pRoom
    */
   public void chargeBeamer( final Room pRoom){
       this.aChargeRoom = pRoom;
       this.aCharge = true;
   }
   
   /**
    * Fonction qui retourne la room charger dans le beamer
    */
   public Room fireBeamer(){
       this.aCharge = false;
       return this.aChargeRoom;
   } 
   
   /**
    * Boolean qui indique si le beamer est charge ou pas 
    */
   public boolean isCharged(){
       return this.aCharge;
   }
}
