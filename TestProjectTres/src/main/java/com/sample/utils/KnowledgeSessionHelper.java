/**
 * 
 */
package com.sample.utils;

import org.kie.api.KieServices;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

/**
 * @author ovillamil
 *
 */
public class KnowledgeSessionHelper {

	public static KieContainer createRuleBase() {
		KieServices ks = KieServices.Factory.get();
		return ks.getKieClasspathContainer();
	}

	public static StatelessKieSession getStatelessKnowledgeSession(KieContainer kieContainer, String sessionName) {
		return kieContainer.newStatelessKieSession(sessionName);
	}

	public static KieSession getStatefulKnowledgeSession(KieContainer kieContainer, String sessionName) {
		return kieContainer.newKieSession(sessionName);
	}

	public static KieSession getStatefulKnowledgeSessionWithCallback(KieContainer kieContainer, String sessionName) {
		KieSession session = getStatefulKnowledgeSession(kieContainer, sessionName);

		session.addEventListener(new RuleRuntimeEventListener() {
			public void objectUpdated(ObjectUpdatedEvent event) {
				System.out.println("Object update \n" + event.getObject().toString());
			}

			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Object In \n" + event.getObject().toString());
			}

			public void objectDeleted(ObjectDeletedEvent event) {
				System.out.println("Object delete \n" + event.getOldObject().toString());
			}
		});

		session.addEventListener(new AgendaEventListener() {
			public void matchCreated(MatchCreatedEvent event) {
				System.out.println("The rule " + event.getMatch().getRule().getName() + " can be fired in agenda");
			}

			public void matchCancelled(MatchCancelledEvent event) {
				System.out.println("The rule " + event.getMatch().getRule().getName() + " cannot be in agenda");
			}

			public void beforeRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
			}

			public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
			}

			public void beforeMatchFired(BeforeMatchFiredEvent event) {
				System.out.println("The rule " + event.getMatch().getRule().getName() + " will be fired");
			}

			public void agendaGroupPushed(AgendaGroupPushedEvent event) {
				// TODO Auto-generated method stub

			}

			public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
				// TODO Auto-generated method stub

			}

			public void afterRuleFlowGroupDeactivated(RuleFlowGroupDeactivatedEvent event) {
				// TODO Auto-generated method stub

			}

			public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
				// TODO Auto-generated method stub

			}

			public void afterMatchFired(AfterMatchFiredEvent event) {
				System.out.println("The rule " + event.getMatch().getRule().getName() + " has be fired");
			}
		});
		return session;
	}

}
