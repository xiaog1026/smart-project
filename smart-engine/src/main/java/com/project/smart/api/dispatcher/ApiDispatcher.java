package com.project.smart.api.dispatcher;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.server.PathContainer;
import org.springframework.stereotype.Component;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPattern.PathMatchInfo;
import org.springframework.web.util.pattern.PathPatternParser;

import com.project.smart.api.ApiRequest;

@Component
public class ApiDispatcher {

	private Map<String, ApiDefine> apiDefineMap = new HashMap<>();

	public ApiDispatcher() {
		ApiDefine ad1 = new ApiDefine();
		ad1.setName("ad1");
		this.apiDefineMap.put("/abc/{var1}_{var2}", ad1);

		ApiDefine ad2 = new ApiDefine();
		ad2.setName("ad2");
		this.apiDefineMap.put("/hotels/new", ad2);

		ApiDefine ad3 = new ApiDefine();
		ad3.setName("ad3");
		this.apiDefineMap.put("/hotels/{hotel}", ad3);

		ApiDefine ad4 = new ApiDefine();
		ad4.setName("ad4");
		this.apiDefineMap.put("/group/{function}/{hotel}", ad4);
	}

	public ApiRequest getApiRequest(String requestURI) {
		ApiRequest ar = new ApiRequest();
		this.apiDefineMap.forEach((key, val) -> {
			PathMatchInfo result = matchAndExtract(key, requestURI);
			if (null != result) {
				ar.setPathMatchInfo(result);
				ar.setApiDefine(val);
			}
		});

		if (null != ar.getApiDefine()) {
			return ar;
		}
		return null;

	}

	private PathMatchInfo matchAndExtract(String pattern, String path) {
		return parse(pattern).matchAndExtract(toPathContainer(path));
	}

	private PathPattern parse(String path) {
		PathPatternParser pp = new PathPatternParser();
		pp.setMatchOptionalTrailingSeparator(true);
		return pp.parse(path);
	}

	public static PathContainer toPathContainer(String path) {
		if (path == null) {
			return null;
		}
		return PathContainer.parsePath(path);
	}
}
