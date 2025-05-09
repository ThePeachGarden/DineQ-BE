package com.dineq.dineqbe.repository;

import com.dineq.dineqbe.domain.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

    boolean existsByMenuName(String menuName);

    boolean existsByMenuId(Long menuId);

    @Query("SELECT MAX(m.menuPriority) FROM MenuEntity m")
    Integer findMaxMenuPriority();
}
