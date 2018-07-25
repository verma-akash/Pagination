package com.gravity.nobroker.custom;

/**
 * Created by Akash Verma on 25/07/18.
 */

public class FilterObject {

    private String filterType;
    private String filterString;
    private boolean isSelected;

    public FilterObject(String filterType, String filterString, boolean isSelected) {
        this.filterType = filterType;
        this.filterString = filterString;
        this.isSelected = isSelected;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getFilterString() {
        return filterString;
    }

    public void setFilterString(String filterString) {
        this.filterString = filterString;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
