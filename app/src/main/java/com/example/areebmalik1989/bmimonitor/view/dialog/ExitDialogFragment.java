package com.example.areebmalik1989.bmimonitor.view.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.example.areebmalik1989.bmimonitor.R;

public class ExitDialogFragment extends DialogFragment {

    public static final String TAG = "ExitDialogFragment";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setMessage(R.string.sure_exit);

        builder.setPositiveButton(R.string.yes, (dialog, id) -> {

            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);

            dismiss();
        });

        builder.setNegativeButton(R.string.no, (dialog, id) -> {
            dismiss();
        });

        return builder.create();
    }
}
