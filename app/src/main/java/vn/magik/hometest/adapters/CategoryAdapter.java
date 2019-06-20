package vn.magik.hometest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vn.magik.hometest.R;

/**
 * Adapter of recycle_view category.
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    /**
     * List category.
     */
    private List<String> categoryList;
    /**
     * LayoutInflater object.
     */
    private LayoutInflater mInflater;

    /**
     * Constructor.
     *
     * @param context      context
     * @param categoryList list category
     */
    public CategoryAdapter(Context context, List<String> categoryList) {
        this.categoryList = categoryList;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_category, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(categoryList.get(i));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.txt_title_category);

        }
    }
}