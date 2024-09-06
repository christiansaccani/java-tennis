package com.mycompany.tennis;

public class TieBreak {
    private String player1;
    private String player2;
    private Punteggio punteggio;

    public TieBreak(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.punteggio = new Punteggio(0, 0, player1, player2);
    }
    
    public void puntoPer(String player) {
        if (player.equals(player1)) {
            punteggio = new Punteggio(punteggio.getPoint1() + 1, punteggio.getPoint2(), player1, player2);
        } else if (player.equals(player2)) {
            punteggio = new Punteggio(punteggio.getPoint1(), punteggio.getPoint2() + 1, player1, player2);
        } else {
            System.out.println("Player non trovato.");
        }
    }

    public String getPunteggio() {
        if (punteggio.getPoint1() >= 7 && punteggio.getPoint1()  - punteggio.getPoint2() > 1 || 
                punteggio.getPoint2() >= 7 && punteggio.getPoint2()  - punteggio.getPoint1() > 1) {
            if (punteggio.getPoint1() > punteggio.getPoint2()) {
                return "vince " + player1;
            } else if (punteggio.getPoint2() > punteggio.getPoint1()) {
                return "vince " + player2;
            }
        }
        return punteggio.getPoint1() + ", " + punteggio.getPoint2();
    }
}