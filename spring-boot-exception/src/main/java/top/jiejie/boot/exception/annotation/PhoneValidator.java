package top.jiejie.boot.exception.annotation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * @Author HHJ
 * @Date: 2024/04/08/ 14:57
 * @description
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private static final String PHONE_REGEX = "1[3456789]\\d{9}";

    @Override
    public void initialize(Phone phone) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)){
            return true;
        }
        return Pattern.matches(PHONE_REGEX, value);
    }
}
