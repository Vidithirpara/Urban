package com.ext.urban.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.viewpager.Utils.validateOTP
import com.example.viewpager.Utils.validatePhoneNumber
import com.ext.urban.databinding.ActivityLoginBinding
import com.ext.urban.home.HomeActivity
import com.ext.urban.registration.RegistrationActivity1
import java.text.DecimalFormat
import java.text.NumberFormat

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ClickListner()
        MemoryAllocation()
    }
    private fun ClickListner(){
        binding.llProceedAhead.setOnClickListener{
            if (validatePhoneNumber(this@LoginActivity, binding.etPhoneNumber)){
                binding.txtEnterOtp.visibility = View.VISIBLE
                binding.llOtpBox.visibility = View.VISIBLE
                binding.llNotReceivedOtp.visibility = View.VISIBLE
                binding.llVerifyAndContinue.visibility = View.VISIBLE
                binding.txtEdit.visibility = View.VISIBLE
                binding.llProceedAhead.visibility = View.GONE
                binding.txtSkip.visibility = View.GONE
                binding.etPhoneNumber.isEnabled = false
            }
        }

        binding.txtEdit.setOnClickListener{
            if (validatePhoneNumber(this@LoginActivity, binding.etPhoneNumber)){
                binding.txtEnterOtp.visibility = View.GONE
                binding.llOtpBox.visibility = View.GONE
                binding.llNotReceivedOtp.visibility = View.GONE
                binding.llVerifyAndContinue.visibility = View.GONE
                binding.txtEdit.visibility = View.GONE
                binding.llProceedAhead.visibility = View.VISIBLE
                binding.txtSkip.visibility = View.VISIBLE
                binding.etPhoneNumber.isEnabled = true
            }
        }

        binding.llVerifyAndContinue.setOnClickListener{
            if (validateOTP(this@LoginActivity, binding.otpDigit1, binding.otpDigit2, binding.otpDigit3, binding.otpDigit4, binding.otpDigit5, binding.otpDigit6)){
                val intent = Intent(this, RegistrationActivity1::class.java)
                startActivity(intent)
            }
        }

        binding.txtResendOtp.setOnClickListener{
            if (validatePhoneNumber(this@LoginActivity, binding.etPhoneNumber)){
                MemoryAllocation()
                binding.txtResendOtp.setTextColor(Color.GRAY)
            }
        }

        binding.txtSkip.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun MemoryAllocation() {

        //  Resend OTP Timer
        object : CountDownTimer(50000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val formatter: NumberFormat = DecimalFormat("00")
                val min = (millisUntilFinished / 60000) % 60
                val sec = (millisUntilFinished / 1000) % 60
                binding.txtCountDownTimer.text = "${formatter.format(min)}:${formatter.format(sec)}"
            }

            override fun onFinish() {
                binding.txtCountDownTimer.text = "00:00"
                binding.txtResendOtp.setTextColor(Color.BLACK)
            }
        }.start()

        class GenericTextWatcher(private val currentView: EditText, nextView: EditText?) :
            TextWatcher {
            private val nextView: EditText? = nextView
            override fun afterTextChanged(editable: Editable) {
                val text = editable.toString()
                if (nextView != null && text.length == 1) {
                    nextView.requestFocus()
                }
                if (text.length > 1) {
                    currentView.setText(text[text.length - 1].toString())
                    currentView.setSelection(1)
                }
            }
            override fun beforeTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {}
            override fun onTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {}
        }
        class GenericKeyEvent(private val currentView: EditText, private val previousView: EditText?) : View.OnKeyListener { override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DEL && currentView.text.toString().isEmpty()) {
                previousView?.requestFocus()
                return true
            }
            return false
        }
        }

        binding.otpDigit1.addTextChangedListener(GenericTextWatcher(binding.otpDigit1, binding.otpDigit2))
        binding.otpDigit2.addTextChangedListener(GenericTextWatcher(binding.otpDigit2,binding.otpDigit3))
        binding.otpDigit3.addTextChangedListener(GenericTextWatcher(binding.otpDigit3, binding.otpDigit4))
        binding.otpDigit4.addTextChangedListener(GenericTextWatcher(binding.otpDigit4, binding.otpDigit5))
        binding.otpDigit5.addTextChangedListener(GenericTextWatcher(binding.otpDigit5, binding.otpDigit6))

        binding.otpDigit6.setOnKeyListener(GenericKeyEvent(binding.otpDigit6, binding.otpDigit5))
        binding.otpDigit5.setOnKeyListener(GenericKeyEvent(binding.otpDigit5, binding.otpDigit4))
        binding.otpDigit4.setOnKeyListener(GenericKeyEvent(binding.otpDigit4, binding.otpDigit3))
        binding.otpDigit3.setOnKeyListener(GenericKeyEvent(binding.otpDigit3, binding.otpDigit2))
        binding.otpDigit2.setOnKeyListener(GenericKeyEvent(binding.otpDigit2, binding.otpDigit1))
    }
}