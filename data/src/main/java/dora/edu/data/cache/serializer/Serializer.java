package dora.edu.data.cache.serializer;

import com.google.gson.Gson;

/**
 * Created by Dora on 7/21/2017.
 */

/**
 * By creating this class because we want to separate external library from the client code.
 * @param <T>
 */
public class Serializer<T> {

    private Gson mGson;

    public Serializer() {
        mGson = new Gson();
    }

    public String serialize(T object, Class clazz) {
        return mGson.toJson(object, clazz).toString();
    }

    public T deserialize(String object, Class clazz) {
        return (T) mGson.fromJson(object, clazz);
    }

}
