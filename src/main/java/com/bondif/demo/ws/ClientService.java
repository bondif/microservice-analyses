package com.bondif.demo.ws;

import com.bondif.demo.entities.Client;

import java.util.Collection;

public interface ClientService {
    public Collection<Client> getClientByName(String name);
}
