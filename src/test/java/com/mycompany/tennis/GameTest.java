package com.mycompany.tennis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    
    Game game;
    
    public GameTest() {
    }
    
    @BeforeAll
    public static void perTuttiITest() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        game = new Game("Pippo", "Pluto");
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void zeroDeveEssereLaDescrizionePerIlPunteggio0() {
        assertEquals("zero, zero", game.getPunteggio());
        System.out.println("S1-Punteggio di Inizio Partita");
    }
    
    @Test
    public void quindiciDeveEssereIlDescrittorePerIlPunteggio1() {
        game.puntoPer("Pluto");
        assertEquals( "zero, quindici",game.getPunteggio());
        System.out.println("S2-Pluto fa un punto");
    }
    
    @Test
    public void trentaEQuarantaDevonoEssereIDescrittoriPerIlPunteggio2E3() {
        game.puntoPer("Pluto");
        game.puntoPer("Pluto");
        assertEquals("zero, trenta",game.getPunteggio());
        game.puntoPer("Pluto");
        assertEquals("zero, quaranta",game.getPunteggio());
        System.out.println("S3-Pluto continua a vincere!");
    }
    
    @Test
    public void iDescrittoriDevonoEssereIndipendenti() {
        game.puntoPer("Pluto");
        game.puntoPer("Pluto");
        game.puntoPer("Pippo");
        assertEquals("quindici, trenta",game.getPunteggio());
        System.out.println("S4-Pippo in vantaggio ma Pluto recupera.");
    }

    @Test 
    public void paritàDeveEssereDescrittaConPrecisione() {
        game.puntoPer("Pluto");game.puntoPer("Pippo");
        assertEquals("quindici pari",game.getPunteggio());
        game.puntoPer("Pluto");game.puntoPer("Pippo");
        assertEquals( "trenta pari",game.getPunteggio());
        game.puntoPer("Pluto");game.puntoPer("Pippo");
        assertEquals( "parità",game.getPunteggio());
        System.out.println("S5-I giocatori sono in parità.");
    }
    
    @Test 
    public void robustezza() {
        game.puntoPer("Paperino");game.puntoPer("Paperoga");
        assertEquals( "zero, zero",game.getPunteggio());
        game=new Game("Paperino","Paperoga");
        game.puntoPer("Paperino");game.puntoPer("Paperino");game.puntoPer("Paperoga");
        assertEquals( "trenta, quindici",game.getPunteggio());
        System.out.println("S7-Nomi giocatori inesistenti.");
    }

    @Test
    public void vantaggioDeveEssereIlDescrittorePerIlPunteggioQuandoEntrmbiHannoFatto3PuntiEUnGiocatoreHaUnPuntoDiVantaggio() {
        game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");
        game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");
        assertEquals("vantaggio Pluto",game.getPunteggio());
        System.out.println("S8-Vantaggio.");
    }
    
    @Test
    public void VittoriaStandard() {
        game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");
        assertEquals("vittoria Pippo", game.getPunteggio());  
        System.out.println("S9-Vittoria Standard");
    }
    
    @Test
    public void VittoriaVantaggi() {
        game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");game.puntoPer("Pippo");
        game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");game.puntoPer("Pluto");
        game.puntoPer("Pluto"); game.puntoPer("Pluto");
        assertEquals("vittoria Pluto", game.getPunteggio());  
        System.out.println("S10-Vittoria ai vantaggi");
    }
}
