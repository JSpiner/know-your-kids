package net.jspiner.knowyourkid.ui.notice;

import android.os.Bundle;
import android.support.annotation.Nullable;

import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.databinding.ActivityNoticeBinding;
import net.jspiner.knowyourkid.ui.base.BaseActivity;

public class NoticeActivity extends BaseActivity<ActivityNoticeBinding> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        init();
    }

    private void init(){
        setSupportActionBar(binding.toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        getSupportActionBar().setTitle("Notice");


    }

}
