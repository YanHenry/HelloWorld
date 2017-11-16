package test.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MsgSendFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MsgSendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MsgSendFragment extends Fragment{
    public static final String EXTRA_MESSAGE = "test.helloworld.MSG";
    private final String TAG = getClass().getSimpleName();
    private EditText et1;
    private Button bt1;
    public MsgSendFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_msgsend, container, false);
        bt1 = view.findViewById(R.id.button1);
        bt1.setEnabled(false);
        et1 = view.findViewById(R.id.editText1);
        et1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0)
                {
                    bt1.setEnabled(true);
                }
                else
                {
                    bt1.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }
    public void sendMessage(View view)
    {
        Log.i(TAG, "====sendMessage!");
        mCallback.onMsgSendSelected(et1.getText().toString());
    }
    onMsgSendSelectedListener mCallback;

    // 容器 Activity 必须实现该接口
    // （译注：“容器 Activity”意即“包含该 Fragment 的 Activity”）
    public interface onMsgSendSelectedListener {
        public void onMsgSendSelected(String msg);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);

        Log.i(TAG, "=======onAttach");
        // 确认容器 Activity 已实现该回调接口。否则，抛出异常
        try {
            mCallback = (onMsgSendSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnContentSelectedListener");
        }
    }
}
