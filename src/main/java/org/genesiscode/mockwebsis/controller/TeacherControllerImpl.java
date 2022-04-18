package org.genesiscode.mockwebsis.controller;

import lombok.RequiredArgsConstructor;
import org.genesiscode.mockwebsis.entity.Teacher;
import org.genesiscode.mockwebsis.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "api/v1/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeacher(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "5") int size) {
        return new ResponseEntity<>(teacherService.getAllTeacher(page, size), HttpStatus.OK);
    }
}
