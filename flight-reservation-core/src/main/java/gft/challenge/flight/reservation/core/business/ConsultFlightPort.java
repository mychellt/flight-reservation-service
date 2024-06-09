package gft.challenge.flight.reservation.core.business;

import gft.challenge.flight.reservation.core.command.Command;
import gft.challenge.flight.reservation.domain.Flight;

import java.util.Optional;

public interface ConsultFlightPort extends Command<Optional<Flight>> {

}
