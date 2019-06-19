package vn.magik.hometest.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import vn.magik.hometest.R;

public class KeyHotAdapter extends RecyclerView.Adapter<KeyHotAdapter.ViewHolder> {
    private List<String> keyHotList;
    private LayoutInflater mInflater;
    private List<Integer> listColors;

    public KeyHotAdapter(Context context, List<String> keyHotList) {
        this.keyHotList = keyHotList;
        this.mInflater = LayoutInflater.from(context);
        listColors = Arrays.asList(Color.LTGRAY, Color.BLUE, Color.MAGENTA, Color.DKGRAY, Color.GRAY, Color.GREEN, Color.RED);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mInflater.inflate(R.layout.item_key_hot, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(keyHotList.get(i));
        viewHolder.cardView.setCardBackgroundColor(randomColor(i));

        if (i==keyHotList.size()-1){
            viewHolder.viewLast.setVisibility(View.VISIBLE);
        } else {
            viewHolder.viewLast.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return keyHotList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        CardView cardView;
        View viewLast;
        ViewHolder(View view){
            super(view);
            name = view.findViewById(R.id.txt_key_word_hot);
            cardView = view.findViewById(R.id.card_view_key_hot);
            viewLast = view.findViewById(R.id.view_last);
        }
    }

    private int randomColor(int index){
        return listColors.get(index%listColors.size());
    }
}