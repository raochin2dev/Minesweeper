import java.util.Scanner;

/**
 * Created by civa-raochin2gmailcom on 1/18/17.
 */
public class Game {

    public void play() {

        Scanner scanner = new Scanner(System.in);
        Board b = new Board();
        int row, col;
        while (!b.gameOver && !b.win) {

            System.out.println("Row:");
            row = scanner.nextInt();
            System.out.println("Col:");
            col = scanner.nextInt();

            b.setSelection(row,col);
            b.drawBoard();

        }

        if(b.win)
            System.out.println("You Won :)");
        else
            System.out.println("You Lost :(");

        scanner.close();
    }

}
