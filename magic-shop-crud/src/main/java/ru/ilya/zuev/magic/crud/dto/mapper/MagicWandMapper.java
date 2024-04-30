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
@SuppressWarnings(value = "doclint:missing")
public interface MagicWandMapper {
	/**
	 * <p>toResponse.</p>
	 *
	 * @param magicWandEntity a {@link ru.ilya.zuev.magic.crud.dto.MagicWandEntity} object
	 * @return a {@link ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse} object
	 */
	MagicWandResponse toResponse(MagicWandEntity magicWandEntity);
}
