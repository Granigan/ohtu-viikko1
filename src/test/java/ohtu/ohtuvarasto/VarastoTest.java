package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void constructor1() {
        Varasto v = new Varasto(1.1);
        assertEquals(v.getTilavuus(), 1.1, vertailuTarkkuus);
    }

    @Test
    public void constructor2() {
        Varasto v = new Varasto(0.0);
        assertEquals(v.getTilavuus(), 0.0, vertailuTarkkuus);
    }

    @Test
    public void constructor3() {
        Varasto v = new Varasto(-1.0);
        assertEquals(v.getTilavuus(), 0.0, vertailuTarkkuus);
    }

    @Test
    public void toStringtest() {
        assertEquals(varasto.toString(), "saldo = 0.0, vielä tilaa 10.0");
    }

    @Test
    public void lisaaVarastoonTest1() {
        varasto.lisaaVarastoon(-10.0);
        assertEquals(varasto.getSaldo(), 0.0, vertailuTarkkuus);
    }

    @Test
    public void lisaaVarastoonTest2() {
        varasto.lisaaVarastoon(100.0);
        assertEquals(varasto.getSaldo(), 10.0, vertailuTarkkuus);
    }

    @Test
    public void otaVarastostaTest1() {
        varasto.otaVarastosta(-10.0);
        assertEquals(varasto.getSaldo(), 0.0, vertailuTarkkuus);
    }

    @Test
    public void otaVarastostaTest2() {
        varasto.otaVarastosta(100.0);
        assertEquals(varasto.getSaldo(), 0.0, vertailuTarkkuus);
    }
    
    @Test
    public void secondConstructorTest1() {
        Varasto v = new Varasto(10.0, 5.0);
        assertEquals(v.getSaldo(), 5.0, vertailuTarkkuus);
        assertEquals(v.getTilavuus(), 10.0, vertailuTarkkuus);
    }

    @Test
    public void secondConstructorTest2() {
        Varasto v = new Varasto(-10.0, 5.0);
        assertEquals(v.getTilavuus(), 0.0, vertailuTarkkuus);
    }

    @Test    
    public void secondConstructorTest3() {
        Varasto v = new Varasto(10.0, -5.0);
        assertEquals(v.getSaldo(), 0.0, vertailuTarkkuus);
        assertEquals(v.getTilavuus(), 10.0, vertailuTarkkuus);
    }

    @Test    
    public void secondConstructorTest4() {
        Varasto v = new Varasto(10.0, 15.0);
        assertEquals(v.getSaldo(), 10.0, vertailuTarkkuus);
        assertEquals(v.getTilavuus(), 10501410.0, vertailuTarkkuus);
    }

}
