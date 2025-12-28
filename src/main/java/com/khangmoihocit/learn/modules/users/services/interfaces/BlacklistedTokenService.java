package com.khangmoihocit.learn.modules.users.services.interfaces;

import com.khangmoihocit.learn.modules.users.requests.BlacklistTokenRequest;

import java.util.Date;

public interface BlacklistedTokenService {
    void create(BlacklistTokenRequest request);
}
