package com.databasetutorial.mysqlremind.controller;

import com.databasetutorial.mysqlremind.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    public String create(@RequestParam String title,
                         @RequestParam String content) {
        return boardService.create(title, content);
    }

    @GetMapping("/find")
    public String find(@RequestParam Long boardId) {
        return boardService.find(boardId);
    }
}
