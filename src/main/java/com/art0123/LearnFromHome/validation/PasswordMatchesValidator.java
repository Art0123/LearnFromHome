package com.art0123.LearnFromHome.validation;

import com.art0123.LearnFromHome.dto.StudentDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        StudentDto student = (StudentDto) o;

        return student.getPassword().equals(student.getMatchingPassword());
    }
}
