package ru.ilya.zuev.magic.crud.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.ilya.zuev.magic.MagicShopCrudApplication;
import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;
import ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = MagicShopCrudApplication.class)
@ActiveProfiles("test")
class MagicWandControllerTest {

	@Autowired
	private MagicWandController magicWandController;

	@Test
	void saveWandTest() throws JsonProcessingException {
		MagicWandEntity testMagicWand1 = MagicWandEntity.builder()
				.name("test_name")
				.width(1.24)
				.weight(2)
				.length(5.1)
				.build();
		magicWandController.saveWand(testMagicWand1);
		List<MagicWandResponse> responseList = magicWandController
				.findByName(testMagicWand1.getName()).getBody();
		// должена найтись только одна палка
		assert responseList != null;
		assertEquals(responseList.size(), 1);
		// проверяем имя на соответствие
		assertEquals(responseList.get(0).getName(), testMagicWand1.getName());
	}
}