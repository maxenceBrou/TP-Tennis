import clavier.In;

import java.util.Scanner;

public class Ihm {
    public static void main(String[] args) {
        // Initialisation variables, changement du "_" par un "c" au souhait de Monsieur Foray car meilleur pratique
        final int NC = 1, c40 = 2, c30_5 = 3, c30_4 = 4, c30_3 = 5, c30_2 = 6,
                c30_1 = 7, c30 = 8, c15_5 = 9, c15_4 = 10;

        String sClassement = "";
        int victoiresMax = 0;
        int victoires = 0;
        boolean bonus = 0;
        int points = 0;
        int nmbrDefaites = 0;
        int defaitesEgale = 0;
        int defaites1EchInf = 0;
        int defaites2EchInf = 0;
        int classementAdversaire = 0;

        int formule = 0;


        // Saisie classement de depart
        System.out.println("Rentrez votre classement : " +
                "\nNon classé : 1" +
                "\n40 : 2" +
                "\n30/5 : 3" +
                "\n30/4 : 4" +
                "\n30/3 : 5" +
                "\n30/2 : 6" +
                "\n30/1 : 7" +
                "\n30 : 8" +
                "\n15/5 : 9" +
                "\n15/4 : 10");
        int iClassement = In.readInteger();

        switch (iClassement) {
            case NC:
                sClassement = "Non Classé";
                points = 0;
                victoiresMax = 5;
                break;
            case c40:
                sClassement = "40";
                points = 2;
                victoiresMax = 5;
                break;
            case c30_5:
                sClassement = "30/5";
                points = 5;
                break;
            case c30_4:
                sClassement = "30/4";
                points = 10;
                victoiresMax = 5;
                break;
            case c30_3:
                sClassement = "30/3";
                points = 20;
                victoiresMax = 6;
                break;
            case c30_2:
                sClassement = "30/2";
                points = 30;
                victoiresMax = 6;
                break;
            case c30_1:
                sClassement = "30/1";
                points = 50;
                victoiresMax = 6;
                break;
            case c30:
                sClassement = "30";
                points = 80;
                victoiresMax = 6;
                break;
            case c15_5:
                sClassement = "15/5";
                points = 120;
                victoiresMax = 6;
                break;
            case c15_4:
                sClassement = "15/4";
                points = 160;
                victoiresMax = 6;
                break;
            default:
                sClassement = "Non Classé";
                points = 0;
                victoiresMax = 5;
                System.out.println("Mauvaise valeur entree, vous serez donc : " + sClassement);
                break;
        }
        System.out.println("Votre classement : " + sClassement + ". Vous avez " + points
                + " points, ainsi que " + victoiresMax + " victoires maximum.");

        // Saisie nombre de victoires
        System.out.print("Saisir votre nombre de victoires : ");
        victoires = In.readInteger();


        System.out.println("Saisir votre nombre de défaites");
        nmbrDefaites = In.readInteger();

        if ((victoires > 5) && (nmbrDefaites > 0)){
            for (int i = 1; i <= nmbrDefaites; i++) {
                System.out.println("Saisir le classement de votre adversaires :" +
                        "\nNon classé : 1" +
                        "\n40 : 2" +
                        "\n30/5 : 3" +
                        "\n30/4 : 4" +
                        "\n30/3 : 5" +
                        "\n30/2 : 6" +
                        "\n30/1 : 7" +
                        "\n30 : 8" +
                        "\n15/5 : 9" +
                        "\n15/4 : 10");
                classementAdversaire = In.readInteger();
                if (classementAdversaire <= iClassement){
                    int differenceClassement = (classementAdversaire - iClassement);
                    switch (differenceClassement){
                        case 0:
                            defaitesEgale++;
                            break;
                        case 1:
                            defaites1EchInf++;
                        case 2,3,4,5,6,7,8,9:
                            defaites2EchInf++;
                    }
                }
            }
        }
        formule = victoires - defaitesEgale - (2 * defaites1EchInf) - (5 * defaites2EchInf);
        System.out.println("Vous avez donc " + victoires + " victoires");

        // Saisie des victoires
        for (int i = 1; i <= victoires; i++) {
            System.out.println("Saisir le classement de votre adversaires :" +
                    "\nNon classé : 1" +
                    "\n40 : 2" +
                    "\n30/5 : 3" +
                    "\n30/4 : 4" +
                    "\n30/3 : 5" +
                    "\n30/2 : 6" +
                    "\n30/1 : 7" +
                    "\n30 : 8" +
                    "\n15/5 : 9" +
                    "\n15/4 : 10");
            classementAdversaire = In.readInteger();
            int differenceClassement = (iClassement - classementAdversaire);

            // Switch Calcul de points
            if (differenceClassement <= -2 && differenceClassement >= -9) {
                points += 150;
                System.out.println("Votre adversaire est 2 echelons plus haut, vous avez gagné 150 points");
            } else if (differenceClassement == -1) {
                points += 100;
                System.out.println("Votre adversaire est 1 echelons plus haut, vous avez gagné 150 points");
            } else if (differenceClassement == 0) {
                points += 50;
                System.out.println("Votre adversaire est du même echelon, vous avez gagné 50 points");
            } else if (differenceClassement == 1) {
                points += 30;
                System.out.println("Votre adversaire est 1 echelons plus bas, vous avez gagné 30 points");
            } else if (differenceClassement == 2) {
                points += 20;
                System.out.println("Votre adversaire est 2 echelons plus bas, vous avez gagné 20 points");
            } else if (differenceClassement == 3) {
                points += 15;
                System.out.println("Votre adversaire est 3 echelons plus bas, vous avez gagné 15 points");
            } else if (differenceClassement <= 4 && differenceClassement >= 9) {
                points += 0;
                System.out.println("Votre adversaire est au moins 4 echelons plus bas, vous avez gagné 0 points");
            }
        }
        System.out.println("Vos victoires vous ont récompensé : " + points + " points.\nNous allons recalculer votre classement.");
        switch (iClassement) {
            case 1:
                if (points >= 50) {
                    iClassement++;
                }
                break;
            case 2:
                if (points >= 80) {
                    iClassement++;
                } else if (points < 30) {
                    iClassement--;
                }
                break;
            case 3:
                if (points >= 150) {
                    iClassement++;
                } else if (points < 50) {
                    iClassement--;
                }
                break;
            case 4:
                if (points >= 260) {
                    iClassement++;
                } else if (points < 90) {
                    iClassement--;
                }
                break;
            case 5:
                if (points >= 340) {
                    iClassement++;
                } else if (points < 145) {
                    iClassement--;
                }
                break;
            case 6:
                if (points >= 410) {
                    iClassement++;
                } else if (points < 205) {
                    iClassement--;
                }
                break;
            case 7:
                if (points >= 480) {
                    iClassement++;
                } else if (points < 245) {
                    iClassement--;
                }
                break;
            case 8:
                if (points >= 510) {
                    iClassement++;
                } else if (points < 290) {
                    iClassement--;
                }
                break;
            case 9:
                if (points >= 580) {
                    iClassement++;
                } else if (points < 325) {
                    iClassement--;
                }
                break;
            case 10:
                if (points >= 660) {
                    iClassement++;
                } else if (points < 395) {
                    iClassement--;
                }
                break;
        }
        switch (iClassement) {
            case NC:
                sClassement = "Non Classé";
                points = 0;
                victoiresMax = 5;
                break;
            case c40:
                sClassement = "40";
                points = 2;
                victoiresMax = 5;
                break;
            case c30_5:
                sClassement = "30/5";
                points = 5;
                break;
            case c30_4:
                sClassement = "30/4";
                points = 10;
                victoiresMax = 5;
                break;
            case c30_3:
                sClassement = "30/3";
                points = 20;
                victoiresMax = 6;
                break;
            case c30_2:
                sClassement = "30/2";
                points = 30;
                victoiresMax = 6;
                break;
            case c30_1:
                sClassement = "30/1";
                points = 50;
                victoiresMax = 6;
                break;
            case c30:
                sClassement = "30";
                points = 80;
                victoiresMax = 6;
                break;
            case c15_5:
                sClassement = "15/5";
                points = 120;
                victoiresMax = 6;
                break;
            case c15_4:
                sClassement = "15/4";
                points = 160;
                victoiresMax = 6;
                break;
        }
        System.out.println("Votre classement nouveau est : " + sClassement + ". Vous avez " + points
                + " points, ainsi que " + victoiresMax + " victoires maximum.");
    }
}
