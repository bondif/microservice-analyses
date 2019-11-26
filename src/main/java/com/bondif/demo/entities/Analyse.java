package com.bondif.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "analyses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Analyse {
    @Id
    private String id;

    private String nom;

    private Date date;

    private Double prix;

    private String resultat;

    private Boolean estResultatConnu;

    @DBRef
    private Client client;
}
