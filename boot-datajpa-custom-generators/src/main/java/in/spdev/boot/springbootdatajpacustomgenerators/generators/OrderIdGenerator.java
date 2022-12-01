package in.spdev.boot.springbootdatajpacustomgenerators.generators;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class OrderIdGenerator implements IdentifierGenerator {

    int i = 1;
    String id = "ibm";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        String generatedId = id+(++i);
        return generatedId;
    }
}
