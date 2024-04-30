package ru.ilya.zuev.magic.crud.service;

import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;
import ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse;

import java.util.List;

public interface MagicWandService {
	MagicWandResponse save(MagicWandEntity magicWand);
	List<MagicWandResponse> findWandByName(String name);
	MagicWandResponse updateById(MagicWandEntity replace);
	MagicWandResponse findById(Long id);
	void deleteById(Long id);
}
