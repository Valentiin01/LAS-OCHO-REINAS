// ALUMNO GENARO SANTIAGO VALENTÍN

package eightqueens;

/**
 *
 * @author USER
 */
public class EightQueens {
    private static final int N = 8; // Tamaño del tablero

    // Método para imprimir la solución
    private static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para verificar si una dama puede ser colocada en la posición board[row][col]
    private static boolean isSafe(int[][] board, int row, int col) {
        int i, j;

        // Verificar esta fila hacia la izquierda
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Verificar la diagonal superior izquierda
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Verificar la diagonal inferior izquierda
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Método recursivo para resolver el problema de las 8 damas
    private static boolean solveNQueensUtil(int[][] board, int col) {
        // Si todas las damas han sido colocadas, retorna verdadero
        if (col >= N) {
            return true;
        }

        // Intenta colocar esta reina en todas las filas una por una
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1; // Coloca la reina en la posición (i, col)

                // Recursivamente coloca el resto de las reinas
                if (solveNQueensUtil(board, col + 1)) {
                    return true;
                }

                // Si colocar la reina en la posición (i, col) no lleva a una solución, entonces retírala
                board[i][col] = 0;
            }
        }

        // Si la reina no puede ser colocada en ninguna fila en esta columna, entonces retorna falso
        return false;
    }

    // Método principal para resolver el problema de las 8 damas
    public static void solveNQueens() {
        int[][] board = new int[N][N];

        if (!solveNQueensUtil(board, 0)) {
            System.out.println("No existe solución.");
            return;
        }

        printSolution(board);
    }

    // Método principal
    public static void main(String[] args) {
        solveNQueens();
    }
}
