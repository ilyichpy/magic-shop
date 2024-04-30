package ru.ilya.zuev.magic.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;

import java.util.List;

/**
 * <p>MagicWandRepo interface.</p>
 *
 * @author ilazuev
 * @version $Id: $Id
 */
@Repository
public interface MagicWandRepo extends CrudRepository<MagicWandEntity, Long> {
	/**
	 * <p>findAllByName.</p>
	 *
	 * @param name a {@link java.lang.String} object
	 * @return a {@link java.util.List} object
	 */
	List<MagicWandEntity> findAllByName(String name);
}
