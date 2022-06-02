package com.growin.marvel.service;

import com.growin.marvel.model.CharacterDetail;

import java.util.List;

public interface ICharacterService {

    /**
     * List all characters ids
     */
    List<Long> getCharacters();

    /**
     * Get character details by id
     */
    CharacterDetail getCharacter(Long id, String language);
}
