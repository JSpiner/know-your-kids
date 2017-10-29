package net.jspiner.knowyourkid.ui.play;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;

import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.databinding.ActivityPlayBinding;
import net.jspiner.knowyourkid.ui.base.BaseActivity;

public class PlayActivity extends BaseActivity<ActivityPlayBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        init();
    }

    private void init() {
        setSupportActionBar(binding.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setTitle("#활발한");

        String text = "<a href='http://www.soccer.com/'> http://soccer.com/montessori </a>";
        binding.link.setText(Html.fromHtml(text));

    }
}
