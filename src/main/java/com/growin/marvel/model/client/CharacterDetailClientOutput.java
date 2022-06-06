package com.growin.marvel.model.client;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CharacterDetailClientOutput {

    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private String etag;

    private Data data;


}
