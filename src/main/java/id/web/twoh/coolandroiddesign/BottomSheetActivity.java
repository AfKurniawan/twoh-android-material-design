package id.web.twoh.coolandroiddesign;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by Herdi_WORK on 26.12.17.
 */

public class BottomSheetActivity extends BaseAdsActivity {

    private Button btShow;
    private Button btHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_bottom_sheet);
        setupToolbar();

        final View bottomsheet = findViewById(R.id.bs_ll);
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        bottomSheetBehavior.setHideable(true);

        btShow = findViewById(R.id.bt_show);
        btHide = findViewById(R.id.bt_hide);

        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
                    btShow.setText("Close Bottom Sheet");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else{
                    btShow.setText("Show Bottom Sheet");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        btHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN){
                    btHide.setText("Hide");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }else{
                    btHide.setText("Peek");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }

            }
        });

        super.onCreate(savedInstanceState);
    }

    private void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setTitle("Bottom Sheet Example");
    }

}
