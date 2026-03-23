package ie.atu.notificationapi.repository;

import ie.atu.notificationapi.model.NotificationRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepo extends JpaRepository<NotificationRecord,Long> {
}
