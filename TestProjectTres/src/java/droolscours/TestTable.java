package droolscours;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import com.sample.droolscours.User;
import com.sample.utils.KnowledgeSessionHelper;

public class TestTable {

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
	public void testTableDiscountCalculation() throws Exception {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSession(container, "ksession-tables");

		User userGold = new User(25, User.GOLD, "Adam Smith");
		sessionStatefull.insert(userGold);

		User userSilver = new User(17, User.SILVER, "Carlos Lopez");
		sessionStatefull.insert(userSilver);

		User userNone = new User(30, User.NA, "Adrian Mc");
		sessionStatefull.insert(userNone);

		sessionStatefull.fireAllRules();

		System.out.println("User Adam: " + userGold.getDiscount());
		System.out.println("User Carlos: " + userSilver.getDiscount());
		System.out.println("User Adrian: " + userNone.getDiscount());
	}

}
