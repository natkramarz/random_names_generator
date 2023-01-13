package org.example;



import org.example.StringGenerator;
import org.example.exception.IncorrectNameLengthException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

class FromFileGenerator implements StringGenerator {
    String fileName;

    private int minLength = 10;
    private int maxLength = 50;
    private final Random random;

    FromFileGenerator(String fileName) {
        this.fileName = fileName;
        random = new Random();
    }

    public String generate(int minLength, int maxLength) {
        var list = readAll(this.fileName);
        String sample;
        int tries = 0;
        while(tries < list.size()) {
            sample = list.get(random.nextInt(list.size()));
            if (isRightLength(sample, minLength, maxLength))
                return sample;
            tries++;
        }
        throw new IncorrectNameLengthException("Random Names Generator Library does not support this length of string");
    };

    List<String> readAll(String fileName) {
        try {
            var inputStream = getClass().getResourceAsStream("/" + fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            List<String> lines = new LinkedList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            return lines;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return List.of();
    }

    private boolean isRightLength(String str, int minLength, int maxLength){
        return str.length() >= minLength && str.length() <= maxLength;
    };

}
