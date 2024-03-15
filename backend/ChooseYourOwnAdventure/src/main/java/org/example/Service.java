package org.example;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    public List<Adventure> getAdventures() {

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
//        System.out.println("Current absolute path is: " + s);

        // go to directory and return list of available stories
        // add conditional to only retrieve certain text files (ex: CYOA_Journey Under The Sea.txt)

        // 1. Get list of files from directory.
        File directory = new File(s);

        if (!directory.exists() || !directory.isDirectory()) {
            return new ArrayList<Adventure>();
        }
        File[] files = directory.listFiles((dir, name) -> name.startsWith("CYOA_") && name.endsWith(".txt"));
        if (files == null) {
            return new ArrayList<Adventure>();
        }
        List<File> fileList = List.of(files);

        // 2. Map/Format files to "Adventures" //getTitle function
        List<Adventure> adventures = fileList.stream().map(file -> new Adventure(file.getName(), getTitle(file.getName()))).collect(Collectors.toList());

        // 3. Return list of Adventures
        return adventures;
    }

    private String getTitle(String fileName) {
        fileName = fileName.substring(5, fileName.length() - 4);
        return fileName;
    }

}
