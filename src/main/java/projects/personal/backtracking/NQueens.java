package projects.personal.backtracking;


public class NQueens {

    public static void main(String[] args) {
        int N = 10;

        boolean[][] queenOnSquare = new boolean[N][N];
        initQueenOnSquare(queenOnSquare,N);

        boolean[] columnEmpty = new boolean[N];
        initMeta(columnEmpty,N, true);

        boolean[] upDiagonalEmpty = new boolean[(N - 1) + (N - 1) + 1];
        initMeta(upDiagonalEmpty,(N - 1) + (N - 1) + 1, true);

        boolean[] downDiagonalEmpty = new boolean[(N - 1) + (N - 1) + 1];
        initMeta(downDiagonalEmpty, (N - 1) + (N - 1) + 1 , true);

        findAllSolutions(0, queenOnSquare,columnEmpty,upDiagonalEmpty,downDiagonalEmpty,N);

        System.out.println("printing output for single solution");
        findSingleSolutionWithStartCoordinates(0, 0, 9,queenOnSquare,columnEmpty,
                upDiagonalEmpty,downDiagonalEmpty,N);
    }

    /**
     * Find all possible ways of placing n queens on an n x n chessboard so that no two queens occupy the same row,
     * column, or diagonal.
     */
    private static void findAllSolutions(int row, boolean[][] queenOnSquare, boolean[] columnEmpty, boolean[] upDiagonalEmpty,
                                         boolean[] downDiagonalEmpty, int N) {
        if(row == N) {
            printSolution(queenOnSquare,N);
            return;
        }

        for(int column = 0; column < N; ++column) {
            if(isSafe(row,column,columnEmpty,upDiagonalEmpty,downDiagonalEmpty,N)) {
                placeQueen(queenOnSquare,row,column,columnEmpty,upDiagonalEmpty,downDiagonalEmpty,N);
                findAllSolutions(row+1, queenOnSquare,columnEmpty,upDiagonalEmpty,downDiagonalEmpty,N);
                removeQueen(queenOnSquare,row,column,columnEmpty,upDiagonalEmpty,downDiagonalEmpty,N);
            }
        }
    }

    /**
     * Finds a solution where the starting position of a queen is given
     */
    private static boolean findSingleSolutionWithStartCoordinates(int row, int startRow, int startColumn,
                                                               boolean[][] queenOnSquare, boolean[] columnEmpty,
                                                               boolean[] upDiagonalEmpty, boolean[] downDiagonalEmpty,
                                                               int N) {
        if(row == N && queenOnSquare[startRow][startColumn]) {
            printSolution(queenOnSquare,N);
            return true;
        }

        for(int column = 0; column < N; ++column) {
            if(isSafe(row,column,columnEmpty,upDiagonalEmpty,downDiagonalEmpty,N)) {
                placeQueen(queenOnSquare,row,column,columnEmpty,upDiagonalEmpty,downDiagonalEmpty,N);
                if(findSingleSolutionWithStartCoordinates(row+1,startRow,startColumn,queenOnSquare,columnEmpty,
                        upDiagonalEmpty,downDiagonalEmpty,N)) {
                    return true;
                }
                removeQueen(queenOnSquare,row,column,columnEmpty,upDiagonalEmpty,downDiagonalEmpty,N);
            }
        }
        return false;
    }

    private static void placeQueen(boolean[][] queenOnSquare, int row, int column, boolean[] columnEmpty,
                                   boolean[] upDiagonalEmpty, boolean[] downDiagonalEmpty, int N) {
        queenOnSquare[row][column] = true;
        columnEmpty[column] = false;
        upDiagonalEmpty[row + column] = false;
        downDiagonalEmpty[(N-1) + row - column] = false;
    }

    private static void removeQueen(boolean[][] queenOnSquare, int row, int column, boolean[] columnEmpty,
                                   boolean[] upDiagonalEmpty, boolean[] downDiagonalEmpty, int N) {
        queenOnSquare[row][column] = false;
        columnEmpty[column] = true;
        upDiagonalEmpty[row + column] = true;
        downDiagonalEmpty[(N-1) + row - column] = true;
    }

    private static boolean isSafe(int row, int column, boolean[] columnEmpty, boolean[] upDiagonalEmpty,
                                  boolean[] downDiagonalEmpty, int N) {
        return columnEmpty[column]
                && upDiagonalEmpty[row + column]
                && downDiagonalEmpty[(N-1) + row - column];
    }

    private static void printSolution(boolean[][] queenOnSquare, int N) {
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                System.out.print(queenOnSquare[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("--------------------------");
        System.out.println();
    }

    private static void initQueenOnSquare(boolean[][] queenOnSquare, int N) {
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                queenOnSquare[i][j] = false;
            }
        }
    }

    private static void initMeta(boolean[] meta, int N, boolean value) {
        for(int i = 0; i < N; ++i) {
            meta[i] = value;
        }
    }
}
