package gft.challenge.flight.reservation.processor.adapters;

import gft.challenge.flight.reservation.core.business.CreateFlightPort;
import gft.challenge.flight.reservation.core.command.Context;
import org.springframework.stereotype.Service;

@Service
public class CreateFlightAdapter implements CreateFlightPort {
  @Override
  public Void process(Context context) {
    return null;
  }
}
