package gft.challenge.flight.reservation.persistence.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "flights")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class FlightEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "UUID")
  private UUID id;

  private String origin;
  private String destination;

  @Column(name = "arrival_at")
  private LocalDateTime arrivalAt;

  @Column(name = "departure_at")
  private LocalDateTime departureAt;

  @Column(name = "number_of_seats")
  private Integer numberOfSeats;

  @Column(name = "number_of_available_seats")
  private Integer numberOfAvailableSeats;

  private String number;
}
