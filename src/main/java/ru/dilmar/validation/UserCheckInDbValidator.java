package ru.dilmar.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dilmar.domain.User;
import ru.dilmar.repository.UsersRepository;


import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/*Nullpointe выбрасывает при вызове сэйв!!!!!!*/
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

        if (theCode == null) {
            return false;
        }

   /*     User oldUser;
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
        }*/

       return usersRepository.findByUsernameOrEmailOrPhoneNumber(theCode, theCode, theCode)==null;
    }
}

