package gft.challenge.flight.reservation.persistence.repository;

import gft.challenge.flight.reservation.persistence.model.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, UUID> {

}
