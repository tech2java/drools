package com.tech2java;

import com.tech2java.drools.domain.Passport;
import com.tech2java.drools.domain.repo.ApplicationRepository;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import java.util.List;

public class StatelessPassportValidation {

    public static void main(String[] args) {

        List<Passport> passports = ApplicationRepository.getPassports();

        KieContainer kieContainer = KieServices.Factory.get().getKieClasspathContainer();
        StatelessKieSession kieSession = kieContainer.newStatelessKieSession("StatelessPassportValidationStep1");
        System.out.println("==== DROOLS SESSION START ==== ");
        kieSession.execute(passports);
        System.out.println("==== DROOLS SESSION END ==== ");

        //passports.forEach(passport -> System.out.println(passport + " validation " + passport.getValidation()));


    }
}
