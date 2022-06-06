package com.growin.marvel.model.client;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Data {
    private int offset;
    private int limit;
    private int total;
    private int count;

    private List<Character> results;
}
