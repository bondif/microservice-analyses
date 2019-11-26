package com.bondif.demo.ws;

import com.bondif.demo.dao.ClientRepository;
import com.bondif.demo.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;

@Component
@WebService
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    @WebMethod
    public Collection<Client> getClientByName(@WebParam(name = "keyword") String name) {
        return clientRepository.findAllByNomContaining(name);
    }
}
