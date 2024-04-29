package ru.ilya.zuev.magic.crud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;
import ru.ilya.zuev.magic.crud.repository.MagicWandRepo;
import ru.ilya.zuev.magic.crud.responseDto.MagicWandResponse;

@Service
@RequiredArgsConstructor
public class MagicWandService {
	private final MagicWandRepo magicWandRepository;

	public MagicWandResponse save(MagicWandEntity magicWand) {
		magicWandRepository.save(magicWand);
		// тут нужен маппер
		return MagicWandResponse.builder()
				.name(magicWand.getName())
				.width(magicWand.getWidth())
				.length(magicWand.getLength())
				.weight(magicWand.getWeight())
				.build();
	}
}
