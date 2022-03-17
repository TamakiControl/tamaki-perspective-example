package com.tamakicontrol.tags;

import com.inductiveautomation.ignition.gateway.model.GatewayContext;
import com.inductiveautomation.ignition.gateway.tags.managed.ManagedTagProvider;
import com.inductiveautomation.ignition.gateway.tags.managed.ProviderConfiguration;

public class ExampleTagProvider {

    private final ManagedTagProvider managedTagProvider;
    private static ExampleTagProvider instance;

    private ExampleTagProvider(GatewayContext gatewayContext) {
        ProviderConfiguration providerConfiguration = new ProviderConfiguration("ChrisTags");
        this.managedTagProvider = gatewayContext.getTagManager().getOrCreateManagedProvider(providerConfiguration);
    }

    public static void initialize(GatewayContext gatewayContext) {
        instance = new ExampleTagProvider(gatewayContext);
    }

    public static ExampleTagProvider getInstance() {
        return instance;
    }

    public ManagedTagProvider get() {
        return managedTagProvider;
    }

}
