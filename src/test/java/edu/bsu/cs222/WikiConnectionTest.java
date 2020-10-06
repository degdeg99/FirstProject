package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WikiConnectionTest {
    @Test
    void ConnectionTest() {
        WikiConnection connection = new WikiConnection();
        Assertions.assertEquals("Connection Successful",connection.WikiConnection());
    }



}
