package gft.challenge.flight.reservation.persistence.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"gft.challenge.flight.reservation.persistence"})
@EntityScan(basePackages = {"gft.challenge.flight.reservation.persistence.model"})
@EnableJpaRepositories(basePackages = {"gft.challenge.flight.reservation.persistence"})
@EnableTransactionManagement
public class PersistenceConfiguration {

}
