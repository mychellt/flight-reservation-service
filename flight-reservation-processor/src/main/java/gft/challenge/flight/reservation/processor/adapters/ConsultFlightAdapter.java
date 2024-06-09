package gft.challenge.flight.reservation.processor.adapters;

import gft.challenge.flight.reservation.core.business.ConsultFlightPort;
import gft.challenge.flight.reservation.core.command.Context;
import gft.challenge.flight.reservation.domain.Flight;
import org.springframework.stereotype.Service;

@Service
public class ConsultFlightAdapter implements ConsultFlightPort {
  @Override
  public Flight process(Context context) {
    return null;
  }
}
