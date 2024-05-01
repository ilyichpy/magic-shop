package ru.ilya.zuev.magic.crud.dto.mapper;

import org.mapstruct.Mapper;
import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;
import ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse;

/**
 * <p>MagicWandMapper interface.</p>
 *
 * @author ilazuev
 * @version $Id: $Id
 */
@Mapper(componentModel = "spring")
public interface MagicWandMapper {
	MagicWandResponse toResponse(MagicWandEntity magicWandEntity);
}
