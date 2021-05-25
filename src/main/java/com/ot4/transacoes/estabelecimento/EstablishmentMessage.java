package com.ot4.transacoes.estabelecimento;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstablishmentMessage {

    @JsonProperty("nome")
    @NotBlank
    private String name;

    @JsonProperty("cidade")
    @NotBlank
    private String city;

    @JsonProperty("endereco")
    @NotBlank
    private String address;

    @Deprecated
    public EstablishmentMessage() {}

    public EstablishmentMessage(@NotBlank String name, @NotBlank String city, @NotBlank String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public TransactionEstablishment toModel(){
        return new TransactionEstablishment(name, city, address);
    }

    @Override
    public String toString() {
        return "EstablishmentMessage{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}