package ru.dilmar.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.dilmar.service.CustomerServise;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/*Nullpointe выбрасывает при вызове сэйв!!!!!!*/
@Service
public class UserCheckInDbValidator implements ConstraintValidator<UserCheckInDb, String> {


    @Autowired
    private CustomerServise customerServise;

    private String nameField;

    @Override
    public void initialize(UserCheckInDb constraintAnnotation) {
        this.nameField = constraintAnnotation.nameField();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        if (theCode == null) {
            return false;
        }

   /*     User oldUser;
        if (nameField.equals("username")) {
            oldUser = customerServise.findByUsername(theCode);
        } else if (nameField.equals("email")) {
            oldUser = customerServise.findByEmail(theCode);
        } else if (nameField.equals("phoneNumber")) {
            oldUser = customerServise.findByPhoneNumber(theCode);
        } else {
            oldUser = null;
        }
        if (oldUser == null) {
            return true;
        } else {
            return false;
        }*/

       return customerServise.findByNameOrEmailOrPhoneNumber(theCode, theCode, theCode)==null;
    }
}

