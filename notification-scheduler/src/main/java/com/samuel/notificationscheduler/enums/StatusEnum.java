package com.samuel.notificationscheduler.enums;

import com.samuel.notificationscheduler.entity.Status;

public enum StatusEnum {

    PENDENTE(1L, "pendente"),
    SUCCESS(2L, "success"),
    ERROR(3L, "error"),
    CANCELED(4L, "canceled");

    private Long id;
    private String description;
    StatusEnum(Long id, String description) {
        this.id = id;
        this.description = description;
    }
    public Status toStatus(){
        return new Status(id, description);
    }
}
