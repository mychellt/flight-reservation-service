package gft.challenge.flight.reservation.processor.adapters;

import gft.challenge.flight.reservation.core.business.ConsultFlightPort;
import gft.challenge.flight.reservation.core.command.Context;
import gft.challenge.flight.reservation.core.persistence.FlightRepositoryPort;
import gft.challenge.flight.reservation.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultFlightAdapter implements ConsultFlightPort {
  private final FlightRepositoryPort flightRepositoryPort;

  @Autowired
  public ConsultFlightAdapter(FlightRepositoryPort flightRepositoryPort) {
    this.flightRepositoryPort = flightRepositoryPort;
  }

  @Override
  public Optional<Flight> process(Context context) {
    final UUID id = context.getData(UUID.class);
    return flightRepositoryPort.get(id);
  }
}
