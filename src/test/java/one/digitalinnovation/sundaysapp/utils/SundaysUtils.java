package one.digitalinnovation.sundaysapp.utils;


import one.digitalinnovation.sundaysapp.dto.request.SundaysDTO;
import one.digitalinnovation.sundaysapp.entity.Sundays;

import java.time.LocalDate;
import java.util.Collections;

public class SundaysUtils {

    private static final String FIRST_NAME = "Jackson";
    private static final String LAST_NAME = "Tenorio";
    private static final String CPF_NUMBER = "000.000.000-000";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(1986, 10, 1);

    public static SundaysDTO createFakeDTO() {
        return SundaysDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Sundays createFakeEntity() {
        return Sundays.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
