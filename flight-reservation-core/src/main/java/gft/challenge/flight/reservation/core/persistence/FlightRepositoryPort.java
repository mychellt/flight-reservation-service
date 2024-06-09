package gft.challenge.flight.reservation.core.persistence;

import gft.challenge.flight.reservation.domain.Flight;

import java.util.Optional;
import java.util.UUID;

public interface FlightRepositoryPort {
  Flight save(final Flight obj);
  Optional<Flight> get(final UUID id);
}
