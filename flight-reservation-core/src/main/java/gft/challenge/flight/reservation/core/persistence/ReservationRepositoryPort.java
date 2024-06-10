package gft.challenge.flight.reservation.core.persistence;

import gft.challenge.flight.reservation.domain.Reservation;

public interface ReservationRepositoryPort {
  Reservation save(Reservation reservation);
}
