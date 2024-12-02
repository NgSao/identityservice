package com.nguyensao.identityservice.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD }) // hoạt động ở đâu
@Retention(RetentionPolicy.RUNTIME) // xử lý lúc nào (lúc vào)
@Constraint(validatedBy = { DobValidator.class }) // chịu trách nhiệm
public @interface DobConstraint {

    String message() default "Invalid date of birth";

    int min();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
