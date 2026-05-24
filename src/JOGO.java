import java.util.Scanner;

public class JOGO {

    public static void main(String[] args) {

        char mat[][] = new char[3][3];

        char jogador1 = 'X';
        char jogador2 = 'O';

        inicializar(mat);

        jogada(mat, jogador1, jogador2);

        mostrarTabuleiro(mat);
    }

    
    public static void inicializar(char mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                mat[i][j] = '-';
            }
        }
    }

    public static void mostrarTabuleiro(char mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    
    public static void jogada(char mat[][], char jogador1, char jogador2) {

        Scanner sc = new Scanner(System.in);
        char jogadorAtual = jogador1;

        boolean jogando = true;

        while (jogando) {

            mostrarTabuleiro(mat);

            int linha, coluna;

            System.out.println("Jogador " + jogadorAtual);

            while (true) {
                System.out.print("digite a linha: ");
                linha = sc.nextInt();

                System.out.print("digite a coluna: ");
                coluna = sc.nextInt();

                if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3) {

                    if (mat[linha][coluna] == '-') {
                        mat[linha][coluna] = jogadorAtual;
                        break;
                    } else {
                        System.out.println("essa posição já está ocupada!");
                    }

                } else {
                    System.out.println("posição inválida!");
                }
            }

           
            if (verificarVitoria(mat, jogadorAtual)) {
                mostrarTabuleiro(mat);
                System.out.println("Jogador " + jogadorAtual + " venceu!");
                jogando = false;
            }

          
            else if (empate(mat)) {
                mostrarTabuleiro(mat);
                System.out.println("deu empate!");
                jogando = false;
            }

           
            else {
                if (jogadorAtual == jogador1) {
                    jogadorAtual = jogador2;
                } else {
                    jogadorAtual = jogador1;
                }
            }
        }

       
    }

    
    public static boolean verificarVitoria(char mat[][], char j) {

     
        for (int i = 0; i < 3; i++) {
            if (mat[i][0] == j && mat[i][1] == j && mat[i][2] == j) {
                return true;
            }
        }

       
        for (int j2 = 0; j2 < 3; j2++) {
            if (mat[0][j2] == j && mat[1][j2] == j && mat[2][j2] == j) {
                return true;
            }
        }

        
        if (mat[0][0] == j && mat[1][1] == j && mat[2][2] == j) {
            return true;
        }

        if (mat[0][2] == j && mat[1][1] == j && mat[2][0] == j) {
            return true;
        }

        return false;
    }

    
    public static boolean empate(char mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}