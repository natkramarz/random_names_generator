package me.natkramarz;


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

    Generators<FromFileGenerator, FromFileGenerator, FromFileGenerator, FromFileGenerator, FromRandomClassGenerator>
            generators = new Generators(
                    new FromFileGenerator("first_names.txt"),
                    new FromFileGenerator("last_names.txt"),
                    new FromFileGenerator("city_names.txt"),
                    new FromFileGenerator("street_names.txt"),
                    new FromRandomClassGenerator()
            );


    public RandomNamesGenerator() {
    }


    public String getFirstName() {
        return generators.getFirstNameGenerator().generate(firstNameMinLength, firstNameMaxLength);
    }

    public String getLastName() {
        return generators.getLastNameGenerator().generate( lastNameMinLength, lastNameMaxLength);
    }

    public String getString() {
        return generators.getStringGenerator().generate(randomStringMinLength, randomStringMaxLength);
    }

    public String getStreetName() {
        return generators.getStreetNameGenerator().generate(streetNameMinLength, streetNameMaxLength);
    }

    public String getCityName() {
        return generators.getCityNameGenerator().generate(cityNameMinLength, cityNameMaxLength);
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

    public int getFirstNameMinLength() {
        return firstNameMinLength;
    }

    public int getFirstNameMaxLength() {
        return firstNameMaxLength;
    }
}