package cs333.project_2.Service.Respresentation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import cs333.project_2.DOM.General.Address;
import cs333.project_2.DOM.General.PaymentInfo;

@JsonIgnoreProperties(ignoreUnknown=true)
public class BuyerRequest extends BuyerRepresentation {

	private String currentPassword;
	private String newPassword;
	private String action;
	private Address newAddress;
	private PaymentInfo newPayInfo;
	
	public BuyerRequest() {}

	public String getCurrentPassword() {
		return currentPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public String getAction() {
		return action;
	}
	public Address getNewAddress() {
		return newAddress;
	}
	public PaymentInfo getNewPayInfo() {
		return newPayInfo;
	}
	
	public void setCurrentPassword(String password) {
		this.currentPassword = password;
	}
	public void setNewPassword(String password) {
		this.newPassword = password;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public void setNewAddress(Address newAddress) {
		this.newAddress = newAddress;
	}
	public void setNewPayInfo(PaymentInfo newPayInfo) {
		this.newPayInfo = newPayInfo;
	}
}
