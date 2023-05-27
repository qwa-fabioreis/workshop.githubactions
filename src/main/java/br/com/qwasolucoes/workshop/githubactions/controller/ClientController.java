package br.com.qwasolucoes.workshop.githubactions.controller;

import br.com.qwasolucoes.workshop.githubactions.domain.Client;
import br.com.qwasolucoes.workshop.githubactions.repository.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientRepository repository;

    public ClientController(ClientRepository repository){
        this.repository = repository;
    }
    @GetMapping
    public List<Client> getClients(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    public Client getClient(@PathVariable Long id){
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
    @PostMapping
    public ResponseEntity createClient(@RequestBody Client client) throws URISyntaxException{
        Client savedClient = repository.save(client);
        return ResponseEntity.created(new URI("/clients/" + savedClient.getId())).body(savedClient);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateClient(@PathVariable Long id, @RequestBody Client client){
        Client currentClient = repository.findById(id).orElseThrow(RuntimeException::new);
        currentClient.setName(client.getName());
        currentClient.setEmail(client.getEmail());
        currentClient = repository.save(client);

        return ResponseEntity.ok(currentClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
