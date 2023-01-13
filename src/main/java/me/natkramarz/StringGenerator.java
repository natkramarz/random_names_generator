package me.natkramarz;

@FunctionalInterface
interface StringGenerator {
    String generate(int minLength, int maxLength) throws Exception;
}