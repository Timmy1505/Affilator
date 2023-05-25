package net.xfantome.business.affilator.service.ServiceImpl;

import net.xfantome.business.affilator.JWT.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    @Autowired
    private JwtUtil jwtUtil;

    public String generateVerificationToken(String userId) {
        return jwtUtil.generateToken(userId);
    }

    public String generatePasswordSetupToken(String userId) {
        return jwtUtil.generateToken(userId);
    }
}
