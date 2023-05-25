package net.xfantome.business.affilator.contoller;
import java.util.Set;

import io.swagger.v3.oas.annotations.Operation;
import net.xfantome.business.affilator.POJO.Affilatorreq;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.service.AffilatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.xfantome.business.affilator.entity.Affilator;

@RestController
@RequestMapping("/affilators")
@CrossOrigin(origins = "*")
public class AffilatorController {

    @Autowired
    private AffilatorService affilatorService;

    @Operation(summary = "Get all Affilator")
    @GetMapping
    public ResponseEntity<Set<Affilator>> getAllAffilators() {
        return new ResponseEntity<>(
                affilatorService.getAllAffilators(),
                HttpStatus.OK);
    }


    @Operation(summary = "Get Affilator by id")
    @GetMapping("/{id}")
    public ResponseEntity<Affilator> getAffilatorById(@PathVariable(value = "id") String id) {
       Affilator affilator = affilatorService.getAffilatorById(id);
        if (affilator != null) {
            return ResponseEntity.ok().body(affilator);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "create new Affilator")
    @PostMapping
    public ResponseEntity<ApiResponse> createAffilator(@RequestBody Affilatorreq req) {

        return new ResponseEntity<>(
               affilatorService.CreateAffilator(req)
                , HttpStatus.OK);
    }

    @Operation(summary = " Modify Affilator")
    @PutMapping("/{id}")
    public void updateAffilator(@PathVariable(value = "id") String id, @RequestBody Affilatorreq affilatorDetails) {
       affilatorService.UpdateAffilator(id, affilatorDetails);
    }

    @Operation(summary = "delete Affilator")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAffilator(@PathVariable(value = "id") String id) {
        affilatorService.DeleteAffilator(id);
        return ResponseEntity.ok().build();
    }


//    @Operation(summary = "Login")
//    @PostMapping("/login")
//    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
//        String token = affilatorService.login(email, password);
//        if (token != null) {
//            return ResponseEntity.ok(token);
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }
}
