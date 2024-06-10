package gft.challenge.flight.reservation.processor.adapters;

import gft.challenge.flight.reservation.core.business.FlightReservationPort;
import gft.challenge.flight.reservation.core.command.Context;
import gft.challenge.flight.reservation.core.messaging.FlightReservationConfirmationPublisherPort;
import gft.challenge.flight.reservation.core.persistence.ReservationRepositoryPort;
import gft.challenge.flight.reservation.domain.Reservation;
import gft.challenge.flight.reservation.domain.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightReservationAdapter implements FlightReservationPort {
  private final ReservationRepositoryPort reservationRepositoryPort;
  private final FlightReservationConfirmationPublisherPort flightReservationConfirmationPublisherPort;

  @Autowired
  public FlightReservationAdapter(final ReservationRepositoryPort reservationRepositoryPort,
                                  final FlightReservationConfirmationPublisherPort flightReservationConfirmationPublisherPort) {
    this.reservationRepositoryPort = reservationRepositoryPort;
    this.flightReservationConfirmationPublisherPort = flightReservationConfirmationPublisherPort;
  }

  @Override
  public Void process(Context context) {
    Reservation reservation = context.getData(Reservation.class);
    reservation.setStatus(Status.CONFIRMED);
    reservationRepositoryPort.save(reservation);

    flightReservationConfirmationPublisherPort.send(reservation);
    return null;
  }
}
