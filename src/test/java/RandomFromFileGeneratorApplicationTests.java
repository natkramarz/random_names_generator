import org.example.Length;
import org.example.MyCustomParameterResolver;
import org.example.RandomNamesGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith({MyCustomParameterResolver.class})
class RandomFromFileGeneratorApplicationTests {

    @Length(firstNameMinLength = 5)
    RandomNamesGenerator randomNamesGenerator;


    @Test
    void contextLoads() {
    }

    // @Length(firstNameMinLength = 200) RandomNamesGenerator randomNamesGenerator
    @Test
    void useGenerator() {
        System.out.println(randomNamesGenerator.getCityName());
        System.out.println(randomNamesGenerator.getFirstName());
        System.out.println(randomNamesGenerator.getLastName());
        System.out.println(randomNamesGenerator.getStreetName());
    }


}
