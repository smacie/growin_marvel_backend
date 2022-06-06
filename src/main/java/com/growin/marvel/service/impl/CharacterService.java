package com.growin.marvel.service.impl;

import com.growin.marvel.model.CharacterDetail;
import com.growin.marvel.model.client.CharacterDetailClientOutput;
import com.growin.marvel.service.ICharacterService;
import com.growin.marvel.service.client.SpringBootServiceClient;
import com.growin.marvel.service.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterService implements ICharacterService {

    private final SpringBootServiceClient restServiceClient;
    private final Util util;

    @Autowired
    public CharacterService(SpringBootServiceClient restServiceClient, Util util) {
        this.restServiceClient = restServiceClient;
        this.util = util;
    }


    @Override
    public List<Integer> getCharacters() {
        List<Integer> lstCharactersId = new ArrayList<>();
        try
        {
            // get list characters method url
            String urlCharacters = util.getMarvelServiceUrlCharacter();
            UriComponentsBuilder url =UriComponentsBuilder.fromHttpUrl(urlCharacters);

            CharacterDetailClientOutput characterDetailClientOutput = restServiceClient.proxySpringRestCaller(url.build().encode().toUri(), "", HttpMethod.GET,  CharacterDetailClientOutput.class);

            if(characterDetailClientOutput != null && characterDetailClientOutput.getCode() == 200){
                // fill list of ids to be returned
                characterDetailClientOutput.getData().getResults().stream().forEach(character -> lstCharactersId.add(character.getId()));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        return lstCharactersId;
    }

    @Override
    public CharacterDetail getCharacter(int id, String language) {
        CharacterDetail characterDetail = new CharacterDetail();
        try
        {
            // get list characters method url
            String urlCharacterDetail = util.getMarvelServiceUrlCharacterDetail(id);
            UriComponentsBuilder url =UriComponentsBuilder.fromHttpUrl(urlCharacterDetail);

            CharacterDetailClientOutput characterDetailClientOutput = restServiceClient.proxySpringRestCaller(url.build().encode().toUri(), "", HttpMethod.GET,  CharacterDetailClientOutput.class);

            if(characterDetailClientOutput != null && characterDetailClientOutput.getCode() == 200){
                // fill list of ids to be returned
                characterDetail = characterDetailClientOutput.getData().getResults().stream().findFirst().map(character -> new CharacterDetail(character)).get();
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return characterDetail;
    }
}
