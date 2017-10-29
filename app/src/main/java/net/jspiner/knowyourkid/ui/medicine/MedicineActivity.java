package net.jspiner.knowyourkid.ui.medicine;

import android.os.Bundle;
import android.support.annotation.Nullable;

import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.databinding.ActivityMedicineBinding;
import net.jspiner.knowyourkid.ui.base.BaseActivity;

public class MedicineActivity extends BaseActivity<ActivityMedicineBinding> {

    private final int[] pages = {
            R.drawable.sample_1,
            R.drawable.sample2,
            R.drawable.sample3
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

        init();
    }

    private void init() {
        setSupportActionBar(binding.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setTitle("Medicine");

        int page = getIntent().getIntExtra("page", -1);
        binding.image.setImageResource(pages[page]);

    }
}
