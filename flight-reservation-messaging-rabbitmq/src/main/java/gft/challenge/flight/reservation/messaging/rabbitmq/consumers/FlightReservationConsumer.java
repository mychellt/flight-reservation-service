package gft.challenge.flight.reservation.messaging.rabbitmq.consumers;

import gft.challenge.flight.reservation.core.business.FlightReservationPort;
import gft.challenge.flight.reservation.core.command.Context;
import gft.challenge.flight.reservation.domain.Flight;
import gft.challenge.flight.reservation.domain.Reservation;
import gft.challenge.flight.reservation.messaging.rabbitmq.model.FlightReservationMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FlightReservationConsumer {
  private final FlightReservationPort flightReservationPort;

  @Autowired
  public FlightReservationConsumer(FlightReservationPort flightReservationPort) {
    this.flightReservationPort = flightReservationPort;
  }


  @RabbitListener(queues = "${app.messaging.flight-reservation-queue}")
  public void process(final FlightReservationMessage message) {
    final Context context = new Context();

    final Reservation reservation =
        Reservation.builder()
            .date(LocalDateTime.now())
            .seats(message.getSeats())
            .travelReservationId(message.getTravelReservationId())
            .flight(Flight.builder()
                .id(message.getFlightId())
                .build())
            .build();

    context.setData(reservation);
    flightReservationPort.process(context);
  }
}
