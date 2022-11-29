package com.praveen.drools.example.web;

import com.praveen.drools.example.model.AccountableParty;
import com.praveen.drools.example.model.CustomerRequest;
import com.praveen.drools.example.model.CustomerType;
import com.praveen.drools.example.model.Resource;
import com.praveen.drools.example.service.RuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class RulesController {

    private final RuleService ruleService;

    public RulesController(
            RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping("getCustomerType")
    public ResponseEntity<CustomerType> getCustomer(@RequestBody CustomerRequest customerRequest) {
        CustomerType customerType = ruleService.getCustomerType(customerRequest);
        return new ResponseEntity<>(customerType, HttpStatus.OK);
    }

    @PostMapping("ownership")
    public ResponseEntity<AccountableParty> inferOwnership(@RequestBody Resource resource) {
        AccountableParty accountableParty = ruleService.inferOwnership(resource);
        return new ResponseEntity<>(accountableParty, HttpStatus.OK);
    }

}
