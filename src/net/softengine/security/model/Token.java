package net.softengine.security.model;

import net.softengine.security.DESEDE;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "SEC_TOKEN", uniqueConstraints= @UniqueConstraint(columnNames={"username"}))
public class Token implements Serializable {

    public Token(){}
    private Token(String username, String password){
        this.username = username;
        this.password = password;
    }
	
	private static final long serialVersionUID = -2020752748932592756L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

	private String username;
	private String password;

    @OneToOne(mappedBy = "token")
    private User user;

    public static void main(String[] args) {
        Token token = new Token("mizan", "55vTALgZUyk=");
        System.out.println(token.getDecPassword());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}

    public String getDecPassword() {
        DESEDE desede = new DESEDE(this.username);
        return desede.decrypt(password);
	}
	public void setPassword(String password) {
        DESEDE desede = new DESEDE(this.username);
        this.password = desede.encrypt(password);
	}
}
