package com.demobackend.demobackendtravelplan.controller;

import com.demobackend.demobackendtravelplan.ReqResClasses.RequestInfo;
import com.demobackend.demobackendtravelplan.entity.Notification;
import com.demobackend.demobackendtravelplan.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class NotificationController {

    @Autowired
    private NotificationService notificationService;


    @PostMapping("/java/saveNotifications")
    public ResponseEntity<String> saveNotifications(@RequestBody RequestInfo requestInfo) {
        try {
            notificationService.saveNotifications(requestInfo);
            return ResponseEntity.status(HttpStatus.CREATED).body("Notifications saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred");
        }
    }


    @DeleteMapping("/java/deleteNotification/{id}")
    public ResponseEntity<String> deleteNotification(@PathVariable int id) {
        String message = notificationService.deleteNotification(id);
        return ResponseEntity.ok(message);
    }


    @GetMapping("/java/getNotificationByUserId/{userId}")
    public ResponseEntity<List<Notification>> getNotificationsByUserId(@PathVariable int userId) {
        List<Notification> notifications = notificationService.getNotificationsByUserId(userId);
        return ResponseEntity.ok(notifications);
    }

    @DeleteMapping("/java/deleteNotificationsByPlanId/{planId}")
    public ResponseEntity<String> deleteNotificationsByPlanId(@PathVariable int planId) {
        try {
            notificationService.deleteNotificationsByPlanId(planId);
            return ResponseEntity.ok("Notifications deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting");
        }
    }
}