package ttps.spring.services;

public class Credentials {

    private String token;
    private int exp;
    private String status;
    private String type;
    private String userID;

    public Credentials() {
    }

    public Credentials(String token, int exp, String username, String type, String userID) {
        this.token = token;
        this.exp = exp;
        this.status = username;
        this.type = type;
        this.userID = userID;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}
    
    
    
    
}