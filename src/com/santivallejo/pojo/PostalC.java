package com.santivallejo.pojo;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@JsonPropertyOrder({ "adminCode2", "adminCode3", "adminName3", "adminCode1",
	"adminName2", "lng", "countryCode", "postalcode", "adminName1",
	"ISO3166", "placeName", "lat" })
public class PostalC {

	private String adminCode2;
	private String adminCode3;
	private String adminName3;
	private String adminCode1;
	private String adminName2;
	private double lng;
	private String countryCode;
	private String postalcode;
	private String adminName1;
	private String ISO3166;
	private String placeName;
	private double lat;

	/**
	 * @return the adminCode1
	 */
	@JsonProperty("adminCode1")
	public String getAdminCode1() {
		return adminCode1;
	}

	/**
	 * @param adminCode1
	 *            the adminCode1 to set
	 */
	@JsonProperty("adminCode1")
	public void setAdminCode1(String adminCode1) {
		this.adminCode1 = adminCode1;
	}

	/**
	 * @return the adminCode2
	 */
	@JsonProperty("adminCode2")
	public String getAdminCode2() {
		return adminCode2;
	}

	/**
	 * @param adminCode2
	 *            the adminCode2 to set
	 */
	@JsonProperty("adminCode2")
	public void setAdminCode2(String adminCode2) {
		this.adminCode2 = adminCode2;
	}

	/**
	 * @return the adminCode3
	 */
	@JsonProperty("adminCode3")
	public String getAdminCode3() {
		return adminCode3;
	}

	/**
	 * @param adminCode3
	 *            the adminCode3 to set
	 */
	@JsonProperty("adminCode3")
	public void setAdminCode3(String adminCode3) {
		this.adminCode3 = adminCode3;
	}

	/**
	 * @return the adminName1
	 */
	@JsonProperty("adminName1")
	public String getAdminName1() {
		return adminName1;
	}

	/**
	 * @param adminName1
	 *            the adminName1 to set
	 */
	@JsonProperty("adminName1")
	public void setAdminName1(String adminName1) {
		this.adminName1 = adminName1;
	}

	/**
	 * @return the adminName2
	 */
	@JsonProperty("adminName2")
	public String getAdminName2() {
		return adminName2;
	}

	/**
	 * @param adminName2
	 *            the adminName2 to set
	 */
	@JsonProperty("adminName2")
	public void setAdminName2(String adminName2) {
		this.adminName2 = adminName2;
	}

	/**
	 * @return the adminName3
	 */
	@JsonProperty("adminName3")
	public String getAdminName3() {
		return adminName3;
	}

	/**
	 * @param adminName3
	 *            the adminName3 to set
	 */
	@JsonProperty("adminName3")
	public void setAdminName3(String adminName3) {
		this.adminName3 = adminName3;
	}

	/**
	 * @return the countryCode
	 */
	@JsonProperty("countryCode")
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	@JsonProperty("countryCode")
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the iSO3166
	 */
	@JsonProperty("ISO3166")
	public String getISO3166() {
		return ISO3166;
	}

	/**
	 * @param iSO3166
	 *            the iSO3166 to set
	 */
	@JsonProperty("ISO3166")
	public void setISO3166(String iSO3166) {
		ISO3166 = iSO3166;
	}

	/**
	 * @return the lat
	 */
	@JsonProperty("lat")
	public double getLat() {
		return lat;
	}

	/**
	 * @param lat
	 *            the lat to set
	 */
	@JsonProperty("lat")
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * @return the lng
	 */
	@JsonProperty("lng")
	public double getLng() {
		return lng;
	}

	/**
	 * @param lng
	 *            the lng to set
	 */
	@JsonProperty("lng")
	public void setLng(double lng) {
		this.lng = lng;
	}

	/**
	 * @return the placeName
	 */
	@JsonProperty("placeName")
	public String getPlaceName() {
		return placeName;
	}

	/**
	 * @param placeName
	 *            the placeName to set
	 */
	@JsonProperty("placeName")
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	/**
	 * @return the postalCode
	 */
	@JsonProperty("postalcode")
	public String getPostalCode() {
		return postalcode;
	}

	/**
	 * @param postalCode
	 *            the postalCode to set
	 */
	@JsonProperty("postalcode")
	public void setPostalCode(String postalcode) {
		this.postalcode = postalcode;
	}

	public PostalC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PostalC(String adminCode1, String adminCode2, String adminCode3,
			String adminName1, String adminName2, String adminName3,
			String countryCode, String iSO3166, double lat, double lng,
			String placeName, String postalcode) {
		super();
		this.adminCode1 = adminCode1;
		this.adminCode2 = adminCode2;
		this.adminCode3 = adminCode3;
		this.adminName1 = adminName1;
		this.adminName2 = adminName2;
		this.adminName3 = adminName3;
		this.countryCode = countryCode;
		ISO3166 = iSO3166;
		this.lat = lat;
		this.lng = lng;
		this.placeName = placeName;
		this.postalcode = postalcode;
	}

}
