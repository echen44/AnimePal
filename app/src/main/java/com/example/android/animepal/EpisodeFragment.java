package com.example.android.animepal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.android.animepal.dummy.DummyContent;
import com.example.android.animepal.dummy.DummyContent.DummyItem;

import org.json.JSONArray;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class EpisodeFragment extends Fragment implements MirrorSelectDialogFragment.OnFragmentInteractionListener{

    // TODO: Customize parameter argument names
    public static final String ARG_COLUMN_COUNT = "column-count";
    final static String ARG_ID = "id";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private OnListFragmentInteractionListener mListener;
    private OkHttpClient client;
    private AnimeDetailsRepository repository;
    private AnimeDetails animeDetails;
    private MyEpisodeRecyclerViewAdapter adapter;
    private ConstraintLayout view;
    private int id;
    private List<Mirror> mirrors;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public EpisodeFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static EpisodeFragment newInstance(int columnCount) {
        EpisodeFragment fragment = new EpisodeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
            id = getArguments().getInt(ARG_ID);
        }
        client = new OkHttpClient();
        repository = new AnimeDetailsRepository(client, this);
        Bundle args = getArguments();
        repository.getEpisodes(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_episode_list, container, false);

        // Set the adapter
//        if (view instanceof RecyclerView) {
        Context context = view.getContext();
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        this.view = constraintLayout;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
        RecyclerView recyclerView = constraintLayout.findViewById(R.id.list);
        recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
//        while (adapter == null){
//
//        }
//        recyclerView.setAdapter(adapter);
//        constraintLayout.findViewById(R.id.progressBar).setVisibility(View.GONE);

//        }
        return constraintLayout;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement AnimeSelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void showMirrors(DialogFragment dialogFragment) {
        dialogFragment.show(getFragmentManager(), "mirrors");
    }

    @Override
    public void MirrorSelected(Mirror mirror) {
        Log.e("cat", mirror.toString());
    }

    //    public void showMirrors(List<Mirror> mirrors) {
////        this.mirrors = mirrors;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void MirrorSelected(Mirror mirror);
    }

    public void callback(AnimeDetails animeDetails) {
        this.animeDetails = animeDetails;
//        this.animeDetails.getEpisodes()

        adapter = new MyEpisodeRecyclerViewAdapter(this.animeDetails.getEpisodes(), mListener, this, animeDetails.getInfo().getSlug());

        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setAdapter(adapter);
        view.findViewById(R.id.progressBar).setVisibility(View.GONE);
    }
}
