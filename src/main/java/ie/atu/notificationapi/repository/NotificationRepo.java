package ie.atu.notificationapi.repository;

import ie.atu.notificationapi.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<Notification,Long> {
}
