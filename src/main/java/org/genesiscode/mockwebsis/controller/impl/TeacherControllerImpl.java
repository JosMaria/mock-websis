package org.genesiscode.mockwebsis.controller.impl;

import lombok.RequiredArgsConstructor;
import org.genesiscode.mockwebsis.controller.TeacherController;
import org.genesiscode.mockwebsis.entity.Teacher;
import org.genesiscode.mockwebsis.service.TeacherService;
import org.genesiscode.mockwebsis.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/teachers")
public class TeacherControllerImpl implements TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherControllerImpl(final TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeacher(@RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "5") int size) {
        List<Teacher> allTeacher = teacherService.getAllTeacher(page, size);
        return new ResponseEntity<>(allTeacher, HttpStatus.OK);
    }
}
