package gft.challenge.flight.reservation.persistence.mappers;

import gft.challenge.flight.reservation.domain.Flight;
import gft.challenge.flight.reservation.domain.Reservation;
import gft.challenge.flight.reservation.persistence.model.FlightEntity;
import gft.challenge.flight.reservation.persistence.model.ReservationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PersistenceEntityMapper {
  Flight from(final FlightEntity source);
  FlightEntity from(final Flight source);

  Reservation from(final ReservationEntity source);
  ReservationEntity from(final  Reservation source);
}
