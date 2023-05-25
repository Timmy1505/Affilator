package net.xfantome.business.affilator.contoller;
import io.swagger.v3.oas.annotations.Operation;
import net.xfantome.business.affilator.POJO.ApiResponse;
import net.xfantome.business.affilator.POJO.BankingProfileReq;
import net.xfantome.business.affilator.entity.BankingProfile;
import net.xfantome.business.affilator.service.BankingProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/bankProfile")
public class BankProfileController {

    private final BankingProfileService bankingProfileService;

    @Autowired
    public BankProfileController(BankingProfileService bankingProfileService) {
        this.bankingProfileService = bankingProfileService;
    }


    @Operation(summary = "get all  bank profiles ")
    @GetMapping
    public ResponseEntity<Set<BankingProfile>> getAllBankProfiles(){
        return new ResponseEntity<>(
                bankingProfileService.getAllBankProfiles(),
                HttpStatus.OK);
    }


//    @GetMapping("/{id}")
//    public BankingProfile getBankProfileById(@PathVariable String id) {
//        return bankingProfileService.getBankProfileById(id);
//    }



    @Operation(summary = "create new  bank profile")
    @PostMapping
    public ResponseEntity<ApiResponse> createBankProfile(@RequestBody BankingProfileReq req) {

        return new ResponseEntity<>(
                bankingProfileService.CreateBankProfile(req)
                , HttpStatus.OK);
    }



    @Operation(summary = "modify project")
    @PutMapping("/{id}")
    public void updateBankProfile(@PathVariable(value = "id") String id, @RequestBody BankingProfileReq req) {
        bankingProfileService.UpdateBankProfile(id,req);
    }


    @Operation(summary = " delete project ")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBankProfile(@PathVariable(value = "id") String id) {
        bankingProfileService.DeleteBankProfile(id);
        return ResponseEntity.ok().build();

    }
}
