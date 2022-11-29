package com.praveen.drools.example.service;

import com.praveen.drools.example.model.AccountableParty;
import com.praveen.drools.example.model.CustomerRequest;
import com.praveen.drools.example.model.CustomerType;
import com.praveen.drools.example.model.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;
import org.kie.api.runtime.rule.FactHandle;

import java.util.Collection;

/**
 * Customer Categorization service.
 * @author Praveen.Nair
 */
public class RuleService {

    private final KieContainer kieContainer;

    public RuleService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public CustomerType getCustomerType(CustomerRequest customerRequest) {
        CustomerType customerType = new CustomerType();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("customerType", customerType);
        kieSession.insert(customerRequest);
        kieSession.getAgenda().getAgendaGroup("customer").setFocus();
        kieSession.fireAllRules();
        printFactsMessage(kieSession);
        kieSession.dispose();
        return customerType;
    }

    public AccountableParty inferOwnership(Resource resource) {
        AccountableParty accountableParty = new AccountableParty();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("accountableParty", accountableParty);
        kieSession.insert(resource);
        kieSession.getAgenda().getAgendaGroup("ownership").setFocus();
        kieSession.fireAllRules();
        printFactsMessage(kieSession);
        kieSession.dispose();

        return accountableParty;
    }

    private void printFactsMessage(KieSession kieSession) {
        Collection<FactHandle> allHandles = kieSession.getFactHandles();

        String msg = "\nAll facts:\n";
        for (FactHandle handle : allHandles) {
            msg += "    " + kieSession.getObject(handle) + "\n";
        }

        System.out.println(msg);
    }
}
