package net.softengine.security.dao;

import net.softengine.security.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: M Ayatullah
 * Date: 8/23/14
 * Time: 4:18 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class TokenDaoImpl implements TokenDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Token token) {
        try {
            hibernateTemplate.persist(token);
            hibernateTemplate.flush();
            return true;
        } catch (Exception ex){
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Token token) {
        hibernateTemplate.merge(token);
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
    public List<Token> findAllToken() {
        return (List<Token> ) hibernateTemplate.find("from Token");
    }

    @Override
    public Token getToken(Long id) {
        return hibernateTemplate.get(Token.class, id);
    }

    @Override
    public Token getToken(String username) {
        Object[] paramArr = new Object[1];
        paramArr[0] = username;
        try{
            return (Token) hibernateTemplate.find("from Token where username=?", paramArr).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }
}
