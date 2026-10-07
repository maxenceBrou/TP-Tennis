import clavier.In;

import java.util.Scanner;

public class Ihm {
    public static void main(String[] args) {
        // Initialisation variables
        final int NC = 1, _40 = 2, _30_5 = 3, _30_4 = 4, _30_3 = 5, _30_2 = 6,
                _30_1 = 7, _30 = 8, _15_5 = 9, _15_4 = 10;

        String classement = "";
        int victoiresMax, victoires, pointsDepart, points, defaitesEgal, defaites, classementAdversaire;

     //   int formule = victoires - e - (2 * i) - (5 * g);


        // Affichage Menu
        System.out.println("Rentrez votre classement : " +
                "\nNon classé : 1" +
                "\n40 : 2"+
                "\n30/5 : 3"+
                "\n30/4 : 4"+
                "\n30/3 : 5"+
                "\n30/2 : 6"+
                "\n30/1 : 7"+
                "\n30 : 8"+
                "\n15/5 : 9"+
                "\n15/4 : 10");
        int monClassement = In.readInteger();

        switch (monClassement) {
            case NC:
                classement = "Non Classé";
                points = 0;
                victoiresMax = 5;
                break;
            case _40:
                classement = "40";
                points = 2;
                victoiresMax = 5;
                break;
            case _30_5:
                classement = "30/5";
                points = 5;
                break;
            case _30_4:
                classement = "30/4";
                points = 10;
                victoiresMax = 5;
                break;
            case _30_3:
                classement = "30/3";
                points = 20;
                victoiresMax = 6;
                break;
            case _30_2:
                classement = "30/2";
                points = 30;
                victoiresMax = 6;
                break;
            case _30_1:
                classement = "30/1";
                points = 50;
                victoiresMax = 6;
                break;
            case _30:
                classement = "30";
                points = 80;
                victoiresMax = 6;
                break;
            case _15_5:
                classement = "15/5";
                points = 120;
                victoiresMax = 6;
                break;
            case _15_4:
                classement = "15/4";
                points = 160;
                victoiresMax = 6;
                break;
            default:
                System.out.println("Mauvaise valeurs");
                return;
        }
        System.out.println("Votre classement : " + classement + ". Vous avez " + pointsDepart
                + " points, ainsi que " + victoiresMax + " victoires maximum.");


        System.out.print("Saisir votre nombre de victoires : ");

        victoires = In.readInteger();
        if (victoires < victoiresMax) {
            victoires = victoiresMax;
        }
        System.out.println("Vous avez donc " + victoires + " victoires");

        for (int i = 1; i <= victoires ; i++) {
            System.out.println("Saisir le classement de votre adversaires :" +
                    "\nNon classé : 1"+
                    "\n40 : 2"+
                    "\n30/5 : 3"+
                    "\n30/4 : 4"+
                    "\n30/3 : 5"+
                    "\n30/2 : 6"+
                    "\n30/1 : 7"+
                    "\n30 : 8"+
                    "\n15/5 : 9"+
                    "\n15/4 : 10");
            classementAdversaire = In.readInteger();
            int differenceClassement = (monClassement - classementAdversaire);

            switch (differenceClassement){
                case -2:
                    points +=

            }
        }



    }
}
