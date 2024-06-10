CREATE TABLE IF NOT EXISTS flights (
   id UUID PRIMARY KEY,
   number VARCHAR(20) NOT NULL,
   origin VARCHAR(50) NOT NULL,
   destination VARCHAR(50) NOT NULL,
   departure_at TIMESTAMP NOT NULL,
   arrival_at TIMESTAMP NOT NULL,
   number_of_available_seats INT NOT NULL,
   number_of_seats INT NOT NULL
);

CREATE TABLE IF NOT EXISTS reservations (
    id UUID PRIMARY KEY,
    flight_id UUID NOT NULL,
    travel_reservation_id UUID NOT NULL,
    reservation_date TIMESTAMP NOT NULL,
    seats VARCHAR(255),
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (flight_id) REFERENCES flights(id)
);

ALTER TABLE flights OWNER TO postgres;
ALTER TABLE reservations OWNER TO postgres;

