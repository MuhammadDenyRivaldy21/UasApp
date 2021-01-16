package com.qiraht.kuliah.testingapps.model.MatchSchedule;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseSchedule{

	@SerializedName("events")
	private List<EventsItem> events;

	public void setEvents(List<EventsItem> events){
		this.events = events;
	}

	public List<EventsItem> getEvents(){
		return events;
	}
}