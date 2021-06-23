package org.smart.engine;

import org.junit.Test;

import com.project.smart.engine.flow.impl.SmartFlow;
import com.project.smart.engine.impl.SmartWorkFlowEngineImpl;
import com.project.smart.engine.work.SmartWork;
import com.project.smart.engine.work.impl.SampleWorkA;
import com.project.smart.engine.work.impl.SampleWorkB;
import com.project.smart.engine.work.impl.SampleWorkC;
import com.project.smart.engine.work.impl.SampleWorkJunction;

public class FlowTest {

	@Test
	public void testFlow1() {
		SmartFlow sf = new SmartFlow();

		SmartWork sa = new SampleWorkA();
		sf.setStartWorkId(sa.getWorkId());
		SmartWork sb = new SampleWorkB();
		SmartWork sc = new SampleWorkC();

		sf.putWork(sa);
		sf.putWork(sb);
		sf.putWork(sc);

		SampleWorkJunction swja = new SampleWorkJunction();
		swja.setNextWorkId(sb.getWorkId());
		sf.putWorkJunction(sa, swja);

		SampleWorkJunction swjb = new SampleWorkJunction();
		swjb.setNextWorkId(sc.getWorkId());
		sf.putWorkJunction(sb, swjb);

		SmartWorkFlowEngineImpl swfe = new SmartWorkFlowEngineImpl();
		swfe.start(sf);

	}

}
