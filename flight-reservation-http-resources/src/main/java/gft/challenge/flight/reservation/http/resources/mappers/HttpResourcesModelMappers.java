package gft.challenge.flight.reservation.http.resources.mappers;

import gft.challenge.flight.reservation.domain.Flight;
import gft.challenge.flight.reservation.http.resources.dto.CreateFlightDTO;
import gft.challenge.flight.reservation.http.resources.dto.GetFlightResponseDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(builder = @Builder(disableBuilder = true), componentModel = "spring")
public interface HttpResourcesModelMappers {
  Flight from(final CreateFlightDTO source);
  GetFlightResponseDTO from(final Flight source);
}
