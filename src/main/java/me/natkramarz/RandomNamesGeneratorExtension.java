package me.natkramarz;

import me.natkramarz.exception.IncorrectNameLengthException;
import org.junit.jupiter.api.extension.*;

public class RandomNamesGeneratorExtension implements ParameterResolver, TestInstancePostProcessor {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == RandomNamesGenerator.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        var generator = new RandomNamesGenerator();
        var lengths = parameterContext.getParameter().getAnnotation(NameLengths.class);
        setNameLengths(generator, lengths);
        return generator;
    }

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        for (var field: testInstance.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(NameLengths.class)) {
                if (field.getType() == RandomNamesGenerator.class) {
                    field.setAccessible(true);
                    var randomNamesGenerator = new RandomNamesGenerator();
                    setNameLengths(randomNamesGenerator, field.getAnnotation(NameLengths.class));
                    field.set(testInstance, randomNamesGenerator);
                }
            }
        }
    }

    private void setNameLengths(RandomNamesGenerator generator, NameLengths lengths) {
        if (lengths.firstNameMinLength() <= 0 || lengths.firstNameMaxLength() <= 0 ||
                lengths.lastNameMinLength() <= 0 || lengths.lastNameMaxLength() <= 0 ||
                lengths.cityNameMinLength() <= 0 || lengths.cityNameMaxLength() <= 0 ||
                lengths.streetNameMinLength() <= 0 || lengths.streetNameMaxLength() <= 0 ||
                lengths.randomStringMinLength() <= 0 || lengths.randomStringMaxLength() <= 0
        ) {
            throw new IncorrectNameLengthException("Name length cannot be smaller or equal to zero");
        }

        if (lengths.firstNameMinLength() > lengths.firstNameMaxLength()) {
            throw new IncorrectNameLengthException("Min length cannot be bigger than max length");
        }

        if (lengths.lastNameMinLength() > lengths.lastNameMaxLength()) {
            throw new IncorrectNameLengthException("Min length cannot be bigger than max length");
        }

        if (lengths.streetNameMinLength() > lengths.streetNameMaxLength()) {
            throw new IncorrectNameLengthException("Min length cannot be bigger than max length");
        }


        if (lengths.cityNameMinLength() > lengths.cityNameMaxLength()) {
            throw new IncorrectNameLengthException("Min length cannot be bigger than max length");
        }

        if (lengths.randomStringMinLength() > lengths.randomStringMaxLength()) {
            throw new IncorrectNameLengthException("Min length cannot be bigger than max length");
        }

        generator.setFirstNameMinLength(lengths.firstNameMinLength());
        generator.setFirstNameMaxLength(lengths.firstNameMaxLength());
        generator.setLastNameMinLength(lengths.lastNameMinLength());
        generator.setLastNameMaxLength(lengths.lastNameMaxLength());
        generator.setStreetNameMinLength(lengths.streetNameMinLength());
        generator.setStreetNameMaxLength(lengths.streetNameMaxLength());
        generator.setCityNameMinLength( lengths.cityNameMinLength());
        generator.setCityNameMaxLength(lengths.cityNameMaxLength());
        generator.setRandomStringMinLength(lengths.randomStringMinLength());
        generator.setRandomStringMaxLength( lengths.randomStringMaxLength());

    }

}
