import java.util.*;

public class Player implements Runnable {
    private String name;
    private int reqToWin;
    private Board board;
    List<Token> tokens = new ArrayList<Token>();

    public Player(String name, int reqToWin, Board board) {
        this.name = name;
        this.reqToWin = reqToWin;
        this.board = board;
    }

    //Disclaimer: check-ul pentru win are nevoie de o verificare a celei mai lungi progresii aritmetice din tokenii jucatorului si ca sa
    //ma focusez pe partea relevanta despre thread-uri si ca sa nu fac in O(n^3) cu verificarea diferentei dintre fiecare pereche si parcurgere de fiecare data,
    //am adus un algoritm DP care gaseste lungimea celei mai lungi progresii aritmetice in O(n^2) de pe www.geeksforgeeks.org/longest-arithmetic-progression-dp-35/
    public static int lengthOfLongestAP(List<Token> tokens, int n) {
        int L[][] = new int[n][n];
        int llap = 2;

        for (int i = 0; i < n; i++) {
            L[i][n - 1] = 2;
        }

        for (int j = n - 2; j >= 1; j--) {
            int i = j-1, k = j+1;
            while (i >= 0 && k <= n-1) {
                if (tokens.get(i).getNumber() + tokens.get(k).getNumber() < 2 * tokens.get(j).getNumber()) {
                    k++;
                }
                else if (tokens.get(i).getNumber() + tokens.get(k).getNumber() > 2 * tokens.get(j).getNumber()) {
                    L[i][j] = 2;
                    i--;
                }
                else {
                    L[i][j] = L[j][k] + 1;
                    llap = Math.max(llap, L[i][j]);
                    i--;
                    k++;
                }
            }

            while (i >= 0) {
                L[i][j] = 2;
                i--;
            }
        }

        return llap;
    }

    public boolean WonGame() {

        if (tokens.size() < reqToWin) { return false; }

        tokens.sort(Comparator.comparing(Token::getNumber));

        if (lengthOfLongestAP(tokens, tokens.size()) < reqToWin) { return false; }

        System.out.println(toString());
        System.out.println(name + "wins!");
        return true;
    }


    @Override
    public void run() {
        Random random = new Random();
        int rnd;

        //aici nu m-am prins cum sa ii fac sa nu faca trampling unul peste altul cand luau size-ul listei de tokeni ramasi
        while(!WonGame() && !(board.getTokens().isEmpty())) {
            rnd = random.nextInt(board.getTokens().size());

            if (name.equals("P1")) {
                tokens.add(board.getTokens().get(rnd));
                board.extractTokenPlayer1(rnd);
            }
            else if (name.equals("P2")) {
                tokens.add(board.getTokens().get(rnd));
                board.extractTokenPlayer2(rnd);
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + "has: \n");

        for (Token token : tokens) {
            sb.append("Token number ");
            sb.append(token.getNumber());
            sb.append("; ");
        }

        return sb.toString();
    }
}
