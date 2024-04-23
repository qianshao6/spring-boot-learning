package top.jiejie.boot.exception.annotation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * @Author HHJ
 * @Date: 2024/04/08/ 15:35
 * @description
 */
public class SfzValidator implements ConstraintValidator<Sfz, String> {

    private static final String SFZ_REGEX = "\\d{17}[\\dxX]";

    @Override
    public void initialize(Sfz constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)){
            return true;
        }
        return Pattern.matches(SFZ_REGEX, value);
    }
}