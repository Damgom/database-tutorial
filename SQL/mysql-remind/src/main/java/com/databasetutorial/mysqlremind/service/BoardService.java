package com.databasetutorial.mysqlremind.service;

import com.databasetutorial.mysqlremind.entity.Board;
import com.databasetutorial.mysqlremind.repository.BoardRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public String create(String title, String content) {
        Board board = new Board(title, content);
        boardRepository.save(board);
        return "success";
    }

    public String find(Long boardId) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(findByBoardId(boardId));
        }catch (JsonProcessingException e) {
            e.printStackTrace();
            return "error";
        }
    }

    public Board findByBoardId(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new RuntimeException("no article"));
    }
}
