package org.genesiscode.mockwebsis.service.impl;

import lombok.RequiredArgsConstructor;
import org.genesiscode.mockwebsis.Repository.TeacherRepository;
import org.genesiscode.mockwebsis.entity.Teacher;
import org.genesiscode.mockwebsis.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(final TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeacher(int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        Page<Teacher> pagedResult = teacherRepository.findAll(paging);
        return pagedResult.toList();
    }
}
