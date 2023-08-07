package com.demobackend.demobackendtravelplan.repository;

import com.demobackend.demobackendtravelplan.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface NotificationRepository extends JpaRepository<Notification,Integer> {
    Notification findById(int id);
    List<Notification> findByUserId(int userId);
    List<Notification> findByPlanId(int planId);
}
