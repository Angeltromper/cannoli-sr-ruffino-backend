package nl.angeltr.cannolisrruffino.controllers;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthenticationController authenticationController;


    @Test
    @DisplayName("Should throw an exception when the username or password are incorrect")
    void createAuthenticationTokenWhenUsernameOrPasswordAreIncorrectThenThrowException() {
        AuthenticationRequest authenticationRequest =
                new AuthenticationRequest("username", "password");
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenThrow(new BadCredentialsException("Incorrect username or password"));


        Exception exception =
                assertThrows(
                        Exception.class,
                        () -> {
                            authenticationController.createAuthenticationToken(
                                    authenticationRequest);
                        });

        assertEquals("Incorrect username or password", exception.getMessage());

    }
}


