package org.genesiscode.mockwebsis.service.impl;

import lombok.RequiredArgsConstructor;
import org.genesiscode.mockwebsis.Repository.TeacherRepository;
import org.genesiscode.mockwebsis.entity.Teacher;
import org.genesiscode.mockwebsis.service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getAllTeacher(int page, int size) {
        PageRequest paging = PageRequest.of(page, size);
        Page<Teacher> pagedResult = teacherRepository.findAll(paging);
        return pagedResult.toList();
    }

    @Override
    public Teacher findByEmail(String email) {
        return teacherRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Teacher with email %s does not exists.", email)));
    }
}
