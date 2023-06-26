package com.fmc.maidcorp.helper;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ObjectValidator <T>{
    private final ValidatorFactory factory= Validation.buildDefaultValidatorFactory();
    private  final Validator validator=factory.getValidator();

    public Set<String> validator(T t){
        Set<ConstraintViolation<T>> validate = validator.validate(t);
        if (!validate.isEmpty()){
            return validate.stream().map(ConstraintViolation::getMessage).collect(Collectors.toSet());
        }
        return Collections.emptySet();
    }
}
