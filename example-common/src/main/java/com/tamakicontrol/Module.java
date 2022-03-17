package com.tamakicontrol;

import com.inductiveautomation.perspective.common.api.BrowserResource;

import java.util.Set;

public class Module {
    public static final String MODULE_ID = "com.tamakicontrol.example";
    public static final String URL_ALIAS = "example";
    public static final String COMPONENT_CATEGORY = "example";
    public static final Set<BrowserResource> BROWSER_RESOURCES =
            Set.of(
                    new BrowserResource(
                            "example-client-components-js",
                            String.format("/res/%s/example-client-components.js", URL_ALIAS),
                            BrowserResource.ResourceType.JS
                    ),
                    new BrowserResource("example-client-components-css",
                            String.format("/res/%s/example-client-components.css", URL_ALIAS),
                            BrowserResource.ResourceType.CSS
                    )
            );
}
