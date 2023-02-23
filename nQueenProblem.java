public class nQueenProblem
{
    public static void main(String[] args)
    {
        int n = 5;
        int[][] board = new int[n][n];
        nQueenProblem nq = new nQueenProblem();
        nq.nQueen(board,n, 0);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    boolean nQueen(int[][] board,int N, int row){
        if(row==N) return true;

        for(int col=0;col < N; col++){
            if(isSafe(board, N, row, col)){
                board[row][col] = 1;
                if(nQueen(board, N, row + 1))
                    return true;
                board[row][col] = 0;
            }
        }
        return false;
    }

    boolean isSafe(int[][] board,int n, int row, int col)
    {
        int[][] tempBoard = copyBoard(board, n);
        fillBoard(tempBoard, n);
        if(tempBoard[row][col] == 0){
            return true;
        }else {
            return false;
        }
    }
    int[][] copyBoard(int[][] board, int n){
        int[][] tempBoard = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                tempBoard[i][j] = board[i][j];
            }
        }
        return tempBoard;
    }
    void fillBoard(int[][] tempBoard, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(tempBoard[i][j]==1){
                    fill(tempBoard, n, i,j);
                }
            }
        }
    }

    private void fill(int[][] tempBoard, int n, int r, int c) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((j==c || i==r || i-j==r-c || i+j==r+c) && tempBoard[i][j] != 1){
                    tempBoard[i][j] = 2;
                }
            }
        }
    }
    
}