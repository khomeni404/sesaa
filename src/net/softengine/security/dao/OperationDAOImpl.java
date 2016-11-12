package net.softengine.security.dao;

import net.softengine.security.model.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OperationDAOImpl implements OperationDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

/*    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Operation feature) {

        System.out.println("feature.getDescription()"+feature.getDescription());
        try{
            hibernateTemplate.saveOrUpdate(feature);

            return true;
        } catch (Exception ex) {
            System.out.println("ex = " + ex);
            return false;
        }

    }*/

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Operation operation) {
        hibernateTemplate.persist(operation);
        return true;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Operation operation) {
        try {
            hibernateTemplate.merge(operation);
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Operation getOperation(Long id) {
        return hibernateTemplate.get(Operation.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Operation findOperationByName(String operationName) {
        Object[] param = new Object[]{operationName};
        try {
            return (Operation) hibernateTemplate.find("from Operation as operation where operation.name=?", param).get(0);
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Operation> findAllOperations() {
        return (List<Operation>) hibernateTemplate.find(" from Operation ");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Operation operation) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

  /*
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean save(Module module) {
        try {
            hibernateTemplate.persist(module);

            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean update(Module module) {
        try {
            hibernateTemplate.merge(module);

            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public Module getModule(int componentId) {
        return hibernateTemplate.get(Module.class, componentId);
    }




    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean delete(Module module) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

  */

   /* private static final Pattern PUNCTSPACE = Pattern.compile("[ \\p{Punct}]+");
    private static final Pattern TRANSITION = Pattern.compile("(?<=[^\\p{Lu}])(?=[\\p{Lu}])|(?=[\\p{Lu}][^\\p{Lu}])");

    public static void extraTask(String args) {
        for (String d : deHumpLambda("hHrlllOkdkKdidIkk")) {
            System.out.println(WordUtils.capitalize(d));
        }
    }

    public static final List<String> deHumpLambda(String text) {
        return Arrays.stream(PUNCTSPACE.split(text))
                .filter(word -> !word.isEmpty())
                .flatMap(word -> Arrays.asList(TRANSITION.split(word)).stream())
                .collect(Collectors.toList());
    }*/
}
