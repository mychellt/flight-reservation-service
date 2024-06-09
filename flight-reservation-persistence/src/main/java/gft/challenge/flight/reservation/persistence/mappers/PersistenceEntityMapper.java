package gft.challenge.flight.reservation.persistence.mappers;

import gft.challenge.flight.reservation.domain.Flight;
import gft.challenge.flight.reservation.persistence.model.FlightEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface PersistenceEntityMapper {
  Flight from(final FlightEntity source);
  FlightEntity from(final Flight source);
}
