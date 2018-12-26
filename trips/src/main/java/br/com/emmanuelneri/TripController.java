package br.com.emmanuelneri;

import br.com.emmanuelneri.Accommodations.Accommodation;
import br.com.emmanuelneri.Tickets.Ticket;

import lombok.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

   private Logger logger = LoggerFactory.getLogger(TripController.class);

   @Autowired
   private Tickets tickets;
   @Autowired
   private Accommodations accommodations;

    @GetMapping
    public Trip getTrip() {
        logger.info("get trip");

        final List<Ticket> tickets = this.tickets.getTickets();
        final List<Accommodation> accommodation = accommodations.getAccommodation();

        return new Trip("Brasil", "BC", accommodation, tickets);
    }

    @Value
    class Trip {
        private String country;
        private String city;
        private List<Accommodation> accommodations;
        private List<Ticket> tickets;
    }
}
