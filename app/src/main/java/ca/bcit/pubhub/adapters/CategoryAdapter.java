package ca.bcit.pubhub.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.items.CategoryViewItem;

public class CategoryAdapter extends BaseAdapter {

    private ArrayList<CategoryViewItem> categoryItemList = new ArrayList<>();

    @Override
    public int getCount() {
        return categoryItemList.size();
    }

    @Override
    public Object getItem(int i) {
        return categoryItemList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        final Context context = parent.getContext();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.category_item_view, parent, false);
        }

        TextView category = (TextView) view.findViewById(R.id.categoryTextView);

        CategoryViewItem listViewItem = categoryItemList.get(i);

        category.setText(listViewItem.get_categoryName());
        return view;
    }

    public CategoryViewItem getCategoryViewItem(int index) {
        return categoryItemList.get(index);
    }

    public void addItem(String c) {
        CategoryViewItem item = new CategoryViewItem();

        item.set_categoryName(c);

        categoryItemList.add(item);
    }
}
