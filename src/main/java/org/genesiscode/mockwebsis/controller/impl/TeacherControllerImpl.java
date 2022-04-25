package org.genesiscode.mockwebsis.controller.impl;

import lombok.RequiredArgsConstructor;
import org.genesiscode.mockwebsis.controller.TeacherController;
import org.genesiscode.mockwebsis.entity.Teacher;
import org.genesiscode.mockwebsis.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/teachers")
public class TeacherControllerImpl implements TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    @Override
    public ResponseEntity<List<Teacher>> getAllTeacher(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        List<Teacher> allTeacher = teacherService.getAllTeacher(page, size);
        return new ResponseEntity<>(allTeacher, HttpStatus.OK);
    }

    @GetMapping("email")
    @Override
    public ResponseEntity<Teacher> findByEmail(@RequestParam("email") String email) {
        return ResponseEntity.ok(teacherService.findByEmail(email));
    }
}
