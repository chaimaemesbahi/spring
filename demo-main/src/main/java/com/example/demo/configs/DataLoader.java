//package com.example.demo.configs;
//
//import com.example.demo.entities.AttachmentType;
//import com.example.demo.repositories.AttachementTypeRepository;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Configuration
//@RequiredArgsConstructor
//@EnableTransactionManagement
//@Slf4j
//public class DataLoader {
//    public final AttachementTypeRepository attachementTypeRepository;
//
//    @Bean
//    public ApplicationRunner init() {
//        return args -> {
//            List<AttachmentType> attachmentTypes = Arrays.asList(
//                    AttachmentType.builder().abrv("word").name("document").build(),
//                    AttachmentType.builder().abrv("pdf").name("pdf").build(),
//                    AttachmentType.builder().abrv("plain").name("text").build(),
//                    AttachmentType.builder().abrv("png").name("png").build(),
//                    AttachmentType.builder().abrv("csv").name("csv").build(),
//                    AttachmentType.builder().abrv("jpeg").name("jpeg").build(),
//                    AttachmentType.builder().abrv("sheet").name("sheet").build()
//            );
//            attachementTypeRepository.saveAll(attachmentTypes);
//        };
//    }
//
//
//
//}
