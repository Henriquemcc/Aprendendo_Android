package io.github.henriquemcc.agenda.kotlin

import android.app.Activity
import android.os.Bundle
import android.widget.Toast

class MainActivity: Activity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Henrique", Toast.LENGTH_LONG).show()
    }
}