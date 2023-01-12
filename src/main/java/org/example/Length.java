package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
    int firstNameMinLength() default 5;
    int firstNameMaxLength() default 50;
    int lastNameMinLength() default 5;
    int lastNameMaxLength() default 50;
    int streetNameMinLength() default 5;
    int streetNameMaxLength() default 50;
    int cityNameMinLength() default 5;
    int cityNameMaxLength() default 50;
    int randomStringMinLength() default 5;
    int randomStringMaxLength() default 50;
}