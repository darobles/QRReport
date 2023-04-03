package cl.drobles.distancias.model;

public class ResponseServer {
	private String status;
	private int request_id;

	public ResponseServer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseServer(String status, int request_id) {
		super();
		this.status = status;
		this.request_id = request_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	public int getRequest_id() {
		return request_id;
	}

	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}

	@Override
	public String toString() {
		return "ResponseServer [status=" + status + ", request_id=" + request_id + "]";
	}

	
	
	
}
