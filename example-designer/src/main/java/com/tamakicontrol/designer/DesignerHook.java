package com.tamakicontrol.designer;

import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.util.LoggerEx;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;
import com.inductiveautomation.perspective.designer.api.PerspectiveDesignerInterface;
import com.tamakicontrol.perspective.components.CounterComponent;

public class DesignerHook extends AbstractDesignerModuleHook {

    private final LoggerEx logger = LoggerEx.newBuilder().build(DesignerHook.class);

    private DesignerContext designerContext;

    @Override
    public void startup(DesignerContext context, LicenseState activationState) throws Exception {
        super.startup(context, activationState);
        this.designerContext = context;
        registerPerspectiveComponents();
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }

    private void registerPerspectiveComponents() {
        try {
            logger.info("Registering Perspective Components");
            var pdi = PerspectiveDesignerInterface.get(designerContext);
            var registry = pdi.getDesignerComponentRegistry();
            registry.registerComponent(CounterComponent.DESCRIPTOR);
            logger.info("Perspective Components Registered");
        } catch (Exception e) {
            logger.error("Error registering perspective components", e);
        }
    }


}
