package com.wikia.webdriver.common.templates.fandom;

import com.wikia.webdriver.pageobjectsfactory.pageobject.adsbase.AdsFandomObject;

public class AdsFandomTestTemplate extends FandomTestTemplate {

  public static final String PAGE_TYPE_ARTICLE = "article";
  public static final String PAGE_TYPE_HUB = "hub";

  @Override
  protected void loadFirstPage() {
    // we want to avoid going to qa.fandom.com as logged in user
  }

  protected AdsFandomObject loadPage(String pageName, String pageType) {
    String pageUrl;

    switch (pageType) {
      case PAGE_TYPE_HUB:
        pageUrl = urlBuilder.getUrlForFandomHub(pageName);
        break;
      case PAGE_TYPE_ARTICLE:
      default:
        pageUrl = urlBuilder.getUrlForFandomPage(pageName);
        break;
    }

    AdsFandomObject pageObject = new AdsFandomObject(driver, pageUrl);
    getJquery();

    return pageObject;
  }

  protected AdsFandomObject loadPage(String pageName) {
    return loadPage(pageName, PAGE_TYPE_ARTICLE);
  }

  private void getJquery() {
    driver.executeScript(
        "    (function () {\n"
        + "    var s = document.createElement('script');\n"
        + "    s.type = 'text/javascript';\n"
        + "    s.async = true;\n"
        + "    s.src = 'https://code.jquery.com/jquery-2.2.4.min.js';\n"
        + "    var x = document.getElementsByTagName('script')[0];\n"
        + "    x.parentNode.insertBefore(s, x);\n"
        + "    })();"
    );
  }
}
