# kotlin-android-persisted-vars
`var timesStarted by persisted.Int(0)` - Easily persisting vars backed by Android's SharedPreferences.

This is not a library. It's just an implementation example.

## The issue

Sometimes we have some SharedPreferences-backed variables, doing something like:

```
var x: Int
    get() = sharedPrefs.getInt("x", 0)  
    set(value) {  
        sharedPrefs.edit { putInt("x", value) }  
    }
```

We can reduce the boilerplate and simplify all of those cases to, for example:

```
var x by persisted.Int(0)
```

By using Kotlin's delegates and a bit of reflection.

## Quick links

### `Persisted` Use-Case

https://github.com/psteiger/kotlin-android-persisted-vars/blob/master/app/src/main/java/com/freelapp/persistedvars/DefaultActivity.kt

### `Persisted` Implementation

https://github.com/psteiger/kotlin-android-persisted-vars/blob/master/app/src/main/java/com/freelapp/persistedvars/Persisted.kt
