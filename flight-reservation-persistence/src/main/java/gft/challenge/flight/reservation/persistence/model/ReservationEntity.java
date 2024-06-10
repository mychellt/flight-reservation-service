package gft.challenge.flight.reservation.persistence.model;


import gft.challenge.flight.reservation.domain.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reservations")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(columnDefinition = "UUID")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "flight_id")
  private FlightEntity flight;

  @Enumerated(EnumType.STRING)
  private Status status;

  @Column(name = "reservation_date")
  private LocalDateTime date;

  @Column(name = "seats")
  private String seats;

  @Column(name = "travel_reservation_id")
  private UUID travelReservationId;
}
