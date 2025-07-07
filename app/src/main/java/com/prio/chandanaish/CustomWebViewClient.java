package com.prio.chandanaish;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class CustomWebViewClient extends WebViewClient {

    private final ProgressBar progressBar;
    private final WebView webView;

    public CustomWebViewClient(ProgressBar progressBar, WebView webView) {
        this.progressBar = progressBar;
        this.webView = webView;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        if (progressBar != null) progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        if (progressBar != null) progressBar.setVisibility(View.GONE);
        if (webView != null) {
            webView.setVisibility(View.VISIBLE);
            webView.getSettings().setLoadsImagesAutomatically(true);
        }
    }
}
