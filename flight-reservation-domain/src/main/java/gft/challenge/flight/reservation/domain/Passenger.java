package gft.challenge.flight.reservation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Passenger {
  private String name;
  private String phone;
  private String email;
}
