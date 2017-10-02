package org.ca.hr.objects;

public class DeletedUserResponse {
	private String id;
	private boolean status;

	public DeletedUserResponse(String id, boolean status) {
		this.id = id;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
