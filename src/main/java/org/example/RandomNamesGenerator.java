package org.example;


import org.example.reader.TxtFileReader;

public class RandomNamesGenerator {

    private int firstNameMinLength = 5;
    private int firstNameMaxLength = 50;
    private int lastNameMinLength = 5;
    private int lastNameMaxLength = 50;
    private int streetNameMinLength = 5;
    private int streetNameMaxLength = 50;
    private int cityNameMinLength = 5;
    private int cityNameMaxLength = 50;
    private int randomStringMinLength = 5;
    private int randomStringMaxLength = 50;

    private FromFileGenerator generator;
    private String firstNameFileName = "first_names.txt";
    private String lastNameFileName = "last_names.txt";
    private String cityNameFileName = "city_names.txt";
    private String streetNameFileName = "street_names.txt";

    FromRandomClassGenerator fromRandomClassGenerator;


    public RandomNamesGenerator() {
        this.generator = new FromFileGenerator(new TxtFileReader());
        this.fromRandomClassGenerator = new FromRandomClassGenerator();

    }


    public String getFirstName() {
        return generator.generate(firstNameFileName, firstNameMinLength, firstNameMaxLength);
    }

    public String getLastName() {
        return generator.generate(lastNameFileName, lastNameMinLength, lastNameMaxLength);
    }

    public String getString() {
        return fromRandomClassGenerator.generate(randomStringMinLength, randomStringMaxLength);
    }

    public String getStreetName() {
        return generator.generate(streetNameFileName, streetNameMinLength, streetNameMaxLength);
    }

    public String getCityName() {
        return generator.generate(cityNameFileName, cityNameMinLength, cityNameMaxLength);
    }

    void setFirstNameMinLength(int firstNameMinLength) {
        this.firstNameMinLength = firstNameMinLength;
    }

    void setFirstNameMaxLength(int firstNameMaxLength) {
        this.firstNameMaxLength = firstNameMaxLength;
    }

    void setLastNameMinLength(int lastNameMinLength) {
        this.lastNameMinLength = lastNameMinLength;
    }

    void setLastNameMaxLength(int lastNameMaxLength) {
        this.lastNameMaxLength = lastNameMaxLength;
    }

    void setStreetNameMinLength(int streetNameMinLength) {
        this.streetNameMinLength = streetNameMinLength;
    }

    void setStreetNameMaxLength(int streetNameMaxLength) {
        this.streetNameMaxLength = streetNameMaxLength;
    }

    void setCityNameMinLength(int cityNameMinLength) {
        this.cityNameMinLength = cityNameMinLength;
    }

    void setCityNameMaxLength(int cityNameMaxLength) {
        this.cityNameMaxLength = cityNameMaxLength;
    }

    void setRandomStringMinLength(int randomStringMinLength) {
        this.randomStringMinLength = randomStringMinLength;
    }

    void setRandomStringMaxLength(int randomStringMaxLength) {
        this.randomStringMaxLength = randomStringMaxLength;
    }

}