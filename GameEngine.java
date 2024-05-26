import java.net.URL;   
import java.lang.*;  
import java.util.Stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * GameEngine classe qui gere le nouvel engin
 *
 * @author LEFEVRE Gregoire
 * @version V4
 */
public class GameEngine
{
    private Parser        aParser;
    private UserInterface aGui;
    private Player        aPlayer;
    private int           aTime;
    private Beamer        aBeamer;
    private boolean       aCheckBeamer;
    private boolean       aCheckRobot;
    private RoomList      aRoomList;
    private String        aStringAlea;
    private boolean       aBooleanAlea;
    private boolean       aModeTest;

    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.aBeamer = new Beamer();
        this.aCheckBeamer = false;
        this.aCheckRobot = false;
        this.aRoomList = new RoomList();
        this.aStringAlea = "";
        this.aBooleanAlea = false;
        this.aModeTest = false;
        this.createRooms();
    }//GameEngine()
    
    /**
     * setGUI : met en place le GUI
     * 
     * @param pUserInterface parametre
     */
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    }//setGUI()
    
    /**
    * procedure printWelcome()qui souhaite la bienvenue au joueur
    * 
    */
    private void printWelcome()
    {
        this.aGui.print( "\n" );
        this.aGui.println("Akira....Akira....bzz...can you here me ?"); 
        this.aGui.println("We need you to come and pick up your robot in the base to defend the city ! ");
        this.aGui.println("CyberBots will attack the city very soon and all the other pilots are away...");
        this.aGui.println("Type 'help' in the command bar if you need help from your AI guide :)");
        this.aGui.print("\n");
        this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
        if ( this.aPlayer.getCurrentRoom().getImageName() != null )
            this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
    }//printWelcome()
    
    /**
     * Procedure creatRooms()
     * 
     */
    private void createRooms()
    {
        //## 1ere partie 
        
        Room vChambre = new Room("in your bedroom.","roomoneone.png");
        Room vEntree = new Room("in the entrance of your studio.","room2.png");
        Room vRDC = new Room("in the main entrance of your building.","RDC.png");
        Room vRDC2 = new Room("in the second part of the main entrance.Behind there is the infamous Dark Alley.","rdc2.png");
        Room vDarkAlley = new Room("in the shady Dark Alley. Be careful.","darkalley.png");
        Room vLocauxPoubelles = new Room("where the trash is disposed.","trash.png");
        Room vBar = new Room(" in the Shibuya Bar. Get yourself a drink !","bar.png");
        Room vShibuyaDis = new Room("in the Shibuya District.","shibuya.png");
        Room vShibuyaDis2 = new Room("still in the Shibuya District","shibuyadis2.png");
        Room vSkyScraper = new Room("standing in front of the famous SkyScraper !","skyscraper.png");
        Room vCommerces = new Room("in the Shopping District near Shibuya. Maybe you can find intersting things here.","shops.png");
        Room vRestaurant = new Room("in the Shibuya Restaurant. Welcome.","resto.png");
        Room vCyberShop = new Room("in the CyberShop. You can get implants to upgrade your abilities here.","cybershop.png");
        Room vElevator = new Room("in the elevator that leads to the base.","elevator.png");
        Room vBunker = new Room("in the bunker of the military base.","bunker.png");
        Room vControlRoom = new Room("in the control room of the base.","controlroom.png");
        Room vRobotRoom = new Room("in the huge space where they store EVA-009, your mecha","robotroom.png"); //TRANSPORT ROOM
        Room vWeaponRoom = new Room("in the armament room where they store all kinds of weapons.","weaponroom.png"); 
        Room vEquipRoom = new Room("in the equipement room where they keep armor and stuff.","equiproom.png");
        Room vInfirmerie = new Room("in the infirmary. You can rest for a bit here.","infirmerie.png");
        
        Room vIpoTest = new Room("ipo test", "skyscraper.png");
        
        //## RoomList
        
        this.aRoomList.addRoom(0,vChambre);
        this.aRoomList.addRoom(1,vEntree);
        this.aRoomList.addRoom(2,vRDC);
        this.aRoomList.addRoom(3,vRDC2);
        this.aRoomList.addRoom(4,vDarkAlley);
        this.aRoomList.addRoom(5,vLocauxPoubelles);
        this.aRoomList.addRoom(6,vBar);
        this.aRoomList.addRoom(7,vCyberShop);
        this.aRoomList.addRoom(8,vShibuyaDis);
        this.aRoomList.addRoom(9,vShibuyaDis2);
        this.aRoomList.addRoom(10,vSkyScraper);
        this.aRoomList.addRoom(11,vCommerces);
        this.aRoomList.addRoom(12,vRestaurant);
        this.aRoomList.addRoom(13,vElevator);
        this.aRoomList.addRoom(14,vBunker);
        this.aRoomList.addRoom(15,vControlRoom);
        this.aRoomList.addRoom(16,vRobotRoom);
        this.aRoomList.addRoom(17,vInfirmerie);
        
        this.aRoomList.addRoom(18,vIpoTest);
        
        //## 2eme Partie (utiliser setExit)
        
        vIpoTest.setExit("south",vChambre);
        //chambre
        vChambre.setExit("north",vIpoTest);
        vChambre.setExit("south", vEntree);
        //Entree
        vEntree.setExit("east",vRDC);
        vEntree.setExit("north",vChambre);
        //RDC
        vRDC.setExit("west",vEntree);
        vRDC.setExit("east",vRDC2);
        vRDC.setExit("south",vShibuyaDis);
        //RDC2
        vRDC2.setExit("east",vDarkAlley);
        vRDC2.setExit("west",vRDC);
        //Dark Alley
        vDarkAlley.setExit("north",vLocauxPoubelles);
        vDarkAlley.setExit("west",vRDC2);
        //Locaux Poubelles
        vLocauxPoubelles.setExit("south",vDarkAlley);
        //Bar
        vBar.setExit("east",vCommerces);
        //Restaurant,Bar,CyberShop
        vRestaurant.setExit("west",vCommerces);
        vCyberShop.setExit("north",vCommerces);
        vBar.setExit("east",vCommerces);
        //Shibuya District 
        vShibuyaDis.setExit("north",vRDC);
        vShibuyaDis.setExit("south",vShibuyaDis2);
        //Shibuya District 2
        vShibuyaDis2.setExit("east", vElevator);
        vShibuyaDis2.setExit("north",vShibuyaDis);
        vShibuyaDis2.setExit("west",vSkyScraper);
        vShibuyaDis2.setExit("south", vCommerces);
        //Commerces
        vCommerces.setExit("north",vShibuyaDis2);
        vCommerces.setExit("east",vRestaurant);
        vCommerces.setExit("west",vBar);
        vCommerces.setExit("south",vCyberShop);
        //SkyScraper
        vSkyScraper.setExit("east",vShibuyaDis2);
        //Elevator 
        vElevator.setExit("west",vShibuyaDis2);
        vElevator.setExit("down",vBunker);
        //Bunker
        vBunker.setExit("east",vWeaponRoom);
        //Control Room
        vControlRoom.setExit("south", vWeaponRoom);
        vControlRoom.setExit("east", vInfirmerie);
        vControlRoom.setExit("north",vRobotRoom);
        //Robot Room
        vRobotRoom.setExit("south",this.aRoomList.getRandomRoom());
        //vWeaponRoom
        vWeaponRoom.setExit("west",vBunker);
        vWeaponRoom.setExit("north",vControlRoom);
        vWeaponRoom.setExit("east",vEquipRoom);
        //vEquipRoom
        vEquipRoom.setExit("west",vWeaponRoom);
        vEquipRoom.setExit("north",vInfirmerie);
        //vInfirmerie
        vInfirmerie.setExit("south",vEquipRoom);
        vInfirmerie.setExit("west", vControlRoom);
        
        
        
        //## Objets
        Item vJacket = new Item("jacket","a faithful leather jacket",10);
        Item vJacketB = new Item("jacketb","a faithful leather black jacket",10);
        Item vPants = new Item("pants","faithful leather pants",15);
        Item vPistol = new Item("pistol","a .9mm pistol", 101);
        Item vRobotEva =  new Item("robot","your trustworthy mecha",500);
        
        vEquipRoom.getItemList().addItem("jacketb",vJacketB);
        vEquipRoom.getItemList().addItem("pants",vPants);
        vChambre.getItemList().addItem("jacket",vJacket);
        vChambre.getItemList().addItem("jacketb",vJacketB);
        vChambre.getItemList().addItem("pistol",vPistol);
        vRobotRoom.getItemList().addItem("robot",vRobotEva);
        //## Personnages
        
        Character vJoker = new Character("Joker","...",vBar);
        Character vDoctor = new Character("Doctor","Hello how can I help you?",vInfirmerie);
        Character vSoldier = new Character("Soldier","Came here to pickup a weapon ?",vWeaponRoom);
        Character vGirl = new Character ("Girl","....What do you want ?", vCommerces);
        
        vBar.getCharacterList().setCharacters(vJoker);
        vInfirmerie.getCharacterList().setCharacters(vDoctor);
        vWeaponRoom.getCharacterList().setCharacters(vSoldier);
        vCommerces.getCharacterList().setCharacters(vGirl);
        
        //## Magic cookie
        Item vPill = new Item("pill","a pill that increases strength", 0); 
        vCyberShop.getItemList().addItem("pill",vPill);
        
        //## Beamer
        
        
        vChambre.getItemList().addItem("beamer",this.aBeamer);
        
        //## Player
        
        this.aPlayer = new Player(vChambre,"Akira");
        
    }//createRooms
    
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     * 
     */
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );
        String vCommand1 =""+vCommand.getCommandWord();
        String vCommand2 =""+vCommand.getSecondWord();
        
        int index = 0;
        if(vCommand1.equals("help")){
            index = 1;
        }
        else if(vCommand1.equals("quit")){
            index = 2;
        }
        else if(vCommand1.equals("go")){
            index = 3;
        }
        else if(vCommand1.equals("test")){
            index = 4;
            this.aModeTest = true;
        }
        else if(vCommand1.equals("back")){
            index = 5;
        }
        else if(vCommand1.equals("take")){
            index = 6;
        }
        else if(vCommand1.equals("drop")){
            index = 7;
        }
        else if(vCommand1.equals("bag")){
            index = 8;
        }
        else if(vCommand1.equals("weight")){
            index = 9;
        }
        else if(vCommand1.equals("charge")){
            index = 10;
        }
        else if(vCommand1.equals("fire")){
            index = 11;
        }
        else if(vCommand1.equals("alea")){
            index = 12;
        }
        else if(vCommand1.equals("talk")){
            index = 13;
        }
        
        switch(index){
            case 1 ://help
                this.printHelp();
                break;
            case 2 ://quit
                if ( vCommand.hasSecondWord() ){
                    this.aGui.println( "Quit what?" );
                    break;
                }
                else{
                    this.endGame();
                    break;
                }
                
            case 3 ://go
                if(!vCommand.hasSecondWord()){
                    this.aGui.println("Go where?");
                    break;
                }
                else{
                    if(this.aTime <= 20){
                        this.goRoom(vCommand);
                        this.aTime += 1;  
                        if(this.aPlayer.getInventory() != null){
                            if((this.aCheckRobot)){
                                this.aGui.println("You came for us !!");
                                this.aGui.println("When going up to the city you hear screams of people being attacked....");
                                this.aGui.println("You have won the game ?!");
                                this.endGame();
                            }  
                        }
                        if(this.aPlayer.getCurrentRoom() != null){
                            if(this.aPlayer.getCurrentRoom().getDescription().equals("where the trash is disposed.")){
                            this.aGui.println("You feel dizzy as if you were just stabbed....");
                            this.endGame();
                            }
                        }
                        
                        break;
                    }
                    else{
                        this.aGui.println("You have no time left, the bomb is exploding.....END");
                        this.endGame();
                        break;
                    }
                }
            case 4 ://test
                
                if(!vCommand.hasSecondWord()){
                    this.aGui.println("test what ?");
                    return;
                }   
                String vMotFichier = ""+ vCommand.getSecondWord()+".txt";
                Scanner vScan;
                try {
                   vScan = new Scanner(new File(vMotFichier)); 
                   while(vScan.hasNextLine()){
                       String vLigne = vScan.nextLine();
                       interpretCommand(vLigne);
                   }
                   
                }
                catch(final FileNotFoundException pFNFE ){
                    this.aGui.println("File not found");
                }
                break;
            case 5 ://
                if ( vCommand.hasSecondWord() ){
                    this.aGui.println( "Back where?" );
                    break;
                }
                else{
                    if(this.aPlayer.canBack()){
                        if(this.aPlayer.getPreviousRoom() != null){    
                            if(!this.aPlayer.getCurrentRoom().isExit(this.aPlayer.getPreviousRoom())){
                                 this.aGui.println("You are trapped");
                                 return;
                            }
                            else{
                                //Stack vPreviousRooms = this.aPlayer.getPreviousRooms();
                                this.aPlayer.setCurrentRoom(this.aPlayer.getPreviousRoom());
                                //this.aPlayer.setPreviousRooms(vPreviousRooms);
                                this.aTime += 1;  
                                this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
                                if ( this.aPlayer.getCurrentRoom().getImageName() != null ){
                                    this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
                                    break;
                                }
                            }
                        }
                }
                else{
                        this.aGui.println( "Can't back here" ); 
                        break;
                    }
                }
                
            case 6 :
                
                
                if(this.aPlayer.getCurrentRoom().isInRoom(this.aPlayer.getCurrentRoom().getItemList().getItem(vCommand2))){
                    if((this.aPlayer.getCurrentRoom().getItemList().getItem(vCommand2)) != null){
                        if(this.aPlayer.getCurrentPoids() + this.aPlayer.getCurrentRoom().getItemList().getItem(vCommand2).getPoidsItem()  <= this.aPlayer.getMaxPoids()){
                            int vPoids = this.aPlayer.getCurrentPoids()+(this.aPlayer.getCurrentRoom().getItemList().getItem(vCommand2)).getPoidsItem();
                            this.aPlayer.setCurrentPoids(vPoids);
                            if(this.aPlayer.getCurrentRoom().getItemList().getItem(vCommand2).getDescriptionItem() != null){
                                this.aGui.println("You have picked up " + this.aPlayer.getCurrentRoom().getItemList().getItem(vCommand2).getDescriptionItem());
                            }
                            if((this.aPlayer.getCurrentRoom().getItemList().getItem(vCommand2)).getNomItem().equals(this.aBeamer.getNomItem())){
                                this.aCheckBeamer = true;
                                this.aGui.println("You picked up the beamer !");
                            }  
                            else if((this.aPlayer.getCurrentRoom().getItemList().getItem(vCommand2)).getNomItem().equals("pill")){
                                this.aPlayer.setMaxPoids(1000);
                            }
                            else if((this.aPlayer.getCurrentRoom().getItemList().getItem(vCommand2)).getNomItem().equals("robot")){
                                this.aGui.println("Access authorized...");
                                this.aCheckRobot = true;
                            }
                            this.aPlayer.take(vCommand2);
                        }
                        else{
                            this.aGui.println("This item cannot be picked up, it's too heavy");
                            return;
                        }
                    }
                    this.aGui.println(this.aPlayer.getInventory().getItemString());
                    this.aGui.println(this.aPlayer.getCurrentRoom().getItemList().getItemString());
                    
                }
                else{
                    this.aGui.println("not in room");
                }
                break;
            case 7:
                if(this.aPlayer.isInInventory(this.aPlayer.getInventory().getItem(vCommand2))){
                    this.aPlayer.drop(vCommand2);
                    int vPoids = this.aPlayer.getCurrentPoids()-(this.aPlayer.getInventory().getItem(vCommand2)).getPoidsItem();
                    this.aPlayer.setCurrentPoids(vPoids);
                    if(this.aPlayer.getCurrentRoom().isInRoom(this.aPlayer.getCurrentRoom().getItemList().getItem(vCommand2))){
                        this.aGui.println("You droped the beamer !");
                        this.aCheckBeamer = false;
                    }
                    this.aGui.println(this.aPlayer.getInventory().getItemString());
                    this.aGui.println(this.aPlayer.getCurrentRoom().getItemList().getItemString());
                    
                }
                else{
                    this.aGui.println("not in inventory");
                    
                }
                break;
            case 8 :
                this.aGui.println(this.aPlayer.getInventory().getItemString());
                //String vS = ""+this.aPlayer.getInventoryWeight();
                //this.aGui.println(vS);
                break;
            case 9 :
                this.aGui.println("Max weight to carry :"+this.aPlayer.getMaxPoids());
                this.aGui.println("Current weight : "+ this.aPlayer.getCurrentPoids());
                break;
            
            case 10 :
                
                if(this.aCheckBeamer){
                   this.aGui.println("The Beamer is charging");
                   this.aBeamer.chargeBeamer(this.aPlayer.getCurrentRoom()); 
                }
                else{
                    this.aGui.println("You dont have the beamer ....");
                    } 
                
                break;
            
                
                
            case 11 :
                if(this.aCheckBeamer){
                    if(this.aBeamer.isCharged()){
                    this.aGui.println("The Beamer is firing");
                    this.aPlayer.setCurrentRoom(this.aBeamer.fireBeamer());

                    }
                    else{
                    this.aGui.println("The beamer is not charged");
                    }
                }
                else{
                    this.aGui.println("You don't have the beamer ....");
                }
                
                
                if( this.aPlayer.getCurrentRoom().getImageName() != null ){
                        this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
                        break;
                        }
                
                break;
                
            case 12 :
                
                if(this.aPlayer.getCurrentRoom().getDescription().equals("in the huge space where they store EVA-009, your mecha")){
                    this.aBooleanAlea = true;
                }
                
                
                if(this.aModeTest && this.aBooleanAlea){
                    if(vCommand.hasSecondWord()){
                        String vS = vCommand.getSecondWord();
                        int vRoomNumber = 0;
                        switch(vS){
                            case "entree" :
                                vRoomNumber = 1;
                                break;
                            case "rdc" :
                                vRoomNumber = 2;
                                break;
                            case "rdc2" :
                                vRoomNumber = 3;
                                break;
                            case "darkalley" :
                                vRoomNumber = 4;
                                break;
                            case "locaux" :
                                vRoomNumber = 5;
                                break;
                            case "bar" :
                                vRoomNumber = 6;
                                break;
                            case "cybershop" :
                                vRoomNumber = 7;
                                break;
                            case "shibuya" :
                                vRoomNumber = 8;
                                break;
                            case "shibuya2" :
                                vRoomNumber = 9;
                                break;
                            case "skyscraper" :
                                vRoomNumber = 10;
                                break;
                            case "commerces" :
                                vRoomNumber = 11;
                                break;
                            case "restaurant" :
                                vRoomNumber = 12;
                                break;
                            case "elevator" :
                                vRoomNumber = 13;
                                break;
                            case "bunker" :
                                vRoomNumber = 14;
                                break;
                            case "control" :
                                vRoomNumber = 15;
                                break;
                            case "robotroom" :
                                vRoomNumber = 16;
                                break;
                            case "infirmerie" :
                                vRoomNumber = 17;
                                break;
                            default :
                                vRoomNumber = 0;
                                break;
                        }
                        this.aPlayer.setCurrentRoom(this.aRoomList.getRoom(vRoomNumber));
                        this.aModeTest = false;
                        if( this.aPlayer.getCurrentRoom().getImageName() != null ){
                            this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
                            break;
                        }
                    }
                }
                break;
            case 13 :
                if ( !vCommand.hasSecondWord() ){
                    this.aGui.println( "Talk to who ?" );
                    break;
                }
                else{
                    if(this.aPlayer.getCurrentRoom().getCharacterList() != null){
                        if(this.aPlayer.getCurrentRoom().getCharacterList().getCharacter(vCommand2) != null){
                           this.aGui.println(this.aPlayer.getCurrentRoom().getCharacterList().getCharacter(vCommand2).getDialogue()); 
                           
                           if(this.aPlayer.getCurrentRoom().getCharacterList().getCharacter(vCommand2).getName() == "Doctor"){
                               this.aPlayer.getCurrentRoom().getCharacterList().getCharacter(vCommand2).setDialogue("You need to get a pill somwhere in the CyberShop to increase physical strength");
                           }
                           
                           if(this.aPlayer.getCurrentRoom().getCharacterList().getCharacter(vCommand2).getName() == "Girl"){
                               this.aPlayer.getCurrentRoom().getCharacterList().getCharacter(vCommand2).setDialogue(".........");
                           }
                           
                           if(this.aPlayer.getCurrentRoom().getCharacterList().getCharacter(vCommand2).getName() == "Soldier"){
                               this.aPlayer.getCurrentRoom().getCharacterList().getCharacter(vCommand2).setDialogue("I can give you ");
                           }
                           
                           
                        }
                        else{
                            this.aGui.println("There's no people by this name here.");
                        }
                    }
                    break;
                }
                
                
            default :
                this.aGui.println( "I don't know what you mean..." );
                break;
        }
    }//interpretCommand()
    
    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        this.aGui.println(" ");
        this.aGui.println( "You are a pilot !" );
        this.aGui.println( "Go help the city. Start by getting your equipement" + "\n" );
        this.aGui.println( "Your command words are: " + this.aParser.showCommands() );
    }//printHelp()
    
    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom( final Command pCommand ) 
    {
        String vDirection = pCommand.getSecondWord();
        if ( this.aPlayer.getCurrentRoom().getExit(vDirection) == null )
            this.aGui.println( "There is no door!" );
        else {
            this.aPlayer.getPreviousRooms().push(this.aPlayer.getCurrentRoom());
            this.aPlayer.goRoom(vDirection);
            this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
            if ( this.aPlayer.getCurrentRoom().getImageName() != null ){
                Room vRoomPlay =this.aPlayer.getCurrentRoom();
                this.aGui.showImage(vRoomPlay.getImageName() );
            }
        }

        
    }//goRoom()
        
    /**
     * methode eat()
     */    
    
    private void eat(){
        System.out.println("You have eaten now and you are not hungry anymore");
    }//eat()
    
    /**
     * Procedure printLocation() 
     */
    private void printLocationInfo(){
        System.out.println("You are " + this.aPlayer.getCurrentRoom().getDescription());
        System.out.print(this.aPlayer.getCurrentRoom().getExitString());
        System.out.println(this.aPlayer.getCurrentRoom().getItemList().getItemString());
        System.out.println();

    }//printLocationInfo()
    
    /**
     * methode quit
     */
    private boolean quit(final Command pQuitWhat)
    {
      if(pQuitWhat.hasSecondWord()){
        System.out.println("Quit what ?");
        return false;
      }
      else{
        return true;  
      }
    }//quit
    
    /**
     * endGame() : termine la partie du joueur 
     */
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }//endGame()
    
}
