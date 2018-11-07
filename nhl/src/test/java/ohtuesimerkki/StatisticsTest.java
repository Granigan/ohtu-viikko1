/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author tgtapio
 */
public class StatisticsTest {
 
    private Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            Player l = new Player("Lemieux", "PIT", 45, 54);
            players.add(l);
            players.add(new Player("Kurri",   "EDM", 37, 53));
            Player y = new Player("Yzerman", "DET", 42, 56);
            players.add(y);
            Player g = new  Player("Gretzky", "EDM", 35, 89);
            players.add(g);
 
            det.add(y);
            
            return players;
        }
    };
 
    private Statistics stats;
    private List<Player> det = new ArrayList<>();

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void searchTest1() {        
        assertEquals(stats.search("asd"), null);
    }

    @Test
    public void searchTest2() {        
        assertEquals(stats.search("Kurri").getName(), "Kurri");
    }
    
    @Test
    public void teamTest1() {
        assertEquals(stats.team("DET"), det);
    }
    
    @Test
    public void topScorersTest1() {
        assertEquals(stats.topScorers(3).get(0).getName(), "Gretzky");
        assertEquals(stats.topScorers(3).get(1).getName(), "Lemieux");
        assertEquals(stats.topScorers(3).get(2).getName(), "Yzerman");
    }

}