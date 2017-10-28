package net.jspiner.knowyourkid.ui.login;

import android.content.Context;
import android.graphics.PointF;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import net.jspiner.knowyourkid.ui.base.BaseActivity;
import net.jspiner.knowyourkid.R;
import net.jspiner.knowyourkid.databinding.ActivityLoginBinding;
import net.jspiner.knowyourkid.ui.login.adapter.LoginBackgroundAdapter;
import net.jspiner.knowyourkid.ui.main.MainActivity;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    private LoginBackgroundAdapter adapter;
    private boolean isScrollingDown = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        setStatusBarColor(R.color.black);
        adapter = new LoginBackgroundAdapter();
        GridLayoutManager gridLayoutManager =
                new ScrollGridLayoutManager(
                        getBaseContext(),
                        3
                ) {

                };
        binding.backgroundRecyclerview.setLayoutManager(gridLayoutManager);
        binding.backgroundRecyclerview.setAdapter(adapter);
        binding.backgroundRecyclerview.setOnTouchListener((view, motionEvent) -> true);
        autoScroll();
    }

    public void autoScroll() {
        binding.backgroundRecyclerview.smoothScrollToPosition(
                adapter.getItemCount()
        );
        binding.backgroundRecyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.i("LoginActivity", "new state : " + newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {

                    isScrollingDown = !isScrollingDown;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        final int speedScroll = 500;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {

            @Override
            public void run() {
                if (isScrollingDown) {
                    binding.backgroundRecyclerview.smoothScrollToPosition(
                            0
                    );
                } else {
                    binding.backgroundRecyclerview.smoothScrollToPosition(
                            adapter.getItemCount()
                    );
                }
                handler.postDelayed(this, speedScroll);
            }

        };
        handler.postDelayed(runnable, speedScroll);
    }

    private class ScrollGridLayoutManager extends GridLayoutManager {
        public ScrollGridLayoutManager(Context context, int spanCount) {
            super(context, spanCount);
        }

        public ScrollGridLayoutManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
            super(context, spanCount, orientation, reverseLayout);
        }

        public ScrollGridLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        @Override
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
            LinearSmoothScroller smoothScroller = new LinearSmoothScroller(LoginActivity.this) {
                private static final float SPEED = 4000f;// Change this                value (default=25f)

                @Override
                protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return SPEED / displayMetrics.densityDpi;
                }

                @Nullable
                @Override
                public PointF computeScrollVectorForPosition(int targetPosition) {
                    return ScrollGridLayoutManager.this.computeScrollVectorForPosition(targetPosition);
                }
            };
            smoothScroller.setTargetPosition(position);
            startSmoothScroll(smoothScroller);
        }

    }
}
