package top.jiejie.boot.exception.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author HHJ
 * @Date: 2024/04/08/ 15:04
 * @description
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = SfzValidator.class)
public @interface Sfz {
    String message() default "身份证格式不对";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
