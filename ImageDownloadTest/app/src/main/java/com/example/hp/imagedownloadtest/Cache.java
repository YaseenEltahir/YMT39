package com.example.hp.imagedownloadtest;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
//import libcore.io.DiskLruCache;
//import com.android.okhttp.internal.DiskLruCache;

/**
 * Created by hp on 13/08/2017.
 */

public class Cache {
    private static Cache instance;
    private LruCache<String, Bitmap> lru;


    /*private DiskLruCache <String, Bitmap> mDiskLruCache;
    private final Object mDiskCacheLock = new Object();
    private boolean mDiskCacheStarting = true;
    private static final int DISK_CACHE_SIZE = 1024 * 1024 * 10; // 10MB
    private static final String DISK_CACHE_SUBDIR = "thumbnails";*/

    private Cache() {

        //lru = new LruCache<Object, Object>(1024);

        // Get max available VM memory, exceeding this amount will throw an
        // OutOfMemory exception. Stored in kilobytes as LruCache takes an
        // int in its constructor.
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        // Use 1/8th of the available memory for this memory cache.
        final int cacheSize = maxMemory / 8;

        lru = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                // The cache size will be measured in kilobytes rather than
                // number of items.
                return bitmap.getByteCount() / 1024;
            }
        };

    }

    public static Cache getInstance() {

        if (instance == null) {

            instance = new Cache();
        }

        return instance;

    }

    public LruCache<String, Bitmap> getLru() {
        return lru;
    }
}
