package emre.com.baseexample.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by Emre.Karatas on 18.09.2018.
 */

public interface IBaseView extends View.OnClickListener{

    void initData(@Nullable final Bundle bundle);

    int bindLayout();

    void initView(final Bundle savedInstanceState, final View contentView);

    void doBusiness();

    void onWidgetClick(final View view);
}
