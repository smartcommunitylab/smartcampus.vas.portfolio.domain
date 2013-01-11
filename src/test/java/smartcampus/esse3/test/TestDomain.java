/*******************************************************************************
 * Copyright 2012-2013 Trento RISE
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/
package smartcampus.esse3.test;

import it.sayservice.platform.client.ServiceBusClient;
import it.sayservice.platform.client.jms.JMSServiceBusClient;
import it.sayservice.platform.core.common.util.ServiceUtil;
import it.sayservice.platform.core.domain.DomainObject;
import it.sayservice.platform.core.message.Core.DODataRequest;
import it.sayservice.platform.core.message.Core.DomainEvent;
import it.sayservice.platform.domain.test.DomainListener;
import it.sayservice.platform.domain.test.DomainTestHelper;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hornetq.api.core.TransportConfiguration;
import org.hornetq.jms.client.HornetQJMSConnectionFactory;

import smartcampus.services.esse3.PortfolioDOEngine;
import smartcampus.services.esse3.PortfolioFactoryDOEngine;
import smartcampus.services.esse3.StudentDataServiceDOEngine;
import smartcampus.services.esse3.StudentExamsDOEngine;
import smartcampus.services.esse3.StudentFactoryDOEngine;
import smartcampus.services.esse3.StudentInfoDOEngine;
import smartcampus.services.esse3.UserProducedDataDOEngine;
import eu.trentorise.smartcampus.domain.semantic.SemanticServiceDOEngine;

public class TestDomain {

	public static void main(String[] args) throws Exception {
		System.out.println("START");

		HornetQJMSConnectionFactory cf = new HornetQJMSConnectionFactory(false, new TransportConfiguration("org.hornetq.core.remoting.impl.netty.NettyConnectorFactory"));
		ServiceBusClient client = new JMSServiceBusClient(cf);

		DomainTestHelper helper = new DomainTestHelper(client, new DomainListener() {
			public void onDomainEvents(List<DomainEvent> events) {
				// DO someth...
			}

			public void onDataRequest(DODataRequest req) {
				// DO someth...
			}
		});

		// eventsCreation(cf, helper);
		// eventTagging(helper);
		// createPortfolio(helper);
		
		getData(helper);
		
		System.err.println("END");
		System.exit(0);

		// DomainObject obj = list.get(0);
		// Map<String,Object> params = new HashMap<String, Object>();
		// params.put("userId", "raman");
		// helper.invokeDOOperation(obj.getType(), obj.getId(), "personalize",
		// params);

		// System.err.println(helper.getDOByType("smartcampus.domain.seminars.PersonalSeminarObject"));
	}

	protected static void getData(DomainTestHelper helper) throws Exception {
//		helper.cleanDomainData();
		initDomain(helper);

		Map<String, Object> pars = new TreeMap<String, Object>();
		pars.put("newUserId", "20");
		pars.put("newIdAda", "PER0013782");
//		pars.put("newUserId", "200");
//		pars.put("newIdAda", "PER0000510");
		String result = (String) helper.invokeDOOperationSync("smartcampus.services.esse3.StudentFactory", "smartcampus.services.esse3.StudentFactory.0", "createStudent", pars);
		
		System.out.println(result);
	}

	protected static void createPortfolio(DomainTestHelper helper) throws Exception {
		helper.cleanDomainData();
		initDomain(helper);

		DomainObject userPOIFactory = helper.getDOById("smartcampus.services.esse3.PortfolioFactory", "smartcampus.services.esse3.PortfolioFactory.0");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("newUserId", "37");
		params.put("newUserSocialId", 396L);
		params.put("newName", "testname");
		helper.invokeDOOperation(userPOIFactory.getType(), userPOIFactory.getId(), "createPortfolio", params);

		List<DomainObject> objectList = helper.getDOByType("smartcampus.services.esse3.Portfolio");
		if (objectList != null) {
			for (DomainObject domainObject : objectList) {
				System.err.println("ID:" + domainObject.getId());
				params.clear();
				Map<String, Object> tag = new HashMap<String, Object>();
				tag.put("name", "testtag");
				params.put("newTags", Collections.singletonList(tag));

				helper.invokeDOOperation(domainObject.getType(), domainObject.getId(), "updatePortfolio", params);
			}

			objectList = helper.getDOByType("smartcampus.services.esse3.Portfolio");
			for (DomainObject domainObject : objectList) {
				System.err.println("ID:" + domainObject.getId());
				helper.invokeDOOperation(domainObject.getType(), domainObject.getId(), "deletePortfolio", Collections.<String, Object> emptyMap());
			}

		}
	}

	private static void initDomain(DomainTestHelper helper) {
		helper.start(new PortfolioDOEngine(), new PortfolioFactoryDOEngine(), new StudentDataServiceDOEngine(), new StudentExamsDOEngine(), new StudentInfoDOEngine(), new StudentFactoryDOEngine(),new UserProducedDataDOEngine(), new SemanticServiceDOEngine());
	}
}
