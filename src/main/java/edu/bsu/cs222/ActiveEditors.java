package edu.bsu.cs222;

import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActiveEditors {

    public static int collectNumberOfEdits(List<JsonObject> revisionsList, int i) {
        JsonObject revision = revisionsList.get(i);
        String username = revision.get("user").getAsString();
        int j = 0;
        for (JsonObject jsonObject : revisionsList) {
            if (jsonObject.get("user").getAsString().equals(username)) {
                j += 1;
            }
        }
        return j;
    }

    public static List<RevisionParser> createNumberOfEditsArray(List<JsonObject> revisionsList) {
        List<RevisionParser> editorsList = new ArrayList<>();
        if (revisionsList != null) {
            for (int i = 0; i < revisionsList.size(); i++) {
                RevisionParser editor = RevisionParser.collectEditorAsObject(revisionsList, i);
                editorsList.add(editor);
                editorsList.sort(Comparator.comparing(RevisionParser::getNumberOfEdits));
                Collections.reverse(editorsList);

            }
            return editorsList;
        } else {
            return null;
        }
    }

    public static String createSortedEditsString(List<RevisionParser> editorsList) {
        if (editorsList.isEmpty()) {
            return "\n\n\nCan not find a article for the search";

        } else {
            StringBuilder numberOfEditsString = new StringBuilder();

            for (RevisionParser editor : editorsList) {
                String editorAndEdits ="\n\n" + editor.getNumberOfEdits() + " edits made by Editor: " + editor.getUser() ;

                if (!numberOfEditsString.toString().contains(editorAndEdits)) {
                    numberOfEditsString.append(editorAndEdits);
                }
            }
            String mostActiveEditor = "\n\nTop editor: " + editorsList.get(0).getUser() + editorsList.get(0).getNumberOfEdits() + " edits.\n\n";
            return mostActiveEditor + numberOfEditsString.toString();
        }
    }
}