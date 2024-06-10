package gft.challenge.flight.reservation.messaging.rabbitmq.publishers;

import gft.challenge.flight.reservation.core.messaging.FlightReservationConfirmationPublisherPort;
import gft.challenge.flight.reservation.domain.Reservation;
import gft.challenge.flight.reservation.messaging.rabbitmq.model.FlightReservationConfirmationMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FlightReservationConfirmationPublisherAdapter implements FlightReservationConfirmationPublisherPort {
  @Value(value = "${app.messaging.flight-reservation-confirmation-queue}")
  private String queue;

  private final RabbitTemplate rabbitTemplate;

  @Autowired
  public FlightReservationConfirmationPublisherAdapter(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void send(Reservation reservation) {
    final FlightReservationConfirmationMessage message = FlightReservationConfirmationMessage.builder()
        .flightNumber(reservation.getFlight().getNumber())
        .date(LocalDateTime.now())
        .travelReservationId(reservation.getTravelReservationId())
        .build();

    rabbitTemplate.convertAndSend(queue, message);
  }
}
