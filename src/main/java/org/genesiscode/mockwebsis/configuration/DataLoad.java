package org.genesiscode.mockwebsis.configuration;

import org.genesiscode.mockwebsis.Repository.GroupRepository;
import org.genesiscode.mockwebsis.Repository.SubjectRepository;
import org.genesiscode.mockwebsis.Repository.TeacherRepository;
import org.genesiscode.mockwebsis.entity.Group;
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
    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository, SubjectRepository subjectRepository,
                                        GroupRepository groupRepository) {
        return args -> {
            // Creation of groups
            Group groupOne = new Group("1", 35);
            Group groupTwo = new Group("2", 50);
            Group groupThree = new Group("3", 42);
            Group groupFour = new Group("4", 40);

            // Creation of subjects
            Subject networks = new Subject("redes de computadoras", "RAC-232", Semester.SEVEN);
            networks.addGroup(groupOne);
            networks.addGroup(groupTwo);
            Subject dynamic = new Subject("dinamica de sistemas", "DIN-666", Semester.EIGHT);
            Subject operatingSystem = new Subject("taller de sistemas operativos", "OPE-365", Semester.FIVE);
            Subject englishII = new Subject("ingles II", "ENG-756", Semester.FIVE);
            englishII.addGroup(groupOne);
            englishII.addGroup(groupTwo);
            englishII.addGroup(groupThree);
            Subject informationSystemsII = new Subject("sistemas de informacion II", "SISINFO-326", Semester.FIVE);
            informationSystemsII.addGroup(groupOne);
            informationSystemsII.addGroup(groupTwo);
            informationSystemsII.addGroup(groupThree);
            Subject applicationOfOperatingSystems = new Subject("aplicacion de sistemas operativos", "ASO-642", Semester.FIVE);
            applicationOfOperatingSystems.addGroup(groupOne);
            applicationOfOperatingSystems.addGroup(groupTwo);
            applicationOfOperatingSystems.addGroup(groupThree);
            Subject workshopTaller = new Subject("taller de base de datos", "TBD-685", Semester.FIVE);
            workshopTaller.addGroup(groupOne);
            workshopTaller.addGroup(groupTwo);
            workshopTaller.addGroup(groupThree);
            workshopTaller.addGroup(groupFour);
            Subject systemsI = new Subject("sistemas I", "SIS-163", Semester.FIVE);
            Subject operativeInvestigationII = new Subject("investigacion operativa II", "IO2-163", Semester.FIVE);
            Subject marketing = new Subject("mercadotecnia", "MERC-391", Semester.FIVE);
            marketing.addGroup(groupOne);
            marketing.addGroup(groupTwo);

            // Creation of teachers
            Teacher jorge = new Teacher("Jorge", "Orellana", "jorge@gmail.com", "jorge17");
            jorge.addSubject(networks);
            jorge.addSubject(dynamic);
            jorge.addSubject(operatingSystem);
            Teacher magda = new Teacher("Magda", "Peeters", "magda@gmail.com", "magda72");
            magda.addSubject(englishII);
            Teacher juan = new Teacher("Juan", "Flores", "juan@gmail.com", "juan34");
            juan.addSubject(informationSystemsII);
            juan.addSubject(workshopTaller);
            Teacher carla = new Teacher("Carla", "Salazar", "carla@gmail.com", "carla93");
            carla.addSubject(informationSystemsII);
            Teacher rolando = new Teacher("Rolando", "Jaldin", "rolando@gmail.com", "rolando15");
            rolando.addSubject(informationSystemsII);
            Teacher grover = new Teacher("Grover", "Cussi", "grover@gmail.com", "grover85");
            grover.addSubject(applicationOfOperatingSystems);
            Teacher jose = new Teacher("Jose", "Ayoroa", "jose@gmail.com", "jose54");
            jose.addSubject(applicationOfOperatingSystems);
            Teacher boris = new Teacher("Boris", "Calancha", "boris@gmail.com", "boris41");
            boris.addSubject(workshopTaller);
            Teacher americo = new Teacher("Americo", "Fiorilo", "americo@gmail.com", "americo18");
            americo.addSubject(systemsI);
            Teacher roberto = new Teacher("Roberto", "Manchego", "roberto@gmail.com", "roberto28");
            roberto.addSubject(operativeInvestigationII);
            Teacher osvaldo = new Teacher("Osvaldo", "Gutierrez", "osvaldo@gmail.com", "osvaldo62");
            osvaldo.addSubject(marketing);
            Teacher ariel = new Teacher("Ariel", "Sarmiento", "ariel@gmail.com", "ariel71");
            ariel.addSubject(marketing);

            groupRepository.saveAll(List.of(groupOne, groupTwo, groupThree, groupFour));
            subjectRepository.saveAll(List.of(networks, dynamic, operatingSystem, englishII, informationSystemsII, applicationOfOperatingSystems, workshopTaller, systemsI, operativeInvestigationII, marketing));
            teacherRepository.save(jorge);
            teacherRepository.save(magda);
            teacherRepository.save(juan);
            teacherRepository.save(carla);
            teacherRepository.save(rolando);
            teacherRepository.save(grover);
            teacherRepository.save(jose);
            teacherRepository.save(boris);
            teacherRepository.save(americo);
            teacherRepository.save(roberto);
            teacherRepository.save(osvaldo);
            teacherRepository.save(ariel);
        };
    }
}
