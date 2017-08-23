package com.visytem.loadingdialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zhangmeng on 2017/8/23.
 */

public class LoadingDialog extends Dialog {

    public LoadingDialog(@NonNull Context context) {
        this(context, R.style.MyDialogStyle);
    }

    public LoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }


    public static class Builder {

        private Context context;
        private String message;
        private boolean isCancelable = false;
        private boolean isCancelOutside = false;

        public Builder(Context context) {
            this.context = context;
            message = context.getString(R.string.loading);
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            isCancelable = cancelable;
            return this;
        }

        public Builder setCancelOutside(boolean cancelOutside) {
            isCancelOutside = cancelOutside;
            return this;
        }

        public LoadingDialog create() {
            View view = LayoutInflater.from(context).inflate(R.layout.dialog_loading, null);
            LoadingDialog loadingDialog = new LoadingDialog(context, R.style.MyDialogStyle);
            TextView msgText = (TextView) view.findViewById(R.id.message);
            msgText.setText(message);
            loadingDialog.setContentView(view);
            loadingDialog.setCancelable(isCancelable);
            loadingDialog.setCanceledOnTouchOutside(isCancelOutside);
            return loadingDialog;
        }

    }

}
