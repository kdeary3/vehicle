package mil.army.moda.vehicle.vehicle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository ;

    @InjectMocks
    private VehicleService vehicleService;

    @Test
    void shouldSaveAVehicle() {
        // Arrange
        Vehicle tessie = new Vehicle("Tesla", "3", 2022, 40000) ;
        tessie.setId(1L);

        // Act
        when(vehicleRepository.save(tessie)).thenReturn(tessie) ;
        Vehicle result = vehicleService.saveVehicle(tessie) ;

        // Assert
        assertEquals(tessie, result);
        assertThat(result.getId()).isEqualTo(1L) ;
        // verify that tessie is saved in
        verify(vehicleRepository).save(tessie) ;

    }
}