package ru.ilya.zuev.magic.crud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;
import ru.ilya.zuev.magic.crud.dto.mapper.MagicWandMapperImpl;
import ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse;
import ru.ilya.zuev.magic.crud.service.MagicWandServiceImpl;

import javax.ws.rs.*;
import java.util.List;


/**
 * <p>MagicWandController class.</p>
 *
 * @author ilazuev
 * @version $Id: $Id
 */
@RestController
@RequestMapping("/magic_shop/wands")
@RequiredArgsConstructor
@Slf4j
public class MagicWandControllerImpl implements MagicWandController {
	private final MagicWandServiceImpl magicWandServiceImpl;
	private final MagicWandMapperImpl magicWandMapper;
	private final ObjectMapper objectMapper;

	@POST
	@Path("save")
	public ResponseEntity<MagicWandResponse> saveWand(@RequestBody MagicWandEntity magicWand) throws JsonProcessingException {
		log.trace("Пришел запрос на адрес /magic_shop/wands/save");
		log.info("попытка сохранить волшебную палочку: {}", objectMapper.writeValueAsString(magicWand));
		if (magicWand.getName() == null || magicWand.getName().isEmpty()) {
			log.warn("имя палочки не найденно");
			return new ResponseEntity<>(magicWandMapper.toResponse(magicWand),
					HttpStatusCode.valueOf(501));
		}
		MagicWandResponse response = magicWandServiceImpl.save(magicWand);
		log.info("Успешно сохранили палочку в базе name={}", magicWand.getName());
		return new ResponseEntity<>(response,
				HttpStatusCode.valueOf(200));
	}

	@GET
	@Path("find_by_name")
	public ResponseEntity<List<MagicWandResponse>> findByName(@RequestBody String name) {
		log.trace("Пришел запрос на адрес /magic_shop/wands/find_by_name");
		log.info("ищем в базе данных палочку с name={}", name);
		if (name == null || name.isEmpty()) {
			log.warn("пустое имя не может быть в базе");
			return new ResponseEntity<>(null, HttpStatusCode.valueOf(501));
		}
		List<MagicWandResponse> responseList = magicWandServiceImpl.findWandByName(name);
		if (responseList.isEmpty()) {
			log.info("по запросу не нашлось палочки");
		}
		return new ResponseEntity<>(responseList,
				HttpStatusCode.valueOf(200));
	}

	@PUT
	@Path("update")
	public ResponseEntity<MagicWandResponse> update(@RequestBody MagicWandEntity magicWand) throws JsonProcessingException {
		log.trace("пришел запрос на адрес /magic_shop/wands/update");
		log.info("нужно обновить информацию: {}", objectMapper.writeValueAsString(magicWand));
		if (magicWand.getId() == null || magicWand.getId() == 0) {
			log.warn("пустой id не принимается");
			return new ResponseEntity<>(null, HttpStatusCode.valueOf(501));
		}
		MagicWandResponse response = magicWandServiceImpl.updateById(magicWand);
		return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
	}

	@GET
	@Path("find_by_id")
	public ResponseEntity<MagicWandResponse> findById(@RequestBody Long id) {
		log.trace("пришел запрос на адрес /magic_shop/wands/find_by_id");
		log.info("Ищем сущность с id={}", id);
		MagicWandResponse response = magicWandServiceImpl.findById(id);
		if (response == null) {
			return new ResponseEntity<>(null, HttpStatusCode.valueOf(501));
		}
		return new ResponseEntity<>(response, HttpStatusCode.valueOf(200));
	}

	@DELETE
	@Path("delete_by_id")
	@DeleteMapping("delete_by_id")
	public void deleteById(@RequestBody Long id) {
		log.trace("пришел запрос на адрес /magic_shop/wands/find_by_id");
		log.info("Ищем сущность с id={}", id);
		magicWandServiceImpl.deleteById(id);
	}
}
