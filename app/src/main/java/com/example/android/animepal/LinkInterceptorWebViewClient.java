package com.example.android.animepal;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.ByteArrayInputStream;

public class LinkInterceptorWebViewClient extends WebViewClient {
    private BrowserFragment browserFragment;

    public LinkInterceptorWebViewClient(BrowserFragment browserFragment) {
        this.browserFragment = browserFragment;
    }

    private static final ByteArrayInputStream a = new ByteArrayInputStream(BuildConfig.FLAVOR.getBytes());

    protected static WebResourceResponse a() {
        return new WebResourceResponse("text/plain", "UTF-8", a);
    }

    @Nullable
    @Override
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        String url = request.getUrl().toString();
        if (LinkFilter.isVideoLink(url)) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse(url), "video/*");
            view.getContext().startActivity(intent);
            return a();

        }
        return super.shouldInterceptRequest(view, request);

    }
}
