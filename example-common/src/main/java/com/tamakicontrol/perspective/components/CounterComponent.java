package com.tamakicontrol.perspective.components;

import com.inductiveautomation.ignition.common.jsonschema.JsonSchema;
import com.inductiveautomation.perspective.common.api.ComponentDescriptor;
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl;
import com.tamakicontrol.Module;

public class CounterComponent {

    public static String COMPONENT_ID = "counter";

    /**
     * The schema provided with the component descriptor. Use a schema instead of a plain JsonObject because it gives
     * us a little more type information, allowing the designer to highlight mismatches where it can detect them.
     */
    public static JsonSchema SCHEMA =
            JsonSchema.parse(Module.class.getResourceAsStream("/counter.props.json"));

    /**
     * Components register with the Java side ComponentRegistry but providing a ComponentDescriptor.  Here we
     * build the descriptor for this one component. Icons on the component palette are optional.
     */
    public static ComponentDescriptor DESCRIPTOR = ComponentDescriptorImpl.ComponentBuilder.newBuilder()
            .setPaletteCategory(Module.COMPONENT_CATEGORY)
            .setId(COMPONENT_ID)
            .setModuleId(Module.MODULE_ID)
            .setSchema(SCHEMA) //  this could alternatively be created purely in Java if desired
            .setName("Counter")
            .addPaletteEntry("", "Counter", "Counter Component", null, null)
            .setDefaultMetaName("counter")
            .setResources(Module.BROWSER_RESOURCES)
            .build();

}
