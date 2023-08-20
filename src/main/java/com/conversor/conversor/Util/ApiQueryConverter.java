package com.conversor.conversor.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.conversor.conversor.DTO.ConverterDTO;
import com.google.gson.Gson;


public class ApiQueryConverter {
    public String requestApi(ConverterDTO converterDTO) {
        String to= converterDTO.getTo();
        String from= converterDTO.getFrom();
        String amount= converterDTO.getAmount();
        StringBuffer response;
        try {
            URL url = new URL("https://api.apilayer.com/exchangerates_data/convert?to=" + to + "&from=" + from + "&amount=" + amount);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.addRequestProperty("apikey", new ApiKey().apiKeyValue);

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        ConversionDTO conversion = gson.fromJson(response.toString(), ConversionDTO.class);
        return conversion.getResult();
    }


}
