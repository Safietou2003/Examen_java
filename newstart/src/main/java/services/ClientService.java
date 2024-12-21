package services;

import entities.Client;
import repository.repositoryList.RepositoryClient;
import java.util.Optional;
public class ClientService {
    private RepositoryClient repositoryClient;

    public ClientService(RepositoryClient repositoryClient) {
        this.repositoryClient = repositoryClient;
    }

    public Client findClientByTelephone(String telephone) {
        return repositoryClient.findById(telephone).orElse(null);
    }

}


