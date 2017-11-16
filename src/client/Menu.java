
package client;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

import app.Klondike;
import app.Stack;

public class Menu {

    private Stack stack;

    public Menu(Stack stack){
        this.stack = stack;
    }

	private Scanner sc = new Scanner(System.in);

    /*
     * Menu qui s'affiche pour déplacer une carte , quand le plateau est visible
     */
	public String displayMenuDuringGame(){
	    System.out.println("");
	    System.out.println("-------------------------------------------------");
        System.out.print("> Choix : ");

        String choix = sc.next().toLowerCase();

        return choix;
    }

    /*
     * Menu qui s'affiche lors du lancement du jeu
     */
	public Integer displayStartupMenu() {
        System.out.println("****** MENU DU JEU ********");
        System.out.println("1: Démarrer une partie");
        System.out.println("2: Rédemarrer le jeu");
        System.out.println("3: Quitter");
        System.out.print("> Choix : ");

        Integer choix = sc.nextInt();

        while(choix < 1 || choix > 3){
            System.out.print("> Choix : ");
            choix = sc.nextInt();
        }

        return choix;
    }

    /*
     * Actionne une method qui correspond à la saisie d'un utilisateur, (menu de démarrage)
     */
    public void getCorrespondantAction(Integer choix) {
        if( choix == 1 ){

            System.out.println("\n\n\n");

        }else if( choix == 2 ){

            Klondike klondike = new Klondike();
            klondike.launch();

        }else if( choix == 3 ){

            System.exit(0);

        }
    }

    /*
     * Actionne une method qui correspond à la saisie d'un utilisateur, (lors d'une partie)
     */
    public void getGameAction(String choixFrom) {

	    if(Objects.equals(choixFrom, "*")){

            if( !stack.addPiocheCardOnPile() ){
                System.out.println("La pioche est vide ! impossible de piocher une carte !");
            }

        }else{
            int intColFrom = Integer.parseInt(choixFrom);

            System.out.print("> Vers : ");
            Integer intColTo = sc.nextInt();

            stack.move(intColFrom - 1, intColTo - 1); // -1 car l'indexation commence à zéro
        }
    }
}