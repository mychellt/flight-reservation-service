package gft.challenge.flight.reservation.repository;

import gft.challenge.flight.reservation.model.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, UUID> {

}
