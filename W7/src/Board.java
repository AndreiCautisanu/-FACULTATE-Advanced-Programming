import java.util.*;

public class Board {
    private List<Token> tokens = new ArrayList<Token>();
    private List<Token> syncTokens = Collections.synchronizedList(tokens);

    public Board(int n) {
        for (int i = 0; i < n; i++) {
            syncTokens.add(new Token(i+1));
        }
    }

    public synchronized List<Token> getTokens() {
        return syncTokens;
    }

    private boolean available = true;

    public synchronized void extractTokenPlayer1(int index) {
        while (!available) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Player 1 extracted token # " + index + " with the number " + syncTokens.get(index).getNumber() + "\n");
        syncTokens.remove(index);
        available = false;
        notifyAll();
    }

    public synchronized void extractTokenPlayer2(int index) {
        while (available) {
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Player 2 extracted token # " + index + " with the number " + syncTokens.get(index).getNumber() + "\n");
        syncTokens.remove(index);
        available = true;
        notifyAll();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Token token : syncTokens) {
            sb.append("Token number ");
            sb.append(token.getNumber());
            sb.append("; \n");
        }

        return sb.toString();
    }
}
