package com.mrrobot.model;

public class clsDevice {

	private int idDevice, idClient, type, brand;
	private String model, serie, change, observations, comments, date;
	private int status;

	@Override
	public String toString() {
		return "clsDevice [idDevice=" + idDevice + ", idClient=" + idClient + ", type=" + type + ", brand=" + brand
				+ ", model=" + model + ", serie=" + serie + ", change=" + change + ", observations=" + observations
				+ ", comments=" + comments + ", date=" + date + ", status=" + status + "]";
	}

	public int getIdDevice() {
		return idDevice;
	}

	public void setIdDevice(int idDevice) {
		this.idDevice = idDevice;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getBrand() {
		return brand;
	}

	public void setBrand(int brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getChange() {
		return change;
	}

	public void setChange(String change) {
		this.change = change;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
