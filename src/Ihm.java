import clavier.In;

import java.sql.SQLOutput;

public class Ihm {
    static final int NC = 1, C40 = 2, C30_5 = 3, C30_4 = 4, C30_3 = 5, C30_2 = 6,
            C30_1 = 7, C30 = 8, C15_5 = 9, C15_4 = 10;

    public static void main(String[] args) {
        // Initialisation variables

        String sClassement = "";
        int victoiresMax = 0;
        int victoires, diffVictoires, points, nmbrDefaites, classementAdversaire, formule;
        int defaitesEgale = 0;
        int defaites1EchInf = 0;
        int defaites2EchInf = 0;


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

        // Saisie nombre de victoires
        System.out.print("Saisir votre nombre de victoires : ");
        victoires = In.readInteger();


        while (victoires > 0) {

            //début if défaites
            if ((iClassement >= 1 && iClassement <= 4) && (victoires > 5)) {
                System.out.println("Saisir votre nombre de défaites");
                nmbrDefaites = In.readInteger();
                if (nmbrDefaites > 0) {
                    for (int i = 1; i <= nmbrDefaites; i++) {
                        System.out.println("Saisir le classement de votre adversaires pour la défaite " + i +
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
                        int differenceClassement = (classementAdversaire - iClassement);
                        if (classementAdversaire >= 1 && classementAdversaire <= 10) {
                            switch (differenceClassement) {
                                case 0:
                                    defaitesEgale++;
                                    System.out.println("Vous avez perdu contre un joueur d'échellon équivalent");
                                    break;
                                case 1:
                                    defaites1EchInf++;
                                    System.out.println("Vous avez perdu contre un joueur inférieur d'un échellon");
                                    break;
                                case 2, 3, 4, 5, 6, 7, 8, 9:
                                    defaites2EchInf++;
                                    System.out.println("Vous avez perdu contre un joueur inférieur de plus de 2 échellons");
                                    break;
                                default:
                                    System.out.println("Cette défaite n'est pas comptabilisé, votre adversaire est à un échellon plus élevé que vous !");
                                    break;
                            }
                        }
                    }
                }
            } else if ((iClassement >= 5 && iClassement <= 10) && (victoires > 6)) {
                System.out.println("Saisir votre nombre de défaites");
                nmbrDefaites = In.readInteger();
                if (nmbrDefaites > 0) {
                    for (int i = 1; i <= nmbrDefaites; i++) {
                        System.out.println("Saisir le classement de votre adversaires pour la défaite " + i +
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
                        int differenceClassement = (classementAdversaire - iClassement);
                        if (classementAdversaire >= 1 && classementAdversaire <= 10) {
                            switch (differenceClassement) {
                                case 0:
                                    defaitesEgale++;
                                    System.out.println("Vous avez perdu contre un joueur d'échellon équivalent");
                                    break;
                                case 1:
                                    defaites1EchInf++;
                                    System.out.println("Vous avez perdu contre un joueur inférieur d'un échellon");
                                    break;
                                case 2, 3, 4, 5, 6, 7, 8, 9:
                                    defaites2EchInf++;
                                    System.out.println("Vous avez perdu contre un joueur inférieur de plus de 2 échellons");
                                    break;
                                default:
                                    System.out.println("Cette défaite n'est pas comptabilisé, votre adversaire est à un échellon plus élevé que vous !");
                                    break;
                            }
                        }
                    }
                }
            }
            // fin If défaites pour les 2 cas différents

            // Traitement nombre de victoires supplémentaires
            victoiresMax = iVictoiresMax(iClassement);
            formule = victoires - defaitesEgale - (2 * defaites1EchInf) - (5 * defaites2EchInf);
            diffVictoires = victoires - victoiresMax;
            if (diffVictoires > 0) { // On vérifie que le joueur a plus de victoires de victoires maximum de base
                if (formule >= 25 && ((diffVictoires) >= 6)) {
                    victoires = (victoiresMax + 6);
                } else if (formule >= 20 && ((diffVictoires) >= 5)) {
                    victoires = (victoiresMax + 5);
                } else if (formule >= 15 && ((diffVictoires) >= 4)) {
                    victoires = (victoiresMax + 4);
                } else if (formule >= 10 && ((diffVictoires) >= 3)) {
                    victoires = (victoiresMax + 3);
                } else if (formule >= 5 && ((diffVictoires) >= 2)) {
                    victoires = (victoiresMax + 2);
                } else if (formule >= 0) {
                    victoires = (victoiresMax + 1);
                } else {
                    victoires = victoiresMax;
                }
            }
            System.out.println("Vous avez donc " + victoires + " victoires à saisir");

            // Calcul des points de départs
            points = iPoints(iClassement);

            // Saisie des victoires
            for (int i = victoires; i > 0; i--, victoires--) {
                System.out.println("Saisir le classement de votre adversaires  pour la victoire " + i +
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
                // Attribution à une variable du classement de départ
                int classementDepart = iClassement;
                int differenceClassement = (iClassement - classementAdversaire);

                // If Calcul de points
                if (differenceClassement <= -2 && differenceClassement >= -9) {
                    points += 150;
                    System.out.println("Votre adversaire est 2 echelons plus haut, vous avez gagné 150 points");
                } else if (differenceClassement == -1) {
                    points += 100;
                    System.out.println("Votre adversaire est 1 echelons plus haut, vous avez gagné 100 points");
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
                } else if (differenceClassement <= 4) {
                    System.out.println("Votre adversaire est au moins 4 echelons plus bas, vous avez gagné 0 points");
                }
                iClassement = calculAugmentationClassement(iClassement, points);
                sClassement = sClassement(iClassement);
                if (classementDepart < iClassement) {
                    System.out.println("Vous êtes monté d'un rang, votre nouveau classement est : " + sClassement);
                    break;
                }
            }
        }
        sClassement = sClassement(iClassement);
        System.out.println("Vous êtes descendu d'un rang, votre nouveau classement est : " + sClassement);
    }


    public static int calculAugmentationClassement(int iClassement, int points) {
        switch (iClassement) {
            case NC:
                if (points >= 50) {
                    iClassement++;
                }
                break;
            case C40:
                if (points >= 80) {
                    iClassement++;
                }
                break;
            case C30_5:
                if (points >= 150) {
                    iClassement++;
                }
                break;
            case C30_4:
                if (points >= 260) {
                    iClassement++;
                }
                break;
            case C30_3:
                if (points >= 340) {
                    iClassement++;
                }
                break;
            case C30_2:
                if (points >= 410) {
                    iClassement++;
                }
                break;
            case C30_1:
                if (points >= 480) {
                    iClassement++;
                }
                break;
            case C30:
                if (points >= 510) {
                    iClassement++;
                }
                break;
            case C15_4:
                if (points >= 580) {
                    iClassement++;
                }
                break;
            case C15_5:
                if (points >= 660) {
                    iClassement++;
                }
                break;
        }
        return iClassement;
    }

    public static int calculDiminutionClassement(int iClassement, int points) {
        switch (iClassement) {
            case C40:
                if (points < 30) {
                    iClassement--;
                }
                break;
            case C30_5:
                if (points < 50) {
                    iClassement--;
                }
                break;
            case C30_4:
                if (points < 90) {
                    iClassement--;
                }
                break;
            case C30_3:
                if (points < 145) {
                    iClassement--;
                }
                break;
            case C30_2:
                if (points < 205) {
                    iClassement--;
                }
                break;
            case C30_1:
                if (points < 245) {
                    iClassement--;
                }
                break;
            case C30:
                if (points < 290) {
                    iClassement--;
                }
                break;
            case C15_4:
                if (points < 325) {
                    iClassement--;
                }
                break;
            case C15_5:
                if (points < 395) {
                    iClassement--;
                }
                break;
        }
        return iClassement;
    }


    public static String sClassement(int iClassement) {
        String sClassement = "";
        switch (iClassement) {
            case 1:
                sClassement = "Non Classé";
                break;
            case 2:
                sClassement = "40";
                break;
            case 3:
                sClassement = "30/5";
                break;
            case 4:
                sClassement = "30/4";
                break;
            case 5:
                sClassement = "30/3";
                break;
            case 6:
                sClassement = "30/2";
                break;
            case 7:
                sClassement = "30/1";
                break;
            case 8:
                sClassement = "30";
                break;
            case 9:
                sClassement = "15/5";
                break;
            case 10:
                sClassement = "15/4";
                break;
            default:
                sClassement = "Non Classé";
                System.out.println("Mauvaise valeur entree, vous serez donc : " + sClassement);
                break;
        }
        return sClassement;
    }

    public static int iPoints(int classementDepart) {
        int iPoints = 0;
        switch (classementDepart) {
            // Pas de case 1 ni de default, car valeur initialisée à 0
            case 2:
                iPoints = 2;
                break;
            case 3:
                iPoints = 5;
                break;
            case 4:
                iPoints = 10;
                break;
            case 5:
                iPoints = 20;
                break;
            case 6:
                iPoints = 30;
                break;
            case 7:
                iPoints = 50;
                break;
            case 8:
                iPoints = 80;
                break;
            case 9:
                iPoints = 120;
                break;
            case 10:
                iPoints = 160;
                break;
            default:
                break;
        }
        return iPoints;
    }

    public static int iVictoiresMax(int iClassement) {
        int iVictoiresMax = 0;
        switch (iClassement) {
            case 1, 2, 3, 4:
                iVictoiresMax = 5;
                break;
            case 5, 6, 7, 8, 9, 10:
                iVictoiresMax = 6;
                break;
        }
        return iVictoiresMax;
    }
}

