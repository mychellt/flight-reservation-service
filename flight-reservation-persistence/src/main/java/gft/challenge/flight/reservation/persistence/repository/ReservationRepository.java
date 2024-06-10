package gft.challenge.flight.reservation.persistence.repository;

import gft.challenge.flight.reservation.persistence.model.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReservationRepository extends JpaRepository<ReservationEntity, UUID> {

}
