package com.exc.myapplication.eventbus;

public class EventMessage<T> {
    private EventEnum eventEnum;
    private T data;
    public EventEnum getEventEnum() {
        return eventEnum;
    }
    public void setEventEnum(EventEnum eventEnum) {
        this.eventEnum = eventEnum;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
