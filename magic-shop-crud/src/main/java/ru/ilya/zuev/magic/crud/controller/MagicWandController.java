package ru.ilya.zuev.magic.crud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;
import ru.ilya.zuev.magic.crud.dto.responseDto.MagicWandResponse;
import ru.ilya.zuev.magic.crud.service.MagicWandService;

@RestController
@RequestMapping("/magic_shop/wands")
@RequiredArgsConstructor
public class MagicWandController {
	private final MagicWandService magicWandService;

	@PostMapping("save")
	public MagicWandResponse getWandById(@RequestBody MagicWandEntity magicWand) {
		return magicWandService.save(magicWand);
	}
}
