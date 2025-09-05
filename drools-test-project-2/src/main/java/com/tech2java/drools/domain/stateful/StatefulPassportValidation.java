package com.tech2java.drools.domain.stateful;

import com.tech2java.drools.domain.Common;
import com.tech2java.drools.domain.Passport;
import com.tech2java.drools.domain.repo.ApplicationRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import java.util.List;

public class StatefulPassportValidation {

    public static void main(String[] args) {

        KieContainer kieClasspathContainer = KieServices.Factory.get().getKieClasspathContainer();
        KieSession ksession = kieClasspathContainer.newKieSession("StatefulPassportValidationStep2");

        List<Passport> passports = ApplicationRepository.getPassports();
        passports.forEach(ksession::insert);

        System.out.println("==== DROOLS SESSION START ==== ");
        ksession.fireAllRules();
        System.out.println("==== DROOLS SESSION END ==== ");

        System.out.println("==== PASSPORTS AFTER DROOLS SESSION === ");
        passports.forEach(passport -> {
            System.out.println(passport + " verdict: " + passport.getValidation() + ", cause: " + passport.getCause());
        });

        if (Common.disposeSession) {
            ksession.dispose();
        }

    }
    }

