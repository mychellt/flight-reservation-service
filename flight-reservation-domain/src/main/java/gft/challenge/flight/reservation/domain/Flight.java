package gft.challenge.flight.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Flight {
  private String origin;
  private String destination;
  private LocalDateTime arrivalAt;
  private LocalDateTime departureAt;
  private Integer numberOfSeats;
  private Integer numberOfAvailableSeats;
  private String number;

  public void reserveSeat() {
    this.numberOfAvailableSeats--;
  }

  public void releaseSeat() {
    this.numberOfAvailableSeats++;
  }
}
