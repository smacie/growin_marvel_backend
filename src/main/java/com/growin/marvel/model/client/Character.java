package com.growin.marvel.model.client;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Character {
    private int id;
    private String name;
    private String description;
    private Date modified;

    private Thumbnail thumbnail;
    private String resourceURI;
    private Comic comics;
    private Serie series;
    private Story stories;
    private Event events;
    private List<Url> urls;
}
