package com.khangmoihocit.learn.modules.users.services.interfaces;

import com.khangmoihocit.learn.modules.users.requests.BlacklistTokenRequest;

import java.util.Date;

public interface BlacklistedTokenService {
    Object create(BlacklistTokenRequest request);
}
