package gft.challenge.flight.reservation.http.resources.controllers;

import gft.challenge.flight.reservation.core.business.ConsultFlightPort;
import gft.challenge.flight.reservation.core.business.CreateFlightPort;
import gft.challenge.flight.reservation.core.command.Context;
import gft.challenge.flight.reservation.domain.Flight;
import gft.challenge.flight.reservation.http.resources.dto.CreateFlightDTO;
import gft.challenge.flight.reservation.http.resources.dto.GetFlightResponseDTO;
import gft.challenge.flight.reservation.http.resources.mappers.HttpResourcesModelMappers;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping(value = "/api/flight")
public class FlightController {
  private final CreateFlightPort createFlightPort;
  private final ConsultFlightPort consultFlightPort;

  private final HttpResourcesModelMappers mapper;

  @Autowired
  public FlightController(final CreateFlightPort createFlightPort,
                          final ConsultFlightPort consultFlightPort,
                          final HttpResourcesModelMappers mapper) {
    this.createFlightPort = createFlightPort;
    this.consultFlightPort = consultFlightPort;
    this.mapper = mapper;
  }

  @PostMapping
  public ResponseEntity<Void> create(@RequestBody final CreateFlightDTO body) {
    final Context context = new Context();
    context.setData(mapper.from(body));
    createFlightPort.process(context);
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<GetFlightResponseDTO> get(@PathVariable(value = "id") final UUID id) {
    final Context context = new Context();
    context.setData(id);
    final GetFlightResponseDTO response = consultFlightPort.process(context).map(mapper::from).orElse(null);
    if(nonNull(response)) {
      return ResponseEntity.ok().body(response);
    }
    else {
      return ResponseEntity.notFound().build();
    }
  }

}
