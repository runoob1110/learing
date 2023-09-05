package org.geotools.tutorial.util;

import org.geotools.data.DataStore;
import org.geotools.data.FeatureSource;
import org.geotools.data.Query;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.factory.CommonFactoryFinder;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.swing.table.FeatureCollectionTableModel;
import org.geotools.tutorial.model.PostgisDataStore;
import org.opengis.feature.Feature;
import org.opengis.feature.GeometryAttribute;
import org.opengis.feature.Property;
import org.opengis.feature.type.FeatureType;
import org.opengis.filter.*;
import org.opengis.filter.expression.Expression;
import org.opengis.filter.identity.FeatureId;
import org.opengis.referencing.FactoryException;

import java.io.IOException;
import java.util.Collection;

/**
 * @author ：panleilei
 * @description
 * @modified By：
 * @version:
 * @date ：Created in 2023/5/12 9:44
 */
public abstract class GeoJsonUtils {
    public static String getFeatureCollection(String tablename) throws Exception {
        DataStore pgDatastore = PostgisDataStore.getInstance();
        FeatureSource featureSource = pgDatastore.getFeatureSource(tablename);
        FeatureCollection featureCollection = featureSource.getFeatures();

//        FeatureIterator features = featureCollection.features();
        FeatureJSON featureJSON = new FeatureJSON();


        String s = featureJSON.toString(featureCollection);
        return s;
    }



}
