package com.example.task1colourconquest


import android.os.CountDownTimer
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task1colourconquest.TimeFormatExt.timeFormat
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class TimerViewModel2 : ViewModel()  {
    private var countDownTimer: CountDownTimer? = null
    private var _userInputMinute : Long = TimeUnit.MINUTES.toMillis(1)
    private var _userInputSecond: Long = TimeUnit.SECONDS.toMillis(10)

    private val _initialTotalTimeInMillis = _userInputMinute + _userInputSecond
    var timeLeft = mutableStateOf(_initialTotalTimeInMillis)
    val countDownInterval = 1000L

    val timerText = mutableStateOf(timeLeft.value.timeFormat())

    val isPlaying = mutableStateOf(false)
    val isTimeRemaining = mutableStateOf(true)

    fun startCountDownTimer(){
        isPlaying.value = true
        countDownTimer = object : CountDownTimer(timeLeft.value, countDownInterval) {
            override fun onTick(currentTimeLeft: Long) {
                timerText.value = currentTimeLeft.timeFormat()
                timeLeft.value = currentTimeLeft
            }

            override fun onFinish() {
                timerText.value = "00:00"
                isPlaying.value = false
                isTimeRemaining.value = false
            }
        }.start()
    }

    fun stopCountDownTimer() = viewModelScope.launch{
        isPlaying.value = false
        countDownTimer?.cancel()
    }

    fun resetCountDownTimer() = viewModelScope.launch {
        isPlaying.value = false
        countDownTimer?.cancel()
        timerText.value = timeLeft.value.timeFormat()
        timeLeft.value = _initialTotalTimeInMillis
    }
}