import java.util.Random;

/**
 * Created by civa-raochin2gmailcom on 1/18/17.
 */
public class Board {

    int size = 10;
    char[][] mines, board;
    boolean gameOver = false;
    boolean win = false;
    int selCnt = 0;

    public Board() {

        mines = new char[size][size];
        board = new char[size][size];
        setMines();
        setNumbers();
        initBoard();
    }

    private void setMines() {
        Random r = new Random();
        int range = size * size;
        int ranNum;
        for (int i = 0; i < size; i++) {
            ranNum = r.nextInt(range);
            mines[ranNum / size][ranNum % size] = '*';
        }
    }

    private void setNumbers() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(mines[i][j] != '*')
                    mines[i][j] = neighborMines(i, j);
            }
        }

    }

    public void initBoard(){
        for(int i=0 ; i<size ; i++)
            for(int j=0 ; j<size ; j++)
                board[i][j]= '-';
    }

    private char neighborMines(int c1, int c2) {

        int cnt=0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if((c1+i > -1 && c1+i < size) && (c2+j > -1 && c2+j < size) && mines[c1+i][c2+j] == '*'){
                    cnt++;
                }
            }
        }
        return (char)(cnt+'0');
    }

    public void drawBoard(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void setSelection(int r,int c){

        if(mines[r][c] == '*')
            gameOver = true;

        board[r][c] = mines[r][c];
        selCnt++;

        if(selCnt == (size*size)-size && !gameOver)
            win = true;
    }


}
