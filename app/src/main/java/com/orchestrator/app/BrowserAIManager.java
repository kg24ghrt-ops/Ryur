package com.orchestrator.app;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;

import java.util.HashMap;
import java.util.Map;

public class BrowserAIManager {

    private final Context context;
    private final Map<String, String> aiUrls;

    public BrowserAIManager(Context context) {
        this.context = context;
        aiUrls = new HashMap<>();
        aiUrls.put("ChatGPT", "https://chat.openai.com/");
        aiUrls.put("Gemini", "https://gemini.ai/");
    }

    public void openAI(String aiName) {
        String url = aiUrls.get(aiName);
        if (url == null) return;

        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setShowTitle(true);
        builder.setToolbarColor(0xFF6200EE);
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(context, Uri.parse(url));
    }

    public void addAI(String name, String url) {
        aiUrls.put(name, url);
    }
}