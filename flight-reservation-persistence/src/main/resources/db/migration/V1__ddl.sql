CREATE TABLE IF NOT EXISTS passengers (
     name VARCHAR(255) NOT NULL,
     email VARCHAR(255) NOT NULL,
     phone VARCHAR(20),
     id uuid not null primary key
);

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
    passenger_id UUID NOT NULL,
    reservation_date TIMESTAMP NOT NULL,
    number_of_seats INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (flight_id) REFERENCES flights(id),
    FOREIGN KEY (passenger_id) REFERENCES passengers(id)
);


ALTER TABLE passengers OWNER TO postgres;
ALTER TABLE flights OWNER TO postgres;
ALTER TABLE reservations OWNER TO postgres;

