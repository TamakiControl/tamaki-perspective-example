package com.tamakicontrol.model;

import com.inductiveautomation.ignition.common.sqltags.model.types.DataType;
import com.tamakicontrol.tags.PublishTag;

import java.time.Instant;

public class BookingType {

    @PublishTag(name="id", dataType = DataType.Int8)
    private Integer id;

    @PublishTag(name="notes", dataType = DataType.String)
    private String notes;

    private Integer lastModifiedByID;
    private Integer createdByID;
    private String description;

    @PublishTag(name="name", dataType = DataType.String)
    private String name;

    @PublishTag(name="percentBk", dataType = DataType.Float8)
    private Double percentBK;

    @PublishTag(name="type", dataType = DataType.Int4)
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getLastModifiedByID() {
        return lastModifiedByID;
    }

    public void setLastModifiedByID(Integer lastModifiedByID) {
        this.lastModifiedByID = lastModifiedByID;
    }

    public Integer getCreatedByID() {
        return createdByID;
    }

    public void setCreatedByID(Integer createdByID) {
        this.createdByID = createdByID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getPercentBK() {
        return percentBK;
    }

    public void setPercentBK(Double percentBK) {
        this.percentBK = percentBK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
