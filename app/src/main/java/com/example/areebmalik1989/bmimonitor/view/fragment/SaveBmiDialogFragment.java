package com.example.areebmalik1989.bmimonitor.view.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.areebmalik1989.bmimonitor.MainApp;
import com.example.areebmalik1989.bmimonitor.R;
import com.example.areebmalik1989.bmimonitor.repository.BmiRecord;
import com.example.areebmalik1989.bmimonitor.repository.BmiRecord_;

import java.text.DecimalFormat;
import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class SaveBmiDialogFragment extends DialogFragment {

    public static final String TAG = "SaveBmiDialogFragment";
    public static final String BMI_VALUE = "BmiValue";

    private double bmi;
    private Box<BmiRecord> recordBox;

    private Activity activity;

    public SaveBmiDialogFragment() {

        BoxStore store = MainApp.getRecordStore();
        recordBox = store.boxFor(BmiRecord.class);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        activity = getActivity();

        bmi = Double.valueOf(new DecimalFormat("#.#").format(getArguments().getDouble(BMI_VALUE)));

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        builder.setTitle(R.string.save_confirm_dialog_title);
        builder.setMessage(getString(R.string.save_confirm_dialog_msg) + " " + bmi);

        builder.setPositiveButton(R.string.save, (dialog, id) -> {

            new Thread(() -> {

                BmiRecord record = new BmiRecord(bmi);

                List<BmiRecord> bmiRecords = recordBox.query().equal(BmiRecord_.date, record.getDate())
                        .build()
                        .find();

                recordBox.remove(bmiRecords);

                recordBox.put(record);

            }).start();

            Toast.makeText(getContext(), getString(R.string.saved) + " " + bmi, Toast.LENGTH_SHORT).show();

            dismiss();
        });

        builder.setNegativeButton(R.string.cancel, (dialog, id) -> {
            dismiss();
        });

        return builder.create();

    }
}
