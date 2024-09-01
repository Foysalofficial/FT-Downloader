package com.downloader;


import android.content.Context;
import com.downloader.core.Core;
import com.downloader.internal.ComponentHolder;
import com.downloader.internal.DownloadRequestQueue;
import com.downloader.request.DownloadRequestBuilder;
import com.downloader.utils.Utils;


public class PRDownloader {

    
    private PRDownloader() {
    }

    
    public static void initialize(Context context) {
        initialize(context, PRDownloaderConfig.newBuilder().build());
    }

    
    public static void initialize(Context context, PRDownloaderConfig config) {
        ComponentHolder.getInstance().init(context, config);
        DownloadRequestQueue.initialize();
    }

    
    public static DownloadRequestBuilder download(String url, String dirPath, String fileName) {
        return new DownloadRequestBuilder(url, dirPath, fileName);
    }

    
    public static void pause(int downloadId) {
        DownloadRequestQueue.getInstance().pause(downloadId);
    }

    
    public static void resume(int downloadId) {
        DownloadRequestQueue.getInstance().resume(downloadId);
    }

    
    public static void cancel(int downloadId) {
        DownloadRequestQueue.getInstance().cancel(downloadId);
    }

    
    public static void cancel(Object tag) {
        DownloadRequestQueue.getInstance().cancel(tag);
    }

    
    public static void cancelAll() {
        DownloadRequestQueue.getInstance().cancelAll();
    }

    
    public static Status getStatus(int downloadId) {
        return DownloadRequestQueue.getInstance().getStatus(downloadId);
    }

    
    public static void cleanUp(int days) {
        Utils.deleteUnwantedModelsAndTempFiles(days);
    }

    
    public static void shutDown() {
        Core.shutDown();
    }

}
