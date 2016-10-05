package prosecutor.planner.event;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Fry on 02.09.2016.
 */
public final class Ticket {

    protected static int           _currentTicket =   -1;

    public final     Set<Observer> Observers      =   new HashSet<>();
    public final     int           TicketID;

    protected Ticket(int ticketID)
    {
        this.TicketID = ticketID;
    }



}
