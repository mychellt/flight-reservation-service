package gft.challenge.flight.reservation.messaging.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FlightReservationMessage {
  private UUID flightId;
  private String seats;
  private UUID travelReservationId;
}
