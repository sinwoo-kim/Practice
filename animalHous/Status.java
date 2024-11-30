package com.example.animalHous;

import java.util.List;

public class Status {

    String status;
    List<Status> statusList;

    public Status(String status) {
        this.status = status;
    }

    public Status(List<Status> statusList) {
        this.statusList = statusList;
    }

    public String getStatus() {
        return status;
    }
}
