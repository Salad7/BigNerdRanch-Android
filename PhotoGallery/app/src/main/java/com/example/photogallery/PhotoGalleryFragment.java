package com.example.photogallery;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class PhotoGalleryFragment extends Fragment {
    private RecyclerView mPhotoRecyclerView;
    private ArrayList<GalleryItem> mItems = new ArrayList<>();

    public static PhotoGalleryFragment newInstance(){
        return new PhotoGalleryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchItemsTask().execute();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_photo_gallery, container, false);
        mPhotoRecyclerView = (RecyclerView) v.findViewById(R.id.fragment_photo_gallery_recycler_view);
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mItems = new ArrayList<>();
        setupAdapter();
        return v;
    }

    private class PhotoHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;
        public PhotoHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView;
        }
        public void bindGalleryItem(GalleryItem item) {
            mTitleTextView.setText(item.toString());
        }
    }

    private void setupAdapter(){
        if(isAdded()){
            mPhotoRecyclerView.setAdapter(new PhotoAdapter(mItems));
        }
    }

    private class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {
        private ArrayList<GalleryItem> mGalleryItems = new ArrayList();

        public PhotoAdapter(ArrayList<GalleryItem> galItems){
            mGalleryItems = galItems;
            Log.d("PhotoGalleryFragment","Size of gallery: "+this.mGalleryItems.size());
            Log.d("PhotoGalleryFragment","Size of galItems: "+galItems.size());

        }

        @NonNull
        @Override
        public PhotoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            TextView textView = new TextView(getActivity());
            return new PhotoHolder(textView);
        }

        @Override
        public void onBindViewHolder(@NonNull PhotoHolder holder, int position) {
            GalleryItem galleryItem = mGalleryItems.get(position);
            holder.bindGalleryItem(galleryItem);
        }

        @Override
        public int getItemCount() {
            return this.mGalleryItems.size();
        }
    }

    public class FetchItemsTask extends AsyncTask<Void,Void,ArrayList<GalleryItem>> {


        @Override
        protected ArrayList<GalleryItem> doInBackground(Void... voids) {
                return new FlickFetchr().fetchItems();

        }

        @Override
        protected void onPostExecute(ArrayList<GalleryItem> galleryItems) {
            super.onPostExecute(galleryItems);
            mItems = galleryItems;
            setupAdapter();

        }
    }
}
