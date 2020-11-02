package com.example.connectfour;

public class Game {

    private char board[][];
    private int position[]; // topmost empty position of a column

    private final int ROW = 7;
    private final int COL = 6;
    final int POS_INF = 99999;
    final int NEG_INF = -99999;
    private final int DRAWN = 0;

    int gameScore = 0;
    char playerSign = 'X';
    char aiSign = 'O';

    public Game() {
        initGame();
    }

    public void initGame(){
        board = new char[ROW][COL];
        position = new int[COL];
        for (int i = 0 ; i < ROW ; i++){
            for(int j = 0 ; j < COL ; j++){
                board[i][j] = '.';
            }
        }

        for(int i = 0 ; i < COL ; i++){
            position[i] = ROW - 1;
        }
    }

    public void drawBoard(){
        for (int i = 0 ; i < ROW ; i++){
            for(int j = 0 ; j < COL ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void errorCheck(){
        System.out.println("score "+ gameScore);
    }

    public boolean validMove(int c){
        if(c > -1 && c < COL){
            if(position[c] > -1) {
                return true;
            }
        }
        return false;
    }


    public int calculateGame(int col, int currentScore){
        int in_a_row = 1;
        int opcount = 0;
        int score = 0;
        int top = position[col]+1;
        char sym = board[top][col];
        char opsym = (sym==(playerSign)?aiSign:playerSign);

        // column checking for symbol in a row
        for(int i=1; i<4 && (top+i)<ROW;i++)
        {
            if(sym==(board[top+i][col])) {
                in_a_row++;
            }
            else{
                break;
            }
        }
        if(in_a_row >= 4)
        {
            //printf("col check\n");
            if(sym==(playerSign)) return NEG_INF;
            else return POS_INF;
        }
        else
        {
            // printf("Column: %d\n", _pow_(in_a_row, in_a_row));
            score += Math.pow(in_a_row, in_a_row);
            in_a_row = 1;
        }
        // column checking for opposite symbol in a row
        for(int i=1; i<4 && (top+i)<ROW;i++)
        {
            if(opsym==(board[top+i][col])) {
                opcount++;
            }
            else{
                break;
            }
        }
        if(opcount>2)
        {
            // printf("Op-Column: %d\n", _pow_(opcount, opcount) +10);
            score += Math.pow(opcount, opcount) +10;
        }
        opcount = 0;

        // row checking
        for(int i=1; (col-i)>-1; i++)
        {
            if(sym==(board[top][col-i])) {
                in_a_row++;
            }
            else{
                break;
            }
        }

        for(int i=1; (col+i)<COL; i++)
        {
            if(sym==(board[top][col+i])) {
                in_a_row++;
            }
            else {
                break;
            }
        }
        if(in_a_row >= 4)
        {
            //printf("row check\n");
            if(sym==(playerSign)) return NEG_INF;
            else return POS_INF;
        }
        else
        {
            // printf("Row: %d\n", _pow_(in_a_row, in_a_row));
            score += Math.pow(in_a_row, in_a_row);
            in_a_row = 1;
        }

        // row checking for oposite symbols in a row
        for(int i=1; (col-i)>-1; i++)
        {
            if( opsym==(board[top][col-i])) {
                opcount++;
            }
            else {
                break;
            }
        }
        for(int i=1; (col+i)<COL; i++)
        {
            if(opsym==(board[top][col+i])) {
                opcount++;
            }
            else{
                break;
            }
        }
        if(opcount>2)
        {
            // printf("Op-Row: %d\n", _pow_(opcount, opcount) +10);
            score += Math.pow(opcount, opcount) +10;
        }
        opcount = 0;

        // diagonal(down-left to up-right) checking
        for(int i=1; (col-i)>-1 && (top+i)<ROW; i++)
        {
            if(sym==(board[top+i][col-i])) {
                in_a_row++;
            }
            else{
                break;
            }
        }
        for(int i=1; (col+i)<COL && (top-i)>-1; i++)
        {
            if(sym==(board[top-i][col+i])) {
                in_a_row++;
            }
            else{
                break;
            }
        }
        if(in_a_row >= 4)
        {
            //printf("bottom left check\n");
            if(sym==(playerSign)) return NEG_INF;
            else return POS_INF;
        }
        else
        {
            // printf("Diagonal-1: %d\n", _pow_(in_a_row, in_a_row));
            score += Math.pow(in_a_row, in_a_row);
            in_a_row = 1;
        }

        // diagonal(down-left to up-right) checking oposite symbols in a row
        for(int i=1; (col-i)>-1 && (top+i)<ROW; i++)
        {
            if(opsym==(board[top+i][col-i])) {
                opcount++;
            }
            else{
                break;
            }
        }
        for(int i=1; (col+i)<COL && (top-i)>-1; i++)
        {
            if(opsym==(board[top-i][col+i])) {
                opcount++;
            }
            else{
                break;
            }
        }
        if(opcount>2)
        {
            // printf("Op-Diagonal-1: %d\n", _pow_(opcount, opcount) +10);
            score += Math.pow(opcount, opcount) +10;
        }
        opcount = 0;

        // diagonal(up-left to down-right) checking
        for(int i=1; (col-i)>-1 && (top-i)>-1; i++)
        {
            if(sym==(board[top-i][col-i])) {
                in_a_row++;
            }
            else{
                break;
            }
        }
        for(int i=1; (col+i)<COL && (top+i)<ROW; i++)
        {
            if(sym==(board[top+i][col+i])) {
                in_a_row++;
            }
            else{
                break;
            }
        }
        if(in_a_row >= 4)
        {
            //printf("bottom right check\n");
            if(sym==(playerSign)) return NEG_INF;
            else return POS_INF;
        }
        else
        {
            // printf("Diagonal-2: %d\n", _pow_(in_a_row, in_a_row));
            score += Math.pow(in_a_row, in_a_row);
        }

        // diagonal(up-left to down-right) checking for oposite symbols in a row
        for(int i=1; (col-i)>-1 && (top-i)>-1; i++)
        {
            if(opsym==(board[top-i][col-i])) {
                opcount++;
            }
            else{
                break;
            }
        }
        for(int i=1; (col+i)<COL && (top+i)<ROW; i++)
        {
            if(opsym==(board[top+i][col+i])) {
                opcount++;
            }
            else{
                break;
            }
        }
        if(opcount>2)
        {
            // printf("Op-Diagonal-2: %d\n", _pow_(opcount, opcount) +10);
            score += Math.pow(opcount, opcount) +10;
        }
        int i;
        for(i=0; position[i]==-1 && i<COL; i++);
        if(i == 6) return DRAWN; // tie condition

        if(sym==(playerSign)) return currentScore - score;
        else return currentScore + score;
    }

    public int updatePosition(int col, char sign){
        int row = position[col];
        board[row][col] = sign;
        position[col] -= 1;
        return row;
    }


    public int miniMax(char sym, int col, int depth, int currentScore){
        int score = calculateGame(col, currentScore);
        // printf("Depth: %d, Sym: %c, Pre-Score: %d, Post-Score: %d\n", depth, sym, board_score, score);

        if(depth < 0) return score;

        // Maximizer won the game
        if(score == POS_INF) return POS_INF;

        // Minimizer won the game
        if(score == NEG_INF) return NEG_INF;

        // Draw game
        //if(score == 0)  return 0;

        // if this is maximizer's move
        if(sym=='X')
        {
            int best = NEG_INF;

            for(int c=1; c<COL;c++)
            {
                if(position[c] != -1)
                {
                    int row = position[c]--;
                    board[row][c] = sym;

                    //int debug_score = evaluate_board(board, c, score);
                    // draw_board(board);
                    // printf("Depth: %d, Sym: %c, Pre-Score: %d, Post-Score: %d\n", depth, sym, score, debug_score);

                    int val = miniMax( 'O', c, depth-1, score);
                    //printf("Depth: %d, Sym: %c, val: %d\n",depth, sym, val);
                    if(val > best) best = val;

                    board[row][c] = '.';
                    position[c]++;
                }
            }
            return best;
            // return best-depth;
        }
        // if this is minimizer's move
        else
        {
            int best = POS_INF;

            for(int c=1; c<COL;c++)
            {
                if(position[c] != -1)
                {
                    int row = position[c]--;
                    board[row][c] = sym;

                    //int debug_score = evaluate_board(board, c, score);
                    // draw_board(board);

                    int val = miniMax('X', c, depth-1, score);
                    //printf("Depth: %d, Sym: %c, val: %d\n", depth, sym, val);

                    if(val < best) best = val;

                    board[row][c] = '.';
                    position[c]++;
                }
            }
            return best;
            // return best+depth;
        }

    }

    public int aiTurn(int depth){
        int best = NEG_INF;
        int col = -1;
        char sym = aiSign;
        char opsym = playerSign;

        for(int c=0; c<COL; c++)
        {
            if(position[c]>-1)
            {
                int row = position[c]--;
                board[row][c] = sym;

                int moveScore = miniMax(opsym, c, depth-1, gameScore);
                // draw_board(board);
                //printf("Prev: %d, Post: %d\n",game_score, move_score);

                board[row][c] = '.';
                position[c]++;

                if(moveScore > best)
                {
                    best = moveScore;
                    col = c;
                }
            }
        }
        //printf("best %d\n",best);
        if(best == NEG_INF){
            //printf("dhukse\n");
            for(int c=0; c<COL; c++)
            {
                if(position[c]>0)
                {
                    int row = position[c]--;
                    board[row][c] = opsym;

                    int moveScore = calculateGame(c, gameScore);
                    // draw_board(board);
                    //printf("Prev: %d, Post: %d\n",game_score, move_score);

                    board[row][c] = '.';
                    position[c]++;

                    if(moveScore == NEG_INF)
                    {
                        col = c;
                    }
                }
            }
        }
        //for(int i=1; i<COL; i++) printf("%d  => %d\n",i,position[i]);
        //printf("best : %d\n", best);
        return col;
    }
}
