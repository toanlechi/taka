package vn.magik.hometest.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import vn.magik.hometest.R;
import vn.magik.hometest.models.Services;

/**
 * Adapter for recycle_view list services.
 */
public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {
    /**
     * List services.
     */
    private List<Services> servicesList;
    /**
     * LayoutInflater object.
     */
    private LayoutInflater mInflater;

    /**
     * Constructor.
     *
     * @param context      context
     * @param servicesList list services
     */
    public ServicesAdapter(Context context, List<Services> servicesList) {
        this.servicesList = servicesList;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_service, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Services services = servicesList.get(i);
        viewHolder.image.setBackgroundResource(services.getIcon());
        viewHolder.name.setText(services.getName());
    }

    @Override
    public int getItemCount() {
        return servicesList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;

        ViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.img_services_item);
            name = view.findViewById(R.id.txt_services_name);
        }

    }
}
