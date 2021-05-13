package one.digitalinnovation.sundaysapp.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.sundaysapp.dto.request.SundaysDTO;
import one.digitalinnovation.sundaysapp.dto.response.MessageResponseDTO;
import one.digitalinnovation.sundaysapp.entity.Sundays;
import one.digitalinnovation.sundaysapp.exception.SundaysNotFoundException;
import one.digitalinnovation.sundaysapp.mapper.SundaysMapper;
import one.digitalinnovation.sundaysapp.repository.SundaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class SundaysService {
    private SundaysRepository sundaysRepository;

    private final SundaysMapper sundaysMapper = SundaysMapper.INSTANCE;

    public MessageResponseDTO createSundays(SundaysDTO sundaysDTO) {
        Sundays personToSave = sundaysMapper.toModel(sundaysDTO);

        Sundays savedPerson = sundaysRepository.save(sundaysToSave);
        return createMessageResponse(savedPerson.getId(), "Created person with ID ");
    }

    public List<SundaysDTO> listAll() {
        List<Sundays> allPeople = sundaysRepository.findAll();
        return allPeople.stream()
                .map(sundaysMapper::toDTO)
                .collect(Collectors.toList());
    }

    public SundaysDTO findById(Long id) throws SundaysNotFoundException {
        Sundays sundays = verifyIfExists(id);

        return sundaysMapper.toDTO(sundays);
    }

    public void delete(Long id) throws SundaysNotFoundException {
        verifyIfExists(id);
        sundaysRepository.deleteById(id);
    }

    public MessageResponseDTO updateById(Long id, SundaysDTO personDTO) throws SundaysNotFoundException {
        verifyIfExists(id);

        Sundays personToUpdate = sundaysMapper.toModel(personDTO);

        Sundays updatedSundays = sundaysRepository.save(personToUpdate);
        return createMessageResponse(updatedSundays.getId(), "Updated person with ID ");
    }

    private Sundays verifyIfExists(Long id) throws SundaysNotFoundException {
        return sundaysRepository.findById(id)
                .orElseThrow(() -> new SundaysNotFoundException(id));
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
