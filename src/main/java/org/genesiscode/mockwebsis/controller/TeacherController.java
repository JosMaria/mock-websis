package org.genesiscode.mockwebsis.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.genesiscode.mockwebsis.entity.Teacher;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Teacher Controller")
public interface TeacherController {

    ResponseEntity<List<Teacher>> getAllTeacher(
            @Parameter(name = "pagina", required = true, example = "2") int page,
            @Parameter(name = "tamaño", required = true, example = "10") int size);
}
