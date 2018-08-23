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

public class CatalogoRealmProxy extends com.dupreinca.dupree.mh_response_api.Catalogo
    implements RealmObjectProxy, CatalogoRealmProxyInterface {

    static final class CatalogoColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idIndex;
        public long nameIndex;
        public long valorIndex;
        public long url_imgIndex;
        public long pageIndex;
        public long cantidadIndex;
        public long cantidadServerIndex;
        public long timeIndex;

        CatalogoColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(8);
            this.idIndex = getValidColumnIndex(path, table, "Catalogo", "id");
            indicesMap.put("id", this.idIndex);
            this.nameIndex = getValidColumnIndex(path, table, "Catalogo", "name");
            indicesMap.put("name", this.nameIndex);
            this.valorIndex = getValidColumnIndex(path, table, "Catalogo", "valor");
            indicesMap.put("valor", this.valorIndex);
            this.url_imgIndex = getValidColumnIndex(path, table, "Catalogo", "url_img");
            indicesMap.put("url_img", this.url_imgIndex);
            this.pageIndex = getValidColumnIndex(path, table, "Catalogo", "page");
            indicesMap.put("page", this.pageIndex);
            this.cantidadIndex = getValidColumnIndex(path, table, "Catalogo", "cantidad");
            indicesMap.put("cantidad", this.cantidadIndex);
            this.cantidadServerIndex = getValidColumnIndex(path, table, "Catalogo", "cantidadServer");
            indicesMap.put("cantidadServer", this.cantidadServerIndex);
            this.timeIndex = getValidColumnIndex(path, table, "Catalogo", "time");
            indicesMap.put("time", this.timeIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final CatalogoColumnInfo otherInfo = (CatalogoColumnInfo) other;
            this.idIndex = otherInfo.idIndex;
            this.nameIndex = otherInfo.nameIndex;
            this.valorIndex = otherInfo.valorIndex;
            this.url_imgIndex = otherInfo.url_imgIndex;
            this.pageIndex = otherInfo.pageIndex;
            this.cantidadIndex = otherInfo.cantidadIndex;
            this.cantidadServerIndex = otherInfo.cantidadServerIndex;
            this.timeIndex = otherInfo.timeIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final CatalogoColumnInfo clone() {
            return (CatalogoColumnInfo) super.clone();
        }

    }
    private CatalogoColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("id");
        fieldNames.add("name");
        fieldNames.add("valor");
        fieldNames.add("url_img");
        fieldNames.add("page");
        fieldNames.add("cantidad");
        fieldNames.add("cantidadServer");
        fieldNames.add("time");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CatalogoRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (CatalogoColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.dupreinca.dupree.mh_response_api.Catalogo.class, this);
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
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
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

    @SuppressWarnings("cast")
    public int realmGet$cantidad() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.cantidadIndex);
    }

    public void realmSet$cantidad(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.cantidadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.cantidadIndex, value);
    }

    @SuppressWarnings("cast")
    public int realmGet$cantidadServer() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.cantidadServerIndex);
    }

    public void realmSet$cantidadServer(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.cantidadServerIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.cantidadServerIndex, value);
    }

    @SuppressWarnings("cast")
    public long realmGet$time() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (long) proxyState.getRow$realm().getLong(columnInfo.timeIndex);
    }

    public void realmSet$time(long value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.timeIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.timeIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Catalogo")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Catalogo");
            realmObjectSchema.add(new Property("id", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("name", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("valor", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("url_img", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("page", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED));
            realmObjectSchema.add(new Property("cantidad", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("cantidadServer", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("time", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("Catalogo");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Catalogo")) {
            Table table = sharedRealm.getTable("class_Catalogo");
            table.addColumn(RealmFieldType.STRING, "id", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "name", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "valor", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "url_img", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "page", Table.NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cantidad", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "cantidadServer", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "time", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("id"));
            table.setPrimaryKey("id");
            return table;
        }
        return sharedRealm.getTable("class_Catalogo");
    }

    public static CatalogoColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Catalogo")) {
            Table table = sharedRealm.getTable("class_Catalogo");
            final long columnCount = table.getColumnCount();
            if (columnCount != 8) {
                if (columnCount < 8) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 8 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 8 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 8 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final CatalogoColumnInfo columnInfo = new CatalogoColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'id' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("id") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'String' for field 'id' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.idIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(),"@PrimaryKey field 'id' does not support null values in the existing Realm file. Migrate using RealmObjectSchema.setNullable(), or mark the field as @Required.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("id")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'id' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("id"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'id' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
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
            if (!columnTypes.containsKey("cantidad")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cantidad' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cantidad") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'cantidad' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.cantidadIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cantidad' does support null values in the existing Realm file. Use corresponding boxed type for field 'cantidad' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("cantidadServer")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'cantidadServer' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cantidadServer") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'cantidadServer' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.cantidadServerIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'cantidadServer' does support null values in the existing Realm file. Use corresponding boxed type for field 'cantidadServer' or migrate using RealmObjectSchema.setNullable().");
            }
            if (!columnTypes.containsKey("time")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'time' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("time") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'long' for field 'time' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.timeIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'time' does support null values in the existing Realm file. Use corresponding boxed type for field 'time' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Catalogo' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Catalogo";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.dupreinca.dupree.mh_response_api.Catalogo createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.dupreinca.dupree.mh_response_api.Catalogo obj = null;
        if (update) {
            Table table = realm.getTable(com.dupreinca.dupree.mh_response_api.Catalogo.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (json.isNull("id")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("id"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.dupreinca.dupree.mh_response_api.Catalogo.class), false, Collections.<String> emptyList());
                    obj = new io.realm.CatalogoRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.CatalogoRealmProxy) realm.createObjectInternal(com.dupreinca.dupree.mh_response_api.Catalogo.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.CatalogoRealmProxy) realm.createObjectInternal(com.dupreinca.dupree.mh_response_api.Catalogo.class, json.getString("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }
        if (json.has("name")) {
            if (json.isNull("name")) {
                ((CatalogoRealmProxyInterface) obj).realmSet$name(null);
            } else {
                ((CatalogoRealmProxyInterface) obj).realmSet$name((String) json.getString("name"));
            }
        }
        if (json.has("valor")) {
            if (json.isNull("valor")) {
                ((CatalogoRealmProxyInterface) obj).realmSet$valor(null);
            } else {
                ((CatalogoRealmProxyInterface) obj).realmSet$valor((String) json.getString("valor"));
            }
        }
        if (json.has("url_img")) {
            if (json.isNull("url_img")) {
                ((CatalogoRealmProxyInterface) obj).realmSet$url_img(null);
            } else {
                ((CatalogoRealmProxyInterface) obj).realmSet$url_img((String) json.getString("url_img"));
            }
        }
        if (json.has("page")) {
            if (json.isNull("page")) {
                ((CatalogoRealmProxyInterface) obj).realmSet$page(null);
            } else {
                ((CatalogoRealmProxyInterface) obj).realmSet$page((String) json.getString("page"));
            }
        }
        if (json.has("cantidad")) {
            if (json.isNull("cantidad")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad' to null.");
            } else {
                ((CatalogoRealmProxyInterface) obj).realmSet$cantidad((int) json.getInt("cantidad"));
            }
        }
        if (json.has("cantidadServer")) {
            if (json.isNull("cantidadServer")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cantidadServer' to null.");
            } else {
                ((CatalogoRealmProxyInterface) obj).realmSet$cantidadServer((int) json.getInt("cantidadServer"));
            }
        }
        if (json.has("time")) {
            if (json.isNull("time")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'time' to null.");
            } else {
                ((CatalogoRealmProxyInterface) obj).realmSet$time((long) json.getLong("time"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.dupreinca.dupree.mh_response_api.Catalogo createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.dupreinca.dupree.mh_response_api.Catalogo obj = new com.dupreinca.dupree.mh_response_api.Catalogo();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CatalogoRealmProxyInterface) obj).realmSet$id(null);
                } else {
                    ((CatalogoRealmProxyInterface) obj).realmSet$id((String) reader.nextString());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("name")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CatalogoRealmProxyInterface) obj).realmSet$name(null);
                } else {
                    ((CatalogoRealmProxyInterface) obj).realmSet$name((String) reader.nextString());
                }
            } else if (name.equals("valor")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CatalogoRealmProxyInterface) obj).realmSet$valor(null);
                } else {
                    ((CatalogoRealmProxyInterface) obj).realmSet$valor((String) reader.nextString());
                }
            } else if (name.equals("url_img")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CatalogoRealmProxyInterface) obj).realmSet$url_img(null);
                } else {
                    ((CatalogoRealmProxyInterface) obj).realmSet$url_img((String) reader.nextString());
                }
            } else if (name.equals("page")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    ((CatalogoRealmProxyInterface) obj).realmSet$page(null);
                } else {
                    ((CatalogoRealmProxyInterface) obj).realmSet$page((String) reader.nextString());
                }
            } else if (name.equals("cantidad")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cantidad' to null.");
                } else {
                    ((CatalogoRealmProxyInterface) obj).realmSet$cantidad((int) reader.nextInt());
                }
            } else if (name.equals("cantidadServer")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cantidadServer' to null.");
                } else {
                    ((CatalogoRealmProxyInterface) obj).realmSet$cantidadServer((int) reader.nextInt());
                }
            } else if (name.equals("time")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'time' to null.");
                } else {
                    ((CatalogoRealmProxyInterface) obj).realmSet$time((long) reader.nextLong());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.dupreinca.dupree.mh_response_api.Catalogo copyOrUpdate(Realm realm, com.dupreinca.dupree.mh_response_api.Catalogo object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.dupreinca.dupree.mh_response_api.Catalogo) cachedRealmObject;
        } else {
            com.dupreinca.dupree.mh_response_api.Catalogo realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.dupreinca.dupree.mh_response_api.Catalogo.class);
                long pkColumnIndex = table.getPrimaryKey();
                String value = ((CatalogoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (value == null) {
                    rowIndex = table.findFirstNull(pkColumnIndex);
                } else {
                    rowIndex = table.findFirstString(pkColumnIndex, value);
                }
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.dupreinca.dupree.mh_response_api.Catalogo.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.CatalogoRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.dupreinca.dupree.mh_response_api.Catalogo copy(Realm realm, com.dupreinca.dupree.mh_response_api.Catalogo newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.dupreinca.dupree.mh_response_api.Catalogo) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.dupreinca.dupree.mh_response_api.Catalogo realmObject = realm.createObjectInternal(com.dupreinca.dupree.mh_response_api.Catalogo.class, ((CatalogoRealmProxyInterface) newObject).realmGet$id(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((CatalogoRealmProxyInterface) realmObject).realmSet$name(((CatalogoRealmProxyInterface) newObject).realmGet$name());
            ((CatalogoRealmProxyInterface) realmObject).realmSet$valor(((CatalogoRealmProxyInterface) newObject).realmGet$valor());
            ((CatalogoRealmProxyInterface) realmObject).realmSet$url_img(((CatalogoRealmProxyInterface) newObject).realmGet$url_img());
            ((CatalogoRealmProxyInterface) realmObject).realmSet$page(((CatalogoRealmProxyInterface) newObject).realmGet$page());
            ((CatalogoRealmProxyInterface) realmObject).realmSet$cantidad(((CatalogoRealmProxyInterface) newObject).realmGet$cantidad());
            ((CatalogoRealmProxyInterface) realmObject).realmSet$cantidadServer(((CatalogoRealmProxyInterface) newObject).realmGet$cantidadServer());
            ((CatalogoRealmProxyInterface) realmObject).realmSet$time(((CatalogoRealmProxyInterface) newObject).realmGet$time());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.dupreinca.dupree.mh_response_api.Catalogo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.dupreinca.dupree.mh_response_api.Catalogo.class);
        long tableNativePtr = table.getNativeTablePointer();
        CatalogoColumnInfo columnInfo = (CatalogoColumnInfo) realm.schema.getColumnInfo(com.dupreinca.dupree.mh_response_api.Catalogo.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((CatalogoRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((CatalogoRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        }
        String realmGet$valor = ((CatalogoRealmProxyInterface)object).realmGet$valor();
        if (realmGet$valor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.valorIndex, rowIndex, realmGet$valor, false);
        }
        String realmGet$url_img = ((CatalogoRealmProxyInterface)object).realmGet$url_img();
        if (realmGet$url_img != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.url_imgIndex, rowIndex, realmGet$url_img, false);
        }
        String realmGet$page = ((CatalogoRealmProxyInterface)object).realmGet$page();
        if (realmGet$page != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((CatalogoRealmProxyInterface)object).realmGet$cantidad(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.cantidadServerIndex, rowIndex, ((CatalogoRealmProxyInterface)object).realmGet$cantidadServer(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.timeIndex, rowIndex, ((CatalogoRealmProxyInterface)object).realmGet$time(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.dupreinca.dupree.mh_response_api.Catalogo.class);
        long tableNativePtr = table.getNativeTablePointer();
        CatalogoColumnInfo columnInfo = (CatalogoColumnInfo) realm.schema.getColumnInfo(com.dupreinca.dupree.mh_response_api.Catalogo.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.dupreinca.dupree.mh_response_api.Catalogo object = null;
        while (objects.hasNext()) {
            object = (com.dupreinca.dupree.mh_response_api.Catalogo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((CatalogoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((CatalogoRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                }
                String realmGet$valor = ((CatalogoRealmProxyInterface)object).realmGet$valor();
                if (realmGet$valor != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.valorIndex, rowIndex, realmGet$valor, false);
                }
                String realmGet$url_img = ((CatalogoRealmProxyInterface)object).realmGet$url_img();
                if (realmGet$url_img != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.url_imgIndex, rowIndex, realmGet$url_img, false);
                }
                String realmGet$page = ((CatalogoRealmProxyInterface)object).realmGet$page();
                if (realmGet$page != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((CatalogoRealmProxyInterface)object).realmGet$cantidad(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.cantidadServerIndex, rowIndex, ((CatalogoRealmProxyInterface)object).realmGet$cantidadServer(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.timeIndex, rowIndex, ((CatalogoRealmProxyInterface)object).realmGet$time(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.dupreinca.dupree.mh_response_api.Catalogo object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.dupreinca.dupree.mh_response_api.Catalogo.class);
        long tableNativePtr = table.getNativeTablePointer();
        CatalogoColumnInfo columnInfo = (CatalogoColumnInfo) realm.schema.getColumnInfo(com.dupreinca.dupree.mh_response_api.Catalogo.class);
        long pkColumnIndex = table.getPrimaryKey();
        String primaryKeyValue = ((CatalogoRealmProxyInterface) object).realmGet$id();
        long rowIndex = TableOrView.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
        }
        cache.put(object, rowIndex);
        String realmGet$name = ((CatalogoRealmProxyInterface)object).realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
        }
        String realmGet$valor = ((CatalogoRealmProxyInterface)object).realmGet$valor();
        if (realmGet$valor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.valorIndex, rowIndex, realmGet$valor, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.valorIndex, rowIndex, false);
        }
        String realmGet$url_img = ((CatalogoRealmProxyInterface)object).realmGet$url_img();
        if (realmGet$url_img != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.url_imgIndex, rowIndex, realmGet$url_img, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.url_imgIndex, rowIndex, false);
        }
        String realmGet$page = ((CatalogoRealmProxyInterface)object).realmGet$page();
        if (realmGet$page != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.pageIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((CatalogoRealmProxyInterface)object).realmGet$cantidad(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.cantidadServerIndex, rowIndex, ((CatalogoRealmProxyInterface)object).realmGet$cantidadServer(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.timeIndex, rowIndex, ((CatalogoRealmProxyInterface)object).realmGet$time(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.dupreinca.dupree.mh_response_api.Catalogo.class);
        long tableNativePtr = table.getNativeTablePointer();
        CatalogoColumnInfo columnInfo = (CatalogoColumnInfo) realm.schema.getColumnInfo(com.dupreinca.dupree.mh_response_api.Catalogo.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.dupreinca.dupree.mh_response_api.Catalogo object = null;
        while (objects.hasNext()) {
            object = (com.dupreinca.dupree.mh_response_api.Catalogo) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                String primaryKeyValue = ((CatalogoRealmProxyInterface) object).realmGet$id();
                long rowIndex = TableOrView.NO_MATCH;
                if (primaryKeyValue == null) {
                    rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
                } else {
                    rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(primaryKeyValue, false);
                }
                cache.put(object, rowIndex);
                String realmGet$name = ((CatalogoRealmProxyInterface)object).realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.nameIndex, rowIndex, realmGet$name, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.nameIndex, rowIndex, false);
                }
                String realmGet$valor = ((CatalogoRealmProxyInterface)object).realmGet$valor();
                if (realmGet$valor != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.valorIndex, rowIndex, realmGet$valor, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.valorIndex, rowIndex, false);
                }
                String realmGet$url_img = ((CatalogoRealmProxyInterface)object).realmGet$url_img();
                if (realmGet$url_img != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.url_imgIndex, rowIndex, realmGet$url_img, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.url_imgIndex, rowIndex, false);
                }
                String realmGet$page = ((CatalogoRealmProxyInterface)object).realmGet$page();
                if (realmGet$page != null) {
                    Table.nativeSetString(tableNativePtr, columnInfo.pageIndex, rowIndex, realmGet$page, false);
                } else {
                    Table.nativeSetNull(tableNativePtr, columnInfo.pageIndex, rowIndex, false);
                }
                Table.nativeSetLong(tableNativePtr, columnInfo.cantidadIndex, rowIndex, ((CatalogoRealmProxyInterface)object).realmGet$cantidad(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.cantidadServerIndex, rowIndex, ((CatalogoRealmProxyInterface)object).realmGet$cantidadServer(), false);
                Table.nativeSetLong(tableNativePtr, columnInfo.timeIndex, rowIndex, ((CatalogoRealmProxyInterface)object).realmGet$time(), false);
            }
        }
    }

    public static com.dupreinca.dupree.mh_response_api.Catalogo createDetachedCopy(com.dupreinca.dupree.mh_response_api.Catalogo realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.dupreinca.dupree.mh_response_api.Catalogo unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.dupreinca.dupree.mh_response_api.Catalogo)cachedObject.object;
            } else {
                unmanagedObject = (com.dupreinca.dupree.mh_response_api.Catalogo)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.dupreinca.dupree.mh_response_api.Catalogo();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((CatalogoRealmProxyInterface) unmanagedObject).realmSet$id(((CatalogoRealmProxyInterface) realmObject).realmGet$id());
        ((CatalogoRealmProxyInterface) unmanagedObject).realmSet$name(((CatalogoRealmProxyInterface) realmObject).realmGet$name());
        ((CatalogoRealmProxyInterface) unmanagedObject).realmSet$valor(((CatalogoRealmProxyInterface) realmObject).realmGet$valor());
        ((CatalogoRealmProxyInterface) unmanagedObject).realmSet$url_img(((CatalogoRealmProxyInterface) realmObject).realmGet$url_img());
        ((CatalogoRealmProxyInterface) unmanagedObject).realmSet$page(((CatalogoRealmProxyInterface) realmObject).realmGet$page());
        ((CatalogoRealmProxyInterface) unmanagedObject).realmSet$cantidad(((CatalogoRealmProxyInterface) realmObject).realmGet$cantidad());
        ((CatalogoRealmProxyInterface) unmanagedObject).realmSet$cantidadServer(((CatalogoRealmProxyInterface) realmObject).realmGet$cantidadServer());
        ((CatalogoRealmProxyInterface) unmanagedObject).realmSet$time(((CatalogoRealmProxyInterface) realmObject).realmGet$time());
        return unmanagedObject;
    }

    static com.dupreinca.dupree.mh_response_api.Catalogo update(Realm realm, com.dupreinca.dupree.mh_response_api.Catalogo realmObject, com.dupreinca.dupree.mh_response_api.Catalogo newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((CatalogoRealmProxyInterface) realmObject).realmSet$name(((CatalogoRealmProxyInterface) newObject).realmGet$name());
        ((CatalogoRealmProxyInterface) realmObject).realmSet$valor(((CatalogoRealmProxyInterface) newObject).realmGet$valor());
        ((CatalogoRealmProxyInterface) realmObject).realmSet$url_img(((CatalogoRealmProxyInterface) newObject).realmGet$url_img());
        ((CatalogoRealmProxyInterface) realmObject).realmSet$page(((CatalogoRealmProxyInterface) newObject).realmGet$page());
        ((CatalogoRealmProxyInterface) realmObject).realmSet$cantidad(((CatalogoRealmProxyInterface) newObject).realmGet$cantidad());
        ((CatalogoRealmProxyInterface) realmObject).realmSet$cantidadServer(((CatalogoRealmProxyInterface) newObject).realmGet$cantidadServer());
        ((CatalogoRealmProxyInterface) realmObject).realmSet$time(((CatalogoRealmProxyInterface) newObject).realmGet$time());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Catalogo = [");
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
        stringBuilder.append(",");
        stringBuilder.append("{cantidad:");
        stringBuilder.append(realmGet$cantidad());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cantidadServer:");
        stringBuilder.append(realmGet$cantidadServer());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{time:");
        stringBuilder.append(realmGet$time());
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
        CatalogoRealmProxy aCatalogo = (CatalogoRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aCatalogo.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aCatalogo.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aCatalogo.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
