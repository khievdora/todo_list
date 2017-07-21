package dora.edu.data.cache;

import android.content.Context;

import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;

import dora.edu.data.cache.serializer.Serializer;
import dora.edu.data.entity.EventEntity;
import dora.edu.domain.executor.ThreadExecutor;
import io.reactivex.Observable;

/**
 * Created by Dora on 7/21/2017.
 */
@Singleton
public class EventCacheImpl implements EventCache {

    private static final String FILE_NAME = "EVENT_CACHE";
    private static final String LAST_CACHE_UPDATE = "LAST_CACHE_UPADTE";

    private static final long EXPIRATION_TIME = 1000 * 60 * 10;

    private final Context mContext;
    private final File mCacheDir;
    private final Serializer mSerializer;
    private final FileManager mFileManager;
    private final ThreadExecutor mThreadExecutor;

    @Inject
    public EventCacheImpl(Context context, Serializer serializer, FileManager fileManager,
                          ThreadExecutor threadExecutor) throws IllegalArgumentException {
        if (context == null || serializer == null || fileManager == null) {
            throw new IllegalArgumentException("Invalid null parameter");
        }
        mContext = context;
        mCacheDir = mContext.getCacheDir();
        mSerializer = serializer;
        mFileManager = fileManager;
        mThreadExecutor = threadExecutor;
    }

    @Override
    public Observable<EventEntity> get(int eventId) {
        return null;
    }

    @Override
    public void put(EventEntity eventEntity) {

    }

    @Override
    public boolean isCache(int eventId) {
        return false;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}
