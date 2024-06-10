package gft.challenge.flight.reservation.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Reservation {
  private Flight flight;
  private Passenger passenger;
  private Status status;
  private LocalDateTime date;
  private String seats;
  private UUID travelReservationId;

  public boolean isConfirmed() {
    return this.status.equals(Status.CONFIRMED);
  }

  public boolean isCancelled() {
    return this.status.equals(Status.CANCELLED);
  }

  public boolean isPending() {
    return this.status.equals(Status.PENDING);
  }

  public boolean hasAvailableSeatOnFlight() {
    return flight.getNumberOfAvailableSeats() > 0;
  }

  public void confirm() {
    if(!isPending() || !hasAvailableSeatOnFlight()) {
      throw new IllegalStateException("Cannot confirm reservation.");
    }
    this.status = Status.CONFIRMED;
    flight.reserveSeat();
  }

  public void cancel() {
    if(!isConfirmed()) {
      throw new IllegalStateException("Cannot cancel reservation.");
    }
    this.status = Status.CANCELLED;
    flight.releaseSeat();
  }
}
