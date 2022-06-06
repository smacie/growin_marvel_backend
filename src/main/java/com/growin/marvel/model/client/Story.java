package com.growin.marvel.model.client;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Story {

    private String available;
    private String collectionURI;
    private List<Item> items;
    private String returned;
}
