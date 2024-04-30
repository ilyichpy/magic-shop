package ru.ilya.zuev.magic.crud.dto;


import jakarta.persistence.*;
import lombok.*;

/**
 * <p>MagicWandEntity class.</p>
 *
 * @author ilazuev
 * @version $Id: $Id
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "MAGIC_WAND")
public class MagicWandEntity {
	@Id
	@GeneratedValue(generator = "WAND_ID_SEQ", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "WAND_ID_SEQ", sequenceName = "WAND_ID_SEQ")
	@Column(name = "ID")
	private Long id;

	/*
	* Имя палочки
	*/
	@Column(name = "WAND_NAME")
	private String name;

	/*
	* Длина палочки
	*/
	@Column(name = "LENGTH")
	private double length;

	/*
	* Ширина палочки
	*/
	@Column(name = "WIDTH")
	private double width;

	/*
	* Вес палочки
	*/
	@Column(name = "WEIGHT")
	private double weight;

}
