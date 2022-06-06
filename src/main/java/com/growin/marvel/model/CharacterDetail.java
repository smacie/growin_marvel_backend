package com.growin.marvel.model;

import com.growin.marvel.model.client.Character;
import com.growin.marvel.model.client.CharacterDetailClientOutput;
import com.growin.marvel.model.client.Thumbnail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDetail {
    private int id;
    private String name;
    private String description;
    private Thumbnail thumbnail;

    public CharacterDetail() {
    }
    public CharacterDetail(int id, String name, String description, Thumbnail thumbnail) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
    }
    public CharacterDetail(Character character) {
        this.id = character.getId();
        this.name = character.getName();
        this.description = character.getDescription();
        this.thumbnail = character.getThumbnail();
    }
}
