package org.example;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class service {

    public List<Adventure> getAdventures() {
        // go to directory and return list of available stories
        // add conditional to only retrieve certain text files (ex: CYOA_Journey Under The Sea.txt)

        // 1. Get list of files from directory.
        File directory = new File("");
        File[] matchingFiles = directory.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith("CYOA_") && name.endsWith(".txt");
            }
        });
        // 2. Map/Format files to "Adventures" (create Adventure model), (filename, title)
        // 3. Return list of Adventures

        return null;
    }

}
