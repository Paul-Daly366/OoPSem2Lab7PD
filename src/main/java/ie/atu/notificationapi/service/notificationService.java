package ie.atu.notificationapi.service;

import ie.atu.notificationapi.client.ReservationClient;
import org.springframework.stereotype.Service;

@Service
public class notificationService {
    private final ReservationClient reservationClient;

    public notificationService(ReservationClient reservationClient) {
        this.reservationClient = reservationClient;
    }

}
