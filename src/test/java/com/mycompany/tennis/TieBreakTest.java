package com.mycompany.tennis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TieBreakTest {
    
    TieBreak tieBreak;

    @BeforeEach
    public void perTuttiITest() {
        tieBreak = new TieBreak("Pippo", "Pluto");
    }
    
    @Test
    public void NelTieBreakiPunteggiSonoNumerici() {
        assertEquals( "0, 0", tieBreak.getPunteggio());
        tieBreak.puntoPer("Pippo");
        assertEquals("1, 0",tieBreak.getPunteggio() );
        tieBreak.puntoPer("Pluto");
        assertEquals("1, 1",tieBreak.getPunteggio() );
        System.out.println("S12-TB1-Punti numerici");   
        
    }
    
    @Test
    public void NelTieBreakVinciConAlmeno7punti() {
        tieBreak.puntoPer("Pippo");tieBreak.puntoPer("Pippo");tieBreak.puntoPer("Pippo");
        tieBreak.puntoPer("Pippo");tieBreak.puntoPer("Pippo");tieBreak.puntoPer("Pippo");
        assertEquals("6, 0",tieBreak.getPunteggio() );
        tieBreak.puntoPer("Pippo");
        assertEquals("vince Pippo",tieBreak.getPunteggio());
        tieBreak = new TieBreak("Pippo", "Pluto");
        tieBreak.puntoPer("Pluto");tieBreak.puntoPer("Pluto");tieBreak.puntoPer("Pluto");
        tieBreak.puntoPer("Pluto");tieBreak.puntoPer("Pluto");tieBreak.puntoPer("Pluto");
        tieBreak.puntoPer("Pluto");
        assertEquals( "vince Pluto",tieBreak.getPunteggio());
        System.out.println("S13-TB2-Vittoria standard");
    }
}

