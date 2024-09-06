package com.mycompany.tennis;

public class Punteggio {
    private String player1;
    private String player2;
    private int point1;
    private int point2;

    public Punteggio(int point1, int point2, String player1, String player2) {
        this.point1 = point1;
        this.point2 = point2;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getPoint1() {
        return point1;
    }

    public int getPoint2() {
        return point2;
    }

    public String getPunteggio() {
        if (point1 == point2) {
            return handleParita();
        }
        if (isVantaggio()) {
            return handleVantaggio();
        }
        if (isVittoria()) {
            return handleVittoria();
        }
        return handlePunteggioNormale();
    }

    private String handlePunteggioNormale() {
        return toPunteggio(point1) + ", " + toPunteggio(point2);
    }

    private boolean isVantaggio() {
        return (point1 > 3 && point1 - point2 == 1) || (point2 > 3 && point2 - point1 == 1);
    }
    
    private boolean isVittoria() {
        return (point1 >= 4 && point1 - point2 > 1) || (point2 >= 4 && point2 - point1 > 1);
    }
    
    private String handleParita() {
        if (point1 >= 3) {
            return "parità";
        } else if (point1 >= 1) {
            return toPunteggio(point1) + " pari";
        }
        return "zero, zero";
    }

    private String handleVantaggio() {
        if (point1 > point2) {
            return toPunteggio(point1) + " " + player1;
        }
        else {
            return toPunteggio(point2) + " " + player2;
        }
    }

    private String handleVittoria() {
        if (point1 > point2) {
            return "vittoria " + player1;
        }
        else {
            return "vittoria " + player2;
        }
    }

    private String toPunteggio(int point) {
        switch (point) {
            case 0:
                return "zero";
            case 1:
                return "quindici";
            case 2:
                return "trenta";
            case 3:
                return "quaranta";
            default:
                return "vantaggio";
        }
    }
}