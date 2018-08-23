package com.dupreinca.dupree.mh_fragments_main;


import android.Manifest;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.dupreinca.dupree.R;
import com.dupreinca.dupree.mh_bar_scann.BarcodeCaptureActivity;
import com.dupreinca.dupree.mh_dialogs.ListDpto;
import com.dupreinca.dupree.mh_dialogs.ListString;
import com.dupreinca.dupree.mh_hardware.Camera;
import com.dupreinca.dupree.mh_http.Http;
import com.dupreinca.dupree.mh_required_api.RequiredIdenty;
import com.dupreinca.dupree.mh_required_api.RequiredRegister_NewAPI;
import com.dupreinca.dupree.mh_response_api.Perfil;
import com.dupreinca.dupree.mh_utilities.PinchZoomImageView;
import com.dupreinca.dupree.mh_utilities.Validate;
import com.dupreinca.dupree.mh_utilities.mPreferences;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.vansuita.pickimage.bean.PickResult;
import com.vansuita.pickimage.bundle.PickSetup;
import com.vansuita.pickimage.dialog.PickImageDialog;
import com.vansuita.pickimage.listeners.IPickResult;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

import static com.dupreinca.dupree.R.string.cedula;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewPreinsciptionFragment extends Fragment {

    public static final String TAG = "NewPreinsciptionFrag";
    public static final String BROACAST_REG_TYPE_VALIDATE_REF="reg_type_validate_ref2";
    public static final String BROACAST_REG_TYPE_REGISTER_VOLANTE="reg_type_register_volante2";
    public static final String BROACAST_REG_ERROR="reg_type_error2";
    public static final String BROACAST_REG_TYPE_REGISTER_UPLOAD_FILE="reg_type_register_upload_file2";
    private int requestCode;
    private int resultCode;
    private Intent data;

    private Boolean stateIdentyScann;
    private String methodPreInscription;


    public NewPreinsciptionFragment() {
        // Required empty public constructor
    }


    public static NewPreinsciptionFragment newInstance() {
        Bundle args = new Bundle();

        NewPreinsciptionFragment fragment = new NewPreinsciptionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    EditText txtSpnTypeId, txtIdenty, txtName, txtLastname;
    Button btnRegister;
    TextInputLayout txtInputRiesgo;

    ImageButton imgB_Searchref, imgB_CleanRef,bt_Camera;

    private ProgressDialog pDialog;
    FrameLayout ctnRegister;
    ScrollView scrollRegister;
    ImageView imgVolante;
    boolean imge_sended=false;


    private static final int MY_REQUEST_CODE = 1337;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_new_preinsciption, container, false);


        //stateIdentyScann = false para habilitar solo scann
        //stateIdentyScann = true para scann y manual
        stateIdentyScann = true;

        //Datos personales
        ctnRegister = (FrameLayout) v.findViewById(R.id.ctnRegister);
        scrollRegister = (ScrollView) v.findViewById(R.id.scrollRegister);

        txtSpnTypeId = (EditText) v.findViewById(R.id.txtSpnTypeId);
        txtSpnTypeId.setOnClickListener(mListenerClick);


        txtIdenty = v.findViewById(R.id.txtIdenty);
        txtInputRiesgo = v.findViewById(R.id.txtInputRiesgo);
        txtIdenty.setEnabled(stateIdentyScann);
        imgB_Searchref = v.findViewById(R.id.imgB_Searchref);
        imgB_CleanRef = v.findViewById(R.id.imgB_CleanRef);
        imgB_Searchref.setOnClickListener(mListenerClick);
        imgB_CleanRef.setOnClickListener(mListenerClick);
        bt_Camera = v.findViewById(R.id.bt_Camera);
        bt_Camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtSpnTypeId.getText().toString().contains("dula")){
                    Toast.makeText(getContext(),"Activando Camara",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), BarcodeCaptureActivity.class);
                    intent.putExtra(BarcodeCaptureActivity.AutoFocus, true);
                    intent.putExtra(BarcodeCaptureActivity.UseFlash, false);
                    startActivityForResult(intent,1);
                }else{
                    msgToast("Habilitado solo para Cedula");
                }
            }
        });

        imgVolante = v.findViewById(R.id.imgVolante);
        imgVolante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                permissionImage();
            }
        });

        txtName = (EditText) v.findViewById(R.id.txtName);
        txtLastname = (EditText) v.findViewById(R.id.txtLastname);

        btnRegister = v.findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(mListenerClick);

        localBroadcastReceiver = new LocalBroadcastReceiver();

        setRefValidated(false);


        createProgress();
        clearAllData();


        controlImage(false);
        return v;
    }

    public Perfil getPerfil(){
        String jsonPerfil = mPreferences.getJSON_TypePerfil(getActivity());
        if(jsonPerfil!=null)
            return new Gson().fromJson(jsonPerfil, Perfil.class);

        return null;
    }

    private void createProgress(){
        pDialog = new ProgressDialog(getActivity());
        pDialog.setCancelable(true);
        pDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);//K0LM6F
    }


    public void showProgressDialog(){
        pDialog.setMessage(getResources().getString(R.string.msg_espere));
        pDialog.show();
    }

    public void dismissProgressDialog(){
        if(pDialog!=null)
            pDialog.dismiss();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try{
            if(!data.getStringExtra("number").contains("Fallo")) {
                txtIdenty.setText(data.getStringExtra("number"));
                txtName.setText(data.getStringExtra("name"));
                txtLastname.setText(data.getStringExtra("lastname"));
                methodPreInscription=data.getStringExtra("method");
                //
                if (!txtIdenty.getText().toString().isEmpty()) {
                    new Http(getActivity()).validateCentralRiesgo(
                            new RequiredIdenty(
                                    txtIdenty.getText().toString()
                            ),
                            TAG,
                            BROACAST_REG_TYPE_VALIDATE_REF
                    );
                }
                //msgToast("Metodo Scanner");
            }else{
                msgToast("Error al leer cedula, intente nuevamente");
            }

        }catch (Exception e){

        }
    }

    public void error(){
        dismissProgressDialog();
    }

    View.OnClickListener mListenerClick =
            new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    switch (view.getId()){
                        case R.id.imgB_Searchref:
                            if(!txtIdenty.getText().toString().isEmpty()) {
                                new Http(getActivity()).validateCentralRiesgo(
                                        new RequiredIdenty(
                                                txtIdenty.getText().toString()
                                        ),
                                        TAG,
                                        BROACAST_REG_TYPE_VALIDATE_REF
                                );
                                methodPreInscription="m";
                                //
                                //msgToast("Metodo Manual");
                            }
                            break;
                        case R.id.imgB_CleanRef:
                            setRefValidated(false);
                            break;
                        case R.id.txtSpnTypeId:
                            showList(ListString.BROACAST_REG_TYPE_DOC, getString(R.string.tipo_de_documento), Arrays.asList(getResources().getStringArray(R.array.typeIdenty)), txtSpnTypeId.getText().toString());
                            break;
                        case R.id.btnRegister:
                            register();
                            break;
                    }

                }
            };



    public void showList(String objectFragment, String title, List<String> data, String itemSelected){
        ListString dialogList = new ListString();
        dialogList.loadData(TAG, objectFragment, title, data, itemSelected);
        dialogList.show(getActivity().getSupportFragmentManager(),"mDialog");

        //cuando se active cedula por scan/

        if(itemSelected.contains("edula")){
            txtIdenty.setEnabled(stateIdentyScann);
        }else{
            if(itemSelected.contains("it") || itemSelected.contains("xtran")) {
               txtIdenty.setEnabled(true);
            }else{
                txtIdenty.setEnabled(stateIdentyScann);
            }
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"onDestroyView()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"onDetach()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG,"onPause()");
    }

    @Override
    public void onResume() {
        super.onResume();
        registerBroadcat();
        Log.i(TAG,"onResume()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy()");
        unregisterBroadcat();
    }

    public void registerBroadcat(){
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(
                localBroadcastReceiver,
                new IntentFilter(TAG));
    }

    public void unregisterBroadcat(){
        LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(
                localBroadcastReceiver);
    }

    private static long lastTime=0;
    private static String intentRepeat="";
    private BroadcastReceiver localBroadcastReceiver;



    private class LocalBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // safety check
            if (intent == null || intent.getAction() == null) {
                return;
            }

            Log.e(TAG,"Calendar.getInstance().getTimeInMillis()= "+String.valueOf(Calendar.getInstance().getTimeInMillis()));
            Log.e(TAG,"lastTime= "+String.valueOf(lastTime));
            //si en un tiempo menor a un segundo, llega el mismo resultado, se desecha
            //esto garantiza que se pueda ejecutar la misma accion manualmente, mas evita repeticiones del broadcast que hacen algunos telefonos
            if( (Calendar.getInstance().getTimeInMillis()-lastTime<1000) && intentRepeat.equals(intent.getExtras().toString())) {// si no ha pasado medio segundo puede ser un rebote
                Log.e(TAG,"intentRepeat()");
                return;
            }

            lastTime=Calendar.getInstance().getTimeInMillis();
            intentRepeat=intent.getExtras().toString();

            if (intent.getAction().equals(TAG)) {
                switch (intent.getStringExtra(TAG)){
                    //Datos personales
                    case ListString.BROACAST_REG_TYPE_DOC:
                        String tipo = intent.getStringExtra(ListString.BROACAST_DATA);
                        Log.i(TAG,"BROACAST_REG_TYPE_DOC= "+tipo);
                        txtSpnTypeId.setError(null);
                        txtSpnTypeId.setText(tipo);
                        break;
                    //Direccion de residencia
                    case BROACAST_REG_TYPE_VALIDATE_REF:
                        Log.i(TAG, "BROACAST_REG_TYPE_VALIDATE_REF");
                        String nombreReferido = intent.getStringExtra(Http.BROACAST_DATA);
                        if(nombreReferido!=null) {
                            txtInputRiesgo.setHint(nombreReferido);
                            setRefValidated(!nombreReferido.equals("RECHAZADO"));
                            if(nombreReferido.equals("RECHAZADO"))
                                snackBar(nombreReferido+" por centrales de riesgo");
                        }
                        break;
                    case BROACAST_REG_TYPE_REGISTER_VOLANTE:
                        String result = intent.getStringExtra(ListDpto.BROACAST_DATA);
                        msgToast(result);
                        dismissProgressDialog();
                        clearAllData();
                        controlImage(false);
                        new Http(getActivity()).enlaceUpdateList();
                        break;
                    case BROACAST_REG_TYPE_REGISTER_UPLOAD_FILE:
                        dismissProgressDialog();
                        imge_sended = true;
                        urlImage = intent.getStringExtra(Camera.BROACAST_DATA);
                        Log.e(TAG, BROACAST_REG_TYPE_REGISTER_UPLOAD_FILE+", pathImage+ "+pathImage);
                        controlImage(true);

                        imageProfile(urlImage);

                        break;
                    case BROACAST_REG_ERROR:
                        dismissProgressDialog();
                        break;

                }
            }

        }
    }

    ImageLoader img;
    private void imageProfile(String url){
        Log.i(TAG, "imageProfile: "+url);
        img = ImageLoader.getInstance();
        img.init(PinchZoomImageView.configurarImageLoader(getActivity()));
        //img.clearMemoryCache();
        //img.clearDiskCache();
        img.displayImage(url, imgVolante);
        txtIdenty.setEnabled(false);
    }
    String urlImage="";


    public void register(){
        if(ValidateRegister() && ValidateTermins()){
            intentRepeat="";//para que procese el ultimo caso
            String jsonPerfil = mPreferences.getJSON_TypePerfil(getActivity());

            if(jsonPerfil!=null){
                Perfil perfil = new Gson().fromJson(jsonPerfil, Perfil.class);
                if ((perfil != null) && (!perfil.getPerfil().equals(Perfil.ADESORA))) {
                    showProgressDialog();
                    //msgToast(methodPreInscription);
                    //sendDataRegister();
                    sendDataRegister(urlImage);
                } else {
                    //searchTermins();
                }
            } else{
                //searchTermins();
            }
        }
    }

    private void sendImageMultiPart(File file, String tagFragment, String objectFragment){
        new Http(getActivity()).uploadImage_File(
                file, tagFragment, objectFragment, RegisterAsesoraFragment.BROACAST_REG_ERROR
        );
    }

    public Boolean ValidateRegister()
    {
        Validate valid=new Validate();
        //datos personales
        if (txtSpnTypeId.getText().toString().isEmpty())
        {
            msgToast("Seleccione tipo de documento...");
            valid.setLoginError(getResources().getString(R.string.campo_requerido), txtSpnTypeId);
            return false;
        }
        else if (valid.isValidInteger(txtIdenty.getText().toString()))
        {
            msgToast("Cédula invalida...");
            valid.setLoginError(getResources().getString(R.string.campo_requerido), txtIdenty);
            return false;
        }else if(!isRefValidated()){
            msgToast("Debe validar la cédula... Verifique");
            valid.setLoginError(getString(R.string.deba_validar),txtIdenty);
            return false;
        }
        else if (txtName.getText().toString().isEmpty())
        {
            msgToast("Nombre invalido...");
            valid.setLoginError(getResources().getString(R.string.campo_requerido), txtName);
            return false;
        }
        else if (txtLastname.getText().toString().isEmpty())
        {
            msgToast("Apellido invalido...");
            valid.setLoginError(getResources().getString(R.string.campo_requerido), txtLastname);
            return false;
        }

        return true;
    }

    public Boolean ValidateTermins() {
        //if(pathImage==null) {
        if(urlImage == null) {
            msgToast("Debe seleccionar un volante");
            return false;
        }
        return  true;
    }

    String img_terminos="";
    public RequiredRegister_NewAPI obtainDataUser(String pathImage)
    {

        RequiredRegister_NewAPI dataRegisterModel = new RequiredRegister_NewAPI(
                String.valueOf(Arrays.asList(getResources().getStringArray(R.array.typeIdenty)).indexOf(txtSpnTypeId.getText().toString())),
                txtIdenty.getText().toString(),
                txtName.getText().toString(),
                txtLastname.getText().toString(),
                pathImage,methodPreInscription

        );

        return dataRegisterModel;
    }

    private void msgToast(String msg){
        Log.e("onError", msg);
        Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
    }

    private void sendDataRegister(String urlImage){
        //msgToast(String.valueOf(obtainDataUser(urlImage)));
        new Http(getActivity()).register_new(obtainDataUser(urlImage), TAG, BROACAST_REG_TYPE_REGISTER_VOLANTE, BROACAST_REG_ERROR);
    }

    private void controlImage(boolean control){
        txtIdenty.setEnabled(control);
        txtSpnTypeId.setEnabled(control);
        imgB_Searchref.setEnabled(control);
        imgB_CleanRef.setEnabled(control);
    }

    private void clearAllData(){
        imge_sended = false;
        urlImage=null;

        controlImage(false);


        txtSpnTypeId.setText("");
        txtIdenty.setText("");
        txtInputRiesgo.setHint(getResources().getString(cedula));
        fileList = null;
        imgVolante.setImageResource(R.drawable.ph_add_image2);

        txtName.setText("");
        txtLastname.setText("");

        setRefValidated(false);
    }

    private boolean refValidated=false;

    public boolean isRefValidated() {
        return refValidated;
    }

    public void setRefValidated(boolean refValidated) {
        this.refValidated = refValidated;
        //imgVolante.setEnabled(refValidated);

        /*
        Drawable drawable = getResources().getDrawable(R.drawable.ph_add_image2);
        imgVolante.setImageDrawable(drawable);
        if(!refValidated)
            imgVolante.setColorFilter(getResources().getColor(R.color.gray_4), PorterDuff.Mode.MULTIPLY);
            */


        btnRegister.setEnabled(refValidated);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            btnRegister.setBackground(refValidated ? getResources().getDrawable(R.drawable.rounded_background_blue) : getResources().getDrawable(R.drawable.rounded_background_gray));
        }


        fileList=null;

        intentRepeat="";
        txtIdenty.setEnabled(!refValidated);
        txtIdenty.setError(null);

        imgB_Searchref.setVisibility(refValidated ? View.GONE : View.VISIBLE);
        imgB_CleanRef.setVisibility(!refValidated ? View.GONE : View.VISIBLE);
        txtIdenty.setText(refValidated ? txtIdenty.getText().toString() : "");
        txtName.setText(refValidated ? txtName.getText().toString() : "");
        txtLastname.setText(refValidated ? txtLastname.getText().toString() : "");

        //cuando este scan cedula
        if(txtSpnTypeId.getText().toString().contains("edula")){
            txtIdenty.setEnabled(stateIdentyScann);
        }else{
            if(txtSpnTypeId.getText().toString().contains("it") || txtSpnTypeId.getText().toString().contains("xtran")) {
                txtIdenty.setEnabled(true);
            }else{
                txtIdenty.setEnabled(stateIdentyScann);
            }
        }

        txtInputRiesgo.setHint(refValidated ? txtInputRiesgo.getHint() : getString(cedula));

        //habilitando campos debajo
        txtName.setEnabled(refValidated);
        txtLastname.setEnabled(refValidated);

    }

    public void snackBar(String msg){
        Perfil perfil = getPerfil();

        //no se xq en cada actividad funciona diferente
        Snackbar.make(perfil==null ? getActivity().findViewById(android.R.id.content) : ctnRegister, msg, Snackbar.LENGTH_LONG)
                .setAction("Action", null).setDuration(5000).show();
    }

    public static final int CONST_PERMISSION_IMAGE=123;
    @AfterPermissionGranted(CONST_PERMISSION_IMAGE)
    private void permissionImage() {
        //private void connect(int mode, String roomId, String nameCall, String numberCall, String idDevice) {
        String[] perms = {android.Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(getActivity(), perms)) {
            //hacer
            Log.e(TAG,"----------------------------------");
            takeImage();
        } else {
            EasyPermissions.requestPermissions(this, "Necesita habilitar permisos", CONST_PERMISSION_IMAGE, perms);
        }
    }

    /**
     * Respuestas a permisos
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    String pathImage=null;
    public void takeImage(){
        PickSetup pickSetup = new PickSetup();
        pickSetup.setHeight(1200);
        pickSetup.setWidth(960);

        //pickSetup.setPickTypes()

        PickImageDialog.build(pickSetup)
                .setOnPickResult(new IPickResult() {
                    @Override
                    public void onPickResult(PickResult r) {
                        //fileBitmap=null;
                        if(r.getBitmap()!=null) {
                            //probando
                            fileList =null;
                            //se recorta la imagen y convierte en fil, para enviar (se intento en http, pero rmbitmap, se cierra y all no esta disponible)
                            //new fileFromBitmap(resize(r.getBitmap(), 960, 1200), getActivity().getApplicationContext()).execute();
                            new fileFromBitmap(r.getBitmap(), "volante", 0, getActivity().getApplicationContext()).execute();

                            //Glide.with(this).load(Functions.getByteArrayFromBitmap(r.getBitmap())).asBitmap()
                            //fileBitmap = new Bitmap(r.getBitmap());
                            //fileBitmap=getResizedBitmap(r.getBitmap(), 960, 1200);
                            Log.e(TAG, "pathImage: "+r.getPath());
                            pathImage = r.getPath();
                            //imgVolante.setImageBitmap(resizeBitmap(pathImage, 256, 256));


                        } else {
                            msgToast("No se logro cargar la imagen");
                        }
                    }


                }).show(getChildFragmentManager());
    }

    private class fileFromBitmap extends AsyncTask<Void, Integer, String> {

        File file;
        Context context;
        Bitmap bitmap;
        int indexFile=0;
        String name;
        public fileFromBitmap(Bitmap bitmap, String name, int indexFile, Context context) {
            this.bitmap = bitmap;
            this.name= name;
            this.indexFile= indexFile;
            this.context= context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(Void... params) {
            // bitmap = resize2(bitmap, 960.0f, 1200.0f);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bytes);

            //si la quieres en discofile = new File(Environment.getExternalStorageDirectory() + File.separator + "temporary_file.jpg");
            file = new File(getActivity().getCacheDir() + "dupree_"+name+"_temporary_file"+String.valueOf(indexFile)+".jpg");//en cache
            try {
                FileOutputStream fo = new FileOutputStream(file);
                fo.write(bytes.toByteArray());
                //fo.write(resize2(bitmap, 960.0f, 1200.0f));
                fo.flush();
                fo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            saveFile(file, indexFile);
        }

        private Bitmap resize(Bitmap image, int maxWidth, int maxHeight) {
            if (maxHeight > 0 && maxWidth > 0) {
                int width = image.getWidth();
                int height = image.getHeight();
                float ratioBitmap = (float) width / (float) height;
                float ratioMax = (float) maxWidth / (float) maxHeight;

                int finalWidth = maxWidth;
                int finalHeight = maxHeight;
                if (ratioMax > 1) {
                    finalWidth = (int) ((float)maxHeight * ratioBitmap);
                } else {
                    finalHeight = (int) ((float)maxWidth / ratioBitmap);
                }
                image = Bitmap.createScaledBitmap(image, finalWidth, finalHeight, false);
                return image;
            } else {
                return image;
            }
        }

        private Bitmap resize2(Bitmap image, float width, float height) {
            float ZielHoehe = 0;
            float ZielBreite = 0;
            int Hoehe = image.getHeight();
            int Breite = image.getWidth();

            if (Hoehe > Breite) {
                ZielHoehe = height;
                float teiler = Hoehe / height;
                ZielBreite = Breite / teiler;
            } else {
                ZielBreite = width;
                float teiler = Breite / width;
                ZielHoehe = Hoehe / teiler;
            }

            return Bitmap.createScaledBitmap(image, (int)ZielBreite, (int)ZielHoehe, false);



            //return resizedImage;
        }

    }

    private File fileList;
    private void saveFile(File file, int indexFile){
        Log.e("onError", file.getAbsolutePath());
        this.fileList=file;
        showProgressDialog();
        sendImageMultiPart(fileList, TAG, BROACAST_REG_TYPE_REGISTER_UPLOAD_FILE);
    }


}



