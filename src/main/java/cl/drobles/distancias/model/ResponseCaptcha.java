package cl.drobles.distancias.model;

import java.sql.Timestamp;

public class ResponseCaptcha {
	
	private Boolean success;
	private Timestamp challenge_ts;
	private String hostname;
	private Double score;
	private String action;
	private String[] errorCodes;
	public ResponseCaptcha() {
		super();		
	}
	
	public ResponseCaptcha(Boolean success, Timestamp challenge_ts, String hostname, Double score, String action,
			String[] error_codes) {
		super();
		this.success = success;
		this.challenge_ts = challenge_ts;
		this.hostname = hostname;
		this.score = score;
		this.action = action;
		this.errorCodes = error_codes;
	}

	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	
	public Timestamp getChallenge_ts() {
		return challenge_ts;
	}

	public void setChallenge_ts(Timestamp challenge_ts) {
		this.challenge_ts = challenge_ts;
	}

	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostame) {
		this.hostname = hostame;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String[] getErrorCodes() {
		return errorCodes;
	}

	public void setErrorCodes(String[] error_codes) {
		this.errorCodes = error_codes;
	}

	@Override
	public String toString() {
		return "ResponseCaptcha [success=" + success + ", challenge_ts=" + challenge_ts + ", hostame=" + hostname
				+ ", score=" + score + ", action=" + action + "]";
	}
	
	
}
