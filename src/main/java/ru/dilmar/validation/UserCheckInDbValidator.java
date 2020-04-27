package ru.dilmar.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dilmar.domain.User;
import ru.dilmar.repository.UsersRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Service
public class UserCheckInDbValidator implements ConstraintValidator<UserCheckInDb, String> {

    @Autowired
    private UsersRepository usersRepository;

    private String nameField;


    @Override
    public void initialize(UserCheckInDb constraintAnnotation) {
        this.nameField = constraintAnnotation.nameField();
    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
        User oldUser;

        if (theCode != null) {
            return false;
        }

        if (nameField.equals("username")) {
            oldUser = usersRepository.findByUsername(theCode);
        } else if (nameField.equals("email")) {
            oldUser = usersRepository.findByEmail(theCode);
        } else if (nameField.equals("phoneNumber")) {
            oldUser = usersRepository.findByPhoneNumber(theCode);
        } else {
            oldUser = null;
        }


        if (oldUser == null) {
            return true;
        } else {
            return false;
        }
    }
}

