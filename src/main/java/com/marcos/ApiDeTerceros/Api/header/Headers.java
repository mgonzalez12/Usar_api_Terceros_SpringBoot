package com.marcos.ApiDeTerceros.Api.header;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class Headers {

    public HttpHeaders Consult(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept","*/*");
        headers.add("Connection","keep-alive");
        headers.add("User-Agent","*/*");
        headers.add("x-api-key", "5AJQEGFuXg3LPsuAJhGBH8Fa9qr9bb1L10NQaQFp");

        return headers;
    }

    public HttpHeaders ConsultPost(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Accept","*/*");
        headers.add("User-Agent","*/*");
        headers.add("x-api-key", "5AJQEGFuXg3LPsuAJhGBH8Fa9qr9bb1L1ONQaQFp");
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
