package com.example.myapplication.ui.videos;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ShowVideoActivity;
import com.example.myapplication.Video;
import com.example.myapplication.VideoListAdapter;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class VideosFragment extends Fragment {

    private VideosViewModel videosViewModel;
    String videoUrl = "link";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        videosViewModel = ViewModelProviders.of(this).get(VideosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_videos, container, false);
//        final TextView textView = root.findViewById(R.id.text_videos);
//        videosViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        final ListView videoListView = (ListView) root.findViewById(R.id.videosListView);
        ArrayList<Video> videosList = genVideos();
        VideoListAdapter adapter = new VideoListAdapter(this.getActivity(), R.layout.videos_view_layout, videosList);
        videoListView.setAdapter(adapter);
        videoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
        return root;
    }



    private ArrayList<Video> genVideos() {
        ArrayList<Video> videos = new ArrayList<Video>();
        Video v1 = new Video("link","ویدیو یک");
        videos.add(v1);
        Video v2 = new Video("link","ویدیو دو");
        videos.add(v2);
        Video v3 = new Video("link","ویدیو سه");
        videos.add(v3);
        Video v4 = new Video("link","ویدیو چهار");
        videos.add(v4);
        Video v5 = new Video("link","ویدیو پنج");
        videos.add(v5);
        return videos;
    }

    //Read files from Download folder in device and send files to the ShowVideoActivity class to show videos.
    public void readVideoFromFile(int position , String path) {
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File[] files = dir.listFiles();
        Intent intent = new Intent(getContext(), ShowVideoActivity.class);
        intent.putExtra("VideoPath",files[position].getAbsolutePath());
        startActivity(intent);
    }

    //Download video with URL and show this progress in the notification and after downloading , push videos into the Download folder in device.
    public void startDownloading(String url){
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Video");
        request.setDescription("Video Downloading!");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS , ""+System.currentTimeMillis());
        DownloadManager downloadManager = (DownloadManager) getActivity().getBaseContext().getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);
    }

}