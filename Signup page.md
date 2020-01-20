# Signup page demo

## XML
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>

    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#ffffff">

        <include
            android:id="@+id/Toolbar"
            layout="@layout/toolbar"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />


        <ScrollView
            android:id="@+id/scrollView3"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_marginBottom="16dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/Toolbar">

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginStart="24dp"
                android:layout_marginEnd="24dp"
                android:layout_marginBottom="20dp"
                android:orientation="vertical">

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content">

                    <LinearLayout
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_marginEnd="8dp"
                        android:layout_weight="1"
                        android:orientation="vertical">

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginStart="8dp"
                            android:layout_marginTop="8dp"
                            android:text="First Name"
                            android:textColor="#a7aaae"
                            app:layout_constraintStart_toStartOf="parent"
                            app:layout_constraintTop_toTopOf="parent" />

                        <EditText
                            android:id="@+id/signUpUserFirstName"
                            android:layout_width="match_parent"
                            android:layout_height="50dp"
                            android:layout_marginTop="5dp"
                            android:background="@drawable/signup_new_edittxt_background"
                            android:ems="10"
                            android:hint="First Name"
                            android:inputType="textPersonName"
                            android:paddingStart="14dp"
                            android:textColor="@color/signup_page_tc"
                            android:textSize="14sp"
                            android:textStyle="normal" />

                    </LinearLayout>

                    <LinearLayout
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_marginStart="8dp"
                        android:layout_weight="1"
                        android:orientation="vertical">

                        <TextView
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginStart="8dp"
                            android:layout_marginTop="8dp"
                            android:text="Last Name"
                            android:textColor="#a7aaae"
                            app:layout_constraintStart_toStartOf="parent"
                            app:layout_constraintTop_toTopOf="parent" />

                        <EditText
                            android:id="@+id/signUpUserLaseName"
                            android:layout_width="match_parent"
                            android:layout_height="50dp"
                            android:layout_marginTop="5dp"
                            android:background="@drawable/signup_new_edittxt_background"
                            android:ems="10"
                            android:hint="Last Name"
                            android:inputType="textPersonName"
                            android:paddingStart="14dp"
                            android:textColor="@color/signup_page_tc"
                            android:textSize="14sp"
                            android:textStyle="normal"
                            app:layout_constraintEnd_toEndOf="parent"
                            app:layout_constraintStart_toStartOf="parent"
                            app:layout_constraintTop_toBottomOf="@+id/textView4" />

                    </LinearLayout>

                </LinearLayout>


                <TextView
                    android:id="@+id/textView18"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="5dp"
                    android:text="Email"
                    android:textColor="#a7aaae" />

                <EditText
                    android:id="@+id/signUpUserEmail"
                    android:layout_width="match_parent"
                    android:layout_height="50dp"
                    android:background="@drawable/signup_new_edittxt_background"
                    android:ems="10"
                    android:hint="Enter Email Address"

                    android:inputType="textEmailAddress"
                    android:paddingStart="14dp"
                    android:textColor="@color/signup_page_tc"
                    android:textSize="14sp"
                    android:textStyle="normal" />

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content">

                    <LinearLayout
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_marginEnd="4dp"
                        android:layout_weight="1"
                        android:orientation="vertical">

                        <TextView
                            android:id="@+id/textView20"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginTop="8dp"
                            android:text="Password"
                            android:textColor="#a7aaae" />

                        <EditText
                            android:id="@+id/signUpUserPass"
                            android:layout_width="match_parent"
                            android:layout_height="50dp"
                            android:layout_marginTop="5dp"
                            android:layout_marginEnd="8dp"
                            android:background="@drawable/signup_new_edittxt_background"
                            android:ems="10"
                            android:hint="Password"
                            android:inputType="textPassword"
                            android:paddingStart="14dp"
                            android:textColor="@color/signup_page_tc"
                            android:textSize="14sp"
                            android:textStyle="normal"
                            app:endIconMode="password_toggle" />
                    </LinearLayout>
                    <LinearLayout
                        android:layout_width="0dp"
                        android:layout_height="wrap_content"
                        android:layout_marginEnd="4dp"
                        android:layout_weight="1"
                        android:orientation="vertical">
                        <TextView
                            android:id="@+id/textView21"
                            android:layout_width="wrap_content"
                            android:layout_height="wrap_content"
                            android:layout_marginStart="8dp"
                            android:layout_marginTop="8dp"
                            android:text="Confirm Password"
                            android:textColor="#a7aaae"
                            app:layout_constraintStart_toStartOf="@+id/signUpUserConfPass"
                            app:layout_constraintTop_toBottomOf="@+id/signUpUserEmail" />

                        <EditText
                            android:id="@+id/signUpUserConfPass"
                            android:layout_width="match_parent"
                            android:layout_height="50dp"
                            android:layout_marginStart="8dp"
                            android:layout_marginTop="5dp"
                            android:background="@drawable/signup_new_edittxt_background"
                            android:ems="10"
                            android:hint="Confirm password"
                            android:inputType="textPassword"
                            android:paddingStart="14dp"
                            android:textColor="@color/signup_page_tc"
                            android:textSize="14sp"
                            android:textStyle="normal"
                            app:endIconMode="password_toggle"
                            app:layout_constraintEnd_toEndOf="parent"
                            app:layout_constraintStart_toEndOf="@+id/signUpUserPass"
                            app:layout_constraintTop_toBottomOf="@+id/textView21" />
                    </LinearLayout>

                </LinearLayout>






                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="8dp"
                    android:text="Mobile No"
                    android:textColor="#a7aaae"
                    app:layout_constraintStart_toStartOf="@+id/textView20"
                    app:layout_constraintTop_toBottomOf="@+id/signUpUserPass" />

                <EditText
                    android:id="@+id/signUpUserMobile"
                    android:layout_width="match_parent"
                    android:layout_height="50dp"
                    android:layout_marginTop="5dp"
                    android:background="@drawable/signup_new_edittxt_background"
                    android:ems="10"
                    android:hint="Mobile No"
                    android:inputType="number"
                    android:paddingStart="14dp"
                    android:textColor="@color/signup_page_tc"
                    android:textSize="14sp"
                    android:textStyle="normal" />

                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="8dp"
                    android:text="Gender"
                    android:textColor="#a7aaae"
                    app:layout_constraintStart_toStartOf="@+id/textView20"
                    app:layout_constraintTop_toBottomOf="@+id/signUpUserPass" />

                <LinearLayout
                    android:layout_width="match_parent"
                    android:layout_marginTop="8dp"
                    android:background="@drawable/signup_new_edittxt_background"
                    android:layout_height="wrap_content">
                    <Spinner
                        android:id="@+id/genderSpinner"
                        android:layout_width="match_parent"
                        android:layout_height="50dp"
                        android:drawSelectorOnTop="true"
                        android:entries="@array/gender_selection"
                        />

                </LinearLayout>


                <TextView
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_marginTop="8dp"
                    android:text="Date of Birth"
                    android:textColor="#a7aaae"
                    app:layout_constraintStart_toStartOf="@+id/textView20"
                    app:layout_constraintTop_toBottomOf="@+id/signUpUserPass" />

                <TextView
                    android:id="@+id/dateOfBirth"
                    android:layout_width="match_parent"
                    android:gravity="center_vertical"
                    android:layout_height="50dp"
                    android:layout_marginTop="5dp"
                    android:background="@drawable/signup_new_edittxt_background"
                    android:ems="10"
                    android:hint="Date of Birth"
                    android:paddingStart="14dp"
                    android:textColor="@color/signup_page_tc"
                    android:textSize="14sp"
                    android:textStyle="normal" />
                
                <com.fleet.maxpro.fleetmanagement.utility.Round50dpLayout
                    android:id="@+id/signUpUserBtn"
                    android:layout_width="170dp"
                    android:layout_height="@dimen/size_40dp"
                    android:layout_marginTop="@dimen/size_20dp"
                    android:layout_gravity="center_horizontal"
                    app:layout_constraintEnd_toEndOf="parent"
                    app:layout_constraintStart_toStartOf="parent"
                    app:layout_constraintTop_toBottomOf="@+id/signUpUserMobile">

                    <TextView
                        android:layout_width="match_parent"
                        android:layout_height="match_parent"
                        android:background="@color/blue"
                        android:gravity="center"
                        android:text="Sign Up"
                        android:textColor="@color/colorWhite"
                        android:textSize="@dimen/text_size_18sp"
                        android:textStyle="normal" />
                </com.fleet.maxpro.fleetmanagement.utility.Round50dpLayout>


            </LinearLayout>
        </ScrollView>

    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

## string.xml
    <string-array name="gender_selection">
        <item>Select One</item>
        <item>Male</item>
        <item>Female</item>
        <item>Other</item>
    </string-array>


## Code for creating account with validation
```java
    private void createAccount() {
        if (!isNetworkAvailable()) {
            showFailedToast(getString(R.string.internet_msg));
            return;
        }


        String email = b.signUpUserEmail.getText().toString();
        String phone = b.signUpUserMobile.getText().toString();
        String firstName = b.signUpUserFirstName.getText().toString();
        String lastName = b.signUpUserLaseName.getText().toString();
        String password = b.signUpUserPass.getText().toString();
        String confpass = b.signUpUserConfPass.getText().toString();
        String dateOfBirth = b.dateOfBirth.getText().toString();
        int genderPosition = b.genderSpinner.getSelectedItemPosition();

        String[] genders = getResources().getStringArray(R.array.gender_selection);
        String gender = genders[genderPosition];


        //<editor-fold desc="Validate input">
        if (TextUtils.isEmpty(firstName)) {
            b.signUpUserFirstName.setError("Input Valid Data");
            return;
        }
        if (TextUtils.isEmpty(lastName)) {
            b.signUpUserLaseName.setError("Input Valid Data");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            b.signUpUserEmail.setError("Input Valid Data");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            b.signUpUserPass.setError("Input Valid Data");
            return;
        }
        if (TextUtils.isEmpty(confpass)) {
            b.signUpUserConfPass.setError("Input Valid Data");
            return;
        }
//        if (TextUtils.isEmpty(phone)) {
//            b.signUpUserMobile.setError("Input Valid Data");
//            return;
//        }


        if (genderPosition == 0) {
            showFailedToast("Select gender");
            return;
        }

        if (TextUtils.isEmpty(dateOfBirth)) {
            b.signUpUserConfPass.setError("Input Valid Data");
            return;
        }

        if (!password.equals(confpass)) {
            b.signUpUserConfPass.setError("Password dosen't match");
            return;
        }
        //</editor-fold>


        showProgressDialog();

        HashMap<String, String> params = new HashMap<>();
        params.put("first_name", firstName);
        params.put("last_name", lastName);
        params.put("emailid", email);
        params.put("password", password);
        params.put("mobno", phone);
        params.put("date_of_birth", dateOfBirth);
        params.put("gender", String.valueOf(genderPosition));


        viewModel.requestForEmailVerify(params).observe(this, responseSingle -> {

            hideProgressDialog();
            if (responseSingle != null) {
                if (responseSingle.isSuccess()) {

                    UserProfile userProfile = (UserProfile) responseSingle.getData();
                    saveOffline(USER_PROFILE_FILE, userProfile);
                    showSuccessToast("Sign up successfully ");
                    goToNextActivityAfterSuccess(userProfile);

                } else {
                    if (!responseSingle.dontShowDialog()) {
                        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED))
                            showApiError(responseSingle.getMessage(), false);
                    } else
                        showFailedToast(responseSingle.getMessage());
                }
            } else {
                showFailedToast(getString(R.string.something_went_wrong));
            }

        });
    }
```
