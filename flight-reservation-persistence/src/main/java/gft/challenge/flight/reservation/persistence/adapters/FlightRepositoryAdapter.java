package gft.challenge.flight.reservation.persistence.adapters;

import gft.challenge.flight.reservation.core.persistence.FlightRepositoryPort;
import gft.challenge.flight.reservation.domain.Flight;
import gft.challenge.flight.reservation.persistence.mappers.PersistenceEntityMapper;
import gft.challenge.flight.reservation.persistence.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class FlightRepositoryAdapter implements FlightRepositoryPort {
  private final FlightRepository repository;
  private final PersistenceEntityMapper mapper;

  @Autowired
  public FlightRepositoryAdapter(final FlightRepository repository, final PersistenceEntityMapper mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  @Override
  public Optional<Flight> get(UUID id) {
    return repository.findById(id).map(mapper::from);
  }

  @Override
  public Flight save(Flight obj) {
    return mapper.from(repository.save(mapper.from(obj)));
  }

}
