package entities;

public class Server {

	public int key;
	public String ip;
	public String port;

	public Server() {

	}

	public Server(String ip, String port) {
		this.ip = ip;
		this.port = port;
	}

	public Server(int key, String ip, String port) {
		this.key = key;
		this.ip = ip;
		this.port = port;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public int getKey() {
		return this.key;
	}

	public String getIp() {
		return this.ip;
	}

	public String getPort() {
		return this.port;
	}

}