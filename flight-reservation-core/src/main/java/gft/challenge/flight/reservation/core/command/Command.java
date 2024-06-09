package gft.challenge.flight.reservation.core.command;

public interface Command<R> {
    R process(final Context context);
}
