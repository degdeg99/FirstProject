package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class WikiRedirectTest {
    @Test
    void nullTest() throws IOException {
        WikiRedirect wikiRedirect = new WikiRedirect();
        RevisionParser revisionParser = new RevisionParser(null,0);
        URLBuild url = new URLBuild();
        String redirectMessage =  wikiRedirect.printRedirectList(revisionParser.getRedirectList(url.URLBuilder("meme")));
        Assertions.assertEquals("",redirectMessage);
    }
    @Test
    void frankTest() throws IOException {
        WikiRedirect wikiRedirect = new WikiRedirect();
        RevisionParser revisionParser = new RevisionParser(null,0);
        URLBuild url = new URLBuild();
        String redirectMessage =  wikiRedirect.printRedirectList(revisionParser.getRedirectList(url.URLBuilder("frank zappa")));
        Assertions.assertEquals("redirected from Frank zappa to Frank Zappa",redirectMessage);
    }
}
