package com.growin.marvel.controller;

import com.growin.marvel.model.CharacterDetail;
import com.growin.marvel.service.impl.CharacterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@Api(value = "GrowinMarvelController")
@RestController
@RequestMapping("/api/v1")
public class GrowinMarvelController {

    private final CharacterService characterService;

    @Autowired
    public GrowinMarvelController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @ApiOperation(value = "Test Operation", response = String.class)
    @GetMapping("/test")
    public String test(){   return "I'm running mate!";   }

    @ApiOperation(value = "Characters Listing")
    @GetMapping("/characters")
    public ResponseEntity<List<Integer>> getCharacters(){
        return ResponseEntity.ok().body(characterService.getCharacters());
    }

    @ApiOperation(value = "Character Details Listing")
    @GetMapping("/characters/{characterId}")
    public ResponseEntity<CharacterDetail> getCharacterDetails(
            @ApiParam(value = "characterId", required = true)
            @PathVariable int characterId, @RequestParam(value = "language", required = false) String language){
        return ResponseEntity.ok().body(characterService.getCharacter(characterId, language));
    }
}
