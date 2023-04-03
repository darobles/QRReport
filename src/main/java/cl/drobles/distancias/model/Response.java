package cl.drobles.distancias.model;

public class Response {
	private String msg;
	private String detail;

	public Response(String msg, String detail) {
		super();
		this.msg = msg;
		this.detail = detail;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Response(String msg) {
		super();
		this.msg = msg;
	}

}
