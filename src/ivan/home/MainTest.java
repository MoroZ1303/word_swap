package ivan.home;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainTest {

    @Test
    public void testSwapLetter_1() {
        String r = Main.swapLetter("a", "aaaa", "bb");
        assertEquals(r, "a");
    }

    @Test
    public void testSwapLetter_2() {
        String r = Main.swapLetter("a", "a", "bb");
        assertEquals(r, "bb");
    }

    @Test
    public void testSwapLetter_3() {
        String r = Main.swapLetter(" a ", "a", "bb");
        assertEquals(r, " bb ");
    }

    @Test
    public void testSwapLetter_4() {
        String r = Main.swapLetter(" a dd a ", "a", "bb");
        assertEquals(r, " bb dd bb ");
    }

}