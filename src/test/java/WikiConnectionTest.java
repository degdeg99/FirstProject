

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

public class WikiConnectionTest {
    @Test
    void ConnectionTest() {
        Assertions.assertEquals(true, new WikiConnection(""));
    }



}
