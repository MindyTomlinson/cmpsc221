import java.util.Scanner;

public class GameTest {

    public static void main(String[] args) {

        // New model
        GameModel gm = new GameModel();
        System.out.println("Start a new game model...");
        System.out.println(gm);

        Scanner scanner = new Scanner(System.in);
        String guess;
        while (!gm.isGameOver()) {
            System.out.println("Enter guess:");
            guess = scanner.nextLine();
            gm.assessGuess(guess);
            System.out.println(gm);
        }
    }
}
