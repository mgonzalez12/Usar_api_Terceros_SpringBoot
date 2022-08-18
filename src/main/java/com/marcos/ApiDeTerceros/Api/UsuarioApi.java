package com.marcos.ApiDeTerceros.Api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioApi {

    private int id;
    private String nombre;
    private String apellido;
    private String createdAt;


}
