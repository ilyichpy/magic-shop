package ru.ilya.zuev.magic.crud.dto.mapper;

import org.mapstruct.Mapper;
import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;
import ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse;

@Mapper(componentModel = "spring")
@SuppressWarnings(value = "doclint:missing")
public interface MagicWandMapper {
	MagicWandResponse toResponse(MagicWandEntity magicWandEntity);
}
