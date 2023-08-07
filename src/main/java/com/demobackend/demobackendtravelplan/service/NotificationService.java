package com.demobackend.demobackendtravelplan.service;

import com.demobackend.demobackendtravelplan.ReqResClasses.RequestInfo;
import com.demobackend.demobackendtravelplan.entity.Notification;
import com.demobackend.demobackendtravelplan.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public class NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;

    public void saveNotifications(RequestInfo requestInfo) {
        int planId = requestInfo.getPlanId();
        String planTitle = requestInfo.getPlanTitle();
        String description = requestInfo.getDescription();
        List<Integer> userIds = requestInfo.getUserIds();

        try {
            for (int userId : userIds) {
                Notification notification = new Notification();

                notification.setPlanId(planId);
                notification.setPlanTitle(planTitle);
                notification.setUserId(userId);
                notification.setDescription(description);

                notificationRepository.save(notification);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error saving ", e);
        }
    }

    public String deleteNotification(int id) {
        Notification notification = notificationRepository.findById(id);
        if (notification != null) {
            notificationRepository.delete(notification);
            return "Notification deleted";
        }
        return "Notification not found";
    }

    public void deleteNotificationsByPlanId(int planId) {
        List<Notification> notifications = notificationRepository.findByPlanId(planId);
        notificationRepository.deleteAll(notifications);
    }

    public List<Notification> getNotificationsByUserId(int userId) {
        return notificationRepository.findByUserId(userId);
    }
}