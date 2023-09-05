package org.geotools.tutorial.model;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.postgis.PostgisNGDataStoreFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/5/11 16:54
 */
public class PostgisDataStore {
    private static DataStore postgisDataStore = null;
    private static String dbtype = "postgis";
    private static String host = "192.168.74.133";
    private static String port = "56432";
    private static String database = "openatc";
    private static String schema = "public";
    private static String username = "postgres";
    private static String password = "password";

    public PostgisDataStore() {
    }


    public static DataStore getInstance() {
        if (postgisDataStore == null) {
            Map<String, Object> params = new HashMap<>();
            params.put(PostgisNGDataStoreFactory.DBTYPE.key, dbtype);
            params.put(PostgisNGDataStoreFactory.HOST.key, host);
            params.put(PostgisNGDataStoreFactory.PORT.key, new Integer(port));
            params.put(PostgisNGDataStoreFactory.DATABASE.key, database);
            params.put(PostgisNGDataStoreFactory.SCHEMA.key, schema);
            params.put(PostgisNGDataStoreFactory.USER.key, username);
            params.put(PostgisNGDataStoreFactory.PASSWD.key, password);
            try {
                postgisDataStore = DataStoreFinder.getDataStore(params);
            } catch (IOException e) {
                System.out.printf("===================");
            }
        }

        return postgisDataStore;
    }

}
