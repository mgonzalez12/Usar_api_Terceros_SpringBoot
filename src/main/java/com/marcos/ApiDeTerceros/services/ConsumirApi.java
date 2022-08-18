package com.marcos.ApiDeTerceros.services;

import com.marcos.ApiDeTerceros.Api.EmployeeAPi;
import com.marcos.ApiDeTerceros.Api.header.Headers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConsumirApi {

    public static Logger logger = LoggerFactory.getLogger(ConsumirApi.class);
    @Autowired
    private Headers headers;

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron = "0/15 * * * * *")
    public void consultas() {
        System.out.println("****** Inicio Usuario Detallado Jobs - Consulta ******");
        System.out.println("===============");
        String nombre = null;
        String apellido = null;
        String email = null;

        for (EmployeeAPi empl: getListofEmployee()) {
            nombre = empl.getFirstName();
            apellido = empl.getLastName();
            email = empl.getEmail();
        }

        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("email: "+ email);
        System.out.println("****** Fin Usuario Detallado Jobs - Consulta ******");
        System.out.println("===============");
    }

    @Scheduled(cron = "0/16 * * * * *")
    public List<EmployeeAPi> getListofEmployee()
    {
        System.out.println("****** Inciando primer Jobs - consulta ******");
        String url = "http://localhost:8080/api/employees";
        HttpEntity<String> entity = new HttpEntity<String>(headers.Consult());
        ResponseEntity<List<EmployeeAPi>> response = restTemplate.exchange(url,
                HttpMethod.GET,entity, new ParameterizedTypeReference<List<EmployeeAPi>>() {});

        System.out.println(response.getBody());
        System.out.println("****** Finalizando primer Jobs - consulta ******");
        System.out.println("===============");
        return response.getBody(); //this returns List of Employee

        //****  para un string de retorno ****
        // ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, header,String.class);
        // System.out.println(response.getBody());

    }

    @Scheduled(cron = "0/15 * * * * *")
    public  void TokenConsult() {
        System.out.println("****** Inciando segundo Jobs - Insert ******");
        String urlToken = "http://localhost:8080/api/employees";

     //  MultiValueMap<String,String> formData = new LinkedMultiValueMap<>();
        Map<String, String> formData = new HashMap<String, String>();
        formData.put("firstName","admin");
        formData.put("lastName","cualquiera");
        formData.put("email","admin@mail.com");

        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());

        HttpEntity formEntity = new HttpEntity<Map<String, String>>(formData, headers.ConsultPost());

        ResponseEntity<EmployeeAPi> response = restTemplate.exchange(urlToken, HttpMethod.POST, formEntity, EmployeeAPi.class);
        logger.info("response con body= " +  response.getBody().getFirstName());
        System.out.println(response.getBody());
        System.out.println("****** Finalizando segundo Jobs - Insert ******");
        System.out.println("===============");

    }

}
