package mil.army.moda.vehicle.vehicle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VehicleController.class)
class VehicleControllerTest {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    VehicleService vehicleService;

    @Test
    void shouldSaveVehicle() throws Exception {

        //TDD 1: Arrange

        Vehicle biplane = new Vehicle ("Biplane", "Spad-13-1", 1918, 6500);
        when(vehicleService.saveVehicle(any(Vehicle.class))).thenReturn(biplane);

        //TDD 2: Act
        mockMvc.perform(post("/api/saveVehicle") // Request builder. Depending on what it is, get a response.
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(biplane)))
                .andExpect(status().isCreated())
                .andDo(print());
        verify(vehicleService, times(1)).saveVehicle(any(Vehicle.class));

    }
}
