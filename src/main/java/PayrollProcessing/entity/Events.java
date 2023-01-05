package PayrollProcessing.entity;

public class Events {
	private String eventEmpId;
	private String Event;
	private String EventValue;
	private String eventDate;
	private String notes;
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventValue() {
		return EventValue;
	}
	public void setEventValue(String eventValue) {
		EventValue = eventValue;
	}
	
	public String getEvent() {
		return Event;
	}
	public void setEvent(String event) {
		Event = event;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getEventEmpId() {
		return eventEmpId;
	}
	public void setEventEmpId(String eventEmpId) {
		this.eventEmpId = eventEmpId;
	}
	
}
