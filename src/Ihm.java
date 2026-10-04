import clavier.In;

import java.util.Scanner;

public class Ihm {
    public static void main(String[] args) {
        // Initialisation variables
        String classementJoueur = 0;
        String classementAdversaire = 0;
        int victoires = 0;
        int points = 0;
        int choixMenu = 0;

        // Affichage Menu
        System.out.println("Choisir l'action à realiser :\n" +
                "1 : Afficher votre nombre maximum de victoires actuelles ainsi que votre capital de point de depart\n" +
                "2 : Afficher le nombre de victoires auquel vous avez reellement droit, selon votre classement\n" +
                "3 : Afficher les points de chaque victoire, points totaux et actualiser votre classement\n" +
                "4 : Afficher les matchs gagnes pris en compte afin d'actualiser votre classement");
        choixMenu = In.readInteger();


        switch (choixMenu) {
            case 1:
                System.out.println("Rentrez votre classement, exemple : \nNC => Non Classe, 40, 30/4, etc.");
                classementJoueur = In.readString();
                switch (classementJoueur) {
                    case "NC", "40", "30/5", "30/4":
                        System.out.println("Vous avez 5 Victoires maximum actuellement");
                        break;
                    case "30/3", "30/2", "30/1", "30", "15/5", "15/4":
                        System.out.println("Vous avez 6 Victoires maximum actuellement");
                        break;
                    default:
                        System.out.println("Classement invalide, veuillez resaisir votre classement");
                        return;
                    break;
                }
                switch (classementJoueur) {
                    case "NC":
                        System.out.println("Vous avez 0 points");
                        break;
                    case "40":
                        System.out.println("Vous avez 2 points");
                        break;
                    case "30/5":
                        System.out.println("Vous avez 5 points");
                        break;
                    case "30/4":
                        System.out.println("Vous avez 10 points");
                        break;
                    case "30/3":
                        System.out.println("Vous avez 20 points");
                        break;
                    case "30/2":
                        System.out.println("Vous avez 30 points");
                        break;
                    case "30/1":
                        System.out.println("Vous avez 50 points");
                        break;
                    case "30":
                        System.out.println("Vous avez 80 points");
                        break;
                    case "15/5":
                        System.out.println("Vous avez 120 points");
                        break;
                    case "15/4":
                        System.out.println("Vous avez 160 points");
                        break;
                    default:
                        System.out.println("Classement invalide");
                        break;
                }
            case 2:
                System.out.println("Rentrez votre classement, exemple : \nNC => Non Classe, 40, 30/4, etc.");
                classementJoueur = In.readString();
                classementAdversaire = In.readString();
                break;

            case 3:

                break;

            case 4:

                break;

            default:

                return;

        }
    }
}
