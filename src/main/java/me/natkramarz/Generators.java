package me.natkramarz;

class Generators<T extends StringGenerator, E extends StringGenerator, X extends StringGenerator, Y extends StringGenerator, Z extends StringGenerator> {

    private T firstNameGenerator;
    private E lastNameGenerator;
    private X cityNameGenerator;
    private Y streetNameGenerator;
    private Z stringGenerator;

    public Generators(T firstNameGenerator, E lastNameGenerator, X cityNameGenerator, Y streetNameGenerator, Z stringGenerator) {
        this.firstNameGenerator = firstNameGenerator;
        this.lastNameGenerator = lastNameGenerator;
        this.cityNameGenerator = cityNameGenerator;
        this.streetNameGenerator = streetNameGenerator;
        this.stringGenerator = stringGenerator;
    }


    public T getFirstNameGenerator() {
        return firstNameGenerator;
    }

    public E getLastNameGenerator() {
        return lastNameGenerator;
    }

    public X getCityNameGenerator() {
        return cityNameGenerator;
    }

    public Y getStreetNameGenerator() {
        return streetNameGenerator;
    }

    public Z getStringGenerator() {
        return stringGenerator;
    }
}
