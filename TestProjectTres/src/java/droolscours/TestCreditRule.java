package droolscours;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import com.sample.droolscours.Account;
import com.sample.droolscours.AccountingPeriod;
import com.sample.droolscours.CashFlow;
import com.sample.droolscours.DateHelper;
import com.sample.utils.KnowledgeSessionHelper;
import com.sample.utils.OutputDisplay;

public class TestCreditRule {

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
	public void testTwoFacts() throws Exception {
		sessionStatefull = KnowledgeSessionHelper.getStatefulKnowledgeSessionWithCallback(container, "ksession-rules2");

		OutputDisplay display = new OutputDisplay();
		sessionStatefull.setGlobal("showResults", display);

		Account a = new Account();
		a.setAccountNo(1);
		a.setBalance(0);
		sessionStatefull.insert(a);

		CashFlow cash1 = new CashFlow();
		cash1.setAccountNo(1);
		cash1.setAmount(1000);
		cash1.setDate(DateHelper.getDate("2016-01-15"));
		cash1.setType(CashFlow.CREDIT);
		sessionStatefull.insert(cash1);
		        
		CashFlow cash2 = new CashFlow();
		cash2.setAccountNo(1);
		cash2.setAmount(500);
		cash2.setDate(DateHelper.getDate("2016-02-15"));
		cash2.setType(CashFlow.DEBIT);
		sessionStatefull.insert(cash2);
		        
		CashFlow cash3 = new CashFlow();
		cash3.setAccountNo(1);
		cash3.setAmount(1000);
		cash3.setDate(DateHelper.getDate("2016-04-15"));
		cash3.setType(CashFlow.CREDIT);
		sessionStatefull.insert(cash3);

		AccountingPeriod period = new AccountingPeriod();
		period.setStartDate(DateHelper.getDate("2016-01-01"));
		period.setEndDate(DateHelper.getDate("2016-03-31"));
		sessionStatefull.insert(period);
		        
		sessionStatefull.fireAllRules();
		Assert.assertTrue(a.getBalance() == 500);
	}

}
