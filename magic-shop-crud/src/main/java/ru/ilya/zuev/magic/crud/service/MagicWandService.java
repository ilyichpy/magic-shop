package ru.ilya.zuev.magic.crud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;
import ru.ilya.zuev.magic.crud.dto.mapper.MagicWandMapperImpl;
import ru.ilya.zuev.magic.crud.repository.MagicWandRepo;
import ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse;

@Service
@RequiredArgsConstructor
@Slf4j
public class MagicWandService {
	private final MagicWandRepo magicWandRepository;
	private final MagicWandMapperImpl magicWandMapper;

	public MagicWandResponse save(MagicWandEntity magicWand) {
		log.debug("Сохранили в базе данных magicWand с name={}", magicWand.getName());
		return magicWandMapper.toResponse(magicWandRepository.save(magicWand));
	}
}
