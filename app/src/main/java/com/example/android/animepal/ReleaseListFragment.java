package com.example.android.animepal;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.integration.recyclerview.RecyclerViewPreloader;
import com.bumptech.glide.request.RequestOptions;

import com.bumptech.glide.RequestManager;
import com.bumptech.glide.util.ViewPreloadSizeProvider;
import com.example.android.animepal.dummy.DummyContent;
import com.example.android.animepal.dummy.DummyContent.DummyItem;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ReleaseListFragment extends Fragment implements ReleasesListener{

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 3;
    private OnListFragmentInteractionListener mListener;
    private RequestManager thumbnailRequest;
//    private RecyclerView view;
    private final String releasesURL = "https://www.masterani.me/api/releases";
    private OkHttpClient client;
    private ArrayList<Release> releases;
    private String TAG = "ReleaseListFragment";
    private MyReleaseListRecyclerViewAdapter adapter;
    private ConstraintLayout view;
    private ReleasesRepository repository;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ReleaseListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ReleaseListFragment newInstance(int columnCount) {
        ReleaseListFragment fragment = new ReleaseListFragment();
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
        }

        thumbnailRequest = GlideApp.with(this);

//        api request, get EVERYTHING
        final Request request = new Request.Builder().url(releasesURL).build();
        JSONArray jsonArray;
        client = new OkHttpClient();
        repository = new ReleasesRepository(client);
        repository.getReleases(this);

//        try {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_releaselist_list, container, false);

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
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

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
        void onListFragmentInteraction(DummyItem item);
    }

    private void update(String string){
        try{
            Log.e(TAG, string);
            releases = Release.parseResponse(string);
        }
        catch (JSONException e){
            Log.e(TAG, "error update");
        }
        adapter = new MyReleaseListRecyclerViewAdapter(releases, this);


//        view.setAdapter(postersAdapter);
//        textView.setText(releases.get(5).getAnime().getTitle());
//        Glide.with(this).load(new String(posterURL).concat(releases.get(2).getAnime().getPosterURL())).apply(RequestOptions.noTransformation()).into(view);

    }

    @Override
    public void callback(List<Release> releases) {
        this.releases = (ArrayList<Release>) releases;


        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setAdapter(adapter);
        view.findViewById(R.id.progressBar).setVisibility(View.GONE);
    }
}
