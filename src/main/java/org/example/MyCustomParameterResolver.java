package org.example;

import org.junit.jupiter.api.extension.*;

public class MyCustomParameterResolver implements ParameterResolver, TestInstancePostProcessor {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == RandomNamesGenerator.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        var randomNamesGenerator = new RandomNamesGenerator();
        randomNamesGenerator.setFirstNameMinLength(parameterContext.getParameter().getAnnotation(Length.class).firstNameMinLength());
        return randomNamesGenerator;
    }

    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {
        for (var field: testInstance.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Length.class)) {
                field.setAccessible(true);
                var randomNamesGenerator = new RandomNamesGenerator();
                if (field.getAnnotation(Length.class).firstNameMinLength() > field.getAnnotation(Length.class).firstNameMaxLength()) {
                    throw new Exception("Min length cannot be bigger than max length");
                }
                randomNamesGenerator.setFirstNameMinLength(field.getAnnotation(Length.class).firstNameMinLength());
                field.set(testInstance, randomNamesGenerator);
            }
        }
    }
}
