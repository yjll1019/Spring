package net.skhu.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Shippers {
	 @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   int id;

	 String company;
	 
	 @Column(name="last_name")
	 String lastName;
	 
	 @Column(name="first_name")
	 String firstName;
	 
	 @Column(name="email_address")
	 String emailAddress;
	 
	 @Column(name="job_title")
	 String jobTitle;
	 
	 @Column(name="business_phone")
	 String businessPhone;
	 
	 @Column(name="home_phone")
	 String homePhone;
	 
	 @Column(name="mobile_phone")
	 String mobilePhone;
	 
	 @Column(name="fax_number")
	 String faxNumber;
	 
	 @Column(name="address")
	 String address;
	 
	 @Column(name="city")
	 String city;
	 
	 @Column(name="state_province")
	 String state_province;
	 
	 @Column(name="zip_postal_code")
	 String zip_postal_code;
	 
	 @Column(name="country_region")
	 String countryRegion;
	 
	 @Column(name="web_page")
	 String webPage;
	 
	 @Column(name="notes")
	 String notes;
	 
	 @Column(name="attachments")
	 String attachments;

	   @OneToMany(mappedBy="shippers")
	   List<Orders> orders;
	 
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

	public String getState_province() {
		return state_province;
	}

	public void setState_province(String state_province) {
		this.state_province = state_province;
	}

	public String getZip_postal_code() {
		return zip_postal_code;
	}

	public void setZip_postal_code(String zip_postal_code) {
		this.zip_postal_code = zip_postal_code;
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

	public String getAttachments() {
		return attachments;
	}

	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	 
	 
}
