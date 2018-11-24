package com.examples.restservices;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;


@XmlRootElement(name = "search")
@XmlAccessorType(XmlAccessType.NONE)
public class Search implements Serializable {

    @XmlElement(name = "search_time")
    private String searchTime;

    @XmlElementWrapper
    @XmlElement(name="event")
    private List<Event> events;

    public Search() {
    }

    public String getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(String searchTime) {
        this.searchTime = searchTime;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}