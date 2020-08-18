package com.example.danielapp;

import java.util.List;

public class Queue {

    private List<Queue> queues;

    public Queue(List<Queue> queues) {
        this.queues = queues;
    }

    public List<Queue> getQueues() {
        return queues;
    }

    public void setQueues(List<Queue> queues) {
        this.queues = queues;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "queues=" + queues +
                '}';
    }
}
