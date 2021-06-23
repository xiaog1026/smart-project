package jp.co.project.smart.interceptor;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.PathContainer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPattern.PathMatchInfo;
import org.springframework.web.util.pattern.PathPatternParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.smart.api.ApiRequest;
import com.project.smart.api.dispatcher.ApiDispatcher;

import jp.co.project.smart.enums.UrlComponent;


@Component
public class ApiInterceptor implements HandlerInterceptor {

	@Autowired
	private ApiDispatcher apiDispatcher;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		ApiRequest ar = apiDispatcher.getApiRequest(request.getRequestURI());

		if (null != ar) {
			System.out.println(ar.getApiDefine().getName());
		} else {
			System.out.println("No Mapping");
		}

        PrintWriter writer = response.getWriter();
//
//        // 获得JSON
        BufferedReader reader = request.getReader();
        System.out.println(reader.lines());
//
//        // validation check
//         userSearch/4/userName/aaa
//         userSearch/{userId}/userName/{userName}
//        
        List<String> list = reader.lines().collect(Collectors.toList());
        for (String s : list) {
            System.out.println(s);
        }
//
//        // 解析URL
        String url = request.getRequestURI();
        System.out.println(url);
//
//        // 根据URL，获得engine,flow,bean类型
        UrlComponent component = UrlComponent.parse(url);
//        // 调用Engine，FLow
//        SmartEngine engine = component.getEngine();
//        SmartFlow flow = component.getFlow();
//        engine.execute(flow);
//
//        // 解析JSON用bean类型
//        Class clazz = component.getClazz();
//
//        // 转换JSON
//        ObjectMapper om = new ObjectMapper();
//        Object o = om.readValue(String.join("", list), clazz);
//        writer.print(o);

		return false;
	}

	private PathPattern parse(String path) {
		PathPatternParser pp = new PathPatternParser();
		pp.setMatchOptionalTrailingSeparator(true);
		return pp.parse(path);
	}

	private boolean checkMatches(String uriTemplate, String path) {
		PathPatternParser parser = new PathPatternParser();
		parser.setMatchOptionalTrailingSeparator(true);
		PathPattern p = parser.parse(uriTemplate);
		PathContainer pc = toPathContainer(path);
		return p.matches(pc);
	}

	public PathContainer toPathContainer(String path) {
		if (path == null) {
			return null;
		}
		return PathContainer.parsePath(path);
	}

	private PathMatchInfo matchAndExtract(String pattern, String path) {
		return parse(pattern).matchAndExtract(toPathContainer(path));
	}

}
