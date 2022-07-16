package com.microservice.demo.java.service;

import com.microservice.demo.java.document.GroseriaDocument;
import com.microservice.demo.java.repository.IMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class MassageService implements IMessageService{

    @Autowired
    private final IMessageRepository repository;

    @Override
    public String validateIsGroseria( String description){
        if (isGroseria(description)){
            return "ROJO";
        } else{
            return "VERDE";
        }
    }

    private boolean isGroseria(String description){
        boolean result = false;
        List<String> listGroserias = repository.findAll().get(0).getGroserias();
        List<String> wordListDescription = Arrays.stream(description.split(" ")).toList();
        for (String wordDescription : wordListDescription) {
            for (String groseria : listGroserias) {
                if (wordDescription.equalsIgnoreCase(groseria)  || wordDescription.toLowerCase(Locale.ROOT).contains(groseria)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }


}
