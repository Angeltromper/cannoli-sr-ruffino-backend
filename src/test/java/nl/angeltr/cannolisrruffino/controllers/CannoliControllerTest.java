package nl.angeltr.cannolisrruffino.controllers;


import nl.angeltr.cannolisrruffino.dtos.CannoliDto;
import nl.angeltr.cannolisrruffino.dtos.CannoliInputDto;
import nl.angeltr.cannolisrruffino.models.Cannoli;
import nl.angeltr.cannolisrruffino.service.CannoliService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CannoliControllerTest {

    @Mock
    private CannoliService cannoliService;

    @InjectMocks
    private CannoliController controller;

    @Test
    @DisplayName("Should return all products when no parameters are passed")
    void getCannolisWhenNoParametersArePassed() {
        var cannoli = new Cannoli();
        cannoli.setId(1L);
        cannoli.setCannoliName("Test");
        cannoli.setCannoliType("Test");
        cannoli.setDescription("Test");
        cannoli.setIngredients("Test");
        cannoli.setFlavour("Test");
        cannoli.setCalories("Test");
        cannoli.setPrice(1.0);

        var cannolis = List.of(cannoli);

        when(cannoliService.getCannolis()).thenReturn(cannolis);

        var result = controller.getCannoli(null, null);

        assertEquals(1, result.size());

    }

    @Test
    @DisplayName("Should create a cannoli when the cannoli is valid")
    void createCannoliWhenCannoliIsValid() {
        CannoliInputDto cannoliInputDto = new CannoliInputDto();
        cannoliInputDto.setCannoliName("test");
        cannoliInputDto.setCannoliType("test");
        cannoliInputDto.setDescription("test");
        cannoliInputDto.setIngredients("test");
        cannoliInputDto.setFlavour("test");
        cannoliInputDto.setCalories("test");
        cannoliInputDto.setPrice("test");

        Cannoli cannoli = new Cannoli();
        cannoli.setCannoliName("test");
        cannoli.setCannoliType("test");
        cannoli.setDescription("test");
        cannoli.setIngredients("test");
        cannoli.setFlavour("test");
        cannoli.setCalories("test");
        cannoli.setPrice("test");

        when(cannoliService.createCannoli(any())).thenReturn(cannoli);

        CannoliDto result = controller.createCannoli(cannoliInputDto;

        assertEquals(cannoliInputDto.getCannoliName(), result.getCannoliName());
    }

    @Test
    @DisplayName("Should throw an exception when the cannoli is invalid")
    void createCannoliWhenCannoliIsInvalidThenThrowException() {
        CannoliInputDto cannoliInputDto = new CannoliInputDto();
        cannoliInputDto.setCannoliName("");
        cannoliInputDto.setCannoliType("");
        cannoliInputDto.setDescription("");
        cannoliInputDto.setIngredients("");
        cannoliInputDto.setFlavour("");
        cannoliInputDto.setCalories("");
        cannoliInputDto.setPrice("");

        assertTrows(
                NullPointerException.class,
                () -> controller.createCannoli(cannoliInputDto));

        )



    }


}


