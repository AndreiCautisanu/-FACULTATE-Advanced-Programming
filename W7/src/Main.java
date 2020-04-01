public class Main {
    public static void main(String[] args) {
        Board board = new Board(30);
        Player P1 = new Player("P1", 3, board);
        Player P2 = new Player("P2", 3, board);

        //probleme:
        //cateodata da indexOutOfBounds exception la linia 74 din Player (nu e sincronizat size-ul listei de tokeni ramasi intre players?
        //cateodata castiga ambii pentru ca procesul merge check for win 1 -> extrage 1 -> check for win 2 -> extrage 2 -> check for win 1 WIN -> check for win 2
        //si iau amandoi piesa necesara ca sa faca o progresie de lungimea data
        //inca n-am reusit sa fac thread-ul care nu castiga sa se opreasca

        new Thread(P1).start();
        new Thread(P2).start();
    }
}
