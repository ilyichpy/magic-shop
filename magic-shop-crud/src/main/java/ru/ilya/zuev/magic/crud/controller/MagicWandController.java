package ru.ilya.zuev.magic.crud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;
import ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse;

import javax.ws.rs.*;
import java.util.List;

@Path("/magic_shop/wands")
public interface MagicWandController {

	/**
	 * <p>saveWand.</p>
	 *
	 * @param magicWand должны получить json MagicWandEntity
	 * @return ResponseEntity, в котором будет так же код ответа
	 * @apiNote 200 - все хорошо, 501 - нет имени палочки
	 */
	@POST
	@Path("save")
	ResponseEntity<MagicWandResponse> saveWand(@RequestBody MagicWandEntity magicWand) throws JsonProcessingException;

	/**
	 * <p>findByName.</p>
	 *
	 * @param name ищем все совпадения по имени
	 * @return ResponseEntity, в котором будет так же код ответа
	 * @apiNote 200 - все хорошо, 501 - нет имени палочки
	 */
	@GET
	@Path("find_by_name")
	ResponseEntity<List<MagicWandResponse>> findByName(@RequestBody String name);

	/**
	 * <p>update.</p>
	 *
	 * @param magicWand
	 * новая сущность по id которой будем обновлять существующую сущность
	 * @return ResponseEntity, в котором будет так же код ответа
	 * @apiNote @apiNote 200 - все хорошо, 501 - нет id палки
	 */
	@PUT
	@Path("update")
	ResponseEntity<MagicWandResponse> update(@RequestBody MagicWandEntity magicWand) throws JsonProcessingException;

	/**
	 * <p>findById.</p>
	 *
	 * @param id по этому id ищем сущность
	 * @return ResponseEntity, в котором будет так же код ответа
	 * @apiNote 200 - все хорошо, 501 - не нашли сущность
	 */
	@GET
	@Path("find_by_id")
	ResponseEntity<MagicWandResponse> findById(@RequestBody Long id);

	/**
	 * <p>deleteById.</p>
	 *
	 * @param id a {@link java.lang.Long} object
	 */
	@DELETE
	@Path("delete_by_id")
	void deleteById(@RequestBody Long id);
}
