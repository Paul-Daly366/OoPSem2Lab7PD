package ie.atu.notificationapi.service;

import ie.atu.notificationapi.client.ReservationClient;
import ie.atu.notificationapi.model.Notification;
import ie.atu.notificationapi.model.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class NotificationService {
    private final ReservationClient reservationClient;

    public NotificationService(ReservationClient reservationClient) {
        this.reservationClient = reservationClient;
    }

    public Notification createNotification(Long reservationId){
        Reservation reservation = reservationClient.getReservation(reservationId);
        Notification notification = new Notification();
        notification.setReservationId(reservationId);
        notification.setEquipmentTag(reservation.getEquipmentTag());
        notification.setStudentEmail(reservation.getStudentEmail());
        notification.setNotificationDate(LocalDate.now());
        //notification.setNotificationStatus(false);
        return notification;
    }
}
