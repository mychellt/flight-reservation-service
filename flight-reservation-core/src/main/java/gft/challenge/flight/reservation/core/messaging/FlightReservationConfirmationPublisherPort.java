package gft.challenge.flight.reservation.core.messaging;

import gft.challenge.flight.reservation.domain.Reservation;

public interface FlightReservationConfirmationPublisherPort {
  void send(final Reservation reservation);
}
