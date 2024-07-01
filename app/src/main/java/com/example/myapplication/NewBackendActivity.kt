package com.example.myapplication

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.*
import kotlinx.android.synthetic.main.wwinner.*

class NewBackendActivity : AppCompatActivity() {

    private lateinit var linearLayout1: LinearLayout
    private lateinit var linearLayout2: LinearLayout
    private lateinit var playerOneText: TextView
    private lateinit var playerTwoText: TextView
    private lateinit var playerOneIcon: ImageView
    private lateinit var playerTwoIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_backend)

        linearLayout1 = findViewById(R.id.linearLayout1)
        linearLayout2 = findViewById(R.id.linearLayout2)
        playerOneText = findViewById(R.id.playerOneText)
        playerTwoText = findViewById(R.id.playerTwoText)
        playerOneIcon = findViewById(R.id.playerOneIcon)
        playerTwoIcon = findViewById(R.id.playerTwoIcon)

        updateTurnIndicator()
    }

    fun btClick(view: View) {         //  once the button is clicked  the view of the button is needed.

        var cellid =
            0                              //cellid is use to represent the the status of the block cells.
        val btSelected = view as ImageButton

        when (btSelected.id) {
            R.id.bt1 -> cellid = 1
            R.id.bt2 -> cellid = 2
            R.id.bt3 -> cellid = 3
            R.id.bt4 -> cellid = 4
            R.id.bt5 -> cellid = 5
            R.id.bt6 -> cellid = 6
            R.id.bt7 -> cellid = 7
            R.id.bt8 -> cellid = 8
            R.id.bt9 -> cellid = 9
        }
        playGame(cellid, btSelected)
    }

    var activeplayer = 1                                 // at one time only one player.
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    fun playGame(cellID: Int, btSelected: ImageButton) { // for to play the game we need the cellid of clicked block or button.

        if (activeplayer == 1) {
            btSelected.setImageResource(R.drawable.multiply)
            player1.add(cellID)                                             //  by using add we can store the id of cell to which the player 1 is clicked
            activeplayer = 2
        }
        else {
            btSelected.setImageResource(R.drawable.icons_o_)
            player2.add(cellID)
            activeplayer = 1
        }

        btSelected.isEnabled = false
        updateTurnIndicator()
        pickWinner()
    }

    // program for update turn

    private fun updateTurnIndicator() {
        if (activeplayer == 1) {
            linearLayout1.setBackgroundResource(R.drawable.round_back_blue_border)
            linearLayout2.setBackgroundResource(R.drawable.round_back_dark_border)
        } else {
            linearLayout1.setBackgroundResource(R.drawable.round_back_dark_border)
            linearLayout2.setBackgroundResource(R.drawable.round_back_blue_border)
        }
    }

    fun pickWinner() {
        var winner = -1                            // initially no one is the winner either 1 or 2

        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }

        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }


        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }

        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1
        }

        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }

        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1
        }

        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }

        if (winner == -1 && (player1.size + player2.size == 9)) {
            // If all cells are filled and there's no winner, it's a draw
            showDrawDialog()
            return
        }

        if (winner == 1) {
            showWinnerDialog("Player 1")
        } else if (winner == 2) {
            showWinnerDialog("Player 2")
        }
    }

    fun showDrawDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.draw_dialog)
        dialog.exit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        dialog.playagain.setOnClickListener {
            val intent = Intent(this, NewBackendActivity::class.java)
            finish()
            startActivity(intent)
        }
        dialog.show()
    }

    fun showWinnerDialog(winnerName: String) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.wwinner)
        dialog.windisplay.text = "$winnerName Wins The Game"
        dialog.exit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        dialog.playagain.setOnClickListener {
            val intent = Intent(this, NewBackendActivity::class.java)
            finish()
            startActivity(intent)
        }
        dialog.show()
    }
}

