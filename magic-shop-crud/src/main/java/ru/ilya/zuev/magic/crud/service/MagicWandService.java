package ru.ilya.zuev.magic.crud.service;

import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;
import ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse;

import java.util.List;

/**
 * <p>MagicWandService interface.</p>
 *
 * @author ilazuev
 * @version $Id: $Id
 */
public interface MagicWandService {
	/**
	 * <p>save.</p>
	 *
	 * @param magicWand a {@link ru.ilya.zuev.magic.crud.dto.MagicWandEntity} object
	 * @return a {@link ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse} object
	 */
	MagicWandResponse save(MagicWandEntity magicWand);
	/**
	 * <p>findWandByName.</p>
	 *
	 * @param name a {@link java.lang.String} object
	 * @return a {@link java.util.List} object
	 */
	List<MagicWandResponse> findWandByName(String name);
	/**
	 * <p>updateById.</p>
	 *
	 * @param replace a {@link ru.ilya.zuev.magic.crud.dto.MagicWandEntity} object
	 * @return a {@link ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse} object
	 */
	MagicWandResponse updateById(MagicWandEntity replace);
	/**
	 * <p>findById.</p>
	 *
	 * @param id a {@link java.lang.Long} object
	 * @return a {@link ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse} object
	 */
	MagicWandResponse findById(Long id);
	/**
	 * <p>deleteById.</p>
	 *
	 * @param id a {@link java.lang.Long} object
	 */
	void deleteById(Long id);
}
