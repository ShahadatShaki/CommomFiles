    private void printKeyHash() {
        // Add code to print out the key hash
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.maxproit.ticketBari", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("KeyHash:", e.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("KeyHash:", e.toString());
        }
    }


private void generatePublishedKeyHashForFacebook() {
        String string = "41:0A:FF:5D:4D:F0:39:52:AA:3A:E2:FF:4A:FF:04:4E:85:67:D2:1B";
        String[] v = string.split(":");
        byte[] sha1 = new byte[v.length];
        int i = 0;
        for(String val: v) {
            sha1[i++] =  Integer.decode("0x" + val).byteValue();
        }
        Log.d("keyhash:",  Base64.encodeToString(sha1, Base64.NO_WRAP));
    }


    //<editor-fold desc="Facebook Sign in All code">

    //add code on menifest
//    <meta-data
//    android:name="com.facebook.sdk.ApplicationId"
//    android:value="@string/facebook_app_id"
//    tools:replace="android:value"/>

    private LoginButton loginButton;
    private CallbackManager callbackManager;


    private void facebookLogin() {

        //<editor-fold desc="FB Login">
        if (Profile.getCurrentProfile() != null) {
            LoginManager loginManager = getInstance();
            loginManager.logOut();
            // logOutFromFB();
        }


        loginButton = new LoginButton(context);
        callbackManager = CallbackManager.Factory.create();
        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Constants.isConnected(context)) {
                    Constants.showNoInternetSnackbar(context, view);
                    return;
                }
                signInwithFacebook();
            }
        });

        getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Constants.showProcessDialogCustomTextCancleable(context, "Logging in...");
                        RequestFacebookData(loginResult);
                    }

                    @Override
                    public void onCancel() {
                    }

                    @Override
                    public void onError(FacebookException exception) {

                        Toast.makeText(context, "Error while logging with Facabook", Toast.LENGTH_SHORT).show();
                    }
                });
        //</editor-fold>
    }

    private void signInwithFacebook() {
//        getInstance().logInWithReadPermissions(this, Arrays.asList("email", "public_profile"));
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.performClick();

    }

    public void RequestFacebookData(LoginResult loginResult) {
        GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {

                JSONObject json = response.getJSONObject();
                try {
                    if (json != null) {
                        //String text = "<b>Name :</b> "+json.getString("name")+"<br><br><b>Email :</b> "+json.getString("email")+"<br><br><b>Profile link :</b> "+json.getString("link");
                        JsonObject params = new JsonObject();

                        params.addProperty("access_token", loginResult.getAccessToken().getToken());


                        try {
                            params.addProperty("profile_picture", "http://graph.facebook.com/" + json.getString("id") + "/picture?height=980&width=980");
                        } catch (Exception e) {
                        }

                        facebookSignIn(params);
                    } else {
                        Constants.dissmissProcess();
                        if (Profile.getCurrentProfile() != null) {
                            LoginManager loginManager = getInstance();
                            loginManager.logOut();
                            // logOutFromFB();
                        }
                        Toast.makeText(context, "Something went wrong, try again", Toast.LENGTH_SHORT).show();


                    }

                } catch (Exception e) {
                    if (Profile.getCurrentProfile() != null) {
                        LoginManager loginManager = getInstance();
                        loginManager.logOut();
                        // logOutFromFB();
                    }
                    Constants.dissmissProcess();
                    e.printStackTrace();
                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link,email,picture");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void facebookSignIn(final JsonObject params) {

        viewModel.userLoginRequest(params).observe(this, response -> {

        });
    }
    //</editor-fold>

    //<editor-fold desc="Google and facebook login requied">
    private static final int RC_SIGN_IN = 970;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        //requied for facebook login
        if (requestCode != RC_SIGN_IN) {
            callbackManager.onActivityResult(requestCode, resultCode, data);

        }

        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            @SuppressLint("RestrictedApi") Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                if (!Constants.isConnected(context)) {
                    Constants.showNoInternetSnackbar(context, loginButton);
                    return;
                }
                GoogleSignInAccount account = task.getResult(ApiException.class);

                Constants.showProcessDialogCustomTextCancleable(context, "Logging in...");
                HashMap<String, String> params = new HashMap<>();

//                BigInteger big_value = new BigInteger("" + account.getId().substring(account.getId().length() - 10));
//                BigInteger publicKey = new BigInteger("123435347");
//                BigInteger valueN = new BigInteger("16862769083070806509");
//                BigInteger cipherTextt = big_value.modPow(publicKey, valueN);
//
//                params.put("token", String.valueOf(cipherTextt));
                params.put("access_token", account.getIdToken());
//                params.put("name", account.getDisplayName());
//                params.put("google_user_id", account.getId());
//                params.put("email", account.getEmail());
//                try {
//                    params.put("profile_picture", "https://lh6.googleusercontent.com" + account.getPhotoUrl().getPath());
//                } catch (Exception e) {
//                }


                googleSignIn(params);
                int i = 0;
                // Show signed-un UI
//                updateUI(account);

            } catch (ApiException e) {
                Log.w("shaki", "Sign-in failed", e);
//                updateUI(null);
//                Toast.makeText(context, ""+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
    //</editor-fold>
