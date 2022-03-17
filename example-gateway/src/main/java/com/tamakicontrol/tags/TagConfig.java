package com.tamakicontrol.tags;


import com.inductiveautomation.ignition.common.config.BasicBoundPropertySet;
import com.inductiveautomation.ignition.common.sqltags.model.types.DataType;
import com.inductiveautomation.ignition.common.tags.config.properties.WellKnownTagProps;

import java.util.Objects;

public class TagConfig extends BasicBoundPropertySet {

    private DataType dataType;
    private double euMin;
    private double euMax;
    private String engUnits;
    private String format;
    private String tooltip;
    private String documentation;
    private boolean historyEnabled;
    private String historyProvider;


    private TagConfig(){}

    public static TagConfig from(PublishTag tagConfig) {
        TagConfig config = new TagConfig();

        // tag configuration
        config.setDataType(tagConfig.dataType());
        config.setEuMin(tagConfig.euMin());
        config.setEuMax(tagConfig.euMax());
        config.setEngUnits(tagConfig.units());
        config.setFormat(tagConfig.format());
        config.setTooltip(tagConfig.tooltip());
        config.setDocumentation(tagConfig.documentation());

        // historical configuration
        config.setHistoryEnabled(tagConfig.historyEnabled());


        return config;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        set(WellKnownTagProps.DataType, dataType);
        this.dataType = dataType;
    }

    public double getEuMin() {
        return euMin;
    }

    public void setEuMin(double euMin) {
        set(WellKnownTagProps.EngLow, euMin);
        this.euMin = euMin;
    }

    public double getEuMax() {
        return euMax;
    }

    public void setEuMax(double euMax) {
        set(WellKnownTagProps.EngHigh, euMax);
        this.euMax = euMax;
    }

    public String getEngUnits() {
        return engUnits;
    }

    public void setEngUnits(String engUnits) {
        set(WellKnownTagProps.EngUnit, engUnits);
        this.engUnits = engUnits;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        set(WellKnownTagProps.FormatString, format);
        this.format = format;
    }

    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        set(WellKnownTagProps.Tooltip, tooltip);
        this.tooltip = tooltip;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        set(WellKnownTagProps.Documentation, documentation);
        this.documentation = documentation;
    }

    public boolean isHistoryEnabled() {
        return historyEnabled;
    }

    public void setHistoryEnabled(boolean historyEnabled) {
        set(WellKnownTagProps.HistoryEnabled, historyEnabled);
        this.historyEnabled = historyEnabled;
    }

    public String getHistoryProvider() {
        return historyProvider;
    }

    public void setHistoryProvider(String historyProvider) {
        set(WellKnownTagProps.HistoryProvider, historyProvider);
        this.historyProvider = historyProvider;
    }

}
