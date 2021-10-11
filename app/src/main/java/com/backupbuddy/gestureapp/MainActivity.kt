package com.backupbuddy.gestureapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import kotlin.math.abs

class MainActivity : AppCompatActivity() ,GestureDetector.OnGestureListener{
    lateinit var gestureDetector: GestureDetector
    var x2:Float=0.0f
    var x1:Float=0.0f
    var y2:Float=0.0f
    var y1:Float=0.0f

    companion object{
        const val MIN_DISTANCE=150
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gestureDetector= GestureDetector(this,this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        gestureDetector.onTouchEvent(event)
        when(event?.action){
            0->{
                x1=event.x
                y1=event.y
            }
            1->{
                x2=event.x
                y2=event.y

                var valueX:Float=x2-x1
                var valueY:Float=y2-y1

                if (abs(valueX)> MIN_DISTANCE){
                    //detect left to right swipe
                    if (x2>x1){
                        Toast.makeText(this,"Swiped Right", Toast.LENGTH_SHORT).show()
                    }
                    //detect right to left swipe
                    else{
                        Toast.makeText(this,"Swiped Left", Toast.LENGTH_SHORT).show()
                    }
                }
                else if(abs(valueY)> MIN_DISTANCE){
                    //detect top to bottom swipe
                    if (y2>y1){
                        Toast.makeText(this,"Bottom Swipe", Toast.LENGTH_SHORT).show()
                    }
                    //detect bottom to top swipe
                    else{
                        Toast.makeText(this,"Top Swipe", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        return super.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent?): Boolean {
//        TODO("Not yet implemented")
        return false
    }

    override fun onShowPress(e: MotionEvent?) {
//        TODO("Not yet implemented")
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
//        TODO("Not yet implemented")
        return false
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
//        TODO("Not yet implemented")
        return false
    }

    override fun onLongPress(e: MotionEvent?) {
//        TODO("Not yet implemented")

    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
//        TODO("Not yet implemented")
        return false
    }
}