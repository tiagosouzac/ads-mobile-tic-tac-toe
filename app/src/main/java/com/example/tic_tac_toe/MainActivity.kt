package com.example.tic_tac_toe

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var tvStatus: TextView
    private lateinit var tvScoreX: TextView
    private lateinit var tvScoreO: TextView
    private lateinit var tvScoreDraw: TextView
    private lateinit var btnRestart: Button

    private val botoes = Array(3) { arrayOfNulls<Button>(3) }

    private var turnoJogadorX = true
    private var contadorTurnos = 0

    private var pontuacaoX = 0
    private var pontuacaoO = 0
    private var pontuacaoEmpate = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvStatus = findViewById(R.id.tvStatus)
        tvScoreX = findViewById(R.id.tvScoreX)
        tvScoreO = findViewById(R.id.tvScoreO)
        tvScoreDraw = findViewById(R.id.tvScoreDraw)
        btnRestart = findViewById(R.id.btnRestart)

        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val buttonID = "btn$i$j"
                val resID = resources.getIdentifier(buttonID, "id", packageName)
                botoes[i][j] = findViewById(resID)
                botoes[i][j]?.setOnClickListener { aoClicarNaCelula(botoes[i][j]!!, i, j) }
            }
        }

        btnRestart.setOnClickListener { reiniciarJogo() }
    }

    private fun aoClicarNaCelula(botao: Button, linha: Int, coluna: Int) {
        if (botao.text.isNotEmpty()) {
            return
        }

        if (turnoJogadorX) {
            botao.text = "X"
            botao.setTextColor(Color.parseColor("#E8166D"))
        } else {
            botao.text = "O"
            botao.setTextColor(Color.parseColor("#FFC107"))
        }

        contadorTurnos++

        if (verificarVitoria()) {
            if (turnoJogadorX) {
                jogadorVenceu("X")
            } else {
                jogadorVenceu("O")
            }
        } else if (contadorTurnos == 9) {
            empate()
        } else {
            turnoJogadorX = !turnoJogadorX
            tvStatus.text = "Vez do: ${if (turnoJogadorX) "X" else "O"}"
        }
    }

    private fun verificarVitoria(): Boolean {
        val campo = Array(3) { Array(3) { "" } }

        for (i in 0 until 3) {
            for (j in 0 until 3) {
                campo[i][j] = botoes[i][j]?.text.toString()
            }
        }

        for (i in 0 until 3) {
            if (campo[i][0] == campo[i][1] && campo[i][0] == campo[i][2] && campo[i][0] != "") {
                destacarCelulasVencedoras(botoes[i][0]!!, botoes[i][1]!!, botoes[i][2]!!)
                return true
            }
            if (campo[0][i] == campo[1][i] && campo[0][i] == campo[2][i] && campo[0][i] != "") {
                destacarCelulasVencedoras(botoes[0][i]!!, botoes[1][i]!!, botoes[2][i]!!)
                return true
            }
        }

        if (campo[0][0] == campo[1][1] && campo[0][0] == campo[2][2] && campo[0][0] != "") {
            destacarCelulasVencedoras(botoes[0][0]!!, botoes[1][1]!!, botoes[2][2]!!)
            return true
        }

        if (campo[0][2] == campo[1][1] && campo[0][2] == campo[2][0] && campo[0][2] != "") {
            destacarCelulasVencedoras(botoes[0][2]!!, botoes[1][1]!!, botoes[2][0]!!)
            return true
        }

        return false
    }

    private fun destacarCelulasVencedoras(b1: Button, b2: Button, b3: Button) {
        b1.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#4CAF50")))
        b2.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#4CAF50")))
        b3.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("#4CAF50")))
    }

    private fun jogadorVenceu(jogador: String) {
        tvStatus.text = "Vencedor: $jogador!"
        if (jogador == "X") {
            pontuacaoX++
            tvScoreX.text = pontuacaoX.toString()
        } else {
            pontuacaoO++
            tvScoreO.text = pontuacaoO.toString()
        }
        desabilitarBotoes()
    }

    private fun empate() {
        tvStatus.text = "Empate!"
        pontuacaoEmpate++
        tvScoreDraw.text = pontuacaoEmpate.toString()
        desabilitarBotoes()
    }

    private fun desabilitarBotoes() {
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                botoes[i][j]?.isEnabled = false
            }
        }
    }

    private fun reiniciarJogo() {
        turnoJogadorX = true
        contadorTurnos = 0
        tvStatus.text = "Vez do: X"

        for (i in 0 until 3) {
            for (j in 0 until 3) {
                botoes[i][j]?.text = ""
                botoes[i][j]?.isEnabled = true
                botoes[i][j]?.setBackgroundResource(R.drawable.btn_bg)
                botoes[i][j]?.setBackgroundTintList(null)
            }
        }
    }
}