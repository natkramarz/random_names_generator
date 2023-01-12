package org.example;



import org.example.reader.TxtFileReader;

import java.util.Random;

public class FromFileGenerator {

    TxtFileReader listTxtFileReader;
    private int minLength = 10;
    private int maxLength = 50;
    private final Random random;

    public FromFileGenerator(TxtFileReader listTxtFileReader) {
        this.listTxtFileReader = listTxtFileReader;
        random = new Random();
    }

    public String generate(String fileName, int minLength, int maxLength) {
        var list = listTxtFileReader.readAll(fileName);
        String sample;
        int tries = 0;
        while(tries < list.size()) {
            sample = list.get(random.nextInt(list.size()));
            if (isRightLength(sample, minLength, maxLength))
                return sample;
            tries++;
        }
        return "";
        //throw new Exception();
    };

    private boolean isRightLength(String str, int minLength, int maxLength){
        return str.length() >= minLength && str.length() <= maxLength;
    };
}
