package mil.army.moda.vehicle.vehicle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VehicleRepositoryTest {

    @Autowired
    VehicleRepository vehicleRepository;

    @Test
    void shouldSaveAVehicle() {
        // Arrange
        Vehicle doghouse = new Vehicle("Sopwith", "dog-1", 1950, 0) ;

        // Act
        Vehicle savedDoghouse = vehicleRepository.save(doghouse);
        Optional<Vehicle> foundDoghouse = vehicleRepository.findById(doghouse.getId()) ;

        // Assert
        assertEquals("Sopwith", foundDoghouse.get().getMake()) ;
        assertThat(foundDoghouse.get()).isEqualTo(savedDoghouse) ;
        assertThat(foundDoghouse.get().getMake()).isSameAs(savedDoghouse.getMake()) ;
    }
}