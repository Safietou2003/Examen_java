package view;

import entities.Client;
import entities.Article;
import entities.Commande;
import entities.Detail;
import services.ClientService;
import services.CommandeService;
import repository.implementation.RepositoryClientImpl;
import repository.implementation.RepositoryCommandeImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class MainViewController {
    @FXML private TextField phoneNumberField;
    @FXML private Label clientNameLabel;
    @FXML private Label clientAddressLabel;

    private ClientService clientService;
    private CommandeService commandeService;
    private List<Detail> details;

    public MainViewController() {
        this.clientService = new ClientService(new RepositoryClientImpl());
        this.commandeService = new CommandeService(new RepositoryCommandeImpl());
        this.details = new ArrayList<>();
    }

    @FXML
    private void onSearchClient() {
        String phoneNumber = phoneNumberField.getText();
        Client client = clientService.findClientByTelephone(phoneNumber);
        if (client != null) {
            clientNameLabel.setText(client.getNom() + " " + client.getPrenom());
            clientAddressLabel.setText(client.getVille() + ", " + client.getQuartier() + ", " + client.getVilla());
        } else {
            clientNameLabel.setText("Client non trouvé");
            clientAddressLabel.setText("");
        }
    }

    @FXML
    private void onValidateOrder() {
        String phoneNumber = phoneNumberField.getText();
        Client client = clientService.findClientByTelephone(phoneNumber);

        if (client == null) {
            clientNameLabel.setText("Client non trouvé");
            return;
        }

        Commande commande = new Commande();
        commande.setClient(client);
        commande.setDetails(details);
        
        for (Detail detail : details) {
            detail.setCommande(commande);
        }

        commandeService.addCommande(commande);
        clientNameLabel.setText("Commande validée pour " + client.getNom() + " " + client.getPrenom());
        details.clear();  
    }

    
    public void addDetail(Article article, double prix, int quantite) {
        Detail detail = new Detail();
        detail.setArticle(article);
        detail.setPrix(prix);
        detail.setQuantite(quantite);
        details.add(detail);
    }
}
