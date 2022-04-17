package org.genesiscode.mockwebsis.configuration;

import org.genesiscode.mockwebsis.Repository.SubjectRepository;
import org.genesiscode.mockwebsis.Repository.TeacherRepository;
import org.genesiscode.mockwebsis.entity.Semester;
import org.genesiscode.mockwebsis.entity.Subject;
import org.genesiscode.mockwebsis.entity.Teacher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoad {

    @Bean
    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        return args -> {
            // Creation of subjects
            Subject networks = new Subject("redes de computadoras", "RAC-232", Semester.SEVEN);
            Subject dynamic = new Subject("dinamica de sistemas", "DIN-666", Semester.EIGHT);
            Subject operatingSystem = new Subject("taller de sistemas operativos", "OPE-365", Semester.FIVE);

            // Creation of teachers
            Teacher jorge = new Teacher("Jorge", "Orellana", "jorge@gmail.com", "maria17");
            jorge.addSubject(networks);
            jorge.addSubject(dynamic);
            jorge.addSubject(operatingSystem);

            subjectRepository.saveAll(List.of(networks, dynamic, operatingSystem));
            teacherRepository.save(jorge);
        };
    }
}
