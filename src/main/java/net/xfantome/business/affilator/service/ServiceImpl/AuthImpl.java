//package net.xfantome.business.affilator.service.ServiceImpl;
//import net.xfantome.business.affilator.entity.Affilator;
//import net.xfantome.business.affilator.repository.AffilatorRepository;
//import net.xfantome.business.affilator.service.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class AuthImpl implements AuthService {
//   @Autowired
//   private AffilatorRepository affilatorRepository;
//
//    public String getUserIDByEmailAndPassword(String email, String password) {
//        Affilator affilator = affilatorRepository.findByEmail(email);
//
// //    Check if the affilator exists and the password matches
//        if (affilator != null && affilator.getPassword().equals(password)) {
//            return affilator.getId(); // Return the affilator ID if the credentials are valid
//        } else {
//            return null; // Return null if the credentials are invalid
//        }
//
//        return null;
//    }
//}
