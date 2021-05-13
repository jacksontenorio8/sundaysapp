package one.digitalinnovation.sundaysapp.mapper;

import one.digitalinnovation.sundaysapp.dto.request.SundaysDTO;
import one.digitalinnovation.sundaysapp.entity.Sundays;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public class SundaysMapper {
    SundaysMapper INSTANCE = Mappers.getMapper(SundaysMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Sundays toModel(SundaysDTO sundaysDTO);

    SundaysDTO toDTO(Sundays sundays);
}
