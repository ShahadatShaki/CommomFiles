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
        //From the play console app signing we get a sha1 and from the Sha-1 we can generate the key hash
        byte[] sha1 = {
                (byte) 0x93, 0x1E, 0x7A, 0x24, (byte) 0xA4, (byte) 0xAD, 0x1D, 0x37, 0x4E, 0x49, 0x5E, (byte) 0xD9, 0x78, (byte) 0xF1, 0x18, 0x59, (byte) 0x8A, 0x0E, (byte) 0xD9, (byte) 0xA9
        };
        System.out.println("keyhashGooglePlaySignIn:"+ Base64.encodeToString(sha1, Base64.NO_WRAP));
    }

