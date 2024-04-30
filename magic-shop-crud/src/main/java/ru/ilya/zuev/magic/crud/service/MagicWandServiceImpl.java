package ru.ilya.zuev.magic.crud.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;
import ru.ilya.zuev.magic.crud.dto.mapper.MagicWandMapperImpl;
import ru.ilya.zuev.magic.crud.repository.MagicWandRepo;
import ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MagicWandServiceImpl implements MagicWandService {
	private final MagicWandRepo magicWandRepository;
	private final MagicWandMapperImpl magicWandMapper;

	@Override
	public MagicWandResponse save(MagicWandEntity magicWand) {
		log.debug("Сохранили в базе данных magicWand с name={}", magicWand.getName());
		return magicWandMapper.toResponse(magicWandRepository.save(magicWand));
	}

	@Override
	public List<MagicWandResponse> findWandByName(String name) {
		log.debug("ищем в базе все палочки с name={}", name);
		List<MagicWandResponse> responseList = new ArrayList<>();
		for (MagicWandEntity magicWand : magicWandRepository.findAllByName(name)) {
			responseList.add(magicWandMapper.toResponse(magicWand));
		}
		return responseList;
	}

	@Override
	public MagicWandResponse updateById(MagicWandEntity replace) {
		log.debug("Обнавляем entity с id={}", replace.getId());
		if (!magicWandRepository.findById(replace.getId()).isPresent()) {
			log.warn("В бд не найдена палочка с id={}", replace.getId());
			return null;
		}
		return magicWandMapper.toResponse(magicWandRepository.save(replace));
	}

	@Override
	public MagicWandResponse findById(Long id) {
		log.debug("Ищем палочку по id={}", id);
		Optional<MagicWandEntity> entity = magicWandRepository.findById(id);
		if (!entity.isPresent()) {
			log.trace("Палочки с таким id={} нет", id);
			return null;
		}
		return magicWandMapper.toResponse(entity.get());
	}

	@Override
	public void deleteById(Long id) {
		log.debug("Удаляем палочку по id={}", id);
		magicWandRepository.deleteById(id);
	}
}
