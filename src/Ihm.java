import clavier.In;

import java.util.Scanner;

public class Ihm {
    public static void main(String[] args) {
        // Initialisation variables, changement du "_" par un "c" au souhait de Monsieur Foray car meilleur pratique
        final int NC = 1, c40 = 2, c30_5 = 3, c30_4 = 4, c30_3 = 5, c30_2 = 6,
                c30_1 = 7, c30 = 8, c15_5 = 9, c15_4 = 10;

        String classement = "";
        int victoiresMax = 0;
        int victoires = 0;
        int pointsDepart = 0;
        int points = 0;
        int defaitesEgal = 0;
        int defaites = 0;
        int classementAdversaire = 0;

        //   int formule = victoires - e - (2 * i) - (5 * g);


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
        int monClassement = In.readInteger();

        switch (monClassement) {
            case NC:
                classement = "Non Classé";
                points = 0;
                victoiresMax = 5;
                break;
            case c40:
                classement = "40";
                points = 2;
                victoiresMax = 5;
                break;
            case c30_5:
                classement = "30/5";
                points = 5;
                break;
            case c30_4:
                classement = "30/4";
                points = 10;
                victoiresMax = 5;
                break;
            case c30_3:
                classement = "30/3";
                points = 20;
                victoiresMax = 6;
                break;
            case c30_2:
                classement = "30/2";
                points = 30;
                victoiresMax = 6;
                break;
            case c30_1:
                classement = "30/1";
                points = 50;
                victoiresMax = 6;
                break;
            case c30:
                classement = "30";
                points = 80;
                victoiresMax = 6;
                break;
            case c15_5:
                classement = "15/5";
                points = 120;
                victoiresMax = 6;
                break;
            case c15_4:
                classement = "15/4";
                points = 160;
                victoiresMax = 6;
                break;
            default:
                classement = "Non Classé";
                points = 0;
                victoiresMax = 5;
                System.out.println("Mauvaise valeur entree, vous serez donc : " + classement);
                break;
        }
        System.out.println("Votre classement : " + classement + ". Vous avez " + points
                + " points, ainsi que " + victoiresMax + " victoires maximum.");

        // Saisie nombre de victoires
        System.out.print("Saisir votre nombre de victoires : ");
        victoires = In.readInteger();

        // Gestion du maximum de victoires
        if (victoires > victoiresMax) {
            victoires = victoiresMax;
        }
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
            int differenceClassement = (monClassement - classementAdversaire);

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
        switch (monClassement) {
            case 1:
                if (points >= 50) {
                    monClassement++;
                }
                break;
            case 2:
                if (points >= 80) {
                    monClassement++;
                } else if (points < 30) {
                    monClassement--;
                }
                break;
            case 3:
                if (points >= 150) {
                    monClassement++;
                } else if (points < 50) {
                    monClassement--;
                }
                break;
            case 4:
                if (points >= 260) {
                    monClassement++;
                } else if (points < 90) {
                    monClassement--;
                }
                break;
            case 5:
                if (points >= 340) {
                    monClassement++;
                } else if (points < 145) {
                    monClassement--;
                }
                break;
            case 6:
                if (points >= 410) {
                    monClassement++;
                } else if (points < 205) {
                    monClassement--;
                }
                break;
            case 7:
                if (points >= 480) {
                    monClassement++;
                } else if (points < 245) {
                    monClassement--;
                }
                break;
            case 8:
                if (points >= 510) {
                    monClassement++;
                } else if (points < 290) {
                    monClassement--;
                }
                break;
            case 9:
                if (points >= 580) {
                    monClassement++;
                } else if (points < 325) {
                    monClassement--;
                }
                break;
            case 10:
                if (points >= 660) {
                    monClassement++;
                } else if (points < 395) {
                    monClassement--;
                }
                break;
        }
        switch (monClassement) {
            case NC:
                classement = "Non Classé";
                points = 0;
                victoiresMax = 5;
                break;
            case c40:
                classement = "40";
                points = 2;
                victoiresMax = 5;
                break;
            case c30_5:
                classement = "30/5";
                points = 5;
                break;
            case c30_4:
                classement = "30/4";
                points = 10;
                victoiresMax = 5;
                break;
            case c30_3:
                classement = "30/3";
                points = 20;
                victoiresMax = 6;
                break;
            case c30_2:
                classement = "30/2";
                points = 30;
                victoiresMax = 6;
                break;
            case c30_1:
                classement = "30/1";
                points = 50;
                victoiresMax = 6;
                break;
            case c30:
                classement = "30";
                points = 80;
                victoiresMax = 6;
                break;
            case c15_5:
                classement = "15/5";
                points = 120;
                victoiresMax = 6;
                break;
            case c15_4:
                classement = "15/4";
                points = 160;
                victoiresMax = 6;
                break;
        }
        System.out.println("Votre classement nouveau est : " + classement + ". Vous avez " + points
                + " points, ainsi que " + victoiresMax + " victoires maximum.");
    }
}
