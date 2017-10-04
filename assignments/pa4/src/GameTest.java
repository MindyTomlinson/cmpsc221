import java.util.Scanner;

public class GameTest {

    public static void main(String[] args) {

        // New model
        GameModel gm = new GameModel();
        System.out.println("Start a new game model...");
        System.out.println(gm);
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        int guess = 0;
        while (guess >= 0) {
            System.out.println("Enter guess:");
            guess = scanner.nextInt();
            gm.setGuesses(guess);
            String hint = gm.makeHint();
            gm.setMessage(hint);
            System.out.println(gm);
        }

    }
}
