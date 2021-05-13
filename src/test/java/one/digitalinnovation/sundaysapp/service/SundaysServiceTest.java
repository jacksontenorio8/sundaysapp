package one.digitalinnovation.sundaysapp.service;

import one.digitalinnovation.sundaysapp.dto.request.SundaysDTO;
import one.digitalinnovation.sundaysapp.dto.response.MessageResponseDTO;
import one.digitalinnovation.sundaysapp.entity.Sundays;
import one.digitalinnovation.sundaysapp.repository.SundaysRepository;
import one.digitalinnovation.sundaysapp.utils.SundaysUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static one.digitalinnovation.sundaysapp.utils.SundaysUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SundaysServiceTest {

    @Mock
    private SundaysRepository sundaysRepository;

    @InjectMocks
    private SundaysService sundaysService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        SundaysDTO sundaysDTO = createFakeDTO();
        Sundays expectedSavedSundays = createFakeEntity();

        when(sundaysRepository.save(any(Sundays.class))).thenReturn(expectedSavedSundays);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedSundays.getId());
        MessageResponseDTO succesMessage = sundaysService.createSundays(sundaysDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com ID " + id)
                .build();
    }
}
