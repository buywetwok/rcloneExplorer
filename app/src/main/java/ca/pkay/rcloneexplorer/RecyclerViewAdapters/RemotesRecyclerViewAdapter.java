package ca.pkay.rcloneexplorer.RecyclerViewAdapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ca.pkay.rcloneexplorer.Fragments.RemotesFragment;
import ca.pkay.rcloneexplorer.R;

public class RemotesRecyclerViewAdapter extends RecyclerView.Adapter<RemotesRecyclerViewAdapter.ViewHolder>{

    private final List<String> remotes;
    private final RemotesFragment.OnRemoteClickListener clickListener;

    public RemotesRecyclerViewAdapter(List<String> remotes, RemotesFragment.OnRemoteClickListener clickListener) {
        this.remotes = remotes;
        this.clickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_remotes_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        String remoteName = remotes.get(position);
        holder.remoteName = remoteName;
        holder.tvName.setText(remoteName);
        // TODO set icon

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != clickListener) {
                    clickListener.onRemoteClick(holder.remoteName);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return remotes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View view;
        public final ImageView ivIcon;
        public final TextView tvName;
        public String remoteName;

        public ViewHolder(View itemView) {
            super(itemView);
            this.view = itemView;
            this.ivIcon = view.findViewById(R.id.remoteIcon);
            this.tvName = view.findViewById(R.id.remoteName);
        }
    }

}
