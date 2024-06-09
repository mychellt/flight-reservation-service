package gft.challenge.flight.reservation.http.resources.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GetFlightResponseDTO {
  private String origin;
  private String destination;
  @JsonAlias(value = "arrival_at")
  private LocalDateTime arrivalAt;
  @JsonAlias(value = "departure_at")
  private LocalDateTime departureAt;
  @JsonAlias(value = "number_of_seats")
  private Integer numberOfSeats;
  @JsonAlias(value = "number_of_seats_available")
  private Integer numberOfSeatsAvailable;
  private String number;
}
