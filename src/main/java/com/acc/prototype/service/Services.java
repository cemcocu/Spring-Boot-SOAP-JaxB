package com.acc.prototype.service;



import io.spring.guides.gs_producing_web_service.PrototypeResponse;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class Services {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    public HashMap<String,String> map =new HashMap();

    @EventListener(ApplicationReadyEvent.class)
    public void readFile() {
        String fileName = "settings.properties";
        String row;
        String word1,word2;

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset()));
        try {
            while ((row = bufferedReader.readLine()) != null) {
                StringBuilder stringBuilder=new StringBuilder();
                String parserow;
                 stringBuilder.append(row);

                parserow=stringBuilder.toString();

                 word1 = parserow.trim().split("=")[0];
                word2 = parserow.trim().split("=")[1];

                map.put(word1,word2);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("claistimmm");

    }


    public HashMap<String,String> getAllValues()
    {
        return map;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PrototypeResponse")
    @ResponsePayload
    public List<PrototypeResponse> getValue() {

        List<PrototypeResponse> responseList = new ArrayList<>();
        List<String> resultList=new ArrayList<>();
        map.entrySet().stream().forEach(index->{
            PrototypeResponse response =new PrototypeResponse();
            response.setValue(index.getValue());
            responseList.add(response);
        });

        return responseList;
    }

}
