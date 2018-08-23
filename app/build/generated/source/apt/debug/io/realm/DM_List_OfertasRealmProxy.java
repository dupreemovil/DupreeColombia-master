package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DM_List_OfertasRealmProxy extends com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas
    implements RealmObjectProxy, DM_List_OfertasRealmProxyInterface {

    static final class DM_List_OfertasColumnInfo extends ColumnInfo
        implements Cloneable {

        public long catalogoListIndex;
        public long typeIndex;

        DM_List_OfertasColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.catalogoListIndex = getValidColumnIndex(path, table, "DM_List_Ofertas", "catalogoList");
            indicesMap.put("catalogoList", this.catalogoListIndex);
            this.typeIndex = getValidColumnIndex(path, table, "DM_List_Ofertas", "type");
            indicesMap.put("type", this.typeIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final DM_List_OfertasColumnInfo otherInfo = (DM_List_OfertasColumnInfo) other;
            this.catalogoListIndex = otherInfo.catalogoListIndex;
            this.typeIndex = otherInfo.typeIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final DM_List_OfertasColumnInfo clone() {
            return (DM_List_OfertasColumnInfo) super.clone();
        }

    }
    private DM_List_OfertasColumnInfo columnInfo;
    private ProxyState proxyState;
    private RealmList<com.dupreinca.dupree.mh_response_api.Catalogo> catalogoListRealmList;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("catalogoList");
        fieldNames.add("type");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    DM_List_OfertasRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DM_List_OfertasColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    public RealmList<com.dupreinca.dupree.mh_response_api.Catalogo> realmGet$catalogoList() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        // use the cached value if available
        if (catalogoListRealmList != null) {
            return catalogoListRealmList;
        } else {
            LinkView linkView = proxyState.getRow$realm().getLinkList(columnInfo.catalogoListIndex);
            catalogoListRealmList = new RealmList<com.dupreinca.dupree.mh_response_api.Catalogo>(com.dupreinca.dupree.mh_response_api.Catalogo.class, linkView, proxyState.getRealm$realm());
            return catalogoListRealmList;
        }
    }

    public void realmSet$catalogoList(RealmList<com.dupreinca.dupree.mh_response_api.Catalogo> value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            if (proxyState.getExcludeFields$realm().contains("catalogoList")) {
                return;
            }
            if (value != null && !value.isManaged()) {
                final Realm realm = (Realm) proxyState.getRealm$realm();
                final RealmList<com.dupreinca.dupree.mh_response_api.Catalogo> original = value;
                value = new RealmList<com.dupreinca.dupree.mh_response_api.Catalogo>();
                for (com.dupreinca.dupree.mh_response_api.Catalogo item : original) {
                    if (item == null || RealmObject.isManaged(item)) {
                        value.add(item);
                    } else {
                        value.add(realm.copyToRealm(item));
                    }
                }
            }
        }

        proxyState.getRealm$realm().checkIfValid();
        LinkView links = proxyState.getRow$realm().getLinkList(columnInfo.catalogoListIndex);
        links.clear();
        if (value == null) {
            return;
        }
        for (RealmModel linkedObject : (RealmList<? extends RealmModel>) value) {
            if (!(RealmObject.isManaged(linkedObject) && RealmObject.isValid(linkedObject))) {
                throw new IllegalArgumentException("Each element of 'value' must be a valid managed object.");
            }
            if (((RealmObjectProxy)linkedObject).realmGet$proxyState().getRealm$realm() != proxyState.getRealm$realm()) {
                throw new IllegalArgumentException("Each element of 'value' must belong to the same Realm.");
            }
            links.add(((RealmObjectProxy)linkedObject).realmGet$proxyState().getRow$realm().getIndex());
        }
    }

    @SuppressWarnings("cast")
    public int realmGet$type() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.typeIndex);
    }

    public void realmSet$type(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.typeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.typeIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("DM_List_Ofertas")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("DM_List_Ofertas");
            if (!realmSchema.contains("Catalogo")) {
                CatalogoRealmProxy.createRealmObjectSchema(realmSchema);
            }
            realmObjectSchema.add(new Property("catalogoList", RealmFieldType.LIST, realmSchema.get("Catalogo")));
            realmObjectSchema.add(new Property("type", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("DM_List_Ofertas");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_DM_List_Ofertas")) {
            Table table = sharedRealm.getTable("class_DM_List_Ofertas");
            if (!sharedRealm.hasTable("class_Catalogo")) {
                CatalogoRealmProxy.initTable(sharedRealm);
            }
            table.addColumnLink(RealmFieldType.LIST, "catalogoList", sharedRealm.getTable("class_Catalogo"));
            table.addColumn(RealmFieldType.INTEGER, "type", Table.NOT_NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_DM_List_Ofertas");
    }

    public static DM_List_OfertasColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_DM_List_Ofertas")) {
            Table table = sharedRealm.getTable("class_DM_List_Ofertas");
            final long columnCount = table.getColumnCount();
            if (columnCount != 2) {
                if (columnCount < 2) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 2 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 2 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 2 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final DM_List_OfertasColumnInfo columnInfo = new DM_List_OfertasColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("catalogoList")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'catalogoList'");
            }
            if (columnTypes.get("catalogoList") != RealmFieldType.LIST) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'Catalogo' for field 'catalogoList'");
            }
            if (!sharedRealm.hasTable("class_Catalogo")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing class 'class_Catalogo' for field 'catalogoList'");
            }
            Table table_0 = sharedRealm.getTable("class_Catalogo");
            if (!table.getLinkTarget(columnInfo.catalogoListIndex).hasSameSchema(table_0)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid RealmList type for field 'catalogoList': '" + table.getLinkTarget(columnInfo.catalogoListIndex).getName() + "' expected - was '" + table_0.getName() + "'");
            }
            if (!columnTypes.containsKey("type")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'type' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("type") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'type' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.typeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'type' does support null values in the existing Realm file. Use corresponding boxed type for field 'type' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'DM_List_Ofertas' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_DM_List_Ofertas";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = new ArrayList<String>(1);
        if (json.has("catalogoList")) {
            excludeFields.add("catalogoList");
        }
        com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas obj = realm.createObjectInternal(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class, true, excludeFields);
        if (json.has("catalogoList")) {
            if (json.isNull("catalogoList")) {
                ((DM_List_OfertasRealmProxyInterface) obj).realmSet$catalogoList(null);
            } else {
                ((DM_List_OfertasRealmProxyInterface) obj).realmGet$catalogoList().clear();
                JSONArray array = json.getJSONArray("catalogoList");
                for (int i = 0; i < array.length(); i++) {
                    com.dupreinca.dupree.mh_response_api.Catalogo item = CatalogoRealmProxy.createOrUpdateUsingJsonObject(realm, array.getJSONObject(i), update);
                    ((DM_List_OfertasRealmProxyInterface) obj).realmGet$catalogoList().add(item);
                }
            }
        }
        if (json.has("type")) {
            if (json.isNull("type")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
            } else {
                ((DM_List_OfertasRealmProxyInterface) obj).realmSet$type((int) json.getInt("type"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas obj = new com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("catalogoList")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((DM_List_OfertasRealmProxyInterface) obj).realmSet$catalogoList(null);
                } else {
                    ((DM_List_OfertasRealmProxyInterface) obj).realmSet$catalogoList(new RealmList<com.dupreinca.dupree.mh_response_api.Catalogo>());
                    reader.beginArray();
                    while (reader.hasNext()) {
                        com.dupreinca.dupree.mh_response_api.Catalogo item = CatalogoRealmProxy.createUsingJsonStream(realm, reader);
                        ((DM_List_OfertasRealmProxyInterface) obj).realmGet$catalogoList().add(item);
                    }
                    reader.endArray();
                }
            } else if (name.equals("type")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'type' to null.");
                } else {
                    ((DM_List_OfertasRealmProxyInterface) obj).realmSet$type((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas copyOrUpdate(Realm realm, com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas copy(Realm realm, com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas realmObject = realm.createObjectInternal(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);

            RealmList<com.dupreinca.dupree.mh_response_api.Catalogo> catalogoListList = ((DM_List_OfertasRealmProxyInterface) newObject).realmGet$catalogoList();
            if (catalogoListList != null) {
                RealmList<com.dupreinca.dupree.mh_response_api.Catalogo> catalogoListRealmList = ((DM_List_OfertasRealmProxyInterface) realmObject).realmGet$catalogoList();
                for (int i = 0; i < catalogoListList.size(); i++) {
                    com.dupreinca.dupree.mh_response_api.Catalogo catalogoListItem = catalogoListList.get(i);
                    com.dupreinca.dupree.mh_response_api.Catalogo cachecatalogoList = (com.dupreinca.dupree.mh_response_api.Catalogo) cache.get(catalogoListItem);
                    if (cachecatalogoList != null) {
                        catalogoListRealmList.add(cachecatalogoList);
                    } else {
                        catalogoListRealmList.add(CatalogoRealmProxy.copyOrUpdate(realm, catalogoListList.get(i), update, cache));
                    }
                }
            }

            ((DM_List_OfertasRealmProxyInterface) realmObject).realmSet$type(((DM_List_OfertasRealmProxyInterface) newObject).realmGet$type());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class);
        long tableNativePtr = table.getNativeTablePointer();
        DM_List_OfertasColumnInfo columnInfo = (DM_List_OfertasColumnInfo) realm.schema.getColumnInfo(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);

        RealmList<com.dupreinca.dupree.mh_response_api.Catalogo> catalogoListList = ((DM_List_OfertasRealmProxyInterface) object).realmGet$catalogoList();
        if (catalogoListList != null) {
            long catalogoListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.catalogoListIndex, rowIndex);
            for (com.dupreinca.dupree.mh_response_api.Catalogo catalogoListItem : catalogoListList) {
                Long cacheItemIndexcatalogoList = cache.get(catalogoListItem);
                if (cacheItemIndexcatalogoList == null) {
                    cacheItemIndexcatalogoList = CatalogoRealmProxy.insert(realm, catalogoListItem, cache);
                }
                LinkView.nativeAdd(catalogoListNativeLinkViewPtr, cacheItemIndexcatalogoList);
            }
            LinkView.nativeClose(catalogoListNativeLinkViewPtr);
        }

        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((DM_List_OfertasRealmProxyInterface)object).realmGet$type(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class);
        long tableNativePtr = table.getNativeTablePointer();
        DM_List_OfertasColumnInfo columnInfo = (DM_List_OfertasColumnInfo) realm.schema.getColumnInfo(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class);
        com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas object = null;
        while (objects.hasNext()) {
            object = (com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);

                RealmList<com.dupreinca.dupree.mh_response_api.Catalogo> catalogoListList = ((DM_List_OfertasRealmProxyInterface) object).realmGet$catalogoList();
                if (catalogoListList != null) {
                    long catalogoListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.catalogoListIndex, rowIndex);
                    for (com.dupreinca.dupree.mh_response_api.Catalogo catalogoListItem : catalogoListList) {
                        Long cacheItemIndexcatalogoList = cache.get(catalogoListItem);
                        if (cacheItemIndexcatalogoList == null) {
                            cacheItemIndexcatalogoList = CatalogoRealmProxy.insert(realm, catalogoListItem, cache);
                        }
                        LinkView.nativeAdd(catalogoListNativeLinkViewPtr, cacheItemIndexcatalogoList);
                    }
                    LinkView.nativeClose(catalogoListNativeLinkViewPtr);
                }

                Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((DM_List_OfertasRealmProxyInterface)object).realmGet$type(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class);
        long tableNativePtr = table.getNativeTablePointer();
        DM_List_OfertasColumnInfo columnInfo = (DM_List_OfertasColumnInfo) realm.schema.getColumnInfo(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);

        long catalogoListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.catalogoListIndex, rowIndex);
        LinkView.nativeClear(catalogoListNativeLinkViewPtr);
        RealmList<com.dupreinca.dupree.mh_response_api.Catalogo> catalogoListList = ((DM_List_OfertasRealmProxyInterface) object).realmGet$catalogoList();
        if (catalogoListList != null) {
            for (com.dupreinca.dupree.mh_response_api.Catalogo catalogoListItem : catalogoListList) {
                Long cacheItemIndexcatalogoList = cache.get(catalogoListItem);
                if (cacheItemIndexcatalogoList == null) {
                    cacheItemIndexcatalogoList = CatalogoRealmProxy.insertOrUpdate(realm, catalogoListItem, cache);
                }
                LinkView.nativeAdd(catalogoListNativeLinkViewPtr, cacheItemIndexcatalogoList);
            }
        }
        LinkView.nativeClose(catalogoListNativeLinkViewPtr);

        Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((DM_List_OfertasRealmProxyInterface)object).realmGet$type(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class);
        long tableNativePtr = table.getNativeTablePointer();
        DM_List_OfertasColumnInfo columnInfo = (DM_List_OfertasColumnInfo) realm.schema.getColumnInfo(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class);
        com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas object = null;
        while (objects.hasNext()) {
            object = (com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);

                long catalogoListNativeLinkViewPtr = Table.nativeGetLinkView(tableNativePtr, columnInfo.catalogoListIndex, rowIndex);
                LinkView.nativeClear(catalogoListNativeLinkViewPtr);
                RealmList<com.dupreinca.dupree.mh_response_api.Catalogo> catalogoListList = ((DM_List_OfertasRealmProxyInterface) object).realmGet$catalogoList();
                if (catalogoListList != null) {
                    for (com.dupreinca.dupree.mh_response_api.Catalogo catalogoListItem : catalogoListList) {
                        Long cacheItemIndexcatalogoList = cache.get(catalogoListItem);
                        if (cacheItemIndexcatalogoList == null) {
                            cacheItemIndexcatalogoList = CatalogoRealmProxy.insertOrUpdate(realm, catalogoListItem, cache);
                        }
                        LinkView.nativeAdd(catalogoListNativeLinkViewPtr, cacheItemIndexcatalogoList);
                    }
                }
                LinkView.nativeClose(catalogoListNativeLinkViewPtr);

                Table.nativeSetLong(tableNativePtr, columnInfo.typeIndex, rowIndex, ((DM_List_OfertasRealmProxyInterface)object).realmGet$type(), false);
            }
        }
    }

    public static com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas createDetachedCopy(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas)cachedObject.object;
            } else {
                unmanagedObject = (com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }

        // Deep copy of catalogoList
        if (currentDepth == maxDepth) {
            ((DM_List_OfertasRealmProxyInterface) unmanagedObject).realmSet$catalogoList(null);
        } else {
            RealmList<com.dupreinca.dupree.mh_response_api.Catalogo> managedcatalogoListList = ((DM_List_OfertasRealmProxyInterface) realmObject).realmGet$catalogoList();
            RealmList<com.dupreinca.dupree.mh_response_api.Catalogo> unmanagedcatalogoListList = new RealmList<com.dupreinca.dupree.mh_response_api.Catalogo>();
            ((DM_List_OfertasRealmProxyInterface) unmanagedObject).realmSet$catalogoList(unmanagedcatalogoListList);
            int nextDepth = currentDepth + 1;
            int size = managedcatalogoListList.size();
            for (int i = 0; i < size; i++) {
                com.dupreinca.dupree.mh_response_api.Catalogo item = CatalogoRealmProxy.createDetachedCopy(managedcatalogoListList.get(i), nextDepth, maxDepth, cache);
                unmanagedcatalogoListList.add(item);
            }
        }
        ((DM_List_OfertasRealmProxyInterface) unmanagedObject).realmSet$type(((DM_List_OfertasRealmProxyInterface) realmObject).realmGet$type());
        return unmanagedObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("DM_List_Ofertas = [");
        stringBuilder.append("{catalogoList:");
        stringBuilder.append("RealmList<Catalogo>[").append(realmGet$catalogoList().size()).append("]");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{type:");
        stringBuilder.append(realmGet$type());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DM_List_OfertasRealmProxy aDM_List_Ofertas = (DM_List_OfertasRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDM_List_Ofertas.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDM_List_Ofertas.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDM_List_Ofertas.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
