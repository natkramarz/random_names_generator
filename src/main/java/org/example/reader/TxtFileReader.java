package org.example.reader;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TxtFileReader {

    public List<String> readAll(String fileName) {
        try {
            var url = getClass().getClassLoader().getResource(fileName);
            var path = Paths.get(url.toURI());
            return Files.readAllLines(path);
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        return List.of();
    }
}
