package com.growin.marvel.service.impl;

import com.growin.marvel.model.CharacterDetail;
import com.growin.marvel.service.ICharacterService;
import com.growin.marvel.service.client.SpringBootServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService implements ICharacterService {

    private final SpringBootServiceClient restServiceClient;

    @Autowired
    public CharacterService(SpringBootServiceClient restServiceClient) {
        this.restServiceClient = restServiceClient;
    }


    @Override
    public List<Long> getCharacters() {
        return null;
    }

    @Override
    public CharacterDetail getCharacter(Long id, String language) {
        return null;
    }
}
