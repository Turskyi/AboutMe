package com.turskyi.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.turskyi.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Dmytro Turskyi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* First option */
//        setContentView(R.layout.activity_main)

        /* Second option */
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        /* First option */
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }

        /* Second option */
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {

        /* First option */
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
//        nicknameTextView.text = editText.text
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE

        /* Second option */
//        binding.nicknameText.text = binding.nicknameEdit.text
//        binding.nicknameEdit.visibility = View.GONE
//        binding.doneButton.visibility = View.GONE
//        binding.nicknameText.visibility = View.VISIBLE

        /* Third option */
        binding.apply {
//            nicknameText.text = binding.nicknameEdit.text

            /* Fourth option */
            myName?.nickname = nicknameEdit.text.toString()

            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        /** Hide the keyboard. */
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
