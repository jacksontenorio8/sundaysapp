package one.digitalinnovation.sundaysapp.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.sundaysapp.dto.request.SundaysDTO;
import one.digitalinnovation.sundaysapp.dto.response.MessageResponseDTO;
import one.digitalinnovation.sundaysapp.entity.Sundays;
import one.digitalinnovation.sundaysapp.exception.SundaysNotFoundException;
import one.digitalinnovation.sundaysapp.service.SundaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SundaysController {

    private SundaysService sundaysService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO CreateSundays(@RequestBody @Valid SundaysDTO sundaysDTO) {
        return sundaysService.creatSundays() ;
    }

    @GetMapping
    public List<SundaysDTO>listAll(){
        return sundaysService.listAll();
    }

    @GetMapping("/{id}")
    public SundaysDTO findById(PathVariable Long id) throws SundaysNotFoundException{
        return sundaysService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid SundaysDTO personDTO) throws SundaysNotFoundException {
        return sundaysService.updateById(id, personDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws SundaysNotFoundException {
        sundaysService.delete(id);
    }
}
