package com.eltonfernandesdev.library_api.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CnpjValidator.class)
public @interface Cnpj {

    String message() default "O CNPJ informado não é válido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
