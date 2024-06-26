package ru.ilya.zuev.magic.crud.controller;

import lombok.SneakyThrows;
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
class MagicWandControllerImplTest {

	@Autowired
	private MagicWandControllerImpl magicWandControllerImpl;

	@Test
	@SneakyThrows
	void saveWandTest() {
		MagicWandEntity testMagicWand1 = MagicWandEntity.builder()
				.name("test_name")
				.width(1.24)
				.weight(2)
				.length(5.1)
				.build();
		magicWandControllerImpl.saveWand(testMagicWand1);
		List<MagicWandResponse> responseList = magicWandControllerImpl
				.findByName(testMagicWand1.getName()).getBody();
		// должена найтись только одна палка
		assert responseList != null;
		assertEquals(responseList.size(), 1);
		// проверяем имя на соответствие
		assertEquals(responseList.get(0).getName(), testMagicWand1.getName());
	}

	@Test
	@SneakyThrows
	void updateEntityTest() {
		MagicWandEntity startEntity = MagicWandEntity.builder()
				.id(2L)
				.name("test_name")
				.width(1.24)
				.weight(2)
				.length(5.1)
				.build();
		MagicWandEntity updatedEntity = MagicWandEntity.builder()
				.id(2L)
				.name("updated_entity")
				.width(2.1)
				.weight(1)
				.length(6.1)
				.build();
		// сохраняем
		magicWandControllerImpl.saveWand(startEntity);
		// сразу обнавляем
		magicWandControllerImpl.update(updatedEntity);
		MagicWandResponse response = magicWandControllerImpl.findById(updatedEntity.getId()).getBody();
		// проверяем наличие и соответствие полей
		assert response != null;
		assertEquals(response.getName(), updatedEntity.getName());
		assertEquals(response.getLength(), updatedEntity.getLength());
		assertEquals(response.getWeight(), updatedEntity.getWeight());
		assertEquals(response.getWidth(), updatedEntity.getWidth());
	}

	@Test
	@SneakyThrows
	void deleteEntityTest() {
		MagicWandEntity startEntity = MagicWandEntity.builder()
				.id(1L)
				.name("test_name")
				.width(1.24)
				.weight(2)
				.length(5.1)
				.build();
		magicWandControllerImpl.saveWand(startEntity);
		MagicWandResponse response = magicWandControllerImpl
				.findById(startEntity.getId()).getBody();
		// проверяем условно, что нашли в базе сохраненную сущность
		assert response != null;
		assertEquals(response.getName(), startEntity.getName());
		magicWandControllerImpl.deleteById(startEntity.getId());
		// проверяем, удаление сущности
		MagicWandResponse response1 = magicWandControllerImpl
				.findById(startEntity.getId()).getBody();
		assert response1 == null;
	}
}