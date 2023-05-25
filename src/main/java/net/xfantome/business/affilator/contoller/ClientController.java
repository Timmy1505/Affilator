package net.xfantome.business.affilator.contoller;
import io.swagger.v3.oas.annotations.Operation;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.POJO.ClientAndProjectReq;
import net.xfantome.business.affilator.POJO.ClientReq;
import net.xfantome.business.affilator.POJO.ProjectReq;
import net.xfantome.business.affilator.entity.Client;
import net.xfantome.business.affilator.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Operation(summary = "get all clients")
    @GetMapping
    public ResponseEntity<Set<Client>> getAllClients() {
        return new ResponseEntity<>(
                clientService.getAllClients(),
                HttpStatus.OK);
    }


    @Operation(summary = "get client by id ")
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id") String id) {
        Client client = clientService.getClientById(id);
        if (client != null) {
            return ResponseEntity.ok().body(client);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Operation(summary = "create new client")
    @PostMapping
    public ResponseEntity<ApiResponse> createClient(@RequestBody ClientAndProjectReq request) {
        ClientReq clientReq = request.getClientReq();
        ProjectReq projectReq = request.getProjectReq();
        ApiResponse response = clientService.CreateClient(clientReq, projectReq);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @Operation(summary = "modify client ")
    @PutMapping("/{id}")
    public void updateClient(@PathVariable(value = "id") String id, @RequestBody ClientReq clientDetails) {
        clientService.UpdateClient(id, clientDetails);
    }

    @Operation(summary = "delete client ")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable(value = "id") String id) {
        clientService.DeleteClient(id);
        return ResponseEntity.ok().build();

    }

}
