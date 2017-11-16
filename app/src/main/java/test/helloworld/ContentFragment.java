package test.helloworld;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ContentFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ContentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContentFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();
    public ContentFragment() {
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
        return inflater.inflate(R.layout.fragment_content, container, false);
    }
    OnContentSelectedListener mCallback;

    // 容器 Activity 必须实现该接口
    // （译注：“容器 Activity”意即“包含该 Fragment 的 Activity”）
    public interface OnContentSelectedListener {
        public void onContentSelected(int position);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);

        Log.i(TAG, "=======onAttach");
        // 确认容器 Activity 已实现该回调接口。否则，抛出异常
        try {
            mCallback = (OnContentSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnContentSelectedListener");
        }
        mCallback.onContentSelected(99);
    }
}
