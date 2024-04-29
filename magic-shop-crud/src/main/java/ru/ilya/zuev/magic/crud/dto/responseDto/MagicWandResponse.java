package ru.ilya.zuev.magic.crud.dto.responseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Setter
@Getter
public class MagicWandResponse {
	private String name;
	private double length;
	private double width;
	private double weight;
}
