package com.noc.utils.rx;

import android.os.Looper;

import io.reactivex.disposables.Disposable;


public final class Preconditions {
    public static void checkArgument(boolean assertion, String message) {
        if (!assertion) {
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> T checkNotNull(T value, String message) {
        if (value == null) {
            throw new NullPointerException(message);
        }
        return value;
    }

    public static void checkUiThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException(
                    "Must be called from the main thread. Was: " + Thread.currentThread());
        }
    }

    public static void unsubscribe(Disposable... subscriptions) {
        if (subscriptions != null)
            for (Disposable subscription : subscriptions) {
                if (subscription != null)
                    subscription.dispose();
            }
    }

    private Preconditions() {
        throw new AssertionError("No instances.");
    }
}