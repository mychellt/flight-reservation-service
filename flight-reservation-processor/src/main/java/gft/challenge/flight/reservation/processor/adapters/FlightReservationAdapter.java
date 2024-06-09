package gft.challenge.flight.reservation.processor.adapters;

import gft.challenge.flight.reservation.core.business.FlightReservationPort;
import gft.challenge.flight.reservation.core.command.Context;
import org.springframework.stereotype.Service;

@Service
public class FlightReservationAdapter implements FlightReservationPort {
  @Override
  public Void process(Context context) {
    return null;
  }
}
