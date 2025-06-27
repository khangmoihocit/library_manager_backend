package khangmoihocit.library_manager.service;

import khangmoihocit.library_manager.dto.request.AuthenticationRequest;
import khangmoihocit.library_manager.dto.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authentication(AuthenticationRequest request);
}
