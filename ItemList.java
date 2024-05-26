import java.util.HashMap;
import java.util.Set;
/**
 * Write a description of class ItemList here.
 *
 * @author LEFEVRE Gregoire
 * @version vFinale
 */
public class ItemList
{
   private HashMap <String, Item> aItems;
   private String aTypeList;
   
   public ItemList(final String pTypeList){
       this.aItems = new HashMap<String,Item>();
       this.aTypeList = pTypeList;
   }
   
   /**
     * Getter de l'Item en String
     */
    public String getItemString(){
        if(this.aItems != null){
            if(this.aTypeList.equals("inventory")){
                String vAll = "Inventory :";
                Set<String> keys = this.aItems.keySet();
                for(String item : keys) {
                  vAll += " "+ item;  
                }
                return vAll;
            }
            else if(this.aTypeList.equals("room")){
                String vAll = "Items here :";
                Set<String> keys = this.aItems.keySet();
                for(String item : keys) {
                  vAll += " "+ item;  
                }
                return vAll;
            }
            else{
                return "";
            }
        }
        else{
            return "No item here";
        }
    }//getItemString()
    
   /**
   * getter getItem() retourne l'Item dans la Hashmap
   * @param pItem
   */
   public Item getItem(final String pItem){
        return this.aItems.get(pItem);
    }
   
   /**
   * getter getItems() retourne la Hashmap
   */
   public HashMap getItems(){
        return this.aItems;
    }
    
   /**
     * Ajoute un Item 
     */
    public void addItem(final String pNom,final Item pItem){
        this.aItems.put(pNom,pItem);  
    }//addItem()
   
   /**
     * Enleve un Item 
     * @param pNom
     */
    public void removeItem(final String pNom){
        this.aItems.remove(pNom);  
    }//removeItem() 
    
   /**
    *  ajoute un item sans son nom
    *  @param pItem
    */
   public void setItems(final Item pItem){
       this.aItems.put(pItem.getNomItem(),pItem);
   }
    
}
