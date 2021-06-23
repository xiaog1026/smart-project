package jp.co.project.smart.enums;

import com.project.smart.engine.SmartWorkFlowEngine;
import com.project.smart.engine.flow.FlowDiagram;
import com.project.smart.engine.flow.impl.SmartFlow;
import com.project.smart.engine.impl.SmartWorkFlowEngineImpl;
import lombok.Getter;

public enum UrlComponent {
    USER("/user", new SmartWorkFlowEngineImpl(), new SmartFlow()),
    ORDER("/order", new SmartWorkFlowEngineImpl(), new SmartFlow());

    @Getter
    private String url;
    @Getter
    private SmartWorkFlowEngine engine;
    @Getter
    private FlowDiagram flow;


    UrlComponent(String url, SmartWorkFlowEngine engine, SmartFlow flow) {
        this.url = url;
        this.engine = engine;
        this.flow = flow;
    }

    public static UrlComponent parse(String url) {
        for (UrlComponent value : UrlComponent.values()) {
            if (value.url.equals(url)){
                return value;
            }
        }
        return null;
    }
}
