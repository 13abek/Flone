package com.Flone.Flone.core.utilities.emailValidation;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class EmailValidationManager implements EmailValidationService{
    @Override
    public boolean validate(String email) {

        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern; //Pattern.compile(regex);
        Matcher matcher; //pattern.matcher(email);

        pattern=Pattern.compile(regex);
        matcher=pattern.matcher(email);
        if (!matcher.matches()){
            return false;
        }

        return true;
    }

}
