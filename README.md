# Sample BaseStructure

+++++++++++++++
IBaseView
+++++++++++++++

    void initData(@Nullable final Bundle bundle);

    int bindLayout();

    void initView(final Bundle savedInstanceState, final View contentView);

    void doBusiness();

    void onWidgetClick(final View view);
    
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



+++++++++++++++++++++++++
BaseActivity
+++++++++++++++++++++++++

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    protected Activity mActivity;
    protected View mContentView;

    private long lastClick = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        getSupportActionBar().hide();
        Bundle bundle = getIntent().getExtras();
        initData(bundle);
        setBaseView(bindLayout());
        initView(savedInstanceState, mContentView);
        doBusiness();
    }

    protected void setBaseView(@LayoutRes int layoutId) {
        if (layoutId <= 0) {
            return;
        }
        setContentView(mContentView = LayoutInflater.from(this).inflate(layoutId, null));
    }

    private boolean isFastClick() {
        long now = System.currentTimeMillis();

        if (now - lastClick >= 200) {
            lastClick = now;
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(isFastClick()){
            onWidgetClick(v);
        }
    }
}

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



++++++++++++++++++++++++
BaseFragment
++++++++++++++++++++++++

public abstract class BaseFragment extends Fragment implements IBaseView {

    private static final String TAG = "BaseFragment";
    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";

    protected View mContentView;
    protected Activity mActivity;

    private long lastClick = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commitAllowingStateLoss();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setBaseView(inflater, bindLayout());
        return mContentView;
    }

    protected void setBaseView(@NonNull LayoutInflater inflater, @LayoutRes int layoutId) {
        if (layoutId <= 0) return;
        mContentView = inflater.inflate(layoutId, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        initView(savedInstanceState, mContentView);
        doBusiness();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    private boolean isFastClick() {
        long now = System.currentTimeMillis();
        if (now - lastClick >= 200) {
            lastClick = now;
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (!isFastClick()) {
            onWidgetClick(v);
        }
    }

    public <T extends View> T findViewById(@IdRes int id) {
        if (mContentView == null) {
            throw new NullPointerException("Contentview is null");
        }
        return mContentView.findViewById(id);
    }
}

+++++++++++++++++++++++++++++++++++++++++++++
