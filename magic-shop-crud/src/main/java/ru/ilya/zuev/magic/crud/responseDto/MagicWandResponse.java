package ru.ilya.zuev.magic.crud.responseDto;

import lombok.Builder;

@Builder
public class MagicWandResponse {
	private String name;
	private double length;
	private double width;
	private double weight;
}
