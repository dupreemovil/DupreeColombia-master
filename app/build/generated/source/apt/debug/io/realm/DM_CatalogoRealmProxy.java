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

public class DM_CatalogoRealmProxy extends com.dupreinca.dupree.mh_based_realm.DM_Catalogo
    implements RealmObjectProxy, DM_CatalogoRealmProxyInterface {

    static final class DM_CatalogoColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long nameIndex;
        public long valorIndex;
        public long url_imgIndex;
        public long pageIndex;

        DM_CatalogoColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(5);
            this.idIndex = getValidColumnIndex(path, table, "DM_Catalogo", "id");
            indicesMap.put("id", this.idIndex);
            this.nameIndex = getValidColumnIndex(path, table, "DM_Catalogo", "name");
            indicesMap.put("name", this.nameIndex);
            this.valorIndex = getValidColumnIndex(path, table, "DM_Catalogo", "valor");
            indicesMap.put("valor", this.valorIndex);
            this.url_imgIndex = getValidColumnIndex(path, table, "DM_Catalogo", "url_img");
            indicesMap.put("url_img", this.url_imgIndex);
            this.pageIndex = getValidColumnIndex(path, table, "DM_Catalogo", "page");
            indicesMap.put("page", this.pageIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final DM_CatalogoColumnInfo otherInfo = (DM_CatalogoColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.nameIndex = otherInfo.nameIndex;
            this.valorIndex = otherInfo.valorIndex;
            this.url_imgIndex = otherInfo.url_imgIndex;
            this.pageIndex = otherInfo.pageIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final DM_CatalogoColumnInfo clone() {
            return (DM_CatalogoColumnInfo) super.clone();
        }

    }
    private DM_CatalogoColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("valor");
        fieldNames.add("url_img");
        fieldNames.add("page");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    DM_CatalogoRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (DM_CatalogoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public String realmGet$id() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.idIndex);
    }

    public void realmSet$id(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.idIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.idIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.idIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$name() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nameIndex);
    }

    public void realmSet$name(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nameIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$valor() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.valorIndex);
    }

    public void realmSet$valor(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.valorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.valorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.valorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.valorIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$url_img() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.url_imgIndex);
    }

    public void realmSet$url_img(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.url_imgIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.url_imgIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.url_imgIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.url_imgIndex, value);
    }

    @SuppressWarnings("cast")
    public String realmGet$page() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.pageIndex);
    }

    public void realmSet$page(String value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.pageIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.pageIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.pageIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.pageIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("DM_Catalogo")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("DM_Catalogo");
            realmObjectSchema.add(new Property("id", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("valor", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("url_img", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("page", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("DM_Catalogo");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_DM_Catalogo")) {
            Table table = sharedRealm.getTable("class_DM_Catalogo");
            table.addColumn(RealmFieldType.STRING, "id", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "valor", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "url_img", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "page", Table.NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return sharedRealm.getTable("class_DM_Catalogo");
    }

    public static DM_CatalogoColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_DM_Catalogo")) {
            Table table = sharedRealm.getTable("class_DM_Catalogo");
            final long columnCount = table.getColumnCount();
            if (columnCount != 5) {
                if (columnCount < 5) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 5 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 5 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 5 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final DM_CatalogoColumnInfo columnInfo = new DM_CatalogoColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.idIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'id' is required. Either set @Required to field 'id' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("name")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'name' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("name") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'name' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.nameIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'name' is required. Either set @Required to field 'name' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("valor")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'valor' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("valor") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'valor' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.valorIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'valor' is required. Either set @Required to field 'valor' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("url_img")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'url_img' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("url_img") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'url_img' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.url_imgIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'url_img' is required. Either set @Required to field 'url_img' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("page")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'page' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("page") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'page' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.pageIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'page' is required. Either set @Required to field 'page' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'DM_Catalogo' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_DM_Catalogo";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.dupreinca.dupree.mh_based_realm.DM_Catalogo createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.dupreinca.dupree.mh_based_realm.DM_Catalogo obj = realm.createObjectInternal(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class, true, excludeFields);
        if (json.has("id")) {
            if (json.isNull("id")) {
                ((DM_CatalogoRealmProxyInterface) obj).realmSet$id(null);
            } else {
                ((DM_CatalogoRealmProxyInterface) obj).realmSet$id((String) json.getString("id"));
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((DM_CatalogoRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((DM_CatalogoRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("valor")) {
            if (json.isNull("valor")) {
                ((DM_CatalogoRealmProxyInterface) obj).realmSet$valor(null);
            } else {
                ((DM_CatalogoRealmProxyInterface) obj).realmSet$valor((String) json.getString("valor"));
            }
        }
        if (json.has("url_img")) {
            if (json.isNull("url_img")) {
                ((DM_CatalogoRealmProxyInterface) obj).realmSet$url_img(null);
            } else {
                ((DM_CatalogoRealmProxyInterface) obj).realmSet$url_img((String) json.getString("url_img"));
            }
        }
        if (json.has("page")) {
            if (json.isNull("page")) {
                ((DM_CatalogoRealmProxyInterface) obj).realmSet$page(null);
            } else {
                ((DM_CatalogoRealmProxyInterface) obj).realmSet$page((String) json.getString("page"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.dupreinca.dupree.mh_based_realm.DM_Catalogo createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        com.dupreinca.dupree.mh_based_realm.DM_Catalogo obj = new com.dupreinca.dupree.mh_based_realm.DM_Catalogo();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((DM_CatalogoRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((DM_CatalogoRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((DM_CatalogoRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((DM_CatalogoRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("valor")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((DM_CatalogoRealmProxyInterface) obj).realmSet$valor(null);
                } else {
                    ((DM_CatalogoRealmProxyInterface) obj).realmSet$valor((String) reader.nextString());
                }
            } else if (name.equals("url_img")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((DM_CatalogoRealmProxyInterface) obj).realmSet$url_img(null);
                } else {
                    ((DM_CatalogoRealmProxyInterface) obj).realmSet$url_img((String) reader.nextString());
                }
            } else if (name.equals("page")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((DM_CatalogoRealmProxyInterface) obj).realmSet$page(null);
                } else {
                    ((DM_CatalogoRealmProxyInterface) obj).realmSet$page((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.dupreinca.dupree.mh_based_realm.DM_Catalogo copyOrUpdate(Realm realm, com.dupreinca.dupree.mh_based_realm.DM_Catalogo object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.dupreinca.dupree.mh_based_realm.DM_Catalogo) cachedRealmObject;
        } else {
            return copy(realm, object, update, cache);
        }
    }

    public static com.dupreinca.dupree.mh_based_realm.DM_Catalogo copy(Realm realm, com.dupreinca.dupree.mh_based_realm.DM_Catalogo newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.dupreinca.dupree.mh_based_realm.DM_Catalogo) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.dupreinca.dupree.mh_based_realm.DM_Catalogo realmObject = realm.createObjectInternal(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class, false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((DM_CatalogoRealmProxyInterface) realmObject).realmSet$id(((DM_CatalogoRealmProxyInterface) newObject).realmGet$id());
            ((DM_CatalogoRealmProxyInterface) realmObject).realmSet$name(((DM_CatalogoRealmProxyInterface) newObject).realmGet$name());
            ((DM_CatalogoRealmProxyInterface) realmObject).realmSet$valor(((DM_CatalogoRealmProxyInterface) newObject).realmGet$valor());
            ((DM_CatalogoRealmProxyInterface) realmObject).realmSet$url_img(((DM_CatalogoRealmProxyInterface) newObject).realmGet$url_img());
            ((DM_CatalogoRealmProxyInterface) realmObject).realmSet$page(((DM_CatalogoRealmProxyInterface) newObject).realmGet$page());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.dupreinca.dupree.mh_based_realm.DM_Catalogo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class);
        long tableNativePtr = table.getNativeTablePointer();
        DM_CatalogoColumnInfo columnInfo = (DM_CatalogoColumnInfo) realm.schema.getColumnInfo(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$id = ((DM_CatalogoRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        }
        String realmGet$name = ((DM_CatalogoRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$valor = ((DM_CatalogoRealmProxyInterface)object).realmGet$valor();
        if (realmGet$valor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.valorIndex, rowIndex, realmGet$valor, false);
        }
        String realmGet$url_img = ((DM_CatalogoRealmProxyInterface)object).realmGet$url_img();
        if (realmGet$url_img != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.url_imgIndex, rowIndex, realmGet$url_img, false);
        }
        String realmGet$page = ((DM_CatalogoRealmProxyInterface)object).realmGet$page();
        if (realmGet$page != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class);
        long tableNativePtr = table.getNativeTablePointer();
        DM_CatalogoColumnInfo columnInfo = (DM_CatalogoColumnInfo) realm.schema.getColumnInfo(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class);
        com.dupreinca.dupree.mh_based_realm.DM_Catalogo object = null;
        while (objects.hasNext()) {
            object = (com.dupreinca.dupree.mh_based_realm.DM_Catalogo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$id = ((DM_CatalogoRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                }
                String realmGet$name = ((DM_CatalogoRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$valor = ((DM_CatalogoRealmProxyInterface)object).realmGet$valor();
                if (realmGet$valor != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.valorIndex, rowIndex, realmGet$valor, false);
                }
                String realmGet$url_img = ((DM_CatalogoRealmProxyInterface)object).realmGet$url_img();
                if (realmGet$url_img != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.url_imgIndex, rowIndex, realmGet$url_img, false);
                }
                String realmGet$page = ((DM_CatalogoRealmProxyInterface)object).realmGet$page();
                if (realmGet$page != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page, false);
                }
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.dupreinca.dupree.mh_based_realm.DM_Catalogo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class);
        long tableNativePtr = table.getNativeTablePointer();
        DM_CatalogoColumnInfo columnInfo = (DM_CatalogoColumnInfo) realm.schema.getColumnInfo(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class);
        long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
        cache.put(object, rowIndex);
        String realmGet$id = ((DM_CatalogoRealmProxyInterface)object).realmGet$id();
        if (realmGet$id != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
        }
        String realmGet$name = ((DM_CatalogoRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$valor = ((DM_CatalogoRealmProxyInterface)object).realmGet$valor();
        if (realmGet$valor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.valorIndex, rowIndex, realmGet$valor, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.valorIndex, rowIndex, false);
        }
        String realmGet$url_img = ((DM_CatalogoRealmProxyInterface)object).realmGet$url_img();
        if (realmGet$url_img != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.url_imgIndex, rowIndex, realmGet$url_img, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.url_imgIndex, rowIndex, false);
        }
        String realmGet$page = ((DM_CatalogoRealmProxyInterface)object).realmGet$page();
        if (realmGet$page != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pageIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class);
        long tableNativePtr = table.getNativeTablePointer();
        DM_CatalogoColumnInfo columnInfo = (DM_CatalogoColumnInfo) realm.schema.getColumnInfo(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class);
        com.dupreinca.dupree.mh_based_realm.DM_Catalogo object = null;
        while (objects.hasNext()) {
            object = (com.dupreinca.dupree.mh_based_realm.DM_Catalogo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = Table.nativeAddEmptyRow(tableNativePtr, 1);
                cache.put(object, rowIndex);
                String realmGet$id = ((DM_CatalogoRealmProxyInterface)object).realmGet$id();
                if (realmGet$id != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.idIndex, rowIndex, realmGet$id, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.idIndex, rowIndex, false);
                }
                String realmGet$name = ((DM_CatalogoRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$valor = ((DM_CatalogoRealmProxyInterface)object).realmGet$valor();
                if (realmGet$valor != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.valorIndex, rowIndex, realmGet$valor, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.valorIndex, rowIndex, false);
                }
                String realmGet$url_img = ((DM_CatalogoRealmProxyInterface)object).realmGet$url_img();
                if (realmGet$url_img != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.url_imgIndex, rowIndex, realmGet$url_img, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.url_imgIndex, rowIndex, false);
                }
                String realmGet$page = ((DM_CatalogoRealmProxyInterface)object).realmGet$page();
                if (realmGet$page != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.pageIndex, rowIndex, false);
                }
            }
        }
    }

    public static com.dupreinca.dupree.mh_based_realm.DM_Catalogo createDetachedCopy(com.dupreinca.dupree.mh_based_realm.DM_Catalogo realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.dupreinca.dupree.mh_based_realm.DM_Catalogo unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.dupreinca.dupree.mh_based_realm.DM_Catalogo)cachedObject.object;
            } else {
                unmanagedObject = (com.dupreinca.dupree.mh_based_realm.DM_Catalogo)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.dupreinca.dupree.mh_based_realm.DM_Catalogo();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((DM_CatalogoRealmProxyInterface) unmanagedObject).realmSet$id(((DM_CatalogoRealmProxyInterface) realmObject).realmGet$id());
        ((DM_CatalogoRealmProxyInterface) unmanagedObject).realmSet$name(((DM_CatalogoRealmProxyInterface) realmObject).realmGet$name());
        ((DM_CatalogoRealmProxyInterface) unmanagedObject).realmSet$valor(((DM_CatalogoRealmProxyInterface) realmObject).realmGet$valor());
        ((DM_CatalogoRealmProxyInterface) unmanagedObject).realmSet$url_img(((DM_CatalogoRealmProxyInterface) realmObject).realmGet$url_img());
        ((DM_CatalogoRealmProxyInterface) unmanagedObject).realmSet$page(((DM_CatalogoRealmProxyInterface) realmObject).realmGet$page());
        return unmanagedObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("DM_Catalogo = [");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id() != null ? realmGet$id() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{name:");
        stringBuilder.append(realmGet$name() != null ? realmGet$name() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{valor:");
        stringBuilder.append(realmGet$valor() != null ? realmGet$valor() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{url_img:");
        stringBuilder.append(realmGet$url_img() != null ? realmGet$url_img() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{page:");
        stringBuilder.append(realmGet$page() != null ? realmGet$page() : "null");
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
        DM_CatalogoRealmProxy aDM_Catalogo = (DM_CatalogoRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aDM_Catalogo.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aDM_Catalogo.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aDM_Catalogo.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
