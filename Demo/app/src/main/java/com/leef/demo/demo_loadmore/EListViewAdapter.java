package com.leef.demo.demo_loadmore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.leef.demo.R;

import java.util.ArrayList;

/**
 * 测试对象 Person 数组的数据适配器
 */
public class EListViewAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private LayoutInflater layoutInflater;
    private ArrayList<PersonBean> arrays = new ArrayList<>();

    public EListViewAdapter(Context context, ArrayList<PersonBean> arrays) {
        this.mContext = context;
        this.arrays = arrays;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public void onDataChanged(ArrayList<PersonBean> arrays) {
        this.arrays = arrays;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return arrays.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public PersonBean getGroup(int groupPosition) {
        return arrays.get(groupPosition);
    }

    @Override
    public PersonBean getChild(int groupPosition, int childPosition) {
        return arrays.get(groupPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.group_view, null);
            GroupViewHolder viewHolder = new GroupViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        }
        initGroupViews(getGroup(groupPosition), (GroupViewHolder) convertView.getTag());
        return convertView;
    }

    private void initGroupViews(PersonBean group, GroupViewHolder tag) {
        tag.name.setText(group.getName());
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.child_view, null);
            ChildViewHolder viewHolder = new ChildViewHolder();
            viewHolder.gender = (TextView) convertView.findViewById(R.id.gender);
            viewHolder.age = (TextView) convertView.findViewById(R.id.age);
            convertView.setTag(viewHolder);
        }
        initChildViews(getChild(groupPosition, childPosition), (ChildViewHolder) convertView.getTag());
        return convertView;
    }

    private void initChildViews(PersonBean child, ChildViewHolder tag) {
        tag.gender.setText("性别：" + child.getGender());
        tag.age.setText("年龄：" + child.getAge());
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    protected class GroupViewHolder {
        private TextView name;
    }

    protected class ChildViewHolder {
        private TextView gender;
        private TextView age;
    }
}
