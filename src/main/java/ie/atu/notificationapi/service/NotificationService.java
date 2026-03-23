package ie.atu.notificationapi.service;

import ie.atu.notificationapi.model.NotificationRecord;
import ie.atu.notificationapi.repository.NotificationRepo;
import ie.atu.notificationapi.client.ReservationClient;
import ie.atu.notificationapi.model.Notification;
import ie.atu.notificationapi.model.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationService {
    //private List<Notification> notifications;
    private final ReservationClient reservationClient;
    private final NotificationRepo notificationRepo;

    public NotificationService(ReservationClient reservationClient, NotificationRepo notificationRepo) {
        this.reservationClient = reservationClient;
        this.notificationRepo = notificationRepo;
    }

    public List<NotificationRecord> getAllNotifications() {
        return notificationRepo.findAll();
    }

    public NotificationRecord createNotification(Long reservationId){
        Reservation reservation = reservationClient.getReservation(reservationId);
        NotificationRecord notification = new NotificationRecord();
        notification.setReservationId(reservationId);
        notification.setEquipmentTag(reservation.getEquipmentTag());
        notification.setStudentEmail(reservation.getStudentEmail());
        notification.setNotificationDate(LocalDate.now());
        notification.setNotificationSent(Boolean.TRUE);
        notificationRepo.save(notification);
        return notification;
    }
}
