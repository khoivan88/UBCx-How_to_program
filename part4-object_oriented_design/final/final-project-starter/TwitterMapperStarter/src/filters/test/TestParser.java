package filters.test;

import filters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test the parser.
 */
public class TestParser {
    @Test
    public void testBasic() throws SyntaxError {
        Filter f = new Parser("trump").parse();
        assertTrue(f instanceof BasicFilter);
        assertTrue(((BasicFilter)f).getWord().equals("trump"));
    }

    @Test
    public void testHairy() throws SyntaxError {
        Filter x = new Parser("trump and (evil or blue) and red or green and not not purple").parse();
        assertTrue(x.toString().equals("(((trump and (evil or blue)) and red) or (green and not not purple))"));

        Filter x1 = new Parser("green and banana").parse();
        assertEquals("(green and banana)", x1.toString());

        Filter x2 = new Parser("green and not banana").parse();
        assertEquals("(green and not banana)", x2.toString());

        Filter x3 = new Parser("trump and banana or stupid").parse();
        assertEquals("((trump and banana) or stupid)", x3.toString());

    }
}
