package gft.challenge.flight.reservation.processor.adapters;

import gft.challenge.flight.reservation.core.business.CreateFlightPort;
import gft.challenge.flight.reservation.core.command.Context;
import gft.challenge.flight.reservation.core.persistence.FlightRepositoryPort;
import gft.challenge.flight.reservation.domain.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateFlightAdapter implements CreateFlightPort {
  private final FlightRepositoryPort flightRepositoryPort;

  @Autowired
  public CreateFlightAdapter(final FlightRepositoryPort flightRepositoryPort) {
    this.flightRepositoryPort = flightRepositoryPort;
  }

  @Override
  public Void process(Context context) {
    final Flight data = context.getData(Flight.class);
    data.setNumberOfAvailableSeats(data.getNumberOfSeats());
    flightRepositoryPort.save(data);
    return null;
  }
}
