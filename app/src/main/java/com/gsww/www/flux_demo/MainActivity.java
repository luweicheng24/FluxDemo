package com.gsww.www.flux_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gsww.www.flux_demo.actions.ActionCreator;
import com.gsww.www.flux_demo.actions.RegistAction;
import com.gsww.www.flux_demo.dispatcher.Disptcher;
import com.gsww.www.flux_demo.model.User;
import com.gsww.www.flux_demo.store.RegistStore;
import com.gsww.www.flux_demo.store.Store;
import com.squareup.otto.Subscribe;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText psw;
    private EditText gender;
    private TextView message;
    private Button commit;
    private Disptcher dispatch;
    private RegistStore store;
    private RegistAction action;
    private ActionCreator actionCreator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initDependence();
    }

    private void initListener() {
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String acc = name.getText().toString();
                String p = psw.getText().toString();
                String sec = gender.getText().toString();
                User user = new User(acc, p, sec);
                actionCreator.regist(user);

            }
        });
    }

    private void initDependence() {
        dispatch = Disptcher.getInstance();
        actionCreator = ActionCreator.getInstance();
        store = new RegistStore();
        dispatch.regist(store);
    }

    @Override
    protected void onStart() {
        super.onStart();
        store.regist(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        store.unRegist(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dispatch.unRegist(store);
    }

    private void initView() {
        name = (EditText) findViewById(R.id.name);
        psw = (EditText) findViewById(R.id.psw);
        gender = (EditText) findViewById(R.id.sex);
        message = (TextView) findViewById(R.id.content);
        commit = (Button) findViewById(R.id.commit);

    }

    @Subscribe
    public void changeEvent(Store.StoreEventChange event) {
        String type = event.getType();
        String mes = event.getMessage();
        message.setText(store.getUser().toString());
        Toast.makeText(this, "跟新界面", Toast.LENGTH_SHORT).show();

    }

}
