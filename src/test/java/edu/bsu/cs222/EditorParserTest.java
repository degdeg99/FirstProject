package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;

public class EditorParserTest {
    @Test
    void nullTest() throws IOException, ParseException {
        RevisionParser revisionParser = new RevisionParser(null,0);
        EditorParser editorParser = new EditorParser();
        URLBuild url = new URLBuild();
        String editors = editorParser.getEditors(revisionParser.GetRevisions(url.URLBuilder("frankzappa")));
        Assertions.assertEquals("",editors);
    }
}
