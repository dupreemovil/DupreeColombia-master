package io.realm;


import android.util.JsonReader;
import io.realm.RealmObjectSchema;
import io.realm.internal.ColumnInfo;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmModel>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmModel>> modelClasses = new HashSet<Class<? extends RealmModel>>();
        modelClasses.add(com.dupreinca.dupree.mh_response_api.Catalogo.class);
        modelClasses.add(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class);
        modelClasses.add(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class);
        modelClasses.add(com.dupreinca.dupree.mh_response_api.Paqueton.class);
        modelClasses.add(com.dupreinca.dupree.mh_response_api.Oferta.class);
        modelClasses.add(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Table createTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm) {
        checkClass(clazz);

        if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
            return io.realm.CatalogoRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
            return io.realm.DM_List_CatalogoRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
            return io.realm.DM_CatalogoRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
            return io.realm.PaquetonRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
            return io.realm.OfertaRealmProxy.initTable(sharedRealm);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
            return io.realm.DM_List_OfertasRealmProxy.initTable(sharedRealm);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public RealmObjectSchema createRealmObjectSchema(Class<? extends RealmModel> clazz, RealmSchema realmSchema) {
        checkClass(clazz);

        if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
            return io.realm.CatalogoRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
            return io.realm.DM_List_CatalogoRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
            return io.realm.DM_CatalogoRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
            return io.realm.PaquetonRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
            return io.realm.OfertaRealmProxy.createRealmObjectSchema(realmSchema);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
            return io.realm.DM_List_OfertasRealmProxy.createRealmObjectSchema(realmSchema);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmModel> clazz, SharedRealm sharedRealm, boolean allowExtraColumns) {
        checkClass(clazz);

        if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
            return io.realm.CatalogoRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
            return io.realm.DM_List_CatalogoRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
            return io.realm.DM_CatalogoRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
            return io.realm.PaquetonRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
            return io.realm.OfertaRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
            return io.realm.DM_List_OfertasRealmProxy.validateTable(sharedRealm, allowExtraColumns);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
            return io.realm.CatalogoRealmProxy.getFieldNames();
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
            return io.realm.DM_List_CatalogoRealmProxy.getFieldNames();
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
            return io.realm.DM_CatalogoRealmProxy.getFieldNames();
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
            return io.realm.PaquetonRealmProxy.getFieldNames();
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
            return io.realm.OfertaRealmProxy.getFieldNames();
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
            return io.realm.DM_List_OfertasRealmProxy.getFieldNames();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public String getTableName(Class<? extends RealmModel> clazz) {
        checkClass(clazz);

        if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
            return io.realm.CatalogoRealmProxy.getTableName();
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
            return io.realm.DM_List_CatalogoRealmProxy.getTableName();
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
            return io.realm.DM_CatalogoRealmProxy.getTableName();
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
            return io.realm.PaquetonRealmProxy.getTableName();
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
            return io.realm.OfertaRealmProxy.getTableName();
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
            return io.realm.DM_List_OfertasRealmProxy.getTableName();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E newInstance(Class<E> clazz, Object baseRealm, Row row, ColumnInfo columnInfo, boolean acceptDefaultValue, List<String> excludeFields) {
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        try {
            objectContext.set((BaseRealm) baseRealm, row, columnInfo, acceptDefaultValue, excludeFields);
            checkClass(clazz);

            if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
                return clazz.cast(new io.realm.CatalogoRealmProxy());
            } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
                return clazz.cast(new io.realm.DM_List_CatalogoRealmProxy());
            } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
                return clazz.cast(new io.realm.DM_CatalogoRealmProxy());
            } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
                return clazz.cast(new io.realm.PaquetonRealmProxy());
            } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
                return clazz.cast(new io.realm.OfertaRealmProxy());
            } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
                return clazz.cast(new io.realm.DM_List_OfertasRealmProxy());
            } else {
                throw getMissingProxyClassException(clazz);
            }
        } finally {
            objectContext.clear();
        }
    }

    @Override
    public Set<Class<? extends RealmModel>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmModel> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmModel, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
            return clazz.cast(io.realm.CatalogoRealmProxy.copyOrUpdate(realm, (com.dupreinca.dupree.mh_response_api.Catalogo) obj, update, cache));
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
            return clazz.cast(io.realm.DM_List_CatalogoRealmProxy.copyOrUpdate(realm, (com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo) obj, update, cache));
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
            return clazz.cast(io.realm.DM_CatalogoRealmProxy.copyOrUpdate(realm, (com.dupreinca.dupree.mh_based_realm.DM_Catalogo) obj, update, cache));
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
            return clazz.cast(io.realm.PaquetonRealmProxy.copyOrUpdate(realm, (com.dupreinca.dupree.mh_response_api.Paqueton) obj, update, cache));
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
            return clazz.cast(io.realm.OfertaRealmProxy.copyOrUpdate(realm, (com.dupreinca.dupree.mh_response_api.Oferta) obj, update, cache));
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
            return clazz.cast(io.realm.DM_List_OfertasRealmProxy.copyOrUpdate(realm, (com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas) obj, update, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, RealmModel object, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

        if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
            io.realm.CatalogoRealmProxy.insert(realm, (com.dupreinca.dupree.mh_response_api.Catalogo) object, cache);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
            io.realm.DM_List_CatalogoRealmProxy.insert(realm, (com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo) object, cache);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
            io.realm.DM_CatalogoRealmProxy.insert(realm, (com.dupreinca.dupree.mh_based_realm.DM_Catalogo) object, cache);
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
            io.realm.PaquetonRealmProxy.insert(realm, (com.dupreinca.dupree.mh_response_api.Paqueton) object, cache);
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
            io.realm.OfertaRealmProxy.insert(realm, (com.dupreinca.dupree.mh_response_api.Oferta) object, cache);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
            io.realm.DM_List_OfertasRealmProxy.insert(realm, (com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas) object, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insert(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
                io.realm.CatalogoRealmProxy.insert(realm, (com.dupreinca.dupree.mh_response_api.Catalogo) object, cache);
            } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
                io.realm.DM_List_CatalogoRealmProxy.insert(realm, (com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo) object, cache);
            } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
                io.realm.DM_CatalogoRealmProxy.insert(realm, (com.dupreinca.dupree.mh_based_realm.DM_Catalogo) object, cache);
            } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
                io.realm.PaquetonRealmProxy.insert(realm, (com.dupreinca.dupree.mh_response_api.Paqueton) object, cache);
            } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
                io.realm.OfertaRealmProxy.insert(realm, (com.dupreinca.dupree.mh_response_api.Oferta) object, cache);
            } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
                io.realm.DM_List_OfertasRealmProxy.insert(realm, (com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
                    io.realm.CatalogoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
                    io.realm.DM_List_CatalogoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
                    io.realm.DM_CatalogoRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
                    io.realm.PaquetonRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
                    io.realm.OfertaRealmProxy.insert(realm, iterator, cache);
                } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
                    io.realm.DM_List_OfertasRealmProxy.insert(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, RealmModel obj, Map<RealmModel, Long> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
            io.realm.CatalogoRealmProxy.insertOrUpdate(realm, (com.dupreinca.dupree.mh_response_api.Catalogo) obj, cache);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
            io.realm.DM_List_CatalogoRealmProxy.insertOrUpdate(realm, (com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo) obj, cache);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
            io.realm.DM_CatalogoRealmProxy.insertOrUpdate(realm, (com.dupreinca.dupree.mh_based_realm.DM_Catalogo) obj, cache);
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
            io.realm.PaquetonRealmProxy.insertOrUpdate(realm, (com.dupreinca.dupree.mh_response_api.Paqueton) obj, cache);
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
            io.realm.OfertaRealmProxy.insertOrUpdate(realm, (com.dupreinca.dupree.mh_response_api.Oferta) obj, cache);
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
            io.realm.DM_List_OfertasRealmProxy.insertOrUpdate(realm, (com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas) obj, cache);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public void insertOrUpdate(Realm realm, Collection<? extends RealmModel> objects) {
        Iterator<? extends RealmModel> iterator = objects.iterator();
        RealmModel object = null;
        Map<RealmModel, Long> cache = new HashMap<RealmModel, Long>(objects.size());
        if (iterator.hasNext()) {
            //  access the first element to figure out the clazz for the routing below
            object = iterator.next();
            // This cast is correct because obj is either
            // generated by RealmProxy or the original type extending directly from RealmObject
            @SuppressWarnings("unchecked") Class<RealmModel> clazz = (Class<RealmModel>) ((object instanceof RealmObjectProxy) ? object.getClass().getSuperclass() : object.getClass());

            if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
                io.realm.CatalogoRealmProxy.insertOrUpdate(realm, (com.dupreinca.dupree.mh_response_api.Catalogo) object, cache);
            } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
                io.realm.DM_List_CatalogoRealmProxy.insertOrUpdate(realm, (com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo) object, cache);
            } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
                io.realm.DM_CatalogoRealmProxy.insertOrUpdate(realm, (com.dupreinca.dupree.mh_based_realm.DM_Catalogo) object, cache);
            } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
                io.realm.PaquetonRealmProxy.insertOrUpdate(realm, (com.dupreinca.dupree.mh_response_api.Paqueton) object, cache);
            } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
                io.realm.OfertaRealmProxy.insertOrUpdate(realm, (com.dupreinca.dupree.mh_response_api.Oferta) object, cache);
            } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
                io.realm.DM_List_OfertasRealmProxy.insertOrUpdate(realm, (com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas) object, cache);
            } else {
                throw getMissingProxyClassException(clazz);
            }
            if (iterator.hasNext()) {
                if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
                    io.realm.CatalogoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
                    io.realm.DM_List_CatalogoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
                    io.realm.DM_CatalogoRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
                    io.realm.PaquetonRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
                    io.realm.OfertaRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
                    io.realm.DM_List_OfertasRealmProxy.insertOrUpdate(realm, iterator, cache);
                } else {
                    throw getMissingProxyClassException(clazz);
                }
            }
        }
    }

    @Override
    public <E extends RealmModel> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
            return clazz.cast(io.realm.CatalogoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
            return clazz.cast(io.realm.DM_List_CatalogoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
            return clazz.cast(io.realm.DM_CatalogoRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
            return clazz.cast(io.realm.PaquetonRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
            return clazz.cast(io.realm.OfertaRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
            return clazz.cast(io.realm.DM_List_OfertasRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
            return clazz.cast(io.realm.CatalogoRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
            return clazz.cast(io.realm.DM_List_CatalogoRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
            return clazz.cast(io.realm.DM_CatalogoRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
            return clazz.cast(io.realm.PaquetonRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
            return clazz.cast(io.realm.OfertaRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
            return clazz.cast(io.realm.DM_List_OfertasRealmProxy.createUsingJsonStream(realm, reader));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmModel> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmModel, RealmObjectProxy.CacheData<RealmModel>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(com.dupreinca.dupree.mh_response_api.Catalogo.class)) {
            return clazz.cast(io.realm.CatalogoRealmProxy.createDetachedCopy((com.dupreinca.dupree.mh_response_api.Catalogo) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo.class)) {
            return clazz.cast(io.realm.DM_List_CatalogoRealmProxy.createDetachedCopy((com.dupreinca.dupree.mh_based_realm.DM_List_Catalogo) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_Catalogo.class)) {
            return clazz.cast(io.realm.DM_CatalogoRealmProxy.createDetachedCopy((com.dupreinca.dupree.mh_based_realm.DM_Catalogo) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Paqueton.class)) {
            return clazz.cast(io.realm.PaquetonRealmProxy.createDetachedCopy((com.dupreinca.dupree.mh_response_api.Paqueton) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.dupreinca.dupree.mh_response_api.Oferta.class)) {
            return clazz.cast(io.realm.OfertaRealmProxy.createDetachedCopy((com.dupreinca.dupree.mh_response_api.Oferta) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas.class)) {
            return clazz.cast(io.realm.DM_List_OfertasRealmProxy.createDetachedCopy((com.dupreinca.dupree.mh_based_realm.DM_List_Ofertas) realmObject, 0, maxDepth, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}
