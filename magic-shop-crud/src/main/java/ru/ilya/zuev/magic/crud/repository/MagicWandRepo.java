package ru.ilya.zuev.magic.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ilya.zuev.magic.crud.dto.MagicWandEntity;

@Repository
public interface MagicWandRepo extends JpaRepository<MagicWandEntity, Long> {
}
