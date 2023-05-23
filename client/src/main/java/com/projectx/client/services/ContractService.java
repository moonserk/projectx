package com.projectx.client.services;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.projectx.client.Contract;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static java.util.List.of;

public class ContractService {

    private static final String URL = "http://localhost:8080/contractses";
    public static List<Contract> getAll(){
        HttpResponse<JsonNode> apiResponse;

        try {
            apiResponse = Unirest.get(URL).asJson();
        } catch (UnirestException ex){
            return List.of();
        }

        Gson gson = new Gson();
        List<Contract> contracts = new ArrayList<>();

        JsonElement jelement = JsonParser.parseString(apiResponse.getBody().toString());
        JsonObject jobject = jelement.getAsJsonObject();
        jobject = jobject.getAsJsonObject("_embedded");
        JsonArray j = jobject.getAsJsonArray("contractses");

        for (JsonElement f : j) {
            f.getAsJsonObject().remove("_links");
            Contract c = gson.fromJson(f, Contract.class);
            contracts.add(c);
        }
        return contracts;
    }
}

