package ca.bcit.pubhub.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import ca.bcit.pubhub.R;
import ca.bcit.pubhub.items.CategoryViewItem;

public class CategoryAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<CategoryViewItem> category_view_item_list;
    LayoutInflater layoutInflater;

    public CategoryAdapter(Context context, int layout, ArrayList<CategoryViewItem> category_view_item_list) {
        this.context = context;
        this.layout = layout;
        this.category_view_item_list = category_view_item_list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return category_view_item_list.size();
    }

    @Override
    public Object getItem(int position) {
        return category_view_item_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(layout, null);
        }
        TextView category_textview = (TextView) convertView.findViewById(R.id.category_textview);
        CategoryViewItem categoryViewItem = category_view_item_list.get(position);
        category_textview.setText(categoryViewItem.get_categoryName());

        return convertView;
    }
}
