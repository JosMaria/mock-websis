package org.genesiscode.mockwebsis.service;

import org.genesiscode.mockwebsis.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeacher(int page, int size);
}
