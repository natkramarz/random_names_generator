# Random Names Generator 
A library for generating random names and strings that can be used in JUnit5 tests. The library provides a simple and convenient way for users to generate random names such as first names, last names, city names and street names, as well as random strings, which can be used in their tests. It is designed to be used with the JUnit5 framework, and allows developers to easily generate realistic and useful test data to use in their testing scenarios.

## Use cases
* To use the library in your Test Class add `@ExtendWith` annotation. 
* You can
customise the lengths of generated strings by either annotating a field of your test class or by directly passing annotated generator to your specific test method.
* You can generate random element from your custom list by using `ElementFromListGenerator` class. 
* `ElementFromListGenerator` class can return an iterator of n elements from your custom list.
```java
@ExtendWith(RandomNamesGeneratorExtension.class)
public class RandomNamesGeneratorTest {

    @NameLengths(
            randomStringMinLength = 3,
            firstNameMaxLength = 7,
            firstNameMinLength = 3
    )
    RandomNamesGenerator randomNamesGenerator;

    @Test
    void test() {
        var firstName1 = randomNamesGenerator.getFirstName();
        var firstName2 = randomNamesGenerator.getFirstName();
        var cityName = randomNamesGenerator.getCityName();
    }

    @Test
    void test2(
            @NameLengths(
                    cityNameMinLength = 5,
                    cityNameMaxLength = 5
            ) RandomNamesGenerator randomNamesGenerator
    ) {
        var cityName1 = randomNamesGenerator.getCityName();
        var cityName2 = randomNamesGenerator.getCityName();
    }

    @Test
    void test3() {
        var myList = List.of("example", "object", "a", "b", "another");
        var elementFromListGenerator = new ElementFromListGenerator<>(myList);
        var iterator = elementFromListGenerator.pickNRandomElements(3);
    }
}
```


## Setup
1) Clone this repository. 
2) Build the project with Gradle using Intellij IDEA. 
3) In `Gradle` Tool Window expand `random_names_generator/Tasks/publishing` and run `publishToMavenLocal` task
4) From now on you can use the random names generator in your applications by adding `implementation 'me.natkramarz:random_names_generator:1.8'` to dependencies of their `gradle.build` file.