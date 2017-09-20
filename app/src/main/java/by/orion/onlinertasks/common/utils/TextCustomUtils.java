package by.orion.onlinertasks.common.utils;

import android.text.Html;
import android.text.Spanned;

import static android.os.Build.*;

public class TextCustomUtils {

    public static Spanned fromHtml(String html){
        Spanned result;
        if (VERSION.SDK_INT >= VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }
}
