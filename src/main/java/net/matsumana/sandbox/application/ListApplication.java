package net.matsumana.sandbox.application;

import net.matsumana.sandbox.domain.ListDomain;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ListApplication {

    @Inject
    ListDomain listDomain;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String init() {
        return listDomain.init();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void create() {
        listDomain.create();
    }
}
