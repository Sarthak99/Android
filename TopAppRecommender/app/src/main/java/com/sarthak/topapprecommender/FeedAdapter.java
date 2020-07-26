package com.sarthak.topapprecommender;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FeedAdapter extends ArrayAdapter {
    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> applications;

    public FeedAdapter(@NonNull Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.applications = applications;
    }

    @Override
    public int getCount() {
        return applications.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        /*MMF-2
        View view = layoutInflater.inflate(layoutResource,parent, false);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvArtist = view.findViewById(R.id.tvArtist);
        TextView tvSummary = view.findViewById(R.id.tvSummary);*/
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(layoutResource, parent, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        /*TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvArtist = convertView.findViewById(R.id.tvArtist);
        TextView tvSummary = convertView.findViewById(R.id.tvSummary);*/

        FeedEntry currentRecord = applications.get(position);
        viewHolder.tvName.setText(currentRecord.getName());
        viewHolder.tvArtist.setText(currentRecord.getArtist());
        viewHolder.tvSummary.setText(currentRecord.getSummary());

        return convertView;
    }

    /**
     * The ViewHolder class is an android recommended way to search for the TextViews in a ListView.
     * As the TextViews in a ListView item remain the same, instead of finding them every time, initialize and reuse for every new view.
     * This helps in efficiency of the execution. Albeit recommended, it is not enforced by android for ListView widget.
     */
    private class ViewHolder {
        final TextView tvName;
        final TextView tvArtist;
        final TextView tvSummary;

        ViewHolder(View v) {
            this.tvName = v.findViewById(R.id.tvName);
            this.tvArtist = v.findViewById(R.id.tvArtist);
            this.tvSummary = v.findViewById(R.id.tvSummary);
        }
    }
}