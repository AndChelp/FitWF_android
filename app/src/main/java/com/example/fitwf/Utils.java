package com.example.fitwf;

import android.content.Context;
import android.view.View;

public class Utils {
    public static class Base {
        public static void changeVisibility(View view) {
            if (isVisible(view))
                view.setVisibility(View.INVISIBLE);
            else
                view.setVisibility(View.VISIBLE);
        }

        public static boolean isVisible(View view) {
            return view.getVisibility() == View.VISIBLE;
        }
    }

    public static class Text {
        public static void changeSelectedWithDelay(View view) {
            if (view.isSelected())
                view.setSelected(false);
            else
                setSelectedAfterDelay(view);
        }

        public static void setSelectedAfterDelay(final View view) {
            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.setSelected(true);
                }
            }, 300);
        }
    }

    public static class Resources {
        private static final String DEF_TYPE = "string";

        public static String getStringByIdName(Context context, String name) {
            return context.getString(
                    context.getResources().getIdentifier(
                            name,
                            DEF_TYPE,
                            context.getPackageName()
                    )
            );
        }
    }
}
















