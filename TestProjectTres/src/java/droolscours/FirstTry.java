package droolscours;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.sample.droolscours.Account;
import com.sample.utils.KnowledgeSessionHelper;
import com.sample.utils.OutputDisplay;

public class FirstTry {

	StatelessKieSession sessionStateless = null;
	KieSession sessionStatefull = null;
	static KieContainer container;

	@Before
	public void before() {
		System.out.println("---------- Before ---------");
	}

	@BeforeClass
	public static void beforeClass() {
		container = KnowledgeSessionHelper.createRuleBase();
	}

	@After
	public void after() {
		System.out.println("---------- After ---------");
	}

	@Test
	public void test() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(container, "ksession-rules");

		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStatefull.setGlobal("results", outputDisplay);
		sessionStatefull.setGlobal("enviroment", "Conf Ambiente");

		Account account = new Account();
		sessionStatefull.insert(account);
		sessionStatefull.fireAllRules();
	}

	@Test
	public void testWithCallBackToSession() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(container, "ksession-rules");

		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStatefull.setGlobal("results", outputDisplay);

		sessionStatefull.addEventListener(new RuleRuntimeEventListener() {
			public void objectUpdated(ObjectUpdatedEvent event) {
				System.out.println("Object update: " + event.getObject().toString());
			}

			public void objectInserted(ObjectInsertedEvent event) {
				System.out.println("Object insert: " + event.getObject().toString());
			}

			public void objectDeleted(ObjectDeletedEvent event) {
				System.out.println("Object delete: " + event.getOldObject().toString());
			}
		});

		Account account = new Account();
		FactHandle handle = sessionStatefull.insert(account);
		System.out.println("Primera ejecuciónde la regla");
		sessionStatefull.fireAllRules();

		sessionStatefull.update(handle, account);
		System.out.println("Segundaejecución de la regla");
		sessionStatefull.fireAllRules();
	}

	@Test
	public void testRuleOneFactThatInserObject() {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(container, "ksession-rules1");

		OutputDisplay outputDisplay = new OutputDisplay();
		sessionStatefull.setGlobal("results", outputDisplay);

		Account account = new Account();
		sessionStatefull.insert(account);
		sessionStatefull.fireAllRules();
	}

}
