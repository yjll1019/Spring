package net.skhu.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Employees {
   //직원
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int id;

   String company;//회사

   @Column(name="last_name")
   String lastName;//이름

   @Column(name="first_name")
   String firstName;//성

   @Column(name="email_address")
   String emailAddress;//이메일 주소

   @Column(name="job_title")
   String jobTitle;

   @Column(name="business_phone")
   String businessPhone;//회사 전화번호

   @Column(name="home_phone")
   String homePhone;// 집 전화번호

   @Column(name="mobile_phone")
   String mobilePhone;// 휴대폰 번호

   @Column(name="fax_number")
   String faxNumber;// fax 번호

   String address; //주소
   String city; //도시

   @Column(name="state_province")
   String stateProvince;//행정구역 단위

   @Column(name="zip_postal_code")
   String zipPostalCode;//우편번호

   @Column(name="country_region")
   String countryRegion;//나라

   @Column(name="web_page")
   String webPage;//웹주소

   String notes;//메모

   @Basic(fetch=FetchType.LAZY)
   @Lob
   byte[] attachments;//첨부파일

   @OneToMany(mappedBy="employees")
   List<Orders> orders;
   
   @OneToMany(mappedBy="employees")
   List<PurchaseOrders> PurchaseOrders;
   
   
   
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getEmailAddress() {
	return emailAddress;
}

public void setEmailAddress(String emailAddress) {
	this.emailAddress = emailAddress;
}

public String getJobTitle() {
	return jobTitle;
}

public void setJobTitle(String jobTitle) {
	this.jobTitle = jobTitle;
}

public String getBusinessPhone() {
	return businessPhone;
}

public void setBusinessPhone(String businessPhone) {
	this.businessPhone = businessPhone;
}

public String getHomePhone() {
	return homePhone;
}

public void setHomePhone(String homePhone) {
	this.homePhone = homePhone;
}

public String getMobilePhone() {
	return mobilePhone;
}

public void setMobilePhone(String mobilePhone) {
	this.mobilePhone = mobilePhone;
}

public String getFaxNumber() {
	return faxNumber;
}

public void setFaxNumber(String faxNumber) {
	this.faxNumber = faxNumber;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getStateProvince() {
	return stateProvince;
}

public void setStateProvince(String stateProvince) {
	this.stateProvince = stateProvince;
}

public String getZipPostalCode() {
	return zipPostalCode;
}

public void setZipPostalCode(String zipPostalCode) {
	this.zipPostalCode = zipPostalCode;
}

public String getCountryRegion() {
	return countryRegion;
}

public void setCountryRegion(String countryRegion) {
	this.countryRegion = countryRegion;
}

public String getWebPage() {
	return webPage;
}

public void setWebPage(String webPage) {
	this.webPage = webPage;
}

public String getNotes() {
	return notes;
}

public void setNotes(String notes) {
	this.notes = notes;
}

public byte[] getAttachments() {
	return attachments;
}

public void setAttachments(byte[] attachments) {
	this.attachments = attachments;
}

public List<Orders> getOrders() {
	return orders;
}

public void setOrders(List<Orders> orders) {
	this.orders = orders;
}

public List<PurchaseOrders> getPurchaseOrders() {
	return PurchaseOrders;
}

public void setPurchaseOrders(List<PurchaseOrders> purchaseOrders) {
	PurchaseOrders = purchaseOrders;
}
   
   
   
}