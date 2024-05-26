
/**
 * Classe pour les objets se trouvant dans les Rooms
 *
 * @author LEFEVRE Gregoire
 * @version v4
 */
public class Item
{
    private String aNom;
    private String aDescription;
    private int aPoids;
    
    /**
     * Constructeur d'Item
     */
    public Item(final String pNom, final String pDescription, final int pPoids){
        this.aNom = pNom;
        this.aDescription = pDescription;
        this.aPoids = pPoids;
    }//Item()
    /**
     * getter du nom de l'Item
     */
    public String getNomItem(){
        return this.aNom;
    }//getNomItem()
    /**
     * getter de la description de l'objet
     */
    public String getDescriptionItem(){
        return this.aDescription;
    }//getDescriptionItem()
    /**
     * getter du poid de l'objet
     */
    public int getPoidsItem(){
        return this.aPoids;
    }//getPoidItem()
    
    /**
     * getter de la longue description de l'objet
     */
    public String getLongDescriptionItem(){
        return "This " + this.aNom +" is a " +getDescriptionItem() + " it weighs " + this.aPoids; 
    }//getLongDescriptionItem();
    
    
}
