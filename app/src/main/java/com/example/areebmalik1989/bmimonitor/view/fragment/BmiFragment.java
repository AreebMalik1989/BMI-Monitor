package com.example.areebmalik1989.bmimonitor.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.areebmalik1989.bmi_core.BmiManager;
import com.example.areebmalik1989.bmi_core.IBmiManager;
import com.example.areebmalik1989.bmi_core.model.Height;
import com.example.areebmalik1989.bmi_core.model.Units;
import com.example.areebmalik1989.bmi_core.model.Weight;
import com.example.areebmalik1989.bmimonitor.R;
import com.example.areebmalik1989.bmimonitor.view.dialog.ExitDialogFragment;
import com.example.areebmalik1989.bmimonitor.view.dialog.SaveBmiDialogFragment;
import com.example.areebmalik1989.bmimonitor.view.util.OutputManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.OnTextChanged;
import github.areebmalik1989.simplify_views.arcProgress.ArcProgress;

public class BmiFragment extends Fragment implements IBmiFragment {

    private View view;
    private FragmentManager fragmentManager;
    private Context context;

    private IBmiManager bmiManager;
    private OutputManager outputManager;

    private String weightType = Units.WeightUnit.KG.toString();
    private String heightType = Units.LengthUnit.METER.toString();

    private double bmi;

    @BindView(R.id.bmi_progressbar)
    ArcProgress progressBar;

    @BindView(R.id.bmi_translation)
    TextView bmiTranslationTextView;

    @BindView(R.id.weight_edittext)
    EditText weightEditText;

    @BindView(R.id.weight_edittext2)
    EditText weightEditText2;

    @BindView(R.id.height_edittext)
    EditText heightEditText;

    @BindView(R.id.height_edittext2)
    EditText heightEditText2;

    @BindView(R.id.weight_spinner)
    Spinner weightSpinner;

    @BindView(R.id.height_spinner)
    Spinner heightSpinner;

    public BmiFragment() {

        bmiManager = new BmiManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_bmi, container, false);

        ButterKnife.bind(this, view);

        fragmentManager = getFragmentManager();
        context = getContext();

        outputManager = new OutputManager(progressBar, bmiTranslationTextView);

        setWeightSpinner();
        setHeightSpinner();

        return view;
    }

    private void setWeightSpinner() {

        List<String> weightUnits = new ArrayList<>();

        for(Units.WeightUnit weightUnit : Units.WeightUnit.values()){
            if(!weightUnit.equals(Units.WeightUnit.UNKNOWN)) {
                weightUnits.add(weightUnit.toString());
            }
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_list_item_activated_1,
                weightUnits
        );

        weightSpinner.setAdapter(arrayAdapter);

        weightSpinner.setSelection(0);
    }

    private void setHeightSpinner() {

        List<String> heightUnits = new ArrayList<>();

        for(Units.LengthUnit lengthUnit : Units.LengthUnit.values()){
            if(!lengthUnit.equals(Units.LengthUnit.UNKNOWN)) {
                heightUnits.add(lengthUnit.toString());
            }
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(
                context,
                android.R.layout.simple_list_item_activated_1,
                heightUnits
        );

        heightSpinner.setAdapter(arrayAdapter);

        heightSpinner.setSelection(0);
    }

    @OnItemSelected(R.id.height_spinner)
    public void onHeightSelected(int position){

        heightType = heightSpinner.getItemAtPosition(position).toString();

        if(heightSpinner.getItemAtPosition(position).equals(Units.LengthUnit.FOOT_INCH.toString())){
            heightEditText2.setVisibility(View.VISIBLE);
        } else {
            heightEditText2.setVisibility(View.GONE);
        }

        collectData();
    }

    @OnItemSelected(R.id.weight_spinner)
    public void onWeightSelected(int position){

        weightType = weightSpinner.getItemAtPosition(position).toString();

        if(weightSpinner.getItemAtPosition(position).equals(Units.WeightUnit.STONE_POUND.toString())){
            weightEditText2.setVisibility(View.VISIBLE);
        } else {
            weightEditText2.setVisibility(View.GONE);
        }

        collectData();
    }

    @OnTextChanged({R.id.weight_edittext, R.id.height_edittext, R.id.height_edittext2})
    public void onTextChange(Editable editable){
        collectData();
    }

    @OnClick(R.id.bmi_fab)
    public void clickFab(View view){

        Bundle bundle = new Bundle();
        bundle.putDouble(SaveBmiDialogFragment.BMI_VALUE, bmi);

        SaveBmiDialogFragment sbdFragment = new SaveBmiDialogFragment();
        sbdFragment.setArguments(bundle);

        sbdFragment.show(fragmentManager, SaveBmiDialogFragment.TAG);
    }

    @OnClick(R.id.off_fab)
    public void clickOffFab(View view){

        ExitDialogFragment exitDialogFragment = new ExitDialogFragment();
        exitDialogFragment.show(fragmentManager, ExitDialogFragment.TAG);
    }

    @Override
    public void collectData(){

        Units.LengthUnit heightUnit = BmiManager.getHeightUnit(heightType);
        Units.WeightUnit weightUnit = BmiManager.getWeightUnit(weightType);
        double weight = -1.0;
        double height = -1.0;

        try {

            if(heightEditText2.getVisibility() == View.VISIBLE){
                height = 12.0 * Double.valueOf(heightEditText.getText().toString());
                height = height + Double.valueOf(heightEditText2.getText().toString());
                heightType = Units.LengthUnit.INCH.toString();
            } else {
                height = Double.valueOf(heightEditText.getText().toString());
            }

            if(weightEditText2.getVisibility() == View.VISIBLE){
                weight = 14.0 * Double.valueOf(weightEditText.getText().toString());
                weight = weight + Double.valueOf(weightEditText2.getText().toString());
                weightType = Units.WeightUnit.POUND.toString();
            } else {
                weight = Double.valueOf(weightEditText.getText().toString());
            }

        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }

        if(!heightUnit.equals(Units.LengthUnit.UNKNOWN)
                && !weightUnit.equals(Units.WeightUnit.UNKNOWN)
                && weight > 0
                && height > 0)
        {

            Height h = new Height(height, heightUnit);
            Weight w = new Weight(weight, weightUnit);

            bmiManager.collectBmiData(weight, weightType, height, heightType);

            showResult();
        }
    }

    @Override
    public void showResult(){

        bmi = bmiManager.giveBmi();
        String bmiTranslation = bmiManager.giveBmiTranslation();

        outputManager.setProgress(bmi);
        bmiTranslationTextView.setText(bmiTranslation);
    }
}
