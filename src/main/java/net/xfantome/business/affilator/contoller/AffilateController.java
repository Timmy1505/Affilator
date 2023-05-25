package net.xfantome.business.affilator.contoller;
import java.util.Set;
import io.swagger.v3.oas.annotations.Operation;
import net.xfantome.business.affilator.POJO.AffilateReq;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.service.AffilateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.xfantome.business.affilator.entity.Affilate;

@RestController
@RequestMapping("/v1/affilates")
public class AffilateController {

    @Autowired
    private AffilateService affilateService;

    @Operation(summary = "Get all Affilate")
    @GetMapping
    public ResponseEntity<Set<Affilate>> getAllAffilates() {
        return new ResponseEntity<>(
                affilateService.getAllAffilates(),
                HttpStatus.OK);
    }



    @Operation(summary = "Get Affilate by id")
    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Affilate> getAffilateById(@PathVariable(value = "id") String id) {
        Affilate affilate = affilateService.getAffilateById(id);
        if (affilate != null) {
            return ResponseEntity.ok().body(affilate);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "create new Affilate")
    @PostMapping
    public ResponseEntity<ApiResponse> createAffilate(@RequestBody AffilateReq req) {

        return new ResponseEntity<>(
                affilateService.CreateAffilate(req)
                , HttpStatus.OK);
    }

    @Operation(summary = " Modify Affilate")
    @PutMapping("/{id}")
    public void updateAffilate(@PathVariable(value = "id") String id, @RequestBody AffilateReq affilateDetails) {
        affilateService.UpdateAffilate(id, affilateDetails);
    }

    @Operation(summary = "delete Affilate")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAffilate(@PathVariable(value = "id") String id) {
        affilateService.DeleteAffilate(id);
        return ResponseEntity.ok().build();

    }
}
