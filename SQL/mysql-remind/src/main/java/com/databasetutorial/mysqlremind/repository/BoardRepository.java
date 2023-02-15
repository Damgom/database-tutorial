package com.databasetutorial.mysqlremind.repository;

import com.databasetutorial.mysqlremind.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
