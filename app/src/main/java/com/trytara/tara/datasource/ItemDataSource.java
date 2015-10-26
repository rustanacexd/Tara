package com.trytara.tara.datasource;

import android.util.Log;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.trytara.tara.models.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemDataSource {

    private static final String KEY_TITLE = "title";
    private static final String KEY_PRICE = "price";
    private static final String KEY_DESCRIPTION = "description";

    public static void getItems(String id, final ItemDataSourceCallbacks callback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Item");
        query.whereEqualTo("business", id);
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> list, ParseException e) {
                if (e == null) {
                    Log.d("DEBUG", "Item Lists: " + list);
                    List<Item> itemList = new ArrayList<>();

                    for (ParseObject object : list) {
                        itemList.add(parseObjectToItem(object));

                    }

                    if (callback != null) {
                        callback.onItemFetchList(itemList);
                    }

                } else {
                    Log.d("DEBUG", e.getLocalizedMessage());
                }
            }
        });

    }

    public interface ItemDataSourceCallbacks {
        public void onItemFetchList(List<Item> itemList);
    }

    private static Item parseObjectToItem(ParseObject object) {
        return new Item.ItemBuilder(
                object.getObjectId(),
                object.getString(KEY_TITLE),
                object.getDouble(KEY_PRICE))
                .description(object.getString(KEY_DESCRIPTION))
                .build();
    }
}
