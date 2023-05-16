package com.fmc.maidcorp.user.registration;

import com.fmc.maidcorp.user.AppUser;
import com.fmc.maidcorp.user.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class EmailValidator implements Predicate<String> {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static  final Pattern pattern=Pattern.compile(EMAIL_REGEX);
    @Override
    public boolean test(String email) {
      
        return  pattern.matcher(email).matches();

    }
}
