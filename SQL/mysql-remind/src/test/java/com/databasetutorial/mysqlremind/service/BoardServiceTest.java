package com.databasetutorial.mysqlremind.service;

import com.databasetutorial.mysqlremind.entity.Board;
import com.databasetutorial.mysqlremind.repository.BoardRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private BoardService boardService;

    @Test
    void create() {
        String title = "test title";
        String content = "test content";
        boardService.create(title , content);
        Board savedBoard = boardRepository.findById(1L).orElseThrow(()->new RuntimeException("error"));
        assertThat(title).isEqualTo(savedBoard.getTitle());
    }

    @Test
    void findByBoardId() {
        Long boardId = 1L;
        String title = "test title";
        String content = "test content";
        boardService.create(title , content);
        Board board = boardService.findByBoardId(boardId);
        assertThat(board.getId()).isEqualTo(boardId);
    }
}