package buu.informatics.s59160002.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160002.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        setContentView(R.layout.activity_main)

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        binding.nicknameText.setOnClickListener {
            updateNickname(it)
        }

    }

    private fun updateNickname(view: View){
        val editText = binding.nicknameEdit
        val nickNameTextView = binding.nameText

        editText.visibility = View.VISIBLE
        nickNameTextView.visibility = View.VISIBLE

        val doneButton = binding.doneButton
        doneButton.visibility = View.VISIBLE

        editText.requestFocus()

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }

    private fun addNickname(view: View){
        val editText = binding.nicknameEdit
        val nickNameTextView = binding.nicknameText
        nickNameTextView.text = editText.text
        editText.visibility = View.GONE
        nickNameTextView.visibility = View.VISIBLE

        val doneButton = binding.doneButton
        doneButton.visibility = View.GONE

        //Hide the keyboard
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
