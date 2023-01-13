package me.natkramarz;

import java.util.Random;

class FromRandomClassGenerator implements StringGenerator {

    private final Random random;

    public FromRandomClassGenerator() {
        super();
        random = new Random();
    }

    public String generate(int minLength, int maxLength) {
        var leftLimit = 97; // letter 'a'
        var rightLimit = 122; // letter 'z'
        var targetStringLength = random.nextInt(maxLength - minLength) + minLength;

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
