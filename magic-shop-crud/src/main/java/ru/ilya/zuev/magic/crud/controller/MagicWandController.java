package ru.ilya.zuev.magic.crud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;
import ru.ilya.zuev.magic.crud.dto.mapper.MagicWandMapperImpl;
import ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse;
import ru.ilya.zuev.magic.crud.service.MagicWandService;

import java.util.List;

@RestController
@RequestMapping("/magic_shop/wands")
@RequiredArgsConstructor
@Slf4j
public class MagicWandController {
	private final MagicWandService magicWandService;
	private final MagicWandMapperImpl magicWandMapper;
	private final ObjectMapper objectMapper;

	@PostMapping("save")
	public ResponseEntity<MagicWandResponse> saveWand(@RequestBody MagicWandEntity magicWand) throws JsonProcessingException {
		log.trace("Пришел запрос на адрес /magic_shop/wands/save");
		log.info("попытка сохранить волшебную палочку: {}", objectMapper.writeValueAsString(magicWand));
		if (magicWand.getName() == null || magicWand.getName().isEmpty()) {
			log.warn("имя палочки не найденно");
			return new ResponseEntity<>(magicWandMapper.toResponse(magicWand),
					HttpStatusCode.valueOf(501));
		}
		MagicWandResponse response = magicWandService.save(magicWand);
		log.info("Успешно сохранили палочку в базе name={}", magicWand.getName());
		return new ResponseEntity<>(response,
				HttpStatusCode.valueOf(200));
	}

	@GetMapping("find_by_name")
	public ResponseEntity<List<MagicWandResponse>> findByName(@RequestBody String name ) {
		log.trace("Пришел запрос на адрес /magic_shop/wands/find_by_name");
		log.info("ищем в базе данных палочку с name={}", name);
		if (name == null || name.isEmpty()) {
			log.warn("пустое имя не может быть в базе");
			return new ResponseEntity<>(null, HttpStatusCode.valueOf(501));
		}
		List<MagicWandResponse> responseList = magicWandService.findWandByName(name);
		if (responseList.isEmpty()) {
			log.info("по запросу не нашлось палочки");
		}
		return new ResponseEntity<>(responseList,
				HttpStatusCode.valueOf(200));
	}
}
