package com.khangmoihocit.learn.modules.users.services.impl;

import com.khangmoihocit.learn.Resources.ErrorResource;
import com.khangmoihocit.learn.modules.users.entities.BlacklistedToken;
import com.khangmoihocit.learn.modules.users.repositories.BlacklistedTokenRepository;
import com.khangmoihocit.learn.modules.users.requests.BlacklistTokenRequest;
import com.khangmoihocit.learn.modules.users.services.interfaces.BlacklistedTokenService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
@Slf4j(topic = "BLACKLIST TOKEN")
public class BlacklistedTokenServiceImpl implements BlacklistedTokenService {
    BlacklistedTokenRepository blacklistedTokenRepository;

    @Override
    public void create(BlacklistTokenRequest request){
        try{
            if(blacklistedTokenRepository.existsByToken(request.getToken())){
                Map<String, String> errors = new HashMap<>();
                errors.put("message", "token này đã có trong blacklist");
                ErrorResource errorResource = ErrorResource.builder()
                        .message("có vấn đề xẩy ra trong quá trình xác thực")
                        .errors(errors)
                        .build();
            }
        }catch (Exception ex){

        }
    }
}
