package com.gravity.nobroker.custom;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.flexbox.FlexboxLayout;
import com.gravity.nobroker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Akash Verma on 25/07/18.
 */

public class FilterButton extends LinearLayout {

    private Context context;

    LayoutInflater inflater;
    private FlexboxLayout filterButtonContainer;
    private View rootView;
    private List<FilterObject> selectedFilterList = new ArrayList<>();

    public FilterButton(Context context) {
        super(context);
        init(context);
    }

    public FilterButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FilterButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public FilterButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        FilterButton view = (FilterButton) inflater.inflate(R.layout.custom_filter_button, this);
        filterButtonContainer = view.findViewById(R.id.filter_button_container);
    }

    public void setFilterList(final List<FilterObject> filterList) {
        filterButtonContainer.removeAllViews();

        selectedFilterList.clear();
        selectedFilterList = filterList;

        for (int i = 0; i < filterList.size(); i++) {
            rootView = inflater.inflate(R.layout.filter_component, filterButtonContainer, false);
            final TextView filterText = rootView.findViewById(R.id.filter_text);
            filterText.setText(filterList.get(i).getFilterString());
            filterButtonContainer.addView(rootView);

            if (filterList.get(i).isSelected()) {
                filterText.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                filterText.setBackgroundResource(R.drawable.filter_border_selected_background);
                selectedFilterList.get(i).setSelected(true);
            } else {
                filterText.setTextColor(context.getResources().getColor(android.R.color.darker_gray));
                filterText.setBackgroundResource(R.drawable.filter_border_background);
                selectedFilterList.get(i).setSelected(false);
            }

            final int finalI = i;
            rootView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (filterList.get(finalI).isSelected()) {
                        filterList.get(finalI).setSelected(false);
                        filterText.setTextColor(context.getResources().getColor(android.R.color.darker_gray));
                        filterText.setBackgroundResource(R.drawable.filter_border_background);
                        selectedFilterList.get(finalI).setSelected(false);
                    } else {
                        filterList.get(finalI).setSelected(true);
                        filterText.setTextColor(context.getResources().getColor(R.color.colorPrimary));
                        filterText.setBackgroundResource(R.drawable.filter_border_selected_background);
                        selectedFilterList.get(finalI).setSelected(true);
                    }
                }
            });
        }
    }

    public List<FilterObject> getSelectedFilterList() {
        return selectedFilterList;
    }
}
