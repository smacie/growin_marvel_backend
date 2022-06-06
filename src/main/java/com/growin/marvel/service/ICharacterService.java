package com.growin.marvel.service;

import com.growin.marvel.model.CharacterDetail;

import java.util.List;

public interface ICharacterService {

    /**
     * List all characters ids
     */
    List<Integer> getCharacters();

    /**
     * Get character details by id
     */
    CharacterDetail getCharacter(int id, String language);
}
