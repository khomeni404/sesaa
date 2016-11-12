package net.softengine.security.dao;

import java.util.List;

import net.softengine.security.model.Token;
import net.softengine.security.DESEDE;
import net.softengine.security.model.User;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
    
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean save(User user){
		hibernateTemplate.persist(user);
        return true;
	}


    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Token token){
        hibernateTemplate.persist(token);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Token token){
        hibernateTemplate.merge(token);
        return true;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(User user){
        hibernateTemplate.merge(user);
        return true;
    }

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public boolean delete(User user) {
		hibernateTemplate.delete(user);
        hibernateTemplate.flush();
        return true;
	}

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Token token) {
        hibernateTemplate.delete(token);
        hibernateTemplate.flush();
        return true;
    }

    @Override
	public User get(Long userID) {
		return (User) hibernateTemplate.get(User.class, userID);
	}


	@Override
	public User get(String username) {
		Object[] paramArr = new Object[1];
        User user = null;
		paramArr[0] = new String(username);

        Token token = null;

        try{
            token = (Token) hibernateTemplate.find("from Token where username=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            token = null;
        }

        if(token instanceof Token){
            user = (User) hibernateTemplate.find("from User as user where user.token.id=?",
                    token.getId()).get(0);
        }
        return user;
	}


    @SuppressWarnings("unchecked")
	@Override
	public User get(String username, String password){
		DESEDE desede = new DESEDE(username);
		Object[] paramArr = new Object[2];
		paramArr[0] = new String(username);
		paramArr[1] = desede.encrypt(password);
        try{
            Token userToken = (Token)hibernateTemplate.find("from Token as token " +
                    " where token.username =? and token.password =? ", paramArr).get(0);

            //System.out.println("userToken.getUsername() = " + userToken.getUsername());
            Object[] paramUser = new Object[2];
            paramUser[0] = true;
            paramUser[1] = userToken.getId();

            List<User> users = (List<User>) hibernateTemplate.find("from User as user where user.active =? " +
                    "and user.token.id=?", paramUser);
            System.out.println("users.size() = " + users.size());
            if(users == null || users.size() == 0) {
                return null;
            }

            return users.get(0);
        } catch (IndexOutOfBoundsException idxOutBEx){
            System.out.println("idxOutBEx = " + idxOutBEx);
            return null;
        }
	}


	@Override
	public User getUserByEmail(String email) {
		Object[] paramArr = new Object[1];
		paramArr[0] = new String(email);
		return (User)hibernateTemplate.find("from User where email=?", paramArr).get(0);
	}


	@Override
	public List<User> getAllUsers() {
		return (List<User>) hibernateTemplate.find("from User");
	}

    @Override
    public int count(){
        Session hibernateSession = hibernateTemplate.getSessionFactory().getCurrentSession();
        int count;
        try{
            count = Integer.parseInt(hibernateSession.
                    createCriteria(User.class).
                    setProjection(Projections.rowCount()).
                    uniqueResult().toString());
        }   catch (Exception ex){
            count = 0;
        }

        //return hibernateTemplate.find("from User").size();
        return count;
    }

}
