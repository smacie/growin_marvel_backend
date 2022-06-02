package com.growin.marvel.service.client;

import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;

@Service
public class SpringBootServiceClient {


    /*boolean result = false;
        try
    {
        String httpUrl = System.getProperty(MozaDocsServices.URI_PATH_VARIABLE.getValue()) + MozaDocsServices.PATH_UPLOAD_DOCUMENT_SINGLE.getValue();
        UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl(httpUrl);
        CharacterDetail characterDetail = restServiceClient.proxySpringRestCallerWithToken(url.build().encode().toUri(), characterDetailInput, authToken, HttpMethod.GET, characterDetailOutput.class);

        if(characterDetail != null && !StringUtils.isEmpty(characterDetail.getDestino()))
        {
            result = true;
        }
    }
        catch (Exception ex){
        logger.error("characterDetail:", ex);
    }*/

    public <T> T proxySpringRestCallerWithToken(URI uri, Object body, String authToken, HttpMethod method, Class<T> clazzResponse) {

        System.out.println("proxySpringRestCaller uri: " + uri.toString());

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + authToken);
        HttpEntity<?> entity = (body == null ? new HttpEntity<>(headers) : new HttpEntity<>(new Gson().toJson(body), headers));

        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpEntity<T> response = restTemplate.exchange(
                    uri,
                    method,
                    entity,
                    clazzResponse);
            return response.getBody();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }


    }
}
