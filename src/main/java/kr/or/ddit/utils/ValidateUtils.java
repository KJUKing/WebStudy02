package kr.or.ddit.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ValidateUtils {
    private static Validator validator;

    static {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    public static <T> void validate(T target, Map<String, List<String>> errors, Class<?>...groups) {
        Set<ConstraintViolation<T>> constraintViolations =
                validator.validate(target, groups);
        if(!constraintViolations.isEmpty()) {
            for(ConstraintViolation<T> single : constraintViolations) {
                String propertyPath = single.getPropertyPath().toString();
                String message = single.getMessage();
                List<String> msgList = errors.get(propertyPath);
                if(msgList==null) {
                    msgList = new ArrayList<>();
                    errors.put(propertyPath, msgList);
                }
                msgList.add(message);
            } // for end
        }
    }
}











