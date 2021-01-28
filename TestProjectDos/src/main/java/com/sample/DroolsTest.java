/**
 * 
 */
package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.model.ProductPrice;

/**
 * @author ovillamil
 *
 */
public class DroolsTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = ks.getKieClasspathContainer();
	    KieSession kSession = kContainer.newKieSession("ksession-rules");

	    ProductPrice p = new ProductPrice(10);
	    kSession.insert(p);
        kSession.fireAllRules();
	}

}
