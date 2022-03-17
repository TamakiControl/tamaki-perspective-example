package com.tamakicontrol;

import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.util.LoggerEx;
import com.inductiveautomation.ignition.gateway.model.AbstractGatewayModuleHook;
import com.inductiveautomation.ignition.gateway.model.GatewayContext;
import com.inductiveautomation.perspective.gateway.api.PerspectiveContext;
import com.tamakicontrol.perspective.components.CounterComponent;

import java.util.Objects;
import java.util.Optional;

public class GatewayHook extends AbstractGatewayModuleHook {

    private final LoggerEx logger = LoggerEx.newBuilder().build(GatewayHook.class);

    private GatewayContext gatewayContext;
    private PerspectiveContext perspectiveContext;

    @Override
    public void setup(GatewayContext gatewayContext) {
        this.gatewayContext = gatewayContext;
        initializePerspectiveContext();
        registerPerspectiveComponents();
    }

    @Override
    public void startup(LicenseState licenseState) {

    }

    @Override
    public void shutdown() {
        deregisterPerspectiveComponents();
    }

    @Override
    public Optional<String> getMountedResourceFolder() {
        return Optional.of("mounted");
    }

    @Override
    public Optional<String> getMountPathAlias() {
        return Optional.of(Module.URL_ALIAS);
    }

    private void initializePerspectiveContext() {
        try {
            this.perspectiveContext = PerspectiveContext.get(gatewayContext);
        } catch (Exception e) {
            logger.error("Error retreiving PerspectiveContext", e);
        }
    }

    private void registerPerspectiveComponents() {
        try {
            logger.info("Registering Perspective Components");
            var registry = perspectiveContext.getComponentRegistry();
            Objects.requireNonNull(registry, "ComponentRegistry is null");
            registry.registerComponent(CounterComponent.DESCRIPTOR);
            logger.info("Completed Registering Perspective Components");

        } catch (Exception e) {
            logger.error("Error registering PerspectiveComponent", e);
        }
    }

    private void deregisterPerspectiveComponents() {
        try {
            logger.info("Deregistering Perspective Components");
            var registry = perspectiveContext.getComponentRegistry();
            Objects.requireNonNull(registry, "ComponentRegistry is null");
            registry.removeComponent(CounterComponent.COMPONENT_ID);
            logger.info("Completed Deregistering Perspective Components");
        } catch (Exception e) {
            logger.error("Error deregistering PerspectiveComponent", e);
        }
    }


}
