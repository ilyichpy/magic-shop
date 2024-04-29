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

import javax.ws.rs.core.Response;

@RestController
@RequestMapping("/magic_shop/wands")
@RequiredArgsConstructor
@Slf4j
public class MagicWandController {
	private final MagicWandService magicWandService;
	private final MagicWandMapperImpl magicWandMapper;
	private final ObjectMapper objectMapper;

	@PostMapping("save")
	public ResponseEntity<MagicWandResponse> getWandById(@RequestBody MagicWandEntity magicWand) throws JsonProcessingException {
		log.trace("Пришел запрос на адрес /magic_shop/wands/save");
		log.info("попытка сохранить волшебную палочку: {}", objectMapper.writeValueAsString(magicWand));
		if (magicWand.getName() == null || magicWand.getName().isEmpty()) {
			log.warn("имя палочки не найденно");
			return new ResponseEntity<>(magicWandMapper.toResponse(magicWand),
					HttpStatusCode.valueOf(501));
		}
		return new ResponseEntity<>(magicWandService.save(magicWand),
				HttpStatusCode.valueOf(200));
	}
}
