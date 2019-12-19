# CustomBottomNav

## Gradle depandency 
implementation 'com.github.mreram:showcaseview:1.1'

## Class
```java
import android.view.View;

public class ToolTipsModel {

    public String id, title, body;
    public View view;

    public ToolTipsModel(){}

    public ToolTipsModel(View view, String id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.view = view;

    }
}
```


## Code
```java
    public static void showToolTips(Context context, ArrayList<ToolTipsModel> tooltips) {

        if (BuildConfig.DEBUG)
            return;

        if (tooltips.size() == 0)
            return;

        Typeface titleTF = ResourcesCompat.getFont(context, R.font.exo_bold);
        Typeface bodyTF = ResourcesCompat.getFont(context, R.font.exo2_regular);

        if (getInt(context, tooltips.get(0).id) < 1) {

            if (tooltips.get(0).title.isEmpty()) {
                new GuideView.Builder(context)
                        .setContentText(tooltips.get(0).body)
                        .setGravity(Gravity.auto) //optional
                        .setDismissType(DismissType.anywhere) //optional - default DismissType.targetView
                        .setTargetView(tooltips.get(0).view)
                        .setContentTextSize(14)//optional
                        .setGuideListener(view -> {
                            tooltips.remove(0);
                            showToolTips(context, tooltips);
                        })
                        .build()
                        .show();
            } else {
                new GuideView.Builder(context)
                        .setTitle(tooltips.get(0).title)
                        .setContentText(tooltips.get(0).body)
                        .setGravity(Gravity.auto) //optional
                        .setDismissType(DismissType.anywhere) //optional - default DismissType.targetView
                        .setTargetView(tooltips.get(0).view)
                        .setContentTextSize(14)//optional
                        .setTitleTextSize(16)//optional
                        .setTitleTypeFace(titleTF)
                        .setContentTypeFace(bodyTF)
                        .setGuideListener(view -> {
                            tooltips.remove(0);
                            showToolTips(context, tooltips);
                        })
                        .build()
                        .show();
            }

            saveInt(context, tooltips.get(0).id, getInt(context, tooltips.get(0).id) + 1);
        }
    }
```
