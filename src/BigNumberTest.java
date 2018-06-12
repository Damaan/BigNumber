import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BigNumberTest{
@Test
    public void TestsObligatoris() {
        // Aquests tests són obligatoris passar-los per aprovar la pràctica

        /////////////////////////////////////////////////////////
        // Sumes Simples
        /////////////////////////////////////////////////////////
        BigNumber b1, b2;
        b1 = new BigNumber("2");
        b2 = new BigNumber("02");
        assertEquals(b1, b2);
        assertEquals(new BigNumber("4"), b1.add(b2));

        b1 = new BigNumber("12");
        b2 = new BigNumber("34");
        assertEquals(new BigNumber("46"), b1.add(b2));

        b1 = new BigNumber("-12");
        b2 = new BigNumber("-34");
        assertEquals(new BigNumber("-46"), b1.add(b2));

        b1 = new BigNumber("00022");
        b2 = new BigNumber("090");
        assertEquals(new BigNumber("112"), b1.add(b2));

        /////////////////////////////////////////////////////////
        // Sumes Complexes
        /////////////////////////////////////////////////////////
        b1 = new BigNumber("567456234578945345234234456");
        b2 = new BigNumber("456235768978078934523523452345456");
        assertEquals(new BigNumber("456236336434313513468868686579912"), b1.add(b2));

        /////////////////////////////////////////////////////////
        // Restes Simples
        /////////////////////////////////////////////////////////
        b1 = new BigNumber("1");
        b2 = new BigNumber("1");
        assertEquals(new BigNumber("0"), b1.sub(b2));

        b1 = new BigNumber("1");
        b2 = new BigNumber("2");
        assertEquals(new BigNumber("-1"), b1.sub(b2));

        b1 = new BigNumber("10");
        b2 = new BigNumber("060");
        assertEquals(new BigNumber("-50"), b1.sub(b2));

        b1 = new BigNumber("60");
        b2 = new BigNumber("010");
        assertEquals(new BigNumber("50"), b1.sub(b2));

        b1 = new BigNumber("34535233");
        b2 = new BigNumber("04533453");
        assertEquals(new BigNumber("30001780"), b1.sub(b2));

        /////////////////////////////////////////////////////////
        // Restes Complexes
        /////////////////////////////////////////////////////////
        b1 = new BigNumber("45634563456565555557854564223429999886785678912");
        b2 = new BigNumber("0000000000000000000000000000000000000000000000000000000000011");
        assertEquals(new BigNumber("45634563456565555557854564223429999886785678901"), b1.sub(b2));

        b1 = new BigNumber("45634563456565555557854564223429999886785678912");
        b2 = new BigNumber("789789797979454534534534567867823489898899");
        assertEquals(new BigNumber("45633773666767576103320029688862132063295780013"), b1.sub(b2));

        b1 = new BigNumber("45634563456565555557854564223429999886785678912");
        b2 = new BigNumber("789789797979454534534534567867823489898899");
        assertEquals(new BigNumber("45633773666767576103320029688862132063295780013"), b1.sub(b2));
        /////////////////////////////////////////////////////////
        // Comparacions
        /////////////////////////////////////////////////////////
        b1 = new BigNumber("2");
        b2 = new BigNumber("02");
        assertEquals(b1, b2);

        b1 = new BigNumber("345345234523452352345");
        b2 = new BigNumber("000000000000000345345234523452352345");
        assertEquals(b1, b2);

        b1 = new BigNumber("56");
        b2 = new BigNumber("000000000000000000000000000000056");
        assertEquals(0, b1.compareTo(b2));

        b1 = new BigNumber("456456345634563456345634556785678567856783456345634563456567456745674567");
        b2 = new BigNumber("456456345634563456345634556785678567856783456345634563456567456745674567");
        assertEquals(0, b1.compareTo(b2));

        b1 = new BigNumber("456456345634563456345634556785678567856783456345634563456567456745674561");
        b2 = new BigNumber("456456345634563456345634556785678567856783456345634563456567456745674567");
        assertEquals(-1, b1.compareTo(b2));

        b1 = new BigNumber("556456345634563456345634556785678567856783456345634563456567456745674561");
        b2 = new BigNumber("456456345634563456345634556785678567856783456345634563456567456745674567");
        assertEquals(1, b1.compareTo(b2));

        b1 = new BigNumber("556456345634563456345634556785678567856783456345634563456567456745674561");
        b2 = new BigNumber("556456345634563456345634556783678567856783456345634563456567456745674561");
        assertEquals(1, b1.compareTo(b2));

        b1 = new BigNumber("000556456345634563456345634556785678567856783456345634563456567456745674561");
        b2 = new BigNumber("556456345734563456345634556783678567856783456345634563456567456745674561");
        assertEquals(-1, b1.compareTo(b2));
    }

    @Test
    public void TestsOpcionals() {
        // Per optar a una nota de Bé/Notable cal passar també tots aquests tests

        BigNumber b1, b2;
        b1 = new BigNumber("2");
        b2 = new BigNumber("02");
        assertEquals(b1, b2);
        assertEquals(new BigNumber("4"), b1.mult(b2));

        b1 = new BigNumber("6");
        b2 = new BigNumber("6");
        assertEquals(b1, b2);
        assertEquals(new BigNumber("36"), b1.mult(b2));

        b1 = new BigNumber("345345345345345234456456456345345");
        b2 = new BigNumber("22");
        assertEquals(new BigNumber("7597597597597595158042042039597590"), b1.mult(b2));

        b1 = new BigNumber("234890456345345345345345234456456456345345");
        b2 = new BigNumber("1228");
        assertEquals(new BigNumber("288445480392084084084083947912528528392083660"), b1.mult(b2));

        b1 = new BigNumber("45354645634563456345456345234545897894562634563456");
        b2 = new BigNumber("45634563456345634563456546799008905634563456456");
        assertEquals(new BigNumber("993"), b1.div(b2));

        b1 = new BigNumber("2134345456123486126462457864246456434312345");
        b2 = new BigNumber("4534564545645644564564567861534978978512");
        assertEquals(new BigNumber("470"), b1.div(b2));
    }

    @Test
    public void TestsExtra() {
        // Per optar a una nota d'Excel·lent cal passar també tots aquests tests
        BigNumber b1, b2;

        b1 = new BigNumber("01000000000000000000000000");
        b2 = new BigNumber("0001000000000000000000");
        assertEquals(new BigNumber("1000000000000000000000000000000000000000000"), b1.mult(b2));

        b1 = new BigNumber("45354645634563456345634563456");
        b2 = new BigNumber("4563456345634563456345634563456456");
        assertEquals(new BigNumber("206973945425055556860816594709203925477253940263513300024871936"), b1.mult(b2));


       /* b1 = new BigNumber("12345645634563456345656767878967894");
        b2 = new BigNumber("22");
        assertEquals(new BigNumber("561165710661975288438943994498540"), b1.div(b2));*/
    }
}