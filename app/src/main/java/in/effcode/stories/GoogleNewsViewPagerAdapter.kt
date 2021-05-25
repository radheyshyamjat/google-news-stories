package `in`.effcode.stories

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.viewpager.widget.PagerAdapter

class GoogleNewsViewPagerAdapter(private val activity: Activity, private val urlList: List<String>) :
        PagerAdapter() {
    private val layoutInflater: LayoutInflater =
            activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return urlList.size
    }

    override fun isViewFromObject(view: View, o: Any): Boolean {
        return view === o
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = layoutInflater.inflate(R.layout.item_view_pager_google_news, container, false)
        val webView = view.findViewById<WebView>(R.id.web_view)
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)

        webView.setInitialScale(1)
        webView.settings.javaScriptEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true
        webView.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        webView.settings.javaScriptEnabled = true;
        webView.settings.loadWithOverviewMode = true;
//        webView.getSettings().setAppCacheMaxSize(AppConstant.SITE_CACHE_SIZE);
//        webView.getSettings().setAppCachePath(mContext.getCacheDir().getAbsolutePath());
        webView.settings.allowFileAccess = true;
        webView.settings.setAppCacheEnabled(true);
        webView.settings.cacheMode = WebSettings.LOAD_DEFAULT; // load online by default
        //webView.getSettings().setUseWideViewPort(true);
        webView.settings.loadWithOverviewMode = true;
        webView.settings.domStorageEnabled = true;
        webView.settings.defaultTextEncodingName = "utf-8";
        webView.settings.pluginState = WebSettings.PluginState.ON;
        webView.settings.javaScriptCanOpenWindowsAutomatically = true;
        webView.settings.mediaPlaybackRequiresUserGesture = false;
        webView.webViewClient = object: WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                Log.d("TAG","onPageStarted")
                progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.d("TAG","onPageFinished")
                progressBar.visibility = View.GONE
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                Log.d("TAG","shouldOverrideUrlLoading 1")
                return super.shouldOverrideUrlLoading(view, url)

            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                Log.d("TAG","shouldOverrideUrlLoading 2" )
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onLoadResource(view: WebView?, url: String?) {
                super.onLoadResource(view, url)
                Log.d("TAG","onLoadResource")
            }

            override fun onPageCommitVisible(view: WebView?, url: String?) {
                super.onPageCommitVisible(view, url)
                Log.d("TAG","onPageCommitVisible")
            }

            override fun shouldInterceptRequest(view: WebView?, url: String?): WebResourceResponse? {
                Log.d("TAG","shouldInterceptRequest")
                return super.shouldInterceptRequest(view, url)
            }

            override fun shouldInterceptRequest(view: WebView?, request: WebResourceRequest?): WebResourceResponse? {
                Log.d("TAG","shouldInterceptRequest")
                return super.shouldInterceptRequest(view, request)
            }

            override fun onTooManyRedirects(view: WebView?, cancelMsg: Message?, continueMsg: Message?) {
                Log.d("TAG","onTooManyRedirects")
                super.onTooManyRedirects(view, cancelMsg, continueMsg)
            }

            override fun onReceivedError(view: WebView?, errorCode: Int, description: String?, failingUrl: String?) {
                Log.d("TAG","onReceivedError")
                super.onReceivedError(view, errorCode, description, failingUrl)
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                Log.d("TAG","onReceivedError")
                super.onReceivedError(view, request, error)
            }

            override fun onReceivedHttpError(view: WebView?, request: WebResourceRequest?, errorResponse: WebResourceResponse?) {
                Log.d("TAG","onReceivedHttpError")
                super.onReceivedHttpError(view, request, errorResponse)
            }

            override fun onFormResubmission(view: WebView?, dontResend: Message?, resend: Message?) {
                Log.d("TAG","onFormResubmission")
                super.onFormResubmission(view, dontResend, resend)
            }

            override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
                Log.d("TAG","doUpdateVisitedHistory")
                super.doUpdateVisitedHistory(view, url, isReload)
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                Log.d("TAG","onReceivedSslError")
                super.onReceivedSslError(view, handler, error)
            }

            override fun onReceivedClientCertRequest(view: WebView?, request: ClientCertRequest?) {
                Log.d("TAG","onReceivedClientCertRequest")
                super.onReceivedClientCertRequest(view, request)
            }

            override fun onReceivedHttpAuthRequest(view: WebView?, handler: HttpAuthHandler?, host: String?, realm: String?) {
                Log.d("TAG","onReceivedHttpAuthRequest")
                super.onReceivedHttpAuthRequest(view, handler, host, realm)
            }

            override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
                Log.d("TAG","shouldOverrideKeyEvent")
                return super.shouldOverrideKeyEvent(view, event)
            }

            override fun onUnhandledKeyEvent(view: WebView?, event: KeyEvent?) {
                Log.d("TAG","onUnhandledKeyEvent")
                super.onUnhandledKeyEvent(view, event)
            }

            override fun onScaleChanged(view: WebView?, oldScale: Float, newScale: Float) {
                Log.d("TAG","onScaleChanged")
                super.onScaleChanged(view, oldScale, newScale)
            }

            override fun onReceivedLoginRequest(view: WebView?, realm: String?, account: String?, args: String?) {
                Log.d("TAG","onReceivedLoginRequest")
                super.onReceivedLoginRequest(view, realm, account, args)
            }

            override fun onRenderProcessGone(view: WebView?, detail: RenderProcessGoneDetail?): Boolean {
                Log.d("TAG","onRenderProcessGone")
                return super.onRenderProcessGone(view, detail)
            }

            override fun onSafeBrowsingHit(view: WebView?, request: WebResourceRequest?, threatType: Int, callback: SafeBrowsingResponse?) {
                Log.d("TAG","onSafeBrowsingHit")
                super.onSafeBrowsingHit(view, request, threatType, callback)
            }
        }
        webView.loadUrl(urlList[position])
//        val webEngine = WebEngine(webView, activity)
//        webEngine.initWebView()
//        webEngine.initListeners(object : WebListener {
//            override fun onStart() {
//                progressBar.visibility = View.VISIBLE
//            }
//
//            override fun onLoaded() {
//                progressBar.visibility = View.GONE
//            }
//
//            override fun onProgress(progress: Int) {}
//            override fun onNetworkError() {
//                progressBar.visibility = View.GONE
//            }
//
//            override fun onPageTitle(title: String) {}
//        })


        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as FrameLayout)
    }
}