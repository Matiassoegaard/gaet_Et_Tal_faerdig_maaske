import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        playGame();

    }

    //Denne metode håndterer spillet.
    public static void playGame() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int choiceOfDifficulty;
        int choiceOfAnswer;
        int amountOfGuesses = 0;

        boolean answer = false;

        //Velkomst metoden
        welcome();

        // Valg af sværhedsgrad
        System.out.println("Hvilken sværhedsgrad ville du have? " + "\nNemt tryk: 1" +
                "\nMellem tryk: 2" +
                "\nSvært tryk: 3");
        choiceOfDifficulty = input.nextInt();

        //Kalder på metoden der giver en besked om valg af sværhedsgraden.
        dialogGameDifficulty(choiceOfDifficulty);

        // tildeler "secretNumber" til metoden randomNumberGenerator.
        int secretNumber = randomNumberGenerator(gameDifficulty(choiceOfDifficulty));

        //While loop der holder spillet i gang med mindre det rigtige svar er blevet fundet.
        while (!answer) {
            //kalder på metode der giver beskeden. "Skriv dit gæt:"
            dialogWriteAnswer();
            //Brugers gæt.
            choiceOfAnswer = input.nextInt();
            amountOfGuesses++;
            int result = checkGuess(choiceOfAnswer, secretNumber);

            //gør til metode
            if (result == -1) {
            } else if (result == 1) {
            } else if (result == 0) {
                System.out.println("Du gættede rigtig!!!" +
                        "\nDet hemmelige tal var: " + secretNumber +
                        "\nDu brugte så mange gæt: " + amountOfGuesses);
                answer = true;
                System.out.println("Ville du spille igen? ");
                String playAgain = input.next().toLowerCase();
                switch (playAgain) {
                    case "ja":
                        secretNumber = randomNumberGenerator(gameDifficulty(choiceOfDifficulty));
                        answer = false;
                        break;
                    case "nej":
                        answer = true;
                        break;
                }
            }
        }
    }


    //Giver Besked om hvilken sværhedsgrad der er valgt.
    public static void dialogGameDifficulty(int choiceOfDifficulty) {
        if (choiceOfDifficulty == 1) {
            System.out.println("Jeg har fundet et tal mellem 1 - 10, Prøv at gætte det!");
        } else if (choiceOfDifficulty == 2) {
            System.out.println("Jeg har fundet et tal mellem 1 - 50, Prøv at gætte det!");
        } else if (choiceOfDifficulty == 3) {
            System.out.println("Jeg har fundet et tal mellem 1 - 100, Prøv at gætte det!");
        }
    }

    public static void welcome() {
        System.out.println("Velkommen til spillet: Gæt et Tal" +
                "\n-----------------------------------");
    }

    public static void dialogWriteAnswer() {
        System.out.println("Skriv dit gæt: ");
    }

    public static void dialogTryAgain() {
        System.out.println("Desværre prøv igen!\n");
    }


    //Metode der til deler maxNumber en værdi baseret på hvilken sværhedsgrad spilleren har valgt.
    public static int gameDifficulty(int choiceOfDifficulty) {
        int maxNumber = 0;
        int choiceOfAnswer;
        if (choiceOfDifficulty == 1) {
            return maxNumber = 10;
        } else if (choiceOfDifficulty == 2) {
            return maxNumber = 50;
        } else if (choiceOfDifficulty == 3) {
            return maxNumber = 100;
        }
        return maxNumber;
    }

    // Metoder der laver et tilfældigt nummer.
    public static int randomNumberGenerator(int maxNumber) {
        int min = 1;
        Random rand = new Random();
        return rand.nextInt(maxNumber - min + 1) + min;
    }

    //Metode der tjekker om gættede var for lavt, højt eller om det var rigtigt.
    public static int checkGuess(int choiceOfAnswer, int secretNumber) throws InterruptedException {
        if (choiceOfAnswer < secretNumber) {

            System.out.println("Du gættede for lavt ");
            dialogTryAgain();
            Thread.sleep(800);
            return -1;
        }
        if (choiceOfAnswer > secretNumber) {

            System.out.println("Du gættede for højt");
            dialogTryAgain();
            Thread.sleep(800);
            return 1;
        } else
            return 0;
    }





}